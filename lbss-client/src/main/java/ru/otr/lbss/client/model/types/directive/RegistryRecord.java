package ru.otr.lbss.client.model.types.directive;

import ru.otr.lbss.client.model.types.basic.XMLDSigSignatureType;

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
 *         &lt;element name="RecordId" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element ref="{urn://x-artefacts-smev-gov-ru/services/message-exchange/types/directive/1.3}Record"/>
 *         &lt;element name="RecordSignature" type="{urn://x-artefacts-smev-gov-ru/services/message-exchange/types/basic/1.3}XMLDSigSignatureType" minOccurs="0"/>
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
    "record",
    "recordSignature"
})
@XmlRootElement(name = "RegistryRecord", namespace = "urn://x-artefacts-smev-gov-ru/services/message-exchange/types/directive/1.3")
public class RegistryRecord {

    @XmlElement(name = "RecordId", namespace = "urn://x-artefacts-smev-gov-ru/services/message-exchange/types/directive/1.3")
    protected int recordId;
    @XmlElement(name = "Record", namespace = "urn://x-artefacts-smev-gov-ru/services/message-exchange/types/directive/1.3", required = true)
    protected Record record;
    @XmlElement(name = "RecordSignature", namespace = "urn://x-artefacts-smev-gov-ru/services/message-exchange/types/directive/1.3")
    protected XMLDSigSignatureType recordSignature;

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
     * Gets the value of the record property.
     * 
     * @return
     *     possible object is
     *     {@link Record }
     *     
     */
    public Record getRecord() {
        return record;
    }

    /**
     * Sets the value of the record property.
     * 
     * @param value
     *     allowed object is
     *     {@link Record }
     *     
     */
    public void setRecord(Record value) {
        this.record = value;
    }

    /**
     * Gets the value of the recordSignature property.
     * 
     * @return
     *     possible object is
     *     {@link XMLDSigSignatureType }
     *     
     */
    public XMLDSigSignatureType getRecordSignature() {
        return recordSignature;
    }

    /**
     * Sets the value of the recordSignature property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLDSigSignatureType }
     *     
     */
    public void setRecordSignature(XMLDSigSignatureType value) {
        this.recordSignature = value;
    }

}
