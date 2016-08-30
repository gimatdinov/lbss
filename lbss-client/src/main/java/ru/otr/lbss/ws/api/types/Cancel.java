
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

import ru.otr.lbss.ws.api.types.basic.MessageReference;
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
 *         &lt;element ref="{urn://x-artefacts-smev-gov-ru/services/message-exchange/types/basic/1.1}MessageReference"/>
 *         &lt;element name="MessageID" type="{urn://x-artefacts-smev-gov-ru/services/message-exchange/types/basic/1.1}UUID"/>
 *         &lt;element ref="{urn://x-artefacts-smev-gov-ru/services/message-exchange/types/1.1}MessageMetadata"/>
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
@XmlType(name = "", propOrder = { "messageReference", "messageID", "messageMetadata", "senderInformationSystemSignature" })
@XmlRootElement(name = "Cancel")
public class Cancel {

	@XmlElement(name = "MessageReference", namespace = "urn://x-artefacts-smev-gov-ru/services/message-exchange/types/basic/1.1", required = true)
	protected MessageReference messageReference;
	@XmlElement(name = "MessageID", required = true)
	protected String messageID;
	@XmlElement(name = "MessageMetadata", required = true)
	protected MessageMetadata messageMetadata;
	@XmlElement(name = "SenderInformationSystemSignature")
	protected XMLDSigSignatureType senderInformationSystemSignature;
	@XmlAttribute(name = "Id")
	@XmlJavaTypeAdapter(CollapsedStringAdapter.class)
	@XmlID
	@XmlSchemaType(name = "ID")
	protected String id;

	/**
	 * 
	 * Ссылка на запрос, который нужно отменить. Сюда нужно писать ID
	 * СМЭВ-сообщения, который был передан при отправке запроса в элементе
	 * //SendRequestRequest/SenderProvidedRequestData/MessageID.
	 * 
	 * 
	 * @return possible object is {@link MessageReference }
	 * 
	 */
	public MessageReference getMessageReference() {
		return messageReference;
	}

	/**
	 * Sets the value of the messageReference property.
	 * 
	 * @param value
	 *            allowed object is {@link MessageReference }
	 * 
	 */
	public void setMessageReference(MessageReference value) {
		this.messageReference = value;
	}

	/**
	 * Gets the value of the messageID property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getMessageID() {
		return messageID;
	}

	/**
	 * Sets the value of the messageID property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setMessageID(String value) {
		this.messageID = value;
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
