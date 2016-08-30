
package com.otr.sufd.smev30supportservice;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

/**
 * <p>
 * Java class for signXmlParams complex type.
 * 
 * <p>
 * The following schema fragment specifies the expected content contained within
 * this class.
 * 
 * <pre>
 * &lt;complexType name="signXmlParams">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="xml" type="{http://www.w3.org/2001/XMLSchema}base64Binary"/>
 *         &lt;element name="fingerprint" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="reference" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="detached" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "signXmlParams", propOrder = { "xml", "fingerprint", "reference", "detached" })
public class SignXmlParams {

    @XmlElement(required = true)
    protected byte[] xml;
    protected String fingerprint;
    protected String reference;
    protected Boolean detached;

    /**
     * Gets the value of the xml property.
     * 
     * @return possible object is byte[]
     */
    public byte[] getXml() {
        return xml;
    }

    /**
     * Sets the value of the xml property.
     * 
     * @param value
     *            allowed object is byte[]
     */
    public void setXml(byte[] value) {
        this.xml = value;
    }

    /**
     * Gets the value of the fingerprint property.
     * 
     * @return possible object is {@link String }
     * 
     */
    public String getFingerprint() {
        return fingerprint;
    }

    /**
     * Sets the value of the fingerprint property.
     * 
     * @param value
     *            allowed object is {@link String }
     * 
     */
    public void setFingerprint(String value) {
        this.fingerprint = value;
    }

    /**
     * Gets the value of the reference property.
     * 
     * @return possible object is {@link String }
     * 
     */
    public String getReference() {
        return reference;
    }

    /**
     * Sets the value of the reference property.
     * 
     * @param value
     *            allowed object is {@link String }
     * 
     */
    public void setReference(String value) {
        this.reference = value;
    }

    /**
     * Gets the value of the detached property.
     * 
     * @return possible object is {@link Boolean }
     * 
     */
    public Boolean isDetached() {
        return detached;
    }

    /**
     * Sets the value of the detached property.
     * 
     * @param value
     *            allowed object is {@link Boolean }
     * 
     */
    public void setDetached(Boolean value) {
        this.detached = value;
    }

}
