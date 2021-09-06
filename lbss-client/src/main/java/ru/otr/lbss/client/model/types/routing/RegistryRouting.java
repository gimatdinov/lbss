package ru.otr.lbss.client.model.types.routing;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * Параметры маршрутизации реестровых записей сообщения
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
 *         &lt;element ref="{urn://x-artefacts-smev-gov-ru/services/message-exchange/types/routing/1.3}RegistryRecordRouting" maxOccurs="1000"/>
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
    "registryRecordRouting"
})
@XmlRootElement(name = "RegistryRouting", namespace = "urn://x-artefacts-smev-gov-ru/services/message-exchange/types/routing/1.3")
public class RegistryRouting {

    @XmlElement(name = "RegistryRecordRouting", namespace = "urn://x-artefacts-smev-gov-ru/services/message-exchange/types/routing/1.3", required = true)
    protected List<RegistryRecordRouting> registryRecordRouting;

    /**
     * Gets the value of the registryRecordRouting property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the registryRecordRouting property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getRegistryRecordRouting().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link RegistryRecordRouting }
     * 
     * 
     */
    public List<RegistryRecordRouting> getRegistryRecordRouting() {
        if (registryRecordRouting == null) {
            registryRecordRouting = new ArrayList<RegistryRecordRouting>();
        }
        return this.registryRecordRouting;
    }

}
