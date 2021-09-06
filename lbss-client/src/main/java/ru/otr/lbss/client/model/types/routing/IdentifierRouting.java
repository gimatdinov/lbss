package ru.otr.lbss.client.model.types.routing;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * Параметры маршрутизации по идентификаторам
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
 *         &lt;element name="IdentifierValue" type="{urn://x-artefacts-smev-gov-ru/services/message-exchange/types/routing/1.3}Value" maxOccurs="1000"/>
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
    "identifierValue"
})
@XmlRootElement(name = "IdentifierRouting", namespace = "urn://x-artefacts-smev-gov-ru/services/message-exchange/types/routing/1.3")
public class IdentifierRouting {

    @XmlElement(name = "IdentifierValue", namespace = "urn://x-artefacts-smev-gov-ru/services/message-exchange/types/routing/1.3", required = true)
    protected List<String> identifierValue;

    /**
     * Gets the value of the identifierValue property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the identifierValue property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getIdentifierValue().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link String }
     * 
     * 
     */
    public List<String> getIdentifierValue() {
        if (identifierValue == null) {
            identifierValue = new ArrayList<String>();
        }
        return this.identifierValue;
    }

}
