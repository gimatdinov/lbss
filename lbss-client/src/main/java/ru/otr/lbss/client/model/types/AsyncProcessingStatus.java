
package ru.otr.lbss.client.model.types;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;

import ru.otr.lbss.client.model.types.basic.InteractionStatusType;
import ru.otr.lbss.client.model.types.basic.SmevFault;

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
 *         &lt;element name="OriginalMessageId" type="{urn://x-artefacts-smev-gov-ru/services/message-exchange/types/basic/1.1}UUID"/>
 *         &lt;element name="StatusCategory" type="{urn://x-artefacts-smev-gov-ru/services/message-exchange/types/basic/1.1}InteractionStatusType"/>
 *         &lt;element name="StatusDetails" type="{urn://x-artefacts-smev-gov-ru/services/message-exchange/types/basic/1.1}string-500" minOccurs="0"/>
 *         &lt;element name="SmevFault" type="{urn://x-artefacts-smev-gov-ru/services/message-exchange/types/basic/1.1}SmevFault" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = { "originalMessageId", "statusCategory", "statusDetails", "smevFault" })
@XmlRootElement(name = "AsyncProcessingStatus")
public class AsyncProcessingStatus {

	@XmlElement(name = "OriginalMessageId", required = true)
	protected String originalMessageId;
	@XmlElement(name = "StatusCategory", required = true)
	@XmlSchemaType(name = "string")
	protected InteractionStatusType statusCategory;
	@XmlElement(name = "StatusDetails")
	protected String statusDetails;
	@XmlElement(name = "SmevFault")
	protected SmevFault smevFault;

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
	 * Gets the value of the statusCategory property.
	 * 
	 * @return possible object is {@link InteractionStatusType }
	 * 
	 */
	public InteractionStatusType getStatusCategory() {
		return statusCategory;
	}

	/**
	 * Sets the value of the statusCategory property.
	 * 
	 * @param value
	 *            allowed object is {@link InteractionStatusType }
	 * 
	 */
	public void setStatusCategory(InteractionStatusType value) {
		this.statusCategory = value;
	}

	/**
	 * Gets the value of the statusDetails property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getStatusDetails() {
		return statusDetails;
	}

	/**
	 * Sets the value of the statusDetails property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setStatusDetails(String value) {
		this.statusDetails = value;
	}

	/**
	 * Gets the value of the smevFault property.
	 * 
	 * @return possible object is {@link SmevFault }
	 * 
	 */
	public SmevFault getSmevFault() {
		return smevFault;
	}

	/**
	 * Sets the value of the smevFault property.
	 * 
	 * @param value
	 *            allowed object is {@link SmevFault }
	 * 
	 */
	public void setSmevFault(SmevFault value) {
		this.smevFault = value;
	}

}
