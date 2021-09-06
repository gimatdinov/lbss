
package com.otr.sufd.smev30supportservice.xml.faultmessage;

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
 *         &lt;element name="fltCode" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="fltMessage" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = { "fltCode", "fltMessage" })
@XmlRootElement(name = "faultDetail")
public class FaultDetail {

    @XmlElement(required = true)
    protected String fltCode;
    @XmlElement(required = true)
    protected String fltMessage;

    /**
     * Gets the value of the fltCode property.
     * 
     * @return possible object is {@link String }
     * 
     */
    public String getFltCode() {
        return fltCode;
    }

    /**
     * Sets the value of the fltCode property.
     * 
     * @param value
     *            allowed object is {@link String }
     * 
     */
    public void setFltCode(String value) {
        this.fltCode = value;
    }

    /**
     * Gets the value of the fltMessage property.
     * 
     * @return possible object is {@link String }
     * 
     */
    public String getFltMessage() {
        return fltMessage;
    }

    /**
     * Sets the value of the fltMessage property.
     * 
     * @param value
     *            allowed object is {@link String }
     * 
     */
    public void setFltMessage(String value) {
        this.fltMessage = value;
    }

}
