package ru.otr.lbss.client.model.types;

import ru.otr.lbss.client.model.types.basic.InteractionStatusType;

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
import javax.xml.datatype.XMLGregorianCalendar;
import java.io.Serializable;


/**
 * Маршрутная информация, заполняемая СМЭВ.
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
 *         &lt;element name="MessageId" type="{urn://x-artefacts-smev-gov-ru/services/message-exchange/types/basic/1.3}UUID" minOccurs="0"/>
 *         &lt;element name="MessageType" type="{urn://x-artefacts-smev-gov-ru/services/message-exchange/types/1.3}MessageTypeType"/>
 *         &lt;element name="Sender" minOccurs="0">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="Mnemonic" type="{urn://x-artefacts-smev-gov-ru/services/message-exchange/types/basic/1.3}string-50" minOccurs="0"/>
 *                   &lt;element name="HumanReadableName" type="{urn://x-artefacts-smev-gov-ru/services/message-exchange/types/basic/1.3}string-500"/>
 *                 &lt;/sequence>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="SendingTimestamp" type="{http://www.w3.org/2001/XMLSchema}dateTime"/>
 *         &lt;element name="Recipient" minOccurs="0">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="Mnemonic" type="{urn://x-artefacts-smev-gov-ru/services/message-exchange/types/basic/1.3}string-100" minOccurs="0"/>
 *                   &lt;element name="HumanReadableName" type="{urn://x-artefacts-smev-gov-ru/services/message-exchange/types/basic/1.3}string-500"/>
 *                 &lt;/sequence>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="DeliveryTimestamp" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *         &lt;element name="Status" type="{urn://x-artefacts-smev-gov-ru/services/message-exchange/types/basic/1.3}InteractionStatusType" minOccurs="0"/>
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
    "messageId",
    "messageType",
    "sender",
    "sendingTimestamp",
    "recipient",
    "deliveryTimestamp",
    "status"
})
@XmlRootElement(name = "MessageMetadata")
public class MessageMetadata implements Serializable {

    @XmlElement(name = "MessageId")
    protected String messageId;
    @XmlElement(name = "MessageType", required = true)
    @XmlSchemaType(name = "string")
    protected MessageTypeType messageType;
    @XmlElement(name = "Sender")
    protected MessageMetadata.Sender sender;
    @XmlElement(name = "SendingTimestamp", required = true)
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar sendingTimestamp;
    @XmlElement(name = "Recipient")
    protected MessageMetadata.Recipient recipient;
    @XmlElement(name = "DeliveryTimestamp")
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar deliveryTimestamp;
    @XmlElement(name = "Status")
    @XmlSchemaType(name = "string")
    protected InteractionStatusType status;
    @XmlAttribute(name = "Id")
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    @XmlID
    @XmlSchemaType(name = "ID")
    protected String id;

    /**
     * Gets the value of the messageId property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMessageId() {
        return messageId;
    }

    /**
     * Sets the value of the messageId property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMessageId(String value) {
        this.messageId = value;
    }

    /**
     * Gets the value of the messageType property.
     * 
     * @return
     *     possible object is
     *     {@link MessageTypeType }
     *     
     */
    public MessageTypeType getMessageType() {
        return messageType;
    }

    /**
     * Sets the value of the messageType property.
     * 
     * @param value
     *     allowed object is
     *     {@link MessageTypeType }
     *     
     */
    public void setMessageType(MessageTypeType value) {
        this.messageType = value;
    }

    /**
     * Gets the value of the sender property.
     * 
     * @return
     *     possible object is
     *     {@link MessageMetadata.Sender }
     *     
     */
    public MessageMetadata.Sender getSender() {
        return sender;
    }

    /**
     * Sets the value of the sender property.
     * 
     * @param value
     *     allowed object is
     *     {@link MessageMetadata.Sender }
     *     
     */
    public void setSender(MessageMetadata.Sender value) {
        this.sender = value;
    }

    /**
     * Gets the value of the sendingTimestamp property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getSendingTimestamp() {
        return sendingTimestamp;
    }

    /**
     * Sets the value of the sendingTimestamp property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setSendingTimestamp(XMLGregorianCalendar value) {
        this.sendingTimestamp = value;
    }

    /**
     * Gets the value of the recipient property.
     * 
     * @return
     *     possible object is
     *     {@link MessageMetadata.Recipient }
     *     
     */
    public MessageMetadata.Recipient getRecipient() {
        return recipient;
    }

    /**
     * Sets the value of the recipient property.
     * 
     * @param value
     *     allowed object is
     *     {@link MessageMetadata.Recipient }
     *     
     */
    public void setRecipient(MessageMetadata.Recipient value) {
        this.recipient = value;
    }

    /**
     * Gets the value of the deliveryTimestamp property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getDeliveryTimestamp() {
        return deliveryTimestamp;
    }

    /**
     * Sets the value of the deliveryTimestamp property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setDeliveryTimestamp(XMLGregorianCalendar value) {
        this.deliveryTimestamp = value;
    }

    /**
     * Gets the value of the status property.
     * 
     * @return
     *     possible object is
     *     {@link InteractionStatusType }
     *     
     */
    public InteractionStatusType getStatus() {
        return status;
    }

    /**
     * Sets the value of the status property.
     * 
     * @param value
     *     allowed object is
     *     {@link InteractionStatusType }
     *     
     */
    public void setStatus(InteractionStatusType value) {
        this.status = value;
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
     *         &lt;element name="Mnemonic" type="{urn://x-artefacts-smev-gov-ru/services/message-exchange/types/basic/1.3}string-100" minOccurs="0"/>
     *         &lt;element name="HumanReadableName" type="{urn://x-artefacts-smev-gov-ru/services/message-exchange/types/basic/1.3}string-500"/>
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
        "mnemonic",
        "humanReadableName"
    })
    public static class Recipient {

        @XmlElement(name = "Mnemonic")
        protected String mnemonic;
        @XmlElement(name = "HumanReadableName", required = true)
        protected String humanReadableName;

        /**
         * Gets the value of the mnemonic property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getMnemonic() {
            return mnemonic;
        }

        /**
         * Sets the value of the mnemonic property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setMnemonic(String value) {
            this.mnemonic = value;
        }

        /**
         * Gets the value of the humanReadableName property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getHumanReadableName() {
            return humanReadableName;
        }

        /**
         * Sets the value of the humanReadableName property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setHumanReadableName(String value) {
            this.humanReadableName = value;
        }

    }


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
     *         &lt;element name="Mnemonic" type="{urn://x-artefacts-smev-gov-ru/services/message-exchange/types/basic/1.3}string-50" minOccurs="0"/>
     *         &lt;element name="HumanReadableName" type="{urn://x-artefacts-smev-gov-ru/services/message-exchange/types/basic/1.3}string-500"/>
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
        "mnemonic",
        "humanReadableName"
    })
    public static class Sender {

        @XmlElement(name = "Mnemonic")
        protected String mnemonic;
        @XmlElement(name = "HumanReadableName", required = true)
        protected String humanReadableName;

        /**
         * Gets the value of the mnemonic property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getMnemonic() {
            return mnemonic;
        }

        /**
         * Sets the value of the mnemonic property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setMnemonic(String value) {
            this.mnemonic = value;
        }

        /**
         * Gets the value of the humanReadableName property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getHumanReadableName() {
            return humanReadableName;
        }

        /**
         * Sets the value of the humanReadableName property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setHumanReadableName(String value) {
            this.humanReadableName = value;
        }

    }

}
