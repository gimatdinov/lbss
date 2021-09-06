package ru.otr.lbss.client.model.types;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAnyElement;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlID;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.CollapsedStringAdapter;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import javax.xml.datatype.XMLGregorianCalendar;
import org.w3c.dom.Element;
import ru.otr.lbss.client.model.types.basic.AttachmentHeaderList;
import ru.otr.lbss.client.model.types.basic.MessagePrimaryContent;
import ru.otr.lbss.client.model.types.basic.RefAttachmentHeaderList;
import ru.otr.lbss.client.model.types.basic.XMLDSigSignatureType;
import ru.otr.lbss.client.model.types.basic.Void;

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
 *         &lt;element name="ReferenceMessageID" type="{urn://x-artefacts-smev-gov-ru/services/message-exchange/types/basic/1.3}UUID" minOccurs="0"/>
 *         &lt;element name="TransactionCode" type="{urn://x-artefacts-smev-gov-ru/services/message-exchange/types/basic/1.3}string-1500" minOccurs="0"/>
 *         &lt;element name="NodeID" type="{urn://x-artefacts-smev-gov-ru/services/message-exchange/types/basic/1.3}string-50" minOccurs="0"/>
 *         &lt;element name="EOL" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *         &lt;element ref="{urn://x-artefacts-smev-gov-ru/services/message-exchange/types/basic/1.3}MessagePrimaryContent"/>
 *         &lt;element name="PersonalSignature" type="{urn://x-artefacts-smev-gov-ru/services/message-exchange/types/basic/1.3}XMLDSigSignatureType" minOccurs="0"/>
 *         &lt;element ref="{urn://x-artefacts-smev-gov-ru/services/message-exchange/types/basic/1.3}AttachmentHeaderList" minOccurs="0"/>
 *         &lt;element ref="{urn://x-artefacts-smev-gov-ru/services/message-exchange/types/basic/1.3}RefAttachmentHeaderList" minOccurs="0"/>
 *         &lt;element name="BusinessProcessMetadata" minOccurs="0">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;any processContents='lax' namespace='##other' maxOccurs="unbounded" minOccurs="0"/>
 *                 &lt;/sequence>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="TestMessage" type="{urn://x-artefacts-smev-gov-ru/services/message-exchange/types/basic/1.3}Void" minOccurs="0"/>
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
    "referenceMessageID",
    "transactionCode",
    "nodeID",
    "eol",
    "messagePrimaryContent",
    "personalSignature",
    "attachmentHeaderList",
    "refAttachmentHeaderList",
    "businessProcessMetadata",
    "testMessage"
})
@XmlRootElement(name = "SenderProvidedRequestData")
public class SenderProvidedRequestData {

    @XmlElement(name = "MessageID", required = true)
    protected String messageID;
    @XmlElement(name = "ReferenceMessageID")
    protected String referenceMessageID;
    @XmlElement(name = "TransactionCode")
    protected String transactionCode;
    @XmlElement(name = "NodeID")
    protected String nodeID;
    @XmlElement(name = "EOL")
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar eol;
    @XmlElement(name = "MessagePrimaryContent", namespace = "urn://x-artefacts-smev-gov-ru/services/message-exchange/types/basic/1.3", required = true)
    protected MessagePrimaryContent messagePrimaryContent;
    @XmlElement(name = "PersonalSignature")
    protected XMLDSigSignatureType personalSignature;
    @XmlElement(name = "AttachmentHeaderList", namespace = "urn://x-artefacts-smev-gov-ru/services/message-exchange/types/basic/1.3")
    protected AttachmentHeaderList attachmentHeaderList;
    @XmlElement(name = "RefAttachmentHeaderList", namespace = "urn://x-artefacts-smev-gov-ru/services/message-exchange/types/basic/1.3")
    protected RefAttachmentHeaderList refAttachmentHeaderList;
    @XmlElement(name = "BusinessProcessMetadata")
    protected SenderProvidedRequestData.BusinessProcessMetadata businessProcessMetadata;
    @XmlElement(name = "TestMessage")
    protected Void testMessage;
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
     * Gets the value of the referenceMessageID property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getReferenceMessageID() {
        return referenceMessageID;
    }

    /**
     * Sets the value of the referenceMessageID property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setReferenceMessageID(String value) {
        this.referenceMessageID = value;
    }

    /**
     * Gets the value of the transactionCode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTransactionCode() {
        return transactionCode;
    }

    /**
     * Sets the value of the transactionCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTransactionCode(String value) {
        this.transactionCode = value;
    }

    /**
     * Gets the value of the nodeID property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNodeID() {
        return nodeID;
    }

    /**
     * Sets the value of the nodeID property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNodeID(String value) {
        this.nodeID = value;
    }

    /**
     * Gets the value of the eol property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getEOL() {
        return eol;
    }

    /**
     * Sets the value of the eol property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setEOL(XMLGregorianCalendar value) {
        this.eol = value;
    }

    /**
     * Содержательная часть запроса, XML-документ.
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
     * Gets the value of the businessProcessMetadata property.
     * 
     * @return
     *     possible object is
     *     {@link SenderProvidedRequestData.BusinessProcessMetadata }
     *     
     */
    public SenderProvidedRequestData.BusinessProcessMetadata getBusinessProcessMetadata() {
        return businessProcessMetadata;
    }

    /**
     * Sets the value of the businessProcessMetadata property.
     * 
     * @param value
     *     allowed object is
     *     {@link SenderProvidedRequestData.BusinessProcessMetadata }
     *     
     */
    public void setBusinessProcessMetadata(SenderProvidedRequestData.BusinessProcessMetadata value) {
        this.businessProcessMetadata = value;
    }

    /**
     * Gets the value of the testMessage property.
     * 
     * @return
     *     possible object is
     *     {@link Void }
     *     
     */
    public Void getTestMessage() {
        return testMessage;
    }

    /**
     * Sets the value of the testMessage property.
     * 
     * @param value
     *     allowed object is
     *     {@link Void }
     *     
     */
    public void setTestMessage(Void value) {
        this.testMessage = value;
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
     *         &lt;any processContents='lax' namespace='##other' maxOccurs="unbounded" minOccurs="0"/>
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
        "any"
    })
    public static class BusinessProcessMetadata {

        @XmlAnyElement(lax = true)
        protected List<Object> any;

        /**
         * Gets the value of the any property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the any property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getAny().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link Element }
         * {@link Object }
         * 
         * 
         */
        public List<Object> getAny() {
            if (any == null) {
                any = new ArrayList<Object>();
            }
            return this.any;
        }

    }

}
