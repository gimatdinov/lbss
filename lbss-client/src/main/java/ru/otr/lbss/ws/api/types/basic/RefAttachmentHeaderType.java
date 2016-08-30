
package ru.otr.lbss.ws.api.types.basic;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

/**
 * 
 * Ссылка на файл, приложенный к СМЭВ-сообщению.
 * 
 * 
 * <p>
 * Java class for RefAttachmentHeaderType complex type.
 * 
 * <p>
 * The following schema fragment specifies the expected content contained within
 * this class.
 * 
 * <pre>
 * &lt;complexType name="RefAttachmentHeaderType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="uuid" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="Hash" type="{http://www.w3.org/2001/XMLSchema}string"/>
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
@XmlType(name = "RefAttachmentHeaderType", propOrder = { "uuid", "hash", "mimeType", "signaturePKCS7" })
public class RefAttachmentHeaderType {

	@XmlElement(required = true)
	protected String uuid;
	@XmlElement(name = "Hash", required = true)
	protected String hash;
	@XmlElement(name = "MimeType", required = true)
	protected String mimeType;
	@XmlElement(name = "SignaturePKCS7")
	protected byte[] signaturePKCS7;

	/**
	 * Gets the value of the uuid property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getUuid() {
		return uuid;
	}

	/**
	 * Sets the value of the uuid property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setUuid(String value) {
		this.uuid = value;
	}

	/**
	 * Gets the value of the hash property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getHash() {
		return hash;
	}

	/**
	 * Sets the value of the hash property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setHash(String value) {
		this.hash = value;
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
