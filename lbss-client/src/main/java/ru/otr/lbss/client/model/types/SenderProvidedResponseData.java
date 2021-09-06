package ru.otr.lbss.client.model.types;

import ru.otr.lbss.client.model.types.basic.AttachmentHeaderList;
import ru.otr.lbss.client.model.types.basic.MessagePrimaryContent;
import ru.otr.lbss.client.model.types.basic.RefAttachmentHeaderList;
import ru.otr.lbss.client.model.types.basic.XMLDSigSignatureType;

import java.util.ArrayList;
import java.util.List;
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
 *         &lt;element name="To" type="{urn://x-artefacts-smev-gov-ru/services/message-exchange/types/basic/1.3}string-4000"/>
 *         &lt;choice>
 *           &lt;sequence>
 *             &lt;element ref="{urn://x-artefacts-smev-gov-ru/services/message-exchange/types/basic/1.3}MessagePrimaryContent"/>
 *             &lt;element name="PersonalSignature" type="{urn://x-artefacts-smev-gov-ru/services/message-exchange/types/basic/1.3}XMLDSigSignatureType" minOccurs="0"/>
 *             &lt;element ref="{urn://x-artefacts-smev-gov-ru/services/message-exchange/types/basic/1.3}AttachmentHeaderList" minOccurs="0"/>
 *             &lt;element ref="{urn://x-artefacts-smev-gov-ru/services/message-exchange/types/basic/1.3}RefAttachmentHeaderList" minOccurs="0"/>
 *           &lt;/sequence>
 *           &lt;element name="RequestRejected" maxOccurs="unbounded">
 *             &lt;complexType>
 *               &lt;complexContent>
 *                 &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                   &lt;sequence>
 *                     &lt;element name="RejectionReasonCode" type="{urn://x-artefacts-smev-gov-ru/services/message-exchange/types/1.3}RejectCode"/>
 *                     &lt;element name="RejectionReasonDescription" type="{urn://x-artefacts-smev-gov-ru/services/message-exchange/types/basic/1.3}string-4000"/>
 *                   &lt;/sequence>
 *                 &lt;/restriction>
 *               &lt;/complexContent>
 *             &lt;/complexType>
 *           &lt;/element>
 *           &lt;element name="RequestStatus">
 *             &lt;complexType>
 *               &lt;complexContent>
 *                 &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                   &lt;sequence>
 *                     &lt;element name="StatusCode" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *                     &lt;element name="StatusParameter" maxOccurs="unbounded" minOccurs="0">
 *                       &lt;complexType>
 *                         &lt;complexContent>
 *                           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                             &lt;sequence>
 *                               &lt;element name="Key" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                               &lt;element name="Value" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                             &lt;/sequence>
 *                           &lt;/restriction>
 *                         &lt;/complexContent>
 *                       &lt;/complexType>
 *                     &lt;/element>
 *                     &lt;element name="StatusDescription" type="{urn://x-artefacts-smev-gov-ru/services/message-exchange/types/basic/1.3}string-4000"/>
 *                   &lt;/sequence>
 *                 &lt;/restriction>
 *               &lt;/complexContent>
 *             &lt;/complexType>
 *           &lt;/element>
 *           &lt;element ref="{urn://x-artefacts-smev-gov-ru/services/message-exchange/types/1.3}AsyncProcessingStatus"/>
 *         &lt;/choice>
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
    "to",
    "messagePrimaryContent",
    "personalSignature",
    "attachmentHeaderList",
    "refAttachmentHeaderList",
    "requestRejected",
    "requestStatus",
    "asyncProcessingStatus"
})
@XmlRootElement(name = "SenderProvidedResponseData")
public class SenderProvidedResponseData {

    @XmlElement(name = "MessageID", required = true)
    protected String messageID;
    @XmlElement(name = "To", required = true)
    protected String to;
    @XmlElement(name = "MessagePrimaryContent", namespace = "urn://x-artefacts-smev-gov-ru/services/message-exchange/types/basic/1.3")
    protected MessagePrimaryContent messagePrimaryContent;
    @XmlElement(name = "PersonalSignature")
    protected XMLDSigSignatureType personalSignature;
    @XmlElement(name = "AttachmentHeaderList", namespace = "urn://x-artefacts-smev-gov-ru/services/message-exchange/types/basic/1.3")
    protected AttachmentHeaderList attachmentHeaderList;
    @XmlElement(name = "RefAttachmentHeaderList", namespace = "urn://x-artefacts-smev-gov-ru/services/message-exchange/types/basic/1.3")
    protected RefAttachmentHeaderList refAttachmentHeaderList;
    @XmlElement(name = "RequestRejected")
    protected List<SenderProvidedResponseData.RequestRejected> requestRejected;
    @XmlElement(name = "RequestStatus")
    protected SenderProvidedResponseData.RequestStatus requestStatus;
    @XmlElement(name = "AsyncProcessingStatus")
    protected AsyncProcessingStatus asyncProcessingStatus;
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
     * Gets the value of the to property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTo() {
        return to;
    }

