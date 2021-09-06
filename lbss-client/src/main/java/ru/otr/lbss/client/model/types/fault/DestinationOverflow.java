package ru.otr.lbss.client.model.types.fault;

import ru.otr.lbss.client.model.types.basic.SmevFault;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for DestinationOverflow complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="DestinationOverflow">
 *   &lt;complexContent>
 *     &lt;extension base="{urn://x-artefacts-smev-gov-ru/services/message-exchange/types/basic/1.3}SmevFault">
 *       &lt;sequence>
 *         &lt;element name="MessageBrokerAddress" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="DestinationName" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "DestinationOverflow", namespace = "urn://x-artefacts-smev-gov-ru/services/message-exchange/types/faults/1.3", propOrder = {
    "messageBrokerAddress",
    "destinationName"
})
public class DestinationOverflow
    extends SmevFault
{

    @XmlElement(name = "MessageBrokerAddress", required = true)
    protected String messageBrokerAddress;
    @XmlElement(name = "DestinationName", required = true)
    protected String destinationName;

    /**
     * Gets the value of the messageBrokerAddress property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMessageBrokerAddress() {
        return messageBrokerAddress;
    }

    /**
     * Sets the value of the messageBrokerAddress property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMessageBrokerAddress(String value) {
        this.messageBrokerAddress = value;
    }

    /**
     * Gets the value of the destinationName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDestinationName() {
        return destinationName;
    }

    /**
     * Sets the value of the destinationName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDestinationName(String value) {
        this.destinationName = value;
    }

}
