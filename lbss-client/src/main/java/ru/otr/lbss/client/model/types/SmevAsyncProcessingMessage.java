package ru.otr.lbss.client.model.types;

import ru.otr.lbss.client.model.StatusMessage;
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
 *         &lt;choice>
 *           &lt;element ref="{urn://x-artefacts-smev-gov-ru/services/message-exchange/types/1.3}AsyncProcessingStatusData"/>
 *         &lt;/choice>
 *         &lt;element name="SMEVSignature" type="{urn://x-artefacts-smev-gov-ru/services/message-exchange/types/basic/1.3}XMLDSigSignatureType" minOccurs="0"/>
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
    "asyncProcessingStatusData",
    "smevSignature"
})
@XmlRootElement(name = "SmevAsyncProcessingMessage")
public class SmevAsyncProcessingMessage extends StatusMessage {

    @XmlElement(name = "AsyncProcessingStatusData")
    protected AsyncProcessingStatusData asyncProcessingStatusData;
    @XmlElement(name = "SMEVSignature")
    protected XMLDSigSignatureType smevSignature;

    /**
     * Gets the value of the asyncProcessingStatusData property.
     * 
     * @return
     *     possible object is
     *     {@link AsyncProcessingStatusData }
     *     
     */
    public AsyncProcessingStatusData getAsyncProcessingStatusData() {
        return asyncProcessingStatusData;
    }

    /**
     * Sets the value of the asyncProcessingStatusData property.
     * 
     * @param value
     *     allowed object is
     *     {@link AsyncProcessingStatusData }
     *     
     */
    public void setAsyncProcessingStatusData(AsyncProcessingStatusData value) {
        this.asyncProcessingStatusData = value;
    }

    /**
     * Gets the value of the smevSignature property.
     * 
     * @return
     *     possible object is
     *     {@link XMLDSigSignatureType }
     *     
     */
    public XMLDSigSignatureType getSMEVSignature() {
        return smevSignature;
    }

    /**
     * Sets the value of the smevSignature property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLDSigSignatureType }
     *     
     */
    public void setSMEVSignature(XMLDSigSignatureType value) {
        this.smevSignature = value;
    }

}