    /**
     * Sets the value of the to property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTo(String value) {
        this.to = value;
    }

    /**
     * Содержательная часть ответа, XML-документ.
     * 
     * @return
     *     possible object is
     *     {@link MessagePrimaryContent }
     *     
     */
    public MessagePrimaryContent getMessagePrimaryContent() {
        return messagePrimaryContent;
    }

    /**
     * Sets the value of the messagePrimaryContent property.
     * 
     * @param value
     *     allowed object is
     *     {@link MessagePrimaryContent }
     *     
     */
    public void setMessagePrimaryContent(MessagePrimaryContent value) {
        this.messagePrimaryContent = value;
    }

    /**
     * Gets the value of the personalSignature property.
     * 
     * @return
     *     possible object is
     *     {@link XMLDSigSignatureType }
     *     
     */
    public XMLDSigSignatureType getPersonalSignature() {
        return personalSignature;
    }

    /**
     * Sets the value of the personalSignature property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLDSigSignatureType }
     *     
     */
    public void setPersonalSignature(XMLDSigSignatureType value) {
        this.personalSignature = value;
    }

    /**
     * Заголовки вложенных файлов.
     * 
     * @return
     *     possible object is
     *     {@link AttachmentHeaderList }
     *     
     */
    public AttachmentHeaderList getAttachmentHeaderList() {
        return attachmentHeaderList;
    }

    /**
     * Sets the value of the attachmentHeaderList property.
     * 
     * @param value
     *     allowed object is
     *     {@link AttachmentHeaderList }
     *     
     */
    public void setAttachmentHeaderList(AttachmentHeaderList value) {
        this.attachmentHeaderList = value;
    }

    /**
     * Заголовки файлов по ссылке.
     * 
     * @return
     *     possible object is
     *     {@link RefAttachmentHeaderList }
     *     
     */
    public RefAttachmentHeaderList getRefAttachmentHeaderList() {
        return refAttachmentHeaderList;
    }

    /**
     * Sets the value of the refAttachmentHeaderList property.
     * 
     * @param value
     *     allowed object is
     *     {@link RefAttachmentHeaderList }
     *     
     */
    public void setRefAttachmentHeaderList(RefAttachmentHeaderList value) {
        this.refAttachmentHeaderList = value;
    }

    /**
     * Gets the value of the requestRejected property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the requestRejected property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getRequestRejected().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link SenderProvidedResponseData.RequestRejected }
     * 
     * 
     */
    public List<SenderProvidedResponseData.RequestRejected> getRequestRejected() {
        if (requestRejected == null) {
            requestRejected = new ArrayList<SenderProvidedResponseData.RequestRejected>();
        }
        return this.requestRejected;
    }

    /**
     * Gets the value of the requestStatus property.
     * 
     * @return
     *     possible object is
     *     {@link SenderProvidedResponseData.RequestStatus }
     *     
     */
    public SenderProvidedResponseData.RequestStatus getRequestStatus() {
        return requestStatus;
    }

    /**
     * Sets the value of the requestStatus property.
     * 
     * @param value
     *     allowed object is
     *     {@link SenderProvidedResponseData.RequestStatus }
     *     
     */
    public void setRequestStatus(SenderProvidedResponseData.RequestStatus value) {
        this.requestStatus = value;
    }

    /**
     * Gets the value of the asyncProcessingStatus property.
     * 
     * @return
     *     possible object is
     *     {@link AsyncProcessingStatus }
     *     
     */
    public AsyncProcessingStatus getAsyncProcessingStatus() {
        return asyncProcessingStatus;
    }

