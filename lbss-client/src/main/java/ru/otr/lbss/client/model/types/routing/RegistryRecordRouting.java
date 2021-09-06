package ru.otr.lbss.client.model.types.routing;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * Параметры маршрутизации реестровой записи
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
 *         &lt;element name="RecordId" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="UseGeneralRouting" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element ref="{urn://x-artefacts-smev-gov-ru/services/message-exchange/types/routing/1.3}DynamicRouting" minOccurs="0"/>
 *         &lt;element ref="{urn://x-artefacts-smev-gov-ru/services/message-exchange/types/routing/1.3}IdentifierRouting" minOccurs="0"/>
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
    "useGeneralRouting",
    "dynamicRouting",
    "identifierRouting"
})
@XmlRootElement(name = "RegistryRecordRouting", namespace = "urn://x-artefacts-smev-gov-ru/services/message-exchange/types/routing/1.3")
public class RegistryRecordRouting {

    @XmlElement(name = "RecordId", namespace = "urn://x-artefacts-smev-gov-ru/services/message-exchange/types/routing/1.3")
    protected int recordId;
    @XmlElement(name = "UseGeneralRouting", namespace = "urn://x-artefacts-smev-gov-ru/services/message-exchange/types/routing/1.3")
    protected boolean useGeneralRouting;
    @XmlElement(name = "DynamicRouting", namespace = "urn://x-artefacts-smev-gov-ru/services/message-exchange/types/routing/1.3")
    protected DynamicRouting dynamicRouting;
    @XmlElement(name = "IdentifierRouting", namespace = "urn://x-artefacts-smev-gov-ru/services/message-exchange/types/routing/1.3")
    protected IdentifierRouting identifierRouting;

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
     * Gets the value of the useGeneralRouting property.
     * 
     */
    public boolean isUseGeneralRouting() {
        return useGeneralRouting;
    }

    /**
     * Sets the value of the useGeneralRouting property.
     * 
     */
    public void setUseGeneralRouting(boolean value) {
        this.useGeneralRouting = value;
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

}
