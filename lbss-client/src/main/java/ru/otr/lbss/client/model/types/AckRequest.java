package ru.otr.lbss.client.model.types;

import ru.otr.lbss.client.model.types.basic.AckTargetMessage;
import ru.otr.lbss.client.model.types.basic.XMLDSigSignatureType;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for anonymous complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element ref="{urn://x-artefacts-smev-gov-ru/services/message-exchange/types/basic/1.3}AckTargetMessage"/>
 *         &lt;element name="CallerInformationSystemSignature" type="{urn://x-artefacts-smev-gov-ru/services/message-exchange/types/basic/1.3}XMLDSigSignatureType" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "ackTargetMessage",
    "callerInformationSystemSignature"
})
@XmlRootElement(name = "AckRequest")
public class AckRequest {

    @XmlElement(name = "AckTargetMessage", namespace = "urn://x-artefacts-smev-gov-ru/services/message-exchange/types/basic/1.3", required = true)
    protected AckTargetMessage ackTargetMessage;
    @XmlElement(name = "CallerInformationSystemSignature")
    protected XMLDSigSignatureType callerInformationSystemSignature;

    /**
     * Gets the value of the ackTargetMessage property.
     * 
     * @return
     *     possible object is
     *     {@link AckTargetMessage }
     *     
     */
    public AckTargetMessage getAckTargetMessage() {
        return ackTargetMessage;
    }

    /**
     * Sets the value of the ackTargetMessage property.
     * 
     * @param value
     *     allowed object is
     *     {@link AckTargetMessage }
     *     
     */
    public void setAckTargetMessage(AckTargetMessage value) {
        this.ackTargetMessage = value;
    }

    /**
     * Gets the value of the callerInformationSystemSignature property.
     * 
     * @return
     *     possible object is
     *     {@link XMLDSigSignatureType }
     *     
     */
    public XMLDSigSignatureType getCallerInformationSystemSignature() {
        return callerInformationSystemSignature;
    }

    /**
     * Sets the value of the callerInformationSystemSignature property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLDSigSignatureType }
     *     
     */
    public void setCallerInformationSystemSignature(XMLDSigSignatureType value) {
        this.callerInformationSystemSignature = value;
    }

}