    /**
     * Sets the value of the asyncProcessingStatus property.
     * 
     * @param value
     *     allowed object is
     *     {@link AsyncProcessingStatus }
     *     
     */
    public void setAsyncProcessingStatus(AsyncProcessingStatus value) {
        this.asyncProcessingStatus = value;
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
     *         &lt;element name="RejectionReasonCode" type="{urn://x-artefacts-smev-gov-ru/services/message-exchange/types/1.3}RejectCode"/>
     *         &lt;element name="RejectionReasonDescription" type="{urn://x-artefacts-smev-gov-ru/services/message-exchange/types/basic/1.3}string-4000"/>
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
        "rejectionReasonCode",
        "rejectionReasonDescription"
    })
    public static class RequestRejected {

        @XmlElement(name = "RejectionReasonCode", required = true)
        @XmlSchemaType(name = "string")
        protected RejectCode rejectionReasonCode;
        @XmlElement(name = "RejectionReasonDescription", required = true)
        protected String rejectionReasonDescription;

        /**
         * Gets the value of the rejectionReasonCode property.
         * 
         * @return
         *     possible object is
         *     {@link RejectCode }
         *     
         */
        public RejectCode getRejectionReasonCode() {
            return rejectionReasonCode;
        }

        /**
         * Sets the value of the rejectionReasonCode property.
         * 
         * @param value
         *     allowed object is
         *     {@link RejectCode }
         *     
         */
        public void setRejectionReasonCode(RejectCode value) {
            this.rejectionReasonCode = value;
        }

        /**
         * Gets the value of the rejectionReasonDescription property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getRejectionReasonDescription() {
            return rejectionReasonDescription;
        }

        /**
         * Sets the value of the rejectionReasonDescription property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setRejectionReasonDescription(String value) {
            this.rejectionReasonDescription = value;
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
     *         &lt;element name="StatusCode" type="{http://www.w3.org/2001/XMLSchema}int"/>
     *         &lt;element name="StatusParameter" maxOccurs="unbounded" minOccurs="0">
     *           &lt;complexType>
     *             &lt;complexContent>
     *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *                 &lt;sequence>
     *                   &lt;element name="Key" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *                   &lt;element name="Value" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *                 &lt;/sequence>
     *               &lt;/restriction>
     *             &lt;/complexContent>
     *           &lt;/complexType>
     *         &lt;/element>
     *         &lt;element name="StatusDescription" type="{urn://x-artefacts-smev-gov-ru/services/message-exchange/types/basic/1.3}string-4000"/>
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
        "statusCode",
        "statusParameter",
        "statusDescription"
    })
    public static class RequestStatus {

        @XmlElement(name = "StatusCode")
        protected int statusCode;
        @XmlElement(name = "StatusParameter")
        protected List<SenderProvidedResponseData.RequestStatus.StatusParameter> statusParameter;
        @XmlElement(name = "StatusDescription", required = true)
        protected String statusDescription;

        /**
         * Gets the value of the statusCode property.
         * 
         */
        public int getStatusCode() {
            return statusCode;
        }

        /**
         * Sets the value of the statusCode property.
         * 
         */
        public void setStatusCode(int value) {
            this.statusCode = value;
        }

        /**
         * Gets the value of the statusParameter property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the statusParameter property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getStatusParameter().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link SenderProvidedResponseData.RequestStatus.StatusParameter }
         * 
         * 
         */
        public List<SenderProvidedResponseData.RequestStatus.StatusParameter> getStatusParameter() {
            if (statusParameter == null) {
                statusParameter = new ArrayList<SenderProvidedResponseData.RequestStatus.StatusParameter>();
            }
            return this.statusParameter;
        }

        /**
         * Gets the value of the statusDescription property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getStatusDescription() {
            return statusDescription;
        }

        /**
         * Sets the value of the statusDescription property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setStatusDescription(String value) {
            this.statusDescription = value;
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
         *         &lt;element name="Key" type="{http://www.w3.org/2001/XMLSchema}string"/>
         *         &lt;element name="Value" type="{http://www.w3.org/2001/XMLSchema}string"/>
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
            "key",
            "value"
        })
        public static class StatusParameter {

            @XmlElement(name = "Key", required = true)
            protected String key;
            @XmlElement(name = "Value", required = true)
            protected String value;

            /**
             * Gets the value of the key property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getKey() {
                return key;
            }

            /**
             * Sets the value of the key property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setKey(String value) {
                this.key = value;
            }

            /**
             * Gets the value of the value property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getValue() {
                return value;
            }

            /**
             * Sets the value of the value property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setValue(String value) {
                this.value = value;
            }

        }

    }

}
