
package ru.otr.lbss.client.model.types.basic;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

/**
 * 
 * Файл, приложенный к СМЭВ-сообщению. Имя файла не передаётся; вложения
 * идентифицируются только идентификаторами внутри сообщения.
 * 
 * 
 * <p>
 * Java class for AttachmentHeaderType complex type.
 * 
 * <p>
 * The following schema fragment specifies the expected content contained within
 * this class.
 * 
 * <pre>
 * &lt;complexType name="AttachmentHeaderType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="contentId" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="MimeType" type="{urn://x-artefacts-smev-gov-ru/services/message-exchange/types/basic/1.1}RFC2046MimeTypesType"/>
 *         &lt;element name="SignaturePKCS7" type="{http://www.w3.org/2001/XMLSchema}base64Binary" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "AttachmentHeaderType", propOrder = { "contentId", "mimeType", "signaturePKCS7" })
public class AttachmentHeaderType {

	@XmlElement(required = true)
	protected String contentId;
	@XmlElement(name = "MimeType", required = true)
	protected String mimeType;
	@XmlElement(name = "SignaturePKCS7")
	protected byte[] signaturePKCS7;

	/**
	 * Gets the value of the contentId property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getContentId() {
		return contentId;
	}

	/**
	 * Sets the value of the contentId property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setContentId(String value) {
		this.contentId = value;
	}

	/**
	 * Gets the value of the mimeType property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getMimeType() {
		return mimeType;
	}

	/**
	 * Sets the value of the mimeType property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setMimeType(String value) {
		this.mimeType = value;
	}

	/**
	 * Gets the value of the signaturePKCS7 property.
	 * 
	 * @return possible object is byte[]
	 */
	public byte[] getSignaturePKCS7() {
		return signaturePKCS7;
	}

	/**
	 * Sets the value of the signaturePKCS7 property.
	 * 
	 * @param value
	 *            allowed object is byte[]
	 */
	public void setSignaturePKCS7(byte[] value) {
		this.signaturePKCS7 = value;
	}

}
