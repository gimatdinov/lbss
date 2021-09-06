
package ru.otr.lbss.client.model.types.routing;

import ru.otr.lbss.client.model.types.basic.XMLDSigSignatureType;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * Параметры маршрутизации сообщения
 * 
 * <p>Java class for anonymous complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element ref="{urn://x-artefacts-smev-gov-ru/services/message-exchange/types/routing/1.3}RoutingInformation"/>
 *         &lt;element name="RoutingSignature" type="{urn://x-artefacts-smev-gov-ru/services/message-exchange/types/basic/1.3}XMLDSigSignatureType"/>
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
    "routingInformation",
    "routingSignature"
})
@XmlRootElement(name = "Routing", namespace = "urn://x-artefacts-smev-gov-ru/services/message-exchange/types/routing/1.3")
public class Routing {

    @XmlElement(name = "RoutingInformation", namespace = "urn://x-artefacts-smev-gov-ru/services/message-exchange/types/routing/1.3", required = true)
    protected RoutingInformation routingInformation;
    @XmlElement(name = "RoutingSignature", namespace = "urn://x-artefacts-smev-gov-ru/services/message-exchange/types/routing/1.3", required = true)
    protected XMLDSigSignatureType routingSignature;

    /**
     * Gets the value of the routingInformation property.
     * 
     * @return
     *     possible object is
     *     {@link RoutingInformation }
     *     
     */
    public RoutingInformation getRoutingInformation() {
        return routingInformation;
    }

    /**
     * Sets the value of the routingInformation property.
     * 
     * @param value
     *     allowed object is
     *     {@link RoutingInformation }
     *     
     */
    public void setRoutingInformation(RoutingInformation value) {
        this.routingInformation = value;
    }

    /**
     * Gets the value of the routingSignature property.
     * 
     * @return
     *     possible object is
     *     {@link XMLDSigSignatureType }
     *     
     */
    public XMLDSigSignatureType getRoutingSignature() {
        return routingSignature;
    }

    /**
     * Sets the value of the routingSignature property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLDSigSignatureType }
     *     
     */
    public void setRoutingSignature(XMLDSigSignatureType value) {
        this.routingSignature = value;
    }

}
