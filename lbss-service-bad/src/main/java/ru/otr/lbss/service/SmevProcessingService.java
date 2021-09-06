package ru.otr.lbss.service;

import static com.mongodb.client.model.Filters.and;
import static com.mongodb.client.model.Filters.eq;
import static com.mongodb.client.model.Sorts.ascending;

import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.xml.datatype.DatatypeFactory;

import org.apache.commons.lang3.SerializationUtils;
import org.bson.BsonDocument;
import org.bson.Document;
import org.bson.conversions.Bson;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

import cxc.jex.common.application.config.PropertiesService;
import cxc.jex.common.exception.ExceptionWrapper;
import cxc.jex.common.failure.FailureWrapper;
import ru.otr.lbss.client.api.SmevPrimeServiceLocal;
import ru.otr.lbss.client.api.SmevPrimeServiceLocal.Mode;
import ru.otr.lbss.client.model.types.AsyncProcessingStatus;
import ru.otr.lbss.client.model.types.AsyncProcessingStatusData;
import ru.otr.lbss.client.model.types.GetRequestRequest;
import ru.otr.lbss.client.model.types.GetResponseRequest;
import ru.otr.lbss.client.model.types.GetStatusRequest;
import ru.otr.lbss.client.model.types.MessageMetadata;
import ru.otr.lbss.client.model.types.MessageTypeType;
import ru.otr.lbss.client.model.types.Request;
import ru.otr.lbss.client.model.types.Response;
import ru.otr.lbss.client.model.types.SendRequestRequest;
import ru.otr.lbss.client.model.types.SendResponseRequest;
import ru.otr.lbss.client.model.types.SenderProvidedRequestData;
import ru.otr.lbss.client.model.types.SenderProvidedResponseData;
import ru.otr.lbss.client.model.types.SmevAsyncProcessingMessage;
import ru.otr.lbss.client.model.types.GetRequestResponse.RequestMessage;
import ru.otr.lbss.client.model.types.GetResponseResponse.ResponseMessage;
//import ru.otr.lbss.client.model.types.MessageMetadata.SupplementaryData;
import ru.otr.lbss.client.model.types.basic.InteractionStatusType;
import ru.otr.lbss.client.model.types.basic.InteractionTypeType;
import ru.otr.lbss.client.model.types.basic.MessagePrimaryContent;
import ru.otr.lbss.service.config.ServiceProperties;
import ru.otr.lbss.service.config.ModeService;
import ru.otr.lbss.service.model.DocNames;
import ru.otr.lbss.service.model.FieldNames;
import ru.otr.lbss.service.model.ModelConstants;
import ru.otr.lbss.service.model.ModelFilters;
import ru.otr.lbss.service.model.types.MpcKey;
import ru.otr.lbss.service.model.types.RequestRoutingData;
import ru.otr.lbss.service.model.types.ResponseRoutingData;
import ru.otr.lbss.service.model.types.ResponseRoutingData.ResponseKind;
import ru.otr.lbss.service.model.types.RoutingData;
import ru.otr.lbss.service.model.types.SmevFaultHelper;
import ru.otr.lbss.service.model.types.SmevMember;
import ru.otr.lbss.service.processing.ProcessingTask;

public class SmevProcessingService {
	private static Logger log = LoggerFactory.getLogger(SmevProcessingService.class);

	@Autowired
	private PropertiesService propertiesService;
	@Autowired
	private ModeService modeService;
	@Autowired
	@Qualifier("messagesDB")
	private MongoDatabase messagesDB;
	@Autowired
	private SmevMemberService memberService;
	@Autowired
	private SmevSignService signService;
	@Autowired
	private SmevFTPService ftpService;

	private long acknowledgmentTimeout;
	private DatatypeFactory datatypeFactory;

	private ExecutorService executorService;

