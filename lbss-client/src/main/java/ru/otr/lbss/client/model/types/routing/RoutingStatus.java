package ru.otr.lbss.client.model.types.routing;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * 
 *                     Статус маршрутизации сообщения
 *                 
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
 *         &lt;element ref="{urn://x-artefacts-smev-gov-ru/services/message-exchange/types/routing/1.3}DynamicRoutingStatus" maxOccurs="1000" minOccurs="0"/>
 *         &lt;element ref="{urn://x-artefacts-smev-gov-ru/services/message-exchange/types/routing/1.3}IdentifierRoutingStatus" maxOccurs="1000" minOccurs="0"/>
 *         &lt;element ref="{urn://x-artefacts-smev-gov-ru/services/message-exchange/types/routing/1.3}RegistryRoutingStatus" maxOccurs="1000" minOccurs="0"/>
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
    "dynamicRoutingStatus",
    "identifierRoutingStatus",
    "registryRoutingStatus"
})
@XmlRootElement(name = "RoutingStatus", namespace = "urn://x-artefacts-smev-gov-ru/services/message-exchange/types/routing/1.3")
public class RoutingStatus {

    @XmlElement(name = "DynamicRoutingStatus", namespace = "urn://x-artefacts-smev-gov-ru/services/message-exchange/types/routing/1.3")
    protected List<DynamicRoutingStatus> dynamicRoutingStatus;
    @XmlElement(name = "IdentifierRoutingStatus", namespace = "urn://x-artefacts-smev-gov-ru/services/message-exchange/types/routing/1.3")
    protected List<IdentifierRoutingStatus> identifierRoutingStatus;
    @XmlElement(name = "RegistryRoutingStatus", namespace = "urn://x-artefacts-smev-gov-ru/services/message-exchange/types/routing/1.3")
    protected List<RegistryRoutingStatus> registryRoutingStatus;

    /**
     * Статусы динамической маршрутизации Gets the value of the dynamicRoutingStatus property.
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
     * Статусы маршрутизации по идентификаторам Gets the value of the identifierRoutingStatus property.
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

    /**
     * Статусы реестровой маршрутизации Gets the value of the registryRoutingStatus property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the registryRoutingStatus property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getRegistryRoutingStatus().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link RegistryRoutingStatus }
     * 
     * 
     */
    public List<RegistryRoutingStatus> getRegistryRoutingStatus() {
        if (registryRoutingStatus == null) {
            registryRoutingStatus = new ArrayList<RegistryRoutingStatus>();
        }
        return this.registryRoutingStatus;
    }

}
