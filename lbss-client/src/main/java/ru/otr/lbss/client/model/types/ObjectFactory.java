package ru.otr.lbss.client.model.types;

import ru.otr.lbss.client.model.types.basic.*;
import ru.otr.lbss.client.model.types.basic.Void;
import ru.otr.lbss.client.model.types.directive.Record;
import ru.otr.lbss.client.model.types.directive.RecordContent;
import ru.otr.lbss.client.model.types.directive.Registry;
import ru.otr.lbss.client.model.types.directive.RegistryRecord;
import ru.otr.lbss.client.model.types.fault.*;
import ru.otr.lbss.client.model.types.routing.*;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;



/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the ru.otr.lbss.client.model package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _MessageIsAlreadySent_QNAME = new QName("urn://x-artefacts-smev-gov-ru/services/message-exchange/types/faults/1.3", "MessageIsAlreadySent");
    private final static QName _InvalidMessageIdFormat_QNAME = new QName("urn://x-artefacts-smev-gov-ru/services/message-exchange/types/faults/1.3", "InvalidMessageIdFormat");
    private final static QName _BusinessDataTypeIsNotSupported_QNAME = new QName("urn://x-artefacts-smev-gov-ru/services/message-exchange/types/faults/1.3", "BusinessDataTypeIsNotSupported");
    private final static QName _QuoteLimitExceeded_QNAME = new QName("urn://x-artefacts-smev-gov-ru/services/message-exchange/types/faults/1.3", "QuoteLimitExceeded");
    private final static QName _AttachmentSizeLimitExceeded_QNAME = new QName("urn://x-artefacts-smev-gov-ru/services/message-exchange/types/faults/1.3", "AttachmentSizeLimitExceeded");
    private final static QName _SMEVFailure_QNAME = new QName("urn://x-artefacts-smev-gov-ru/services/message-exchange/types/faults/1.3", "SMEVFailure");
    private final static QName _SenderIsNotRegistered_QNAME = new QName("urn://x-artefacts-smev-gov-ru/services/message-exchange/types/faults/1.3", "SenderIsNotRegistered");
    private final static QName _RecipientIsNotFound_QNAME = new QName("urn://x-artefacts-smev-gov-ru/services/message-exchange/types/faults/1.3", "RecipientIsNotFound");
    private final static QName _DestinationOverflow_QNAME = new QName("urn://x-artefacts-smev-gov-ru/services/message-exchange/types/faults/1.3", "DestinationOverflow");
    private final static QName _AccessDenied_QNAME = new QName("urn://x-artefacts-smev-gov-ru/services/message-exchange/types/faults/1.3", "AccessDenied");
    private final static QName _SignatureVerificationFault_QNAME = new QName("urn://x-artefacts-smev-gov-ru/services/message-exchange/types/faults/1.3", "SignatureVerificationFault");
    private final static QName _EndOfLifeReached_QNAME = new QName("urn://x-artefacts-smev-gov-ru/services/message-exchange/types/faults/1.3", "EndOfLifeReached");
    private final static QName _InvalidContent_QNAME = new QName("urn://x-artefacts-smev-gov-ru/services/message-exchange/types/faults/1.3", "InvalidContent");
    private final static QName _UnknownMessageType_QNAME = new QName("urn://x-artefacts-smev-gov-ru/services/message-exchange/types/faults/1.3", "UnknownMessageType");
    private final static QName _TransactionCodeInvalid_QNAME = new QName("urn://x-artefacts-smev-gov-ru/services/message-exchange/types/faults/1.3", "TransactionCodeInvalid");
    private final static QName _AttachmentContentMiscoordination_QNAME = new QName("urn://x-artefacts-smev-gov-ru/services/message-exchange/types/faults/1.3", "AttachmentContentMiscoordination");
    private final static QName _StaleMessageId_QNAME = new QName("urn://x-artefacts-smev-gov-ru/services/message-exchange/types/faults/1.3", "StaleMessageId");
    private final static QName _TargetMessageIsNotFound_QNAME = new QName("urn://x-artefacts-smev-gov-ru/services/message-exchange/types/faults/1.3", "TargetMessageIsNotFound");
    private final static QName _AckResponse_QNAME = new QName("urn://x-artefacts-smev-gov-ru/services/message-exchange/types/1.3", "AckResponse");
    private final static QName _IncorrectResponseContentType_QNAME = new QName("urn://x-artefacts-smev-gov-ru/services/message-exchange/types/faults/1.3", "IncorrectResponseContentType");
    private final static QName _RequestIsNotFound_QNAME = new QName("urn://x-artefacts-smev-gov-ru/services/message-exchange/types/faults/1.3", "RequestIsNotFound");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: ru.otr.lbss.client.model
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link SenderProvidedRequestData }
     * 
     */
    public SenderProvidedRequestData createSenderProvidedRequestData() {
        return new SenderProvidedRequestData();
    }

    /**
     * Create an instance of {@link MessageMetadata }
     * 
     */
    public MessageMetadata createMessageMetadata() {
        return new MessageMetadata();
    }

    /**
     * Create an instance of {@link SenderProvidedResponseData }
     * 
     */
    public SenderProvidedResponseData createSenderProvidedResponseData() {
        return new SenderProvidedResponseData();
    }

    /**
     * Create an instance of {@link GetRequestResponse }
     * 
     */
    public GetRequestResponse createGetRequestResponse() {
        return new GetRequestResponse();
    }

    /**
     * Create an instance of {@link GetResponseResponse }
     * 
     */
    public GetResponseResponse createGetResponseResponse() {
        return new GetResponseResponse();
    }

    /**
     * Create an instance of {@link InvalidContent }
     * 
     */
    public InvalidContent createInvalidContent() {
        return new InvalidContent();
    }

    /**
     * Create an instance of {@link SenderProvidedResponseData.RequestStatus }
     * 
     */
    public SenderProvidedResponseData.RequestStatus createSenderProvidedResponseDataRequestStatus() {
        return new SenderProvidedResponseData.RequestStatus();
    }

    /**
     * Create an instance of {@link GetStatusRequest }
     * 
     */
    public GetStatusRequest createGetStatusRequest() {
        return new GetStatusRequest();
    }

    /**
     * Create an instance of {@link Timestamp }
     * 
     */
    public Timestamp createTimestamp() {
        return new Timestamp();
    }

    /**
     * Create an instance of {@link XMLDSigSignatureType }
     * 
     */
    public XMLDSigSignatureType createXMLDSigSignatureType() {
        return new XMLDSigSignatureType();
    }

    /**
     * Create an instance of {@link GetStatusResponse }
     * 
     */
    public GetStatusResponse createGetStatusResponse() {
        return new GetStatusResponse();
    }

    /**
     * Create an instance of {@link SmevAsyncProcessingMessage }
     * 
     */
    public SmevAsyncProcessingMessage createSmevAsyncProcessingMessage() {
        return new SmevAsyncProcessingMessage();
    }

    /**
     * Create an instance of {@link AsyncProcessingStatusData }
     * 
     */
    public AsyncProcessingStatusData createAsyncProcessingStatusData() {
        return new AsyncProcessingStatusData();
    }

    /**
     * Create an instance of {@link AsyncProcessingStatus }
     * 
     */
    public AsyncProcessingStatus createAsyncProcessingStatus() {
        return new AsyncProcessingStatus();
    }

    /**
     * Create an instance of {@link RoutingStatus }
     * 
     */
    public RoutingStatus createRoutingStatus() {
        return new RoutingStatus();
    }

    /**
     * Create an instance of {@link DynamicRoutingStatus }
     * 
     */
    public DynamicRoutingStatus createDynamicRoutingStatus() {
        return new DynamicRoutingStatus();
    }

    /**
     * Create an instance of {@link IdentifierRoutingStatus }
     * 
     */
    public IdentifierRoutingStatus createIdentifierRoutingStatus() {
        return new IdentifierRoutingStatus();
    }

    /**
     * Create an instance of {@link RegistryRoutingStatus }
     * 
     */
    public RegistryRoutingStatus createRegistryRoutingStatus() {
        return new RegistryRoutingStatus();
    }

    /**
     * Create an instance of {@link SmevFault }
     * 
     */
    public SmevFault createSmevFault() {
        return new SmevFault();
    }

    /**
     * Create an instance of {@link AckRequest }
     * 
     */
    public AckRequest createAckRequest() {
        return new AckRequest();
    }

    /**
     * Create an instance of {@link AckTargetMessage }
     * 
     */
    public AckTargetMessage createAckTargetMessage() {
        return new AckTargetMessage();
    }

    /**
     * Create an instance of {@link Request }
     * 
     */
    public Request createRequest() {
        return new Request();
    }

    /**
     * Create an instance of {@link MessagePrimaryContent }
     * 
     */
    public MessagePrimaryContent createMessagePrimaryContent() {
        return new MessagePrimaryContent();
    }

    /**
     * Create an instance of {@link AttachmentHeaderList }
     * 
     */
    public AttachmentHeaderList createAttachmentHeaderList() {
        return new AttachmentHeaderList();
    }

    /**
     * Create an instance of {@link AttachmentHeaderType }
     * 
     */
    public AttachmentHeaderType createAttachmentHeaderType() {
        return new AttachmentHeaderType();
    }

    /**
     * Create an instance of {@link RefAttachmentHeaderList }
     * 
     */
    public RefAttachmentHeaderList createRefAttachmentHeaderList() {
        return new RefAttachmentHeaderList();
    }

    /**
     * Create an instance of {@link RefAttachmentHeaderType }
     * 
     */
    public RefAttachmentHeaderType createRefAttachmentHeaderType() {
        return new RefAttachmentHeaderType();
    }

    /**
     * Create an instance of {@link SenderProvidedRequestData.BusinessProcessMetadata }
     * 
     */
    public SenderProvidedRequestData.BusinessProcessMetadata createSenderProvidedRequestDataBusinessProcessMetadata() {
        return new SenderProvidedRequestData.BusinessProcessMetadata();
    }

    /**
     * Create an instance of {@link Void }
     * 
     */
    public Void createVoid() {
        return new Void();
    }

    /**
     * Create an instance of {@link MessageMetadata.Sender }
     * 
     */
    public MessageMetadata.Sender createMessageMetadataSender() {
        return new MessageMetadata.Sender();
    }

    /**
     * Create an instance of {@link MessageMetadata.Recipient }
     * 
     */
    public MessageMetadata.Recipient createMessageMetadataRecipient() {
        return new MessageMetadata.Recipient();
    }

    /**
     * Create an instance of {@link FSAttachmentsList }
     * 
     */
    public FSAttachmentsList createFSAttachmentsList() {
        return new FSAttachmentsList();
    }

    /**
     * Create an instance of {@link FSAuthInfo }
     * 
     */
    public FSAuthInfo createFSAuthInfo() {
        return new FSAuthInfo();
    }

    /**
     * Create an instance of {@link SendRequestRequest }
     * 
     */
    public SendRequestRequest createSendRequestRequest() {
        return new SendRequestRequest();
    }

    /**
     * Create an instance of {@link AttachmentContentList }
     * 
     */
    public AttachmentContentList createAttachmentContentList() {
        return new AttachmentContentList();
    }

    /**
     * Create an instance of {@link AttachmentContentType }
     * 
     */
    public AttachmentContentType createAttachmentContentType() {
        return new AttachmentContentType();
    }

    /**
     * Create an instance of {@link Routing }
     * 
     */
    public Routing createRouting() {
        return new Routing();
    }

    /**
     * Create an instance of {@link RoutingInformation }
     * 
     */
    public RoutingInformation createRoutingInformation() {
        return new RoutingInformation();
    }

    /**
     * Create an instance of {@link DynamicRouting }
     * 
     */
    public DynamicRouting createDynamicRouting() {
        return new DynamicRouting();
    }

    /**
     * Create an instance of {@link IdentifierRouting }
     * 
     */
    public IdentifierRouting createIdentifierRouting() {
        return new IdentifierRouting();
    }

    /**
     * Create an instance of {@link RegistryRouting }
     * 
     */
    public RegistryRouting createRegistryRouting() {
        return new RegistryRouting();
    }

    /**
     * Create an instance of {@link RegistryRecordRouting }
     * 
     */
    public RegistryRecordRouting createRegistryRecordRouting() {
        return new RegistryRecordRouting();
    }

    /**
     * Create an instance of {@link Response }
     * 
     */
    public Response createResponse() {
        return new Response();
    }

    /**
     * Create an instance of {@link SenderProvidedResponseData.RequestRejected }
     * 
     */
    public SenderProvidedResponseData.RequestRejected createSenderProvidedResponseDataRequestRejected() {
        return new SenderProvidedResponseData.RequestRejected();
    }

    /**
     * Create an instance of {@link SendResponseRequest }
     * 
     */
    public SendResponseRequest createSendResponseRequest() {
        return new SendResponseRequest();
    }

    /**
     * Create an instance of {@link SendRequestResponse }
     * 
     */
    public SendRequestResponse createSendRequestResponse() {
        return new SendRequestResponse();
    }

    /**
     * Create an instance of {@link GetRequestResponse.RequestMessage }
     * 
     */
    public GetRequestResponse.RequestMessage createGetRequestResponseRequestMessage() {
        return new GetRequestResponse.RequestMessage();
    }

    /**
     * Create an instance of {@link GetResponseResponse.ResponseMessage }
     * 
     */
    public GetResponseResponse.ResponseMessage createGetResponseResponseResponseMessage() {
        return new GetResponseResponse.ResponseMessage();
    }

    /**
     * Create an instance of {@link SendResponseResponse }
     * 
     */
    public SendResponseResponse createSendResponseResponse() {
        return new SendResponseResponse();
    }

    /**
     * Create an instance of {@link GetResponseRequest }
     * 
     */
    public GetResponseRequest createGetResponseRequest() {
        return new GetResponseRequest();
    }

    /**
     * Create an instance of {@link MessageTypeSelector }
     * 
     */
    public MessageTypeSelector createMessageTypeSelector() {
        return new MessageTypeSelector();
    }

    /**
     * Create an instance of {@link GetRequestRequest }
     * 
     */
    public GetRequestRequest createGetRequestRequest() {
        return new GetRequestRequest();
    }

    /**
     * Create an instance of {@link MessageReference }
     * 
     */
    public MessageReference createMessageReference() {
        return new MessageReference();
    }

    /**
     * Create an instance of {@link ArchiveType }
     * 
     */
    public ArchiveType createArchiveType() {
        return new ArchiveType();
    }

    /**
     * Create an instance of {@link FileType }
     * 
     */
    public FileType createFileType() {
        return new FileType();
    }

    /**
     * Create an instance of {@link RegistryRecord }
     * 
     */
    public RegistryRecord createRegistryRecord() {
        return new RegistryRecord();
    }

    /**
     * Create an instance of {@link Record }
     * 
     */
    public Record createRecord() {
        return new Record();
    }

    /**
     * Create an instance of {@link RecordContent }
     * 
     */
    public RecordContent createRecordContent() {
        return new RecordContent();
    }

    /**
     * Create an instance of {@link Registry }
     * 
     */
    public Registry createRegistry() {
        return new Registry();
    }

    /**
     * Create an instance of {@link SignatureVerificationFault }
     * 
     */
    public SignatureVerificationFault createSignatureVerificationFault() {
        return new SignatureVerificationFault();
    }

    /**
     * Create an instance of {@link DestinationOverflow }
     * 
     */
    public DestinationOverflow createDestinationOverflow() {
        return new DestinationOverflow();
    }

    /**
     * Create an instance of {@link QuoteLimitExceeded }
     * 
     */
    public QuoteLimitExceeded createQuoteLimitExceeded() {
        return new QuoteLimitExceeded();
    }

    /**
     * Create an instance of {@link AttachmentSizeLimitExceeded }
     * 
     */
    public AttachmentSizeLimitExceeded createAttachmentSizeLimitExceeded() {
        return new AttachmentSizeLimitExceeded();
    }

    /**
     * Create an instance of {@link BusinessDataTypeIsNotSupported }
     * 
     */
    public BusinessDataTypeIsNotSupported createBusinessDataTypeIsNotSupported() {
        return new BusinessDataTypeIsNotSupported();
    }

    /**
     * Create an instance of {@link InvalidContent.ValidationError }
     * 
     */
    public InvalidContent.ValidationError createInvalidContentValidationError() {
        return new InvalidContent.ValidationError();
    }

    /**
     * Create an instance of {@link SenderProvidedResponseData.RequestStatus.StatusParameter }
     * 
     */
    public SenderProvidedResponseData.RequestStatus.StatusParameter createSenderProvidedResponseDataRequestStatusStatusParameter() {
        return new SenderProvidedResponseData.RequestStatus.StatusParameter();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Void }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "urn://x-artefacts-smev-gov-ru/services/message-exchange/types/faults/1.3", name = "MessageIsAlreadySent")
    public JAXBElement<Void> createMessageIsAlreadySent(Void value) {
        return new JAXBElement<Void>(_MessageIsAlreadySent_QNAME, Void.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Void }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "urn://x-artefacts-smev-gov-ru/services/message-exchange/types/faults/1.3", name = "InvalidMessageIdFormat")
    public JAXBElement<Void> createInvalidMessageIdFormat(Void value) {
        return new JAXBElement<Void>(_InvalidMessageIdFormat_QNAME, Void.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link BusinessDataTypeIsNotSupported }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "urn://x-artefacts-smev-gov-ru/services/message-exchange/types/faults/1.3", name = "BusinessDataTypeIsNotSupported")
    public JAXBElement<BusinessDataTypeIsNotSupported> createBusinessDataTypeIsNotSupported(BusinessDataTypeIsNotSupported value) {
        return new JAXBElement<BusinessDataTypeIsNotSupported>(_BusinessDataTypeIsNotSupported_QNAME, BusinessDataTypeIsNotSupported.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link QuoteLimitExceeded }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "urn://x-artefacts-smev-gov-ru/services/message-exchange/types/faults/1.3", name = "QuoteLimitExceeded")
    public JAXBElement<QuoteLimitExceeded> createQuoteLimitExceeded(QuoteLimitExceeded value) {
        return new JAXBElement<QuoteLimitExceeded>(_QuoteLimitExceeded_QNAME, QuoteLimitExceeded.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AttachmentSizeLimitExceeded }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "urn://x-artefacts-smev-gov-ru/services/message-exchange/types/faults/1.3", name = "AttachmentSizeLimitExceeded")
    public JAXBElement<AttachmentSizeLimitExceeded> createAttachmentSizeLimitExceeded(AttachmentSizeLimitExceeded value) {
        return new JAXBElement<AttachmentSizeLimitExceeded>(_AttachmentSizeLimitExceeded_QNAME, AttachmentSizeLimitExceeded.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Void }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "urn://x-artefacts-smev-gov-ru/services/message-exchange/types/faults/1.3", name = "SMEVFailure")
    public JAXBElement<Void> createSMEVFailure(Void value) {
        return new JAXBElement<Void>(_SMEVFailure_QNAME, Void.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Void }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "urn://x-artefacts-smev-gov-ru/services/message-exchange/types/faults/1.3", name = "SenderIsNotRegistered")
    public JAXBElement<Void> createSenderIsNotRegistered(Void value) {
        return new JAXBElement<Void>(_SenderIsNotRegistered_QNAME, Void.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Void }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "urn://x-artefacts-smev-gov-ru/services/message-exchange/types/faults/1.3", name = "RecipientIsNotFound")
    public JAXBElement<Void> createRecipientIsNotFound(Void value) {
        return new JAXBElement<Void>(_RecipientIsNotFound_QNAME, Void.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DestinationOverflow }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "urn://x-artefacts-smev-gov-ru/services/message-exchange/types/faults/1.3", name = "DestinationOverflow")
    public JAXBElement<DestinationOverflow> createDestinationOverflow(DestinationOverflow value) {
        return new JAXBElement<DestinationOverflow>(_DestinationOverflow_QNAME, DestinationOverflow.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Void }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "urn://x-artefacts-smev-gov-ru/services/message-exchange/types/faults/1.3", name = "AccessDenied")
    public JAXBElement<Void> createAccessDenied(Void value) {
        return new JAXBElement<Void>(_AccessDenied_QNAME, Void.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SignatureVerificationFault }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "urn://x-artefacts-smev-gov-ru/services/message-exchange/types/faults/1.3", name = "SignatureVerificationFault")
    public JAXBElement<SignatureVerificationFault> createSignatureVerificationFault(SignatureVerificationFault value) {
        return new JAXBElement<SignatureVerificationFault>(_SignatureVerificationFault_QNAME, SignatureVerificationFault.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Void }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "urn://x-artefacts-smev-gov-ru/services/message-exchange/types/faults/1.3", name = "EndOfLifeReached")
    public JAXBElement<Void> createEndOfLifeReached(Void value) {
        return new JAXBElement<Void>(_EndOfLifeReached_QNAME, Void.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link InvalidContent }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "urn://x-artefacts-smev-gov-ru/services/message-exchange/types/faults/1.3", name = "InvalidContent")
    public JAXBElement<InvalidContent> createInvalidContent(InvalidContent value) {
        return new JAXBElement<InvalidContent>(_InvalidContent_QNAME, InvalidContent.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Void }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "urn://x-artefacts-smev-gov-ru/services/message-exchange/types/faults/1.3", name = "UnknownMessageType")
    public JAXBElement<Void> createUnknownMessageType(Void value) {
        return new JAXBElement<Void>(_UnknownMessageType_QNAME, Void.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SmevFault }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "urn://x-artefacts-smev-gov-ru/services/message-exchange/types/faults/1.3", name = "TransactionCodeInvalid")
    public JAXBElement<SmevFault> createTransactionCodeInvalid(SmevFault value) {
        return new JAXBElement<SmevFault>(_TransactionCodeInvalid_QNAME, SmevFault.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Void }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "urn://x-artefacts-smev-gov-ru/services/message-exchange/types/faults/1.3", name = "AttachmentContentMiscoordination")
    public JAXBElement<Void> createAttachmentContentMiscoordination(Void value) {
        return new JAXBElement<Void>(_AttachmentContentMiscoordination_QNAME, Void.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Void }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "urn://x-artefacts-smev-gov-ru/services/message-exchange/types/faults/1.3", name = "StaleMessageId")
    public JAXBElement<Void> createStaleMessageId(Void value) {
        return new JAXBElement<Void>(_StaleMessageId_QNAME, Void.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Void }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "urn://x-artefacts-smev-gov-ru/services/message-exchange/types/faults/1.3", name = "TargetMessageIsNotFound")
    public JAXBElement<Void> createTargetMessageIsNotFound(Void value) {
        return new JAXBElement<Void>(_TargetMessageIsNotFound_QNAME, Void.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Void }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "urn://x-artefacts-smev-gov-ru/services/message-exchange/types/1.3", name = "AckResponse")
    public JAXBElement<Void> createAckResponse(Void value) {
        return new JAXBElement<Void>(_AckResponse_QNAME, Void.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Void }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "urn://x-artefacts-smev-gov-ru/services/message-exchange/types/faults/1.3", name = "IncorrectResponseContentType")
    public JAXBElement<Void> createIncorrectResponseContentType(Void value) {
        return new JAXBElement<Void>(_IncorrectResponseContentType_QNAME, Void.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Void }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "urn://x-artefacts-smev-gov-ru/services/message-exchange/types/faults/1.3", name = "RequestIsNotFound")
    public JAXBElement<Void> createRequestIsNotFound(Void value) {
        return new JAXBElement<Void>(_RequestIsNotFound_QNAME, Void.class, null, value);
    }

}
