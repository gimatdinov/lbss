
package ru.otr.lbss.ws.api.types;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlID;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.CollapsedStringAdapter;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

import ru.otr.lbss.ws.api.types.basic.FSAttachmentsList;
import ru.otr.lbss.ws.api.types.basic.XMLDSigSignatureType;

/**
 * <p>
 * Java class for anonymous complex type.
 * 
 * <p>
 * The following schema fragment specifies the expected content contained within
 * this class.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element ref="{urn://x-artefacts-smev-gov-ru/services/message-exchange/types/1.1}SenderProvidedRequestData"/>
 *         &lt;element ref="{urn://x-artefacts-smev-gov-ru/services/message-exchange/types/1.1}MessageMetadata"/>
 *         &lt;element ref="{urn://x-artefacts-smev-gov-ru/services/message-exchange/types/basic/1.1}FSAttachmentsList" minOccurs="0"/>
 *         &lt;element name="ReplyTo" type="{urn://x-artefacts-smev-gov-ru/services/message-exchange/types/basic/1.1}string-4000"/>
 *         &lt;element name="SenderInformationSystemSignature" type="{urn://x-artefacts-smev-gov-ru/services/message-exchange/types/basic/1.1}XMLDSigSignatureType" minOccurs="0"/>
 *       &lt;/sequence>
 *       &lt;attribute name="Id" type="{http://www.w3.org/2001/XMLSchema}ID" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = { "senderProvidedRequestData", "messageMetadata", "fsAttachmentsList", "replyTo", "senderInformationSystemSignature" })
@XmlRootElement(name = "Request")
public class Request {

	@XmlElement(name = "SenderProvidedRequestData", required = true)
	protected SenderProvidedRequestData senderProvidedRequestData;
	@XmlElement(name = "MessageMetadata", required = true)
	protected MessageMetadata messageMetadata;
	@XmlElement(name = "FSAttachmentsList", namespace = "urn://x-artefacts-smev-gov-ru/services/message-exchange/types/basic/1.1")
	protected FSAttachmentsList fsAttachmentsList;
	@XmlElement(name = "ReplyTo", required = true)
	protected String replyTo;
	@XmlElement(name = "SenderInformationSystemSignature")
	protected XMLDSigSignatureType senderInformationSystemSignature;
	@XmlAttribute(name = "Id")
	@XmlJavaTypeAdapter(CollapsedStringAdapter.class)
	@XmlID
	@XmlSchemaType(name = "ID")
	protected String id;

	/**
	 * Gets the value of the senderProvidedRequestData property.
	 * 
	 * @return possible object is {@link SenderProvidedRequestData }
	 * 
	 */
	public SenderProvidedRequestData getSenderProvidedRequestData() {
		return senderProvidedRequestData;
	}

	/**
	 * Sets the value of the senderProvidedRequestData property.
	 * 
	 * @param value
	 *            allowed object is {@link SenderProvidedRequestData }
	 * 
	 */
	public void setSenderProvidedRequestData(SenderProvidedRequestData value) {
		this.senderProvidedRequestData = value;
	}

	/**
	 * 
	 * Информация об отправителе, дате отправки, маршрутизации сообщения, и
	 * другая (см. определение типа). Все данные заполняются СМЭВ. Элемент
	 * //MessageMetadata/SendingTimestamp содержит дату и время, начиная с
	 * которых отсчитывается срок исполнения запроса. Остальные данные
	 * предназначены для целей анализа (машинного и ручного) качества
	 * обслуживания информационной системы - получателя сообщения, а также для
	 * предоставления службе поддержки оператора СМЭВ в случае необходимости.
	 * 
	 * 
	 * @return possible object is {@link MessageMetadata }
	 * 
	 */
	public MessageMetadata getMessageMetadata() {
		return messageMetadata;
	}

	/**
	 * Sets the value of the messageMetadata property.
	 * 
	 * @param value
	 *            allowed object is {@link MessageMetadata }
	 * 
	 */
	public void setMessageMetadata(MessageMetadata value) {
		this.messageMetadata = value;
	}

	/**
	 * Gets the value of the fsAttachmentsList property.
	 * 
	 * @return possible object is {@link FSAttachmentsList }
	 * 
	 */
	public FSAttachmentsList getFSAttachmentsList() {
		return fsAttachmentsList;
	}

	/**
	 * Sets the value of the fsAttachmentsList property.
	 * 
	 * @param value
	 *            allowed object is {@link FSAttachmentsList }
	 * 
	 */
	public void setFSAttachmentsList(FSAttachmentsList value) {
		this.fsAttachmentsList = value;
	}

	/**
	 * Gets the value of the replyTo property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getReplyTo() {
		return replyTo;
	}

	/**
	 * Sets the value of the replyTo property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setReplyTo(String value) {
		this.replyTo = value;
	}

	/**
	 * Gets the value of the senderInformationSystemSignature property.
	 * 
	 * @return possible object is {@link XMLDSigSignatureType }
	 * 
	 */
	public XMLDSigSignatureType getSenderInformationSystemSignature() {
		return senderInformationSystemSignature;
	}

	/**
	 * Sets the value of the senderInformationSystemSignature property.
	 * 
	 * @param value
	 *            allowed object is {@link XMLDSigSignatureType }
	 * 
	 */
	public void setSenderInformationSystemSignature(XMLDSigSignatureType value) {
		this.senderInformationSystemSignature = value;
	}

	/**
	 * Gets the value of the id property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getId() {
		return id;
	}

	/**
	 * Sets the value of the id property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setId(String value) {
		this.id = value;
	}

}
