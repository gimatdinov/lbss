
package ru.otr.lbss.client.model.types.routing;

import java.util.ArrayList;
import java.util.List;
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
 *         &lt;element name="RecordId" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="RoutingStatusCode" type="{urn://x-artefacts-smev-gov-ru/services/message-exchange/types/routing/1.3}RoutingStatusCodeType"/>
 *         &lt;element ref="{urn://x-artefacts-smev-gov-ru/services/message-exchange/types/routing/1.3}DynamicRoutingStatus" maxOccurs="1000" minOccurs="0"/>
 *         &lt;element ref="{urn://x-artefacts-smev-gov-ru/services/message-exchange/types/routing/1.3}IdentifierRoutingStatus" maxOccurs="1000" minOccurs="0"/>
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
    "recordId",
    "routingStatusCode",
    "dynamicRoutingStatus",
    "identifierRoutingStatus"
})
@XmlRootElement(name = "RegistryRoutingStatus", namespace = "urn://x-artefacts-smev-gov-ru/services/message-exchange/types/routing/1.3")
public class RegistryRoutingStatus {

    @XmlElement(name = "RecordId", namespace = "urn://x-artefacts-smev-gov-ru/services/message-exchange/types/routing/1.3")
    protected int recordId;
    @XmlElement(name = "RoutingStatusCode", namespace = "urn://x-artefacts-smev-gov-ru/services/message-exchange/types/routing/1.3", required = true)
    @XmlSchemaType(name = "string")
    protected RoutingStatusCodeType routingStatusCode;
    @XmlElement(name = "DynamicRoutingStatus", namespace = "urn://x-artefacts-smev-gov-ru/services/message-exchange/types/routing/1.3")
    protected List<DynamicRoutingStatus> dynamicRoutingStatus;
    @XmlElement(name = "IdentifierRoutingStatus", namespace = "urn://x-artefacts-smev-gov-ru/services/message-exchange/types/routing/1.3")
    protected List<IdentifierRoutingStatus> identifierRoutingStatus;

    /**
     * Gets the value of the recordId property.
     * 
     */
    public int getRecordId() {
        return recordId;
    }

    /**
     * Sets the value of the recordId property.
     * 
     */
    public void setRecordId(int value) {
        this.recordId = value;
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

    /**
     * Gets the value of the dynamicRoutingStatus property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the dynamicRoutingStatus property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getDynamicRoutingStatus().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link DynamicRoutingStatus }
     * 
     * 
     */
    public List<DynamicRoutingStatus> getDynamicRoutingStatus() {
        if (dynamicRoutingStatus == null) {
            dynamicRoutingStatus = new ArrayList<DynamicRoutingStatus>();
        }
        return this.dynamicRoutingStatus;
    }

    /**
     * Gets the value of the identifierRoutingStatus property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the identifierRoutingStatus property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getIdentifierRoutingStatus().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link IdentifierRoutingStatus }
     * 
     * 
     */
    public List<IdentifierRoutingStatus> getIdentifierRoutingStatus() {
        if (identifierRoutingStatus == null) {
            identifierRoutingStatus = new ArrayList<IdentifierRoutingStatus>();
        }
        return this.identifierRoutingStatus;
    }

}
