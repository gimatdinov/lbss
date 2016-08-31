
package ru.otr.lbss.client.model.types;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

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
 *         &lt;element ref="{urn://x-artefacts-smev-gov-ru/services/message-exchange/types/1.1}MessageMetadata"/>
 *         &lt;element name="SMEVSignature" type="{urn://x-artefacts-smev-gov-ru/services/message-exchange/types/basic/1.1}XMLDSigSignatureType" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = { "messageMetadata", "smevSignature" })
@XmlRootElement(name = "SendRequestResponse")
public class SendRequestResponse {

	@XmlElement(name = "MessageMetadata", required = true)
	protected MessageMetadata messageMetadata;
	@XmlElement(name = "SMEVSignature")
	protected XMLDSigSignatureType smevSignature;

	/**
	 * 
	 * Данные о сообщении: ID, присвоенный СМЭВ, дата приёма по часам СМЭВ,
	 * результат маршрутизации, etc.
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
	 * Gets the value of the smevSignature property.
	 * 
	 * @return possible object is {@link XMLDSigSignatureType }
	 * 
	 */
	public XMLDSigSignatureType getSMEVSignature() {
		return smevSignature;
	}

	/**
	 * Sets the value of the smevSignature property.
	 * 
	 * @param value
	 *            allowed object is {@link XMLDSigSignatureType }
	 * 
	 */
	public void setSMEVSignature(XMLDSigSignatureType value) {
		this.smevSignature = value;
	}

}
