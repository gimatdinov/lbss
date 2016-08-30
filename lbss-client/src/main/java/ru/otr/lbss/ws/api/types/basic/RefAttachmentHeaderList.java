
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
 *         &lt;element name="RefAttachmentHeader" type="{urn://x-artefacts-smev-gov-ru/services/message-exchange/types/basic/1.1}RefAttachmentHeaderType" maxOccurs="unbounded"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = { "refAttachmentHeader" })
@XmlRootElement(name = "RefAttachmentHeaderList")
public class RefAttachmentHeaderList {

	@XmlElement(name = "RefAttachmentHeader", required = true)
	protected List<RefAttachmentHeaderType> refAttachmentHeader;

	/**
	 * Gets the value of the refAttachmentHeader property.
	 * 
	 * <p>
	 * This accessor method returns a reference to the live list, not a
	 * snapshot. Therefore any modification you make to the returned list will
	 * be present inside the JAXB object. This is why there is not a
	 * <CODE>set</CODE> method for the refAttachmentHeader property.
	 * 
	 * <p>
	 * For example, to add a new item, do as follows:
	 * 
	 * <pre>
	 * getRefAttachmentHeader().add(newItem);
	 * </pre>
	 * 
	 * 
	 * <p>
	 * Objects of the following type(s) are allowed in the list
	 * {@link RefAttachmentHeaderType }
	 * 
	 * 
	 */
	public List<RefAttachmentHeaderType> getRefAttachmentHeader() {
		if (refAttachmentHeader == null) {
			refAttachmentHeader = new ArrayList<RefAttachmentHeaderType>();
		}
		return this.refAttachmentHeader;
	}

}
