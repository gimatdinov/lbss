
package ru.otr.lbss.client.model.types;

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

import ru.otr.lbss.client.model.types.basic.FSAttachmentsList;
import ru.otr.lbss.client.model.types.basic.XMLDSigSignatureType;

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
 *         &lt;element name="OriginalMessageId" type="{urn://x-artefacts-smev-gov-ru/services/message-exchange/types/basic/1.1}UUID" minOccurs="0"/>
 *         &lt;element name="OriginalTransactionCode" type="{urn://x-artefacts-smev-gov-ru/services/message-exchange/types/basic/1.1}string-1500" minOccurs="0"/>
 *         &lt;element name="ReferenceMessageID" type="{urn://x-artefacts-smev-gov-ru/services/message-exchange/types/basic/1.1}UUID" minOccurs="0"/>
 *         &lt;element ref="{urn://x-artefacts-smev-gov-ru/services/message-exchange/types/1.1}SenderProvidedResponseData"/>
 *         &lt;element ref="{urn://x-artefacts-smev-gov-ru/services/message-exchange/types/1.1}MessageMetadata"/>
 *         &lt;element ref="{urn://x-artefacts-smev-gov-ru/services/message-exchange/types/basic/1.1}FSAttachmentsList" minOccurs="0"/>
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
@XmlType(name = "", propOrder = { "originalMessageId", "originalTransactionCode", "referenceMessageID", "senderProvidedResponseData", "messageMetadata",
        "fsAttachmentsList", "senderInformationSystemSignature" })
@XmlRootElement(name = "Response")
public class Response {

	@XmlElement(name = "OriginalMessageId")
	protected String originalMessageId;
	@XmlElement(name = "OriginalTransactionCode")
	protected String originalTransactionCode;
	@XmlElement(name = "ReferenceMessageID")
	protected String referenceMessageID;
	@XmlElement(name = "SenderProvidedResponseData", required = true)
	protected SenderProvidedResponseData senderProvidedResponseData;
	@XmlElement(name = "MessageMetadata", required = true)
	protected MessageMetadata messageMetadata;
	@XmlElement(name = "FSAttachmentsList", namespace = "urn://x-artefacts-smev-gov-ru/services/message-exchange/types/basic/1.1")
	protected FSAttachmentsList fsAttachmentsList;
	@XmlElement(name = "SenderInformationSystemSignature")
	protected XMLDSigSignatureType senderInformationSystemSignature;
	@XmlAttribute(name = "Id")
	@XmlJavaTypeAdapter(CollapsedStringAdapter.class)
	@XmlID
	@XmlSchemaType(name = "ID")
	protected String id;

	/**
	 * Gets the value of the originalMessageId property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getOriginalMessageId() {
		return originalMessageId;
	}

	/**
	 * Sets the value of the originalMessageId property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setOriginalMessageId(String value) {
		this.originalMessageId = value;
	}

	/**
	 * Gets the value of the originalTransactionCode property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getOriginalTransactionCode() {
		return originalTransactionCode;
	}

	/**
	 * Sets the value of the originalTransactionCode property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setOriginalTransactionCode(String value) {
		this.originalTransactionCode = value;
	}

	/**
	 * Gets the value of the referenceMessageID property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getReferenceMessageID() {
		return referenceMessageID;
	}

	/**
	 * Sets the value of the referenceMessageID property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setReferenceMessageID(String value) {
		this.referenceMessageID = value;
	}

	/**
	 * Gets the value of the senderProvidedResponseData property.
	 * 
	 * @return possible object is {@link SenderProvidedResponseData }
	 * 
	 */
	public SenderProvidedResponseData getSenderProvidedResponseData() {
		return senderProvidedResponseData;
	}

	/**
	 * Sets the value of the senderProvidedResponseData property.
	 * 
	 * @param value
	 *            allowed object is {@link SenderProvidedResponseData }
	 * 
	 */
	public void setSenderProvidedResponseData(SenderProvidedResponseData value) {
		this.senderProvidedResponseData = value;
	}

	/**
	 * Gets the value of the messageMetadata property.
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
