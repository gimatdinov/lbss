
package ru.otr.lbss.client.model.types;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

import ru.otr.lbss.client.model.types.basic.Timestamp;
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
 *         &lt;element ref="{urn://x-artefacts-smev-gov-ru/services/message-exchange/types/basic/1.1}Timestamp"/>
 *         &lt;element name="CallerInformationSystemSignature" type="{urn://x-artefacts-smev-gov-ru/services/message-exchange/types/basic/1.1}XMLDSigSignatureType"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = { "timestamp", "callerInformationSystemSignature" })
@XmlRootElement(name = "GetStatusRequest")
public class GetStatusRequest {

	@XmlElement(name = "Timestamp", namespace = "urn://x-artefacts-smev-gov-ru/services/message-exchange/types/basic/1.1", required = true)
	protected Timestamp timestamp;
	@XmlElement(name = "CallerInformationSystemSignature", required = true)
	protected XMLDSigSignatureType callerInformationSystemSignature;

	/**
	 * Gets the value of the timestamp property.
	 * 
	 * @return possible object is {@link Timestamp }
	 * 
	 */
	public Timestamp getTimestamp() {
		return timestamp;
	}

	/**
	 * Sets the value of the timestamp property.
	 * 
	 * @param value
	 *            allowed object is {@link Timestamp }
	 * 
	 */
	public void setTimestamp(Timestamp value) {
		this.timestamp = value;
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
