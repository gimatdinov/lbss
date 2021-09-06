package ru.otr.lbss.client.model.types.directive;

import ru.otr.lbss.client.model.types.basic.AttachmentHeaderList;
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
 *         &lt;element ref="{urn://x-artefacts-smev-gov-ru/services/message-exchange/types/directive/1.3}RecordContent"/>
 *         &lt;element ref="{urn://x-artefacts-smev-gov-ru/services/message-exchange/types/basic/1.3}AttachmentHeaderList" minOccurs="0"/>
 *         &lt;element ref="{urn://x-artefacts-smev-gov-ru/services/message-exchange/types/basic/1.3}RefAttachmentHeaderList" minOccurs="0"/>
 *         &lt;element name="PersonalSignature" type="{urn://x-artefacts-smev-gov-ru/services/message-exchange/types/basic/1.3}XMLDSigSignatureType" maxOccurs="10" minOccurs="0"/>
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
    "recordContent",
    "attachmentHeaderList",
    "refAttachmentHeaderList",
    "personalSignature"
})
@XmlRootElement(name = "Record", namespace = "urn://x-artefacts-smev-gov-ru/services/message-exchange/types/directive/1.3")
public class Record {

    @XmlElement(name = "RecordContent", namespace = "urn://x-artefacts-smev-gov-ru/services/message-exchange/types/directive/1.3", required = true)
    protected RecordContent recordContent;
    @XmlElement(name = "AttachmentHeaderList", namespace = "urn://x-artefacts-smev-gov-ru/services/message-exchange/types/basic/1.3")
    protected AttachmentHeaderList attachmentHeaderList;
    @XmlElement(name = "RefAttachmentHeaderList", namespace = "urn://x-artefacts-smev-gov-ru/services/message-exchange/types/basic/1.3")
    protected RefAttachmentHeaderList refAttachmentHeaderList;
    @XmlElement(name = "PersonalSignature", namespace = "urn://x-artefacts-smev-gov-ru/services/message-exchange/types/directive/1.3")
    protected List<XMLDSigSignatureType> personalSignature;
    @XmlAttribute(name = "Id")
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    @XmlID
    @XmlSchemaType(name = "ID")
    protected String id;

    /**
     * Gets the value of the recordContent property.
     * 
     * @return
     *     possible object is
     *     {@link RecordContent }
     *     
     */
    public RecordContent getRecordContent() {
        return recordContent;
    }

    /**
     * Sets the value of the recordContent property.
     * 
     * @param value
     *     allowed object is
     *     {@link RecordContent }
     *     
     */
    public void setRecordContent(RecordContent value) {
        this.recordContent = value;
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
     * Gets the value of the personalSignature property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the personalSignature property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getPersonalSignature().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link XMLDSigSignatureType }
     * 
     * 
     */
    public List<XMLDSigSignatureType> getPersonalSignature() {
        if (personalSignature == null) {
            personalSignature = new ArrayList<XMLDSigSignatureType>();
        }
        return this.personalSignature;
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
