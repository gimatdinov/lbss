package ru.otr.lbss.client.model.types;

import ru.otr.lbss.client.model.types.basic.InteractionStatusType;
import ru.otr.lbss.client.model.types.basic.SmevFault;
import ru.otr.lbss.client.model.types.routing.RoutingStatus;

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
 *         &lt;element name="OriginalMessageId" type="{urn://x-artefacts-smev-gov-ru/services/message-exchange/types/basic/1.3}UUID"/>
 *         &lt;element name="StatusCategory" type="{urn://x-artefacts-smev-gov-ru/services/message-exchange/types/basic/1.3}InteractionStatusType"/>
 *         &lt;element name="StatusDetails" type="{urn://x-artefacts-smev-gov-ru/services/message-exchange/types/basic/1.3}string-500" minOccurs="0"/>
 *         &lt;element ref="{urn://x-artefacts-smev-gov-ru/services/message-exchange/types/routing/1.3}RoutingStatus" minOccurs="0"/>
 *         &lt;element name="SmevFault" type="{urn://x-artefacts-smev-gov-ru/services/message-exchange/types/basic/1.3}SmevFault" minOccurs="0"/>
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
    "originalMessageId",
    "statusCategory",
    "statusDetails",
    "routingStatus",
    "smevFault"
})
@XmlRootElement(name = "AsyncProcessingStatus")
public class AsyncProcessingStatus {

    @XmlElement(name = "OriginalMessageId", required = true)
    protected String originalMessageId;
    @XmlElement(name = "StatusCategory", required = true)
    @XmlSchemaType(name = "string")
    protected InteractionStatusType statusCategory;
    @XmlElement(name = "StatusDetails")
    protected String statusDetails;
    @XmlElement(name = "RoutingStatus", namespace = "urn://x-artefacts-smev-gov-ru/services/message-exchange/types/routing/1.3")
    protected RoutingStatus routingStatus;
    @XmlElement(name = "SmevFault")
    protected SmevFault smevFault;

    /**
     * Gets the value of the originalMessageId property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOriginalMessageId() {
        return originalMessageId;
    }

    /**
     * Sets the value of the originalMessageId property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOriginalMessageId(String value) {
        this.originalMessageId = value;
    }

    /**
     * Gets the value of the statusCategory property.
     * 
     * @return
     *     possible object is
     *     {@link InteractionStatusType }
     *     
     */
    public InteractionStatusType getStatusCategory() {
        return statusCategory;
    }

    /**
     * Sets the value of the statusCategory property.
     * 
     * @param value
     *     allowed object is
     *     {@link InteractionStatusType }
     *     
     */
    public void setStatusCategory(InteractionStatusType value) {
        this.statusCategory = value;
    }

    /**
     * Gets the value of the statusDetails property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getStatusDetails() {
        return statusDetails;
    }

    /**
     * Sets the value of the statusDetails property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setStatusDetails(String value) {
        this.statusDetails = value;
    }

    /**
     * Статус маршрутизации сообщения
     * 
     * @return
     *     possible object is
     *     {@link RoutingStatus }
     *     
     */
    public RoutingStatus getRoutingStatus() {
        return routingStatus;
    }

    /**
     * Sets the value of the routingStatus property.
     * 
     * @param value
     *     allowed object is
     *     {@link RoutingStatus }
     *     
     */
    public void setRoutingStatus(RoutingStatus value) {
        this.routingStatus = value;
    }

    /**
     * Gets the value of the smevFault property.
     * 
     * @return
     *     possible object is
     *     {@link SmevFault }
     *     
     */
    public SmevFault getSmevFault() {
        return smevFault;
    }

    /**
     * Sets the value of the smevFault property.
     * 
     * @param value
     *     allowed object is
     *     {@link SmevFault }
     *     
     */
    public void setSmevFault(SmevFault value) {
        this.smevFault = value;
    }

}
