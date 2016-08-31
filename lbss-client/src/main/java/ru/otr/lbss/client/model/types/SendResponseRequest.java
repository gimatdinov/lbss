
package ru.otr.lbss.client.model.types;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

import ru.otr.lbss.client.model.types.basic.AttachmentContentList;
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
 *         &lt;element ref="{urn://x-artefacts-smev-gov-ru/services/message-exchange/types/1.1}SenderProvidedResponseData"/>
 *         &lt;element ref="{urn://x-artefacts-smev-gov-ru/services/message-exchange/types/basic/1.1}AttachmentContentList" minOccurs="0"/>
 *         &lt;element name="CallerInformationSystemSignature" type="{urn://x-artefacts-smev-gov-ru/services/message-exchange/types/basic/1.1}XMLDSigSignatureType" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = { "senderProvidedResponseData", "attachmentContentList", "callerInformationSystemSignature" })
@XmlRootElement(name = "SendResponseRequest")
public class SendResponseRequest {

	@XmlElement(name = "SenderProvidedResponseData", required = true)
	protected SenderProvidedResponseData senderProvidedResponseData;
	@XmlElement(name = "AttachmentContentList", namespace = "urn://x-artefacts-smev-gov-ru/services/message-exchange/types/basic/1.1")
	protected AttachmentContentList attachmentContentList;
	@XmlElement(name = "CallerInformationSystemSignature")
	protected XMLDSigSignatureType callerInformationSystemSignature;

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
	 * Gets the value of the attachmentContentList property.
	 * 
	 * @return possible object is {@link AttachmentContentList }
	 * 
	 */
	public AttachmentContentList getAttachmentContentList() {
		return attachmentContentList;
	}

	/**
	 * Sets the value of the attachmentContentList property.
	 * 
	 * @param value
	 *            allowed object is {@link AttachmentContentList }
	 * 
	 */
	public void setAttachmentContentList(AttachmentContentList value) {
		this.attachmentContentList = value;
	}

	/**
	 * Gets the value of the callerInformationSystemSignature property.
	 * 
	 * @return possible object is {@link XMLDSigSignatureType }
	 * 
	 */
	public XMLDSigSignatureType getCallerInformationSystemSignature() {
		return callerInformationSystemSignature;
	}

	/**
	 * Sets the value of the callerInformationSystemSignature property.
	 * 
	 * @param value
	 *            allowed object is {@link XMLDSigSignatureType }
	 * 
	 */
	public void setCallerInformationSystemSignature(XMLDSigSignatureType value) {
		this.callerInformationSystemSignature = value;
	}

}
