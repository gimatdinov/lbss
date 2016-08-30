
package ru.otr.lbss.ws.api.types.basic;

import javax.activation.DataHandler;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlID;
import javax.xml.bind.annotation.XmlMimeType;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.CollapsedStringAdapter;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

/**
 * 
 * Содержимое вложенного файла. Значение атрибута attachmentId должно быть
 * уникально среди всех элементов и атрибутов СМЭВ-сообщения, имеющих тип xs:ID.
 * 
 * 
 * <p>
 * Java class for AttachmentContentType complex type.
 * 
 * <p>
 * The following schema fragment specifies the expected content contained within
 * this class.
 * 
 * <pre>
 * &lt;complexType name="AttachmentContentType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Id" type="{http://www.w3.org/2001/XMLSchema}ID"/>
 *         &lt;element name="Content" type="{http://www.w3.org/2001/XMLSchema}base64Binary"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "AttachmentContentType", propOrder = { "id", "content" })
public class AttachmentContentType {

	@XmlElement(name = "Id", required = true)
	@XmlJavaTypeAdapter(CollapsedStringAdapter.class)
	@XmlID
	@XmlSchemaType(name = "ID")
	protected String id;
	@XmlElement(name = "Content", required = true)
	@XmlMimeType("application/octet-stream")
	protected DataHandler content;

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

	/**
	 * Gets the value of the content property.
	 * 
	 * @return possible object is {@link DataHandler }
	 * 
	 */
	public DataHandler getContent() {
		return content;
	}

	/**
	 * Sets the value of the content property.
	 * 
	 * @param value
	 *            allowed object is {@link DataHandler }
	 * 
	 */
	public void setContent(DataHandler value) {
		this.content = value;
	}

}
