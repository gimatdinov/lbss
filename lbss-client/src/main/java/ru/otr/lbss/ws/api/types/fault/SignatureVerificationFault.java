
package ru.otr.lbss.ws.api.types.fault;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

import ru.otr.lbss.ws.api.types.basic.SmevFault;

/**
 * <p>
 * Java class for SignatureVerificationFault complex type.
 * 
 * <p>
 * The following schema fragment specifies the expected content contained within
 * this class.
 * 
 * <pre>
 * &lt;complexType name="SignatureVerificationFault">
 *   &lt;complexContent>
 *     &lt;extension base="{urn://x-artefacts-smev-gov-ru/services/message-exchange/types/basic/1.1}SmevFault">
 *       &lt;sequence>
 *         &lt;element name="SignatureVerificationFault">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;enumeration value="PoorSOAPEnvelopeFormat"/>
 *               &lt;enumeration value="NoSignatureFound"/>
 *               &lt;enumeration value="IncorrectSignatureTarget"/>
 *               &lt;enumeration value="SignatureIsInvalid"/>
 *               &lt;enumeration value="CertificateIsNotFound"/>
 *               &lt;enumeration value="CertificateIsExpired"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "SignatureVerificationFault", propOrder = { "signatureVerificationFault" })
public class SignatureVerificationFault extends SmevFault {

	@XmlElement(name = "SignatureVerificationFault", required = true)
	protected String signatureVerificationFault;

	/**
	 * Gets the value of the signatureVerificationFault property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getSignatureVerificationFault() {
		return signatureVerificationFault;
	}

	/**
	 * Sets the value of the signatureVerificationFault property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setSignatureVerificationFault(String value) {
		this.signatureVerificationFault = value;
	}

}
