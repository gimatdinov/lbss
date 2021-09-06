package ru.otr.lbss.client.model.types.directive;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
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
 *         &lt;element ref="{urn://x-artefacts-smev-gov-ru/services/message-exchange/types/directive/1.3}RegistryRecord" maxOccurs="1000"/>
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
    "registryRecord"
})
@XmlRootElement(name = "Registry", namespace = "urn://x-artefacts-smev-gov-ru/services/message-exchange/types/directive/1.3")
public class Registry {

    @XmlElement(name = "RegistryRecord", namespace = "urn://x-artefacts-smev-gov-ru/services/message-exchange/types/directive/1.3", required = true)
    protected List<RegistryRecord> registryRecord;

    /**
     * Gets the value of the registryRecord property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the registryRecord property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getRegistryRecord().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link RegistryRecord }
     * 
     * 
     */
    public List<RegistryRecord> getRegistryRecord() {
        if (registryRecord == null) {
            registryRecord = new ArrayList<RegistryRecord>();
        }
        return this.registryRecord;
    }

}