	@PostConstruct
	private void init() {
		log.info("init");
		try {
			acknowledgmentTimeout = propertiesService.getLong(ServiceProperties.PrimeService_acknowledgmentTimeout, 900000);
			datatypeFactory = DatatypeFactory.newInstance();
			executorService = Executors.newCachedThreadPool();
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	@PreDestroy
	private void fina() {
		log.info("fina");
		executorService.shutdown();
	}

	private Mode getMode() {
		return modeService.getPrimeServiceMode();
	}

	private void processCommonData(RoutingData routingData, String msgId) throws FailureWrapper {
		MessageMetadata metadata = new MessageMetadata();
		metadata.setId("ID_" + UUID.randomUUID());
		metadata.setMessageId(msgId.trim().toLowerCase());
		metadata.setSendingTimestamp(datatypeFactory.newXMLGregorianCalendar(new GregorianCalendar()));
		//metadata.setDestinationName("TODO DestinationName");
		routingData.setMessageMetadata(metadata);
	}

	private void processMessagePrimaryContent(RoutingData routingData, MessagePrimaryContent mpc) throws FailureWrapper {
		if (mpc == null || mpc.getAny() == null) {
			throw new FailureWrapper("SMEV.InvalidMessagePrimaryContent");
		}
		if (mpc.getAny().getNamespaceURI() == null || mpc.getAny().getLocalName() == null) {
			throw new FailureWrapper("SMEV.InvalidMessagePrimaryContent");
		}
		if (mpc.getAny().getNamespaceURI().trim().length() == 0 || mpc.getAny().getLocalName().trim().length() == 0) {
			throw new FailureWrapper("SMEV.InvalidMessagePrimaryContent");
		}
		if (mpc != null && mpc.getAny() != null) {
			routingData.setMpcKey(new MpcKey(mpc.getAny().getNamespaceURI(), mpc.getAny().getLocalName()));
		}
	}

	private void processSupplementaryData(RoutingData routingData, SmevMember sender, SmevMember recipient) throws FailureWrapper {
		routingData.getMessageMetadata().setSender(sender.toSender());
		routingData.getMessageMetadata().setRecipient(recipient.toRecipient());
		//routingData.getMessageMetadata().setSupplementaryData(new SupplementaryData());
		//routingData.getMessageMetadata().getSupplementaryData().setInteractionType(InteractionTypeType.NOT_DETECTED);
		if (sender.getType() == SmevMember.Type.PGU) {
			if (recipient.getType() == SmevMember.Type.OIV) {
				//routingData.getMessageMetadata().getSupplementaryData().setInteractionType(InteractionTypeType.PGU_2_OIV);
			}
		}
		if (sender.getType() == SmevMember.Type.OIV) {
			if (recipient.getType() == SmevMember.Type.OIV) {
				if (sender.equals(recipient)) {
					//routingData.getMessageMetadata().getSupplementaryData().setInteractionType(InteractionTypeType.OIV_2_SAME_OIV);
				} else {
					//routingData.getMessageMetadata().getSupplementaryData().setInteractionType(InteractionTypeType.OIV_2_OIV);
				}
			}
			if (recipient.getType() == SmevMember.Type.PGU) {
				//routingData.getMessageMetadata().getSupplementaryData().setInteractionType(InteractionTypeType.PGU_2_OIV);
			}
		}
		//routingData.getMessageMetadata().getSupplementaryData().setDetectedContentTypeName("TODO SupplementaryData.DetectedContentTypeName");
	}

	public RequestRoutingData makeRoutingData(SendRequestRequest request, SmevMember sender) throws FailureWrapper {
		RequestRoutingData result = new RequestRoutingData();
		processCommonData(result, request.getSenderProvidedRequestData().getMessageID());
		result.setReplyTo(sender.getMnemonic() + "|" + result.getMessageMetadata().getMessageId() + "|"
		        + result.getMessageMetadata().getSendingTimestamp().toXMLFormat());

		result.getMessageMetadata().setMessageType(MessageTypeType.REQUEST);
		processMessagePrimaryContent(result, request.getSenderProvidedRequestData().getMessagePrimaryContent());
		SmevMember recipient = memberService.findMember(result.getMpcKey());
		if (recipient == null) {
			throw new FailureWrapper("SMEV.BusinessDataTypeIsNotSupported.Unregistered");
		}
		processSupplementaryData(result, sender, recipient);
		return result;
	}

	public ResponseRoutingData makeRoutingData(SendResponseRequest request, SmevMember sender) throws FailureWrapper {
		ResponseRoutingData result = new ResponseRoutingData();
		processCommonData(result, request.getSenderProvidedResponseData().getMessageID());
		result.setTo(request.getSenderProvidedResponseData().getTo());

		result.getMessageMetadata().setMessageType(MessageTypeType.RESPONSE);
		if (request.getSenderProvidedResponseData().getMessagePrimaryContent() != null) {
			result.setKind(ResponseKind.MessagePrimaryContent);
			processMessagePrimaryContent(result, request.getSenderProvidedResponseData().getMessagePrimaryContent());
			SmevMember owner = memberService.findMember(result.getMpcKey());
			if (owner == null) {
				throw new FailureWrapper("SMEV.BusinessDataTypeIsNotSupported.Unregistered");
			}
			if (!sender.equals(owner)) {
				throw new FailureWrapper("SMEV.BusinessDataTypeIsNotSupported.NoOwner", String.format("Отправитель (%s) не совпадает с владельцем ВС (%s)", sender.getMnemonic(), owner.getMnemonic()));
			}
		}
		if (!request.getSenderProvidedResponseData().getRequestRejected().isEmpty()) {
			log.info("Ответ содержит отказ Reject");
			result.setKind(ResponseKind.RequestRejected);
			// Ищем первоначальный запрос
			MongoCollection<RequestMessage> requestCollection = messagesDB.getCollection(DocNames.RequestMessage, RequestMessage.class);
			RequestMessage requestMessage = requestCollection.find(eq("Request.ReplyTo", result.getTo())).first();

			//TODO Нужно сюда вкорячить поиск в БД корневого элемента, который не равен текущему и находится в одном namespace
			//result.setMpcKey(new MpcKey(requestMessage.getMpcNamespace(), requestMessage.getMpcRootElement().replace("Request", "Responce")));
			//////////////////////////////////////////////////////////////

		}
		if (request.getSenderProvidedResponseData().getRequestStatus() != null) {
			result.setKind(ResponseKind.RequestStatus);
		}
		if (request.getSenderProvidedResponseData().getAsyncProcessingStatus() != null) {
			result.setKind(ResponseKind.AsyncProcessingStatus);
		}

		MongoCollection<RequestMessage> collection = messagesDB.getCollection(DocNames.RequestMessage, RequestMessage.class);
		RequestMessage requestMessage = collection.find(eq("Request.ReplyTo", result.getTo())).first();
		if (requestMessage == null) {
			throw new FailureWrapper("SMEV.RecipientIsNotFound.RequestNotFound");
		}

		String requestSenderMnemonic = requestMessage.getRequest().getMessageMetadata().getSender().getMnemonic();
		SmevMember recipient = memberService.findMember(requestSenderMnemonic);
		if (recipient == null) {
			throw new FailureWrapper("SMEV.RecipientIsNotFound.UnregisteredRecipient");
		}
		processSupplementaryData(result, sender, recipient);
		return result;
	}

	public RequestMessage findRequest(String messageID, SmevMember sender) {
		MongoCollection<RequestMessage> collection = messagesDB.getCollection(DocNames.RequestMessage, RequestMessage.class);
		Bson filter = and(ModelFilters.forRequestMessageID(messageID),
		        eq("Request.MessageMetadata.Status", InteractionStatusType.REQUEST_IS_ACCEPTED_BY_SMEV.toString()));
		if (sender != null) {
			filter = and(filter, eq("Request.MessageMetadata.Recipient.Mnemonic", sender.getMnemonic()));
		}
		return collection.find(filter).first();
	}

	public ResponseMessage findResponse(String messageID, SmevMember sender) {
		MongoCollection<ResponseMessage> collection = messagesDB.getCollection(DocNames.ResponseMessage, ResponseMessage.class);
		Bson filter = and(ModelFilters.forResponseMessageID(messageID),
		        eq("Response.MessageMetadata.Status", InteractionStatusType.RESPONSE_IS_ACCEPTED_BY_SMEV.toString()));
		if (sender != null) {
			filter = and(filter, eq("Response.MessageMetadata.Recipient.Mnemonic", sender.getMnemonic()));
		}
		return collection.find(filter).first();
	}

	public void putRequest(SendRequestRequest src, RequestRoutingData __routingData, boolean async) throws FailureWrapper {
		RequestRoutingData routingData = SerializationUtils.clone(__routingData);
		ProcessingTask task = new ProcessingTask(async) {
			public void run() {
				try {
					String senderMnemonic = routingData.getMessageMetadata().getSender().getMnemonic();
					String recipientMnemonic = routingData.getMessageMetadata().getRecipient().getMnemonic();
					log.info(senderMnemonic + "->" + recipientMnemonic + " : putRequest : ReplyTo = " + routingData.getReplyTo() + ", MpcKey = "
		                    + routingData.getMpcKey());
					Request request = new Request();
					request.setId("ID_" + UUID.randomUUID());
					request.setSenderProvidedRequestData(src.getSenderProvidedRequestData());
					request.setMessageMetadata(routingData.getMessageMetadata());
					request.getMessageMetadata().setStatus(InteractionStatusType.REQUEST_IS_ACCEPTED_BY_SMEV);
					request.setReplyTo(routingData.getReplyTo());
					request.setSenderInformationSystemSignature(src.getCallerInformationSystemSignature());

					RequestMessage requestMessage = new RequestMessage();
					requestMessage.setRequest(request);
					requestMessage.setAttachmentContentList(src.getAttachmentContentList());
					requestMessage.setMpcNamespace(routingData.getMpcKey().getNamespace());
					requestMessage.setMpcRootElement(routingData.getMpcKey().getRootElement());

					ftpService.complete(requestMessage);

					signService.signSMEVSignature(requestMessage);
					requestMessage.setAcknowledgmentTimestamp(System.currentTimeMillis() - acknowledgmentTimeout);

					MongoCollection<RequestMessage> collection = messagesDB.getCollection(DocNames.RequestMessage, RequestMessage.class);
					collection.insertOne(requestMessage);
				} catch (FailureWrapper failure) {
					setFailure(failure);
					if (isAsync()) {
						putFailure(src, routingData, failure);
					}
				} catch (ExceptionWrapper e) {
					FailureWrapper failure = new FailureWrapper(e);
					setFailure(failure);
					if (isAsync()) {
						putFailure(src, routingData, failure);
					}
				}
			}
		};
		if (async) {
			executorService.execute(task);
		} else {
			task.run();
			if (task.getFailure() != null) {
				throw task.getFailure();
			}
		}
	}

	private void putFailure(SendRequestRequest src, RequestRoutingData routingData, FailureWrapper failure) {
		log.info("{} : putFailure : ReplyTo = {} , MpcKey = {}", routingData.getMessageMetadata().getSender().getMnemonic(), routingData.getReplyTo() , routingData.getMpcKey() );
		log.info("{}", failure.getMessage());
		Response response = new Response();
		response.setId("ID_" + UUID.randomUUID());
		response.setOriginalMessageId(src.getSenderProvidedRequestData().getMessageID());
		response.setOriginalTransactionCode(src.getSenderProvidedRequestData().getTransactionCode());
		response.setReferenceMessageID(src.getSenderProvidedRequestData().getReferenceMessageID());

		SenderProvidedResponseData spresd = new SenderProvidedResponseData();
		spresd.setId("ID_" + UUID.randomUUID());
		spresd.setMessageID(UUID.randomUUID().toString());
		spresd.setTo(routingData.getReplyTo());

		AsyncProcessingStatus status = new AsyncProcessingStatus();
		status.setOriginalMessageId(src.getSenderProvidedRequestData().getMessageID());
		status.setStatusCategory(InteractionStatusType.REQUEST_IS_REJECTED_BY_SMEV);
		status.setStatusDetails(failure.getCause().getMessage());
		status.setSmevFault(SmevFaultHelper.failure2SmevFault(failure));
		spresd.setAsyncProcessingStatus(status);

		response.setSenderProvidedResponseData(spresd);

		MessageMetadata metadata = new MessageMetadata();
		metadata.setId("ID_" + UUID.randomUUID());
		metadata.setMessageId(spresd.getMessageID());
		metadata.setMessageType(MessageTypeType.RESPONSE);
		metadata.setSender(ModelConstants.SMEV_AS_MEMBER.toSender());
		metadata.setSendingTimestamp(datatypeFactory.newXMLGregorianCalendar(new GregorianCalendar()));
		//metadata.setRecipient(routingData.getMessageMetadata().getSender().toRecipient());
		metadata.setRecipient(routingData.getMessageMetadata().getRecipient());
		/*metadata.setSupplementaryData(new SupplementaryData());
		metadata.getSupplementaryData().setInteractionType(InteractionTypeType.OTHER);
		metadata.setDestinationName("TODO DestinationName");*/
		metadata.setStatus(InteractionStatusType.RESPONSE_IS_ACCEPTED_BY_SMEV);
		response.setMessageMetadata(metadata);

		ResponseMessage responseMessage = new ResponseMessage();
		responseMessage.setResponse(response);

		try {
			signService.signSMEVSignature(responseMessage);
			responseMessage.setAcknowledgmentTimestamp(System.currentTimeMillis() - acknowledgmentTimeout);

			MongoCollection<ResponseMessage> collection = messagesDB.getCollection(DocNames.ResponseMessage, ResponseMessage.class);
			collection.insertOne(responseMessage);

		} catch (ExceptionWrapper e) {
			log.error(e.getMessage(), e);
		}
	}

	public void putResponse(SendResponseRequest src, ResponseRoutingData __routingData, boolean async) throws FailureWrapper {
		ResponseRoutingData routingData = SerializationUtils.clone(__routingData);

		ProcessingTask task = new ProcessingTask(async) {
			public void run() {
				try {
					String senderMnemonic = routingData.getMessageMetadata().getSender().getMnemonic();
					String recipientMnemonic = routingData.getMessageMetadata().getRecipient().getMnemonic();
					log.info(senderMnemonic + "->" + recipientMnemonic + " : putResponse : To = " + routingData.getTo() + ", "
		                    + (routingData.getKind() == ResponseKind.MessagePrimaryContent ? "MpcKey=" + routingData.getMpcKey() : routingData.getKind()));
					Response response = new Response();
					response.setId("ID_" + UUID.randomUUID());
					MongoCollection<RequestMessage> requestCollection = messagesDB.getCollection(DocNames.RequestMessage, RequestMessage.class);
					RequestMessage requestMessage = requestCollection.find(eq("Request.ReplyTo", routingData.getTo())).first();
					SenderProvidedRequestData spreqd = requestMessage.getRequest().getSenderProvidedRequestData();
					response.setOriginalMessageId(spreqd.getMessageID());
					response.setOriginalTransactionCode(spreqd.getTransactionCode());
					response.setReferenceMessageID(spreqd.getReferenceMessageID());
					response.setSenderProvidedResponseData(src.getSenderProvidedResponseData());
					response.setMessageMetadata(routingData.getMessageMetadata());
					response.getMessageMetadata().setStatus(InteractionStatusType.RESPONSE_IS_ACCEPTED_BY_SMEV);
					response.setSenderInformationSystemSignature(src.getCallerInformationSystemSignature());

					ResponseMessage responseMessage = new ResponseMessage();
					responseMessage.setResponse(response);
					if (routingData.getMpcKey() != null) {
						responseMessage.setAttachmentContentList(src.getAttachmentContentList());
						responseMessage.setMpcNamespace(routingData.getMpcKey().getNamespace());
						responseMessage.setMpcRootElement(routingData.getMpcKey().getRootElement());
						ftpService.complete(responseMessage);
					}

					signService.signSMEVSignature(responseMessage);
					responseMessage.setAcknowledgmentTimestamp(System.currentTimeMillis() - acknowledgmentTimeout);

					MongoCollection<ResponseMessage> responseCollection = messagesDB.getCollection(DocNames.ResponseMessage, ResponseMessage.class);
					responseCollection.insertOne(responseMessage);

				} catch (FailureWrapper failure) {
					setFailure(failure);
					if (isAsync()) {
						putStatus(src, routingData, failure);
					}
				} catch (ExceptionWrapper e) {
					FailureWrapper failure = new FailureWrapper(e);
					setFailure(failure);
					if (isAsync()) {
						putStatus(src, routingData, failure);
					}
				}
			}
		};
		if (async) {
			executorService.submit(task);
		} else {
			task.run();
			if (task.getFailure() != null) {
				throw task.getFailure();
			}
		}
	}

	private void putStatus(SendResponseRequest src, ResponseRoutingData routingData, FailureWrapper failure) {
		log.info(routingData.getMessageMetadata().getSender().getMnemonic() + " : putStatus : To = " + routingData.getTo() + ", MpcKey = "
		        + routingData.getMpcKey());
		AsyncProcessingStatus status = new AsyncProcessingStatus();

		status.setOriginalMessageId(src.getSenderProvidedResponseData().getMessageID());
		status.setStatusCategory(InteractionStatusType.REQUEST_IS_REJECTED_BY_SMEV);
		status.setStatusDetails(failure.getCause().getMessage());
		status.setSmevFault(SmevFaultHelper.failure2SmevFault(failure));

		SmevAsyncProcessingMessage statusMessage = new SmevAsyncProcessingMessage();
		statusMessage.setAsyncProcessingStatusData(new AsyncProcessingStatusData());
		statusMessage.getAsyncProcessingStatusData().setId("ID_" + UUID.randomUUID());
		statusMessage.getAsyncProcessingStatusData().setAsyncProcessingStatus(status);

		//statusMessage.setRecipient(routingData.getMessageMetadata().getSender().toRecipient());

		try {
			signService.signSMEVSignature(statusMessage);

			MongoCollection<SmevAsyncProcessingMessage> collection = messagesDB.getCollection(DocNames.StatusMessage, SmevAsyncProcessingMessage.class);
			collection.insertOne(statusMessage);
		} catch (ExceptionWrapper e) {
			log.error(e.getMessage(), e);
		}
	}

	public boolean ackRequest(String messageID, SmevMember sender) throws ExceptionWrapper {
		MongoCollection<RequestMessage> collection = messagesDB.getCollection(DocNames.RequestMessage, RequestMessage.class);
		Bson filter = and(ModelFilters.forRequestMessageID(messageID),
		        eq("Request.MessageMetadata.Status", InteractionStatusType.REQUEST_IS_ACCEPTED_BY_SMEV.toString()));
		filter = and(filter, eq("Request.MessageMetadata.Recipient.Mnemonic", sender.getMnemonic()));
		RequestMessage requestMessage = collection.findOneAndDelete(filter);
		if (requestMessage != null) {
			if (requestMessage.getRequest().getFSAttachmentsList() != null) {
				ftpService.archive(requestMessage.getRequest().getFSAttachmentsList());
			}
			requestMessage.getRequest().getMessageMetadata().setDeliveryTimestamp(datatypeFactory.newXMLGregorianCalendar(new GregorianCalendar()));
			requestMessage.getRequest().getMessageMetadata().setStatus(InteractionStatusType.UNDER_PROCESSING);
			signService.signSMEVSignature(requestMessage);
			collection.insertOne(requestMessage);
			log.info(sender.getMnemonic() + " : ack : MessageID = " + messageID + " -> Request, OK");
			return true;
		} else {
			return false;
		}
	}

	public boolean ackResponse(String messageID, SmevMember sender) throws ExceptionWrapper {
		MongoCollection<ResponseMessage> collection = messagesDB.getCollection(DocNames.ResponseMessage, ResponseMessage.class);
		Bson filter = and(ModelFilters.forResponseMessageID(messageID),
		        eq("Response.MessageMetadata.Status", InteractionStatusType.RESPONSE_IS_ACCEPTED_BY_SMEV.toString()));
		filter = and(filter, eq("Response.MessageMetadata.Recipient.Mnemonic", sender.getMnemonic()));
		ResponseMessage responseMessage = collection.findOneAndDelete(filter);
		if (responseMessage != null) {
			if (responseMessage.getResponse().getFSAttachmentsList() != null) {
				ftpService.archive(responseMessage.getResponse().getFSAttachmentsList());
			}
			responseMessage.getResponse().getMessageMetadata().setDeliveryTimestamp(datatypeFactory.newXMLGregorianCalendar(new GregorianCalendar()));
			responseMessage.getResponse().getMessageMetadata().setStatus(InteractionStatusType.RESPONSE_IS_DELIVERED);
			signService.signSMEVSignature(responseMessage);
			collection.insertOne(responseMessage);
			log.info(sender.getMnemonic() + " : ack : MessageID = " + messageID + " -> Response, OK");
			return true;
		} else {
			return false;
		}
	}

	public RequestMessage getRequest(GetRequestRequest request, SmevMember recipient) {
		log.info(recipient.getMnemonic() + " : getRequest");
		log.info("{}", recipient.toString());
		MongoCollection<RequestMessage> collection = messagesDB.getCollection(DocNames.RequestMessage, RequestMessage.class);
		Bson filter = eq("Request.MessageMetadata.Status", InteractionStatusType.REQUEST_IS_ACCEPTED_BY_SMEV.toString());
		filter = and(filter, eq("Request.MessageMetadata.Recipient.Mnemonic", recipient.getMnemonic()));
		filter = and(filter, ModelFilters.forAcknowledgment(acknowledgmentTimeout));
		String mpcNamespace = request.getMessageTypeSelector().getNamespaceURI();
		String mpcRootElement = request.getMessageTypeSelector().getRootElementLocalName();
		if (mpcNamespace != null && mpcRootElement != null) {
			filter = and(filter, ModelFilters.forMPC(mpcNamespace, mpcRootElement));
		}
		// TODO добавить в фильтр String nodeID =
		// request.getMessageTypeSelector().getNodeID();

		RequestMessage requestMessage = collection.find(filter).sort(ascending("Request.MessageMetadata.SendingTimestamp")).first();



		if (getMode() == SmevPrimeServiceLocal.Mode.LIVE && requestMessage != null) {
			collection.updateOne(eq(FieldNames.docId, requestMessage.getDocId().toString()),
			        new Document("$set", new Document(FieldNames.acknowledgmentTimestamp, System.currentTimeMillis())));
		}
		return requestMessage;
	}

	public ResponseMessage getResponse(GetResponseRequest request, SmevMember recipient) {
		log.info(recipient.getMnemonic() + " : getResponse");
		MongoCollection<ResponseMessage> collection = messagesDB.getCollection(DocNames.ResponseMessage, ResponseMessage.class);
		Bson filter = eq("Response.MessageMetadata.Status", InteractionStatusType.RESPONSE_IS_ACCEPTED_BY_SMEV.toString());
		filter = and(filter, eq("Response.MessageMetadata.Recipient.Mnemonic", recipient.getMnemonic()));
		filter = and(filter, ModelFilters.forAcknowledgment(acknowledgmentTimeout));
		String mpcNamespace = request.getMessageTypeSelector().getNamespaceURI();
		String mpcRootElement = request.getMessageTypeSelector().getRootElementLocalName();
		if (mpcNamespace != null && mpcRootElement != null) {
			filter = and(filter, ModelFilters.forMPC(mpcNamespace, mpcRootElement));
		}
		// TODO добавить в фильтр String nodeID =
		// request.getMessageTypeSelector().getNodeID();

		ResponseMessage responseMessage = collection.find(filter).sort(ascending("Response.MessageMetadata.SendingTimestamp")).first();
		if (getMode() == SmevPrimeServiceLocal.Mode.LIVE && responseMessage != null) {
			collection.updateOne(eq(FieldNames.docId, responseMessage.getDocId().toString()),
			        new Document("$set", new Document(FieldNames.acknowledgmentTimestamp, System.currentTimeMillis())));
		}
		return responseMessage;
	}

	public SmevAsyncProcessingMessage getStatus(GetStatusRequest request, SmevMember sender) {
		log.info(sender.getMnemonic() + " : getStatus");
		MongoCollection<SmevAsyncProcessingMessage> collection = messagesDB.getCollection(DocNames.StatusMessage, SmevAsyncProcessingMessage.class);
		Bson filter = eq(FieldNames.delivered, false);
		filter = and(filter, eq("Recipient.Mnemonic", sender.getMnemonic()));
		SmevAsyncProcessingMessage statusMessage = collection.find(filter).first();
		if (getMode() == SmevPrimeServiceLocal.Mode.LIVE && statusMessage != null) {
			//collection.updateOne(eq(FieldNames.docId, statusMessage.getDocId().toString()), new Document("$set", new Document(FieldNames.delivered, true)));
		}
		return statusMessage;
	}
}
