
package ru.otr.lbss.ws.api.types.basic;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;

import ru.otr.lbss.ws.api.types.fault.AttachmentSizeLimitExceeded;
import ru.otr.lbss.ws.api.types.fault.BusinessDataTypeIsNotSupported;
import ru.otr.lbss.ws.api.types.fault.DestinationOverflow;
import ru.otr.lbss.ws.api.types.fault.InvalidContent;
import ru.otr.lbss.ws.api.types.fault.QuoteLimitExceeded;
import ru.otr.lbss.ws.api.types.fault.SignatureVerificationFault;

/**
 * <p>
 * Java class for SmevFault complex type.
 * 
 * <p>
 * The following schema fragment specifies the expected content contained within
 * this class.
 * 
 * <pre>
 * &lt;complexType name="SmevFault">
 *   &lt;complexContent>
 *     &lt;extension base="{urn://x-artefacts-smev-gov-ru/services/message-exchange/types/basic/1.1}Void">
 *       &lt;sequence>
 *         &lt;element name="Code" type="{urn://x-artefacts-smev-gov-ru/services/message-exchange/types/basic/1.1}string-50" minOccurs="0"/>
 *         &lt;element name="Description" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "SmevFault", propOrder = { "code", "description" })
@XmlSeeAlso({ InvalidContent.class, SignatureVerificationFault.class, DestinationOverflow.class, QuoteLimitExceeded.class, AttachmentSizeLimitExceeded.class,
        BusinessDataTypeIsNotSupported.class })
public class SmevFault extends Void {

	@XmlElement(name = "Code")
	protected String code;
	@XmlElement(name = "Description")
	protected String description;

	/**
	 * Gets the value of the code property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getCode() {
		return code;
	}

	/**
	 * Sets the value of the code property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setCode(String value) {
		this.code = value;
	}

	/**
	 * Gets the value of the description property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * Sets the value of the description property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setDescription(String value) {
		this.description = value;
	}

}
