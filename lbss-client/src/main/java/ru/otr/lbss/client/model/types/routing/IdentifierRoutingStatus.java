package ru.otr.lbss.client.model.types.routing;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSchemaType;
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
 *         &lt;element name="IdentifierValue" type="{urn://x-artefacts-smev-gov-ru/services/message-exchange/types/routing/1.3}Value"/>
 *         &lt;element name="RoutingStatusCode" type="{urn://x-artefacts-smev-gov-ru/services/message-exchange/types/routing/1.3}RoutingStatusCodeType"/>
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
    "identifierValue",
    "routingStatusCode"
})
@XmlRootElement(name = "IdentifierRoutingStatus", namespace = "urn://x-artefacts-smev-gov-ru/services/message-exchange/types/routing/1.3")
public class IdentifierRoutingStatus {

    @XmlElement(name = "IdentifierValue", namespace = "urn://x-artefacts-smev-gov-ru/services/message-exchange/types/routing/1.3", required = true)
    protected String identifierValue;
    @XmlElement(name = "RoutingStatusCode", namespace = "urn://x-artefacts-smev-gov-ru/services/message-exchange/types/routing/1.3", required = true)
    @XmlSchemaType(name = "string")
    protected RoutingStatusCodeType routingStatusCode;

    /**
     * Gets the value of the identifierValue property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getIdentifierValue() {
        return identifierValue;
    }

    /**
     * Sets the value of the identifierValue property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setIdentifierValue(String value) {
        this.identifierValue = value;
    }

    /**
     * Gets the value of the routingStatusCode property.
     * 
     * @return
     *     possible object is
     *     {@link RoutingStatusCodeType }
     *     
     */
    public RoutingStatusCodeType getRoutingStatusCode() {
        return routingStatusCode;
    }

    /**
     * Sets the value of the routingStatusCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link RoutingStatusCodeType }
     *     
     */
    public void setRoutingStatusCode(RoutingStatusCodeType value) {
        this.routingStatusCode = value;
    }

}
