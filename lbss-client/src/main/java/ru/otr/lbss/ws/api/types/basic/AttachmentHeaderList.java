
package ru.otr.lbss.ws.api.types.basic;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

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
 *         &lt;element name="AttachmentHeader" type="{urn://x-artefacts-smev-gov-ru/services/message-exchange/types/basic/1.1}AttachmentHeaderType" maxOccurs="unbounded"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = { "attachmentHeader" })
@XmlRootElement(name = "AttachmentHeaderList")
public class AttachmentHeaderList {

	@XmlElement(name = "AttachmentHeader", required = true)
	protected List<AttachmentHeaderType> attachmentHeader;

	/**
	 * Gets the value of the attachmentHeader property.
	 * 
	 * <p>
	 * This accessor method returns a reference to the live list, not a
	 * snapshot. Therefore any modification you make to the returned list will
	 * be present inside the JAXB object. This is why there is not a
	 * <CODE>set</CODE> method for the attachmentHeader property.
	 * 
	 * <p>
	 * For example, to add a new item, do as follows:
	 * 
	 * <pre>
	 * getAttachmentHeader().add(newItem);
	 * </pre>
	 * 
	 * 
	 * <p>
	 * Objects of the following type(s) are allowed in the list
	 * {@link AttachmentHeaderType }
	 * 
	 * 
	 */
	public List<AttachmentHeaderType> getAttachmentHeader() {
		if (attachmentHeader == null) {
			attachmentHeader = new ArrayList<AttachmentHeaderType>();
		}
		return this.attachmentHeader;
	}

}
