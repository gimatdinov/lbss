
package ru.otr.lbss.client.model.types.routing;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlID;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.CollapsedStringAdapter;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;


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
 *         &lt;element name="MessageID" type="{urn://x-artefacts-smev-gov-ru/services/message-exchange/types/basic/1.3}UUID"/>
 *         &lt;element ref="{urn://x-artefacts-smev-gov-ru/services/message-exchange/types/routing/1.3}DynamicRouting" minOccurs="0"/>
 *         &lt;element ref="{urn://x-artefacts-smev-gov-ru/services/message-exchange/types/routing/1.3}IdentifierRouting" minOccurs="0"/>
 *         &lt;element ref="{urn://x-artefacts-smev-gov-ru/services/message-exchange/types/routing/1.3}RegistryRouting" minOccurs="0"/>
 *       &lt;/sequence>
 *       &lt;attribute name="Id" type="{http://www.w3.org/2001/XMLSchema}ID" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "messageID",
    "dynamicRouting",
    "identifierRouting",
    "registryRouting"
})
@XmlRootElement(name = "RoutingInformation", namespace = "urn://x-artefacts-smev-gov-ru/services/message-exchange/types/routing/1.3")
public class RoutingInformation {

    @XmlElement(name = "MessageID", namespace = "urn://x-artefacts-smev-gov-ru/services/message-exchange/types/routing/1.3", required = true)
    protected String messageID;
    @XmlElement(name = "DynamicRouting", namespace = "urn://x-artefacts-smev-gov-ru/services/message-exchange/types/routing/1.3")
    protected DynamicRouting dynamicRouting;
    @XmlElement(name = "IdentifierRouting", namespace = "urn://x-artefacts-smev-gov-ru/services/message-exchange/types/routing/1.3")
    protected IdentifierRouting identifierRouting;
    @XmlElement(name = "RegistryRouting", namespace = "urn://x-artefacts-smev-gov-ru/services/message-exchange/types/routing/1.3")
    protected RegistryRouting registryRouting;
    @XmlAttribute(name = "Id")
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    @XmlID
    @XmlSchemaType(name = "ID")
    protected String id;

    /**
     * Gets the value of the messageID property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMessageID() {
        return messageID;
    }

    /**
     * Sets the value of the messageID property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMessageID(String value) {
        this.messageID = value;
    }

    /**
     * Gets the value of the dynamicRouting property.
     * 
     * @return
     *     possible object is
     *     {@link DynamicRouting }
     *     
     */
    public DynamicRouting getDynamicRouting() {
        return dynamicRouting;
    }

    /**
     * Sets the value of the dynamicRouting property.
     * 
     * @param value
     *     allowed object is
     *     {@link DynamicRouting }
     *     
     */
    public void setDynamicRouting(DynamicRouting value) {
        this.dynamicRouting = value;
    }

    /**
     * Gets the value of the identifierRouting property.
     * 
     * @return
     *     possible object is
     *     {@link IdentifierRouting }
     *     
     */
    public IdentifierRouting getIdentifierRouting() {
        return identifierRouting;
    }

    /**
     * Sets the value of the identifierRouting property.
     * 
     * @param value
     *     allowed object is
     *     {@link IdentifierRouting }
     *     
     */
    public void setIdentifierRouting(IdentifierRouting value) {
        this.identifierRouting = value;
    }

    /**
     * Gets the value of the registryRouting property.
     * 
     * @return
     *     possible object is
     *     {@link RegistryRouting }
     *     
     */
    public RegistryRouting getRegistryRouting() {
        return registryRouting;
    }

    /**
     * Sets the value of the registryRouting property.
     * 
     * @param value
     *     allowed object is
     *     {@link RegistryRouting }
     *     
     */
    public void setRegistryRouting(RegistryRouting value) {
        this.registryRouting = value;
    }

    /**
     * Gets the value of the id property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getId() {
        return id;
    }

    /**
     * Sets the value of the id property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setId(String value) {
        this.id = value;
    }

}
