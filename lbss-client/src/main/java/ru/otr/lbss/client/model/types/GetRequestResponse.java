package ru.otr.lbss.client.model.types;

import ru.otr.lbss.client.model.InformationMessage;
import ru.otr.lbss.client.model.StatusMessage;
import ru.otr.lbss.client.model.types.basic.AttachmentContentList;
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
 *         &lt;element name="RequestMessage" minOccurs="0">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;choice>
 *                     &lt;sequence>
 *                       &lt;element ref="{urn://x-artefacts-smev-gov-ru/services/message-exchange/types/1.3}Request"/>
 *                       &lt;element ref="{urn://x-artefacts-smev-gov-ru/services/message-exchange/types/basic/1.3}AttachmentContentList" minOccurs="0"/>
 *                     &lt;/sequence>
 *                   &lt;/choice>
 *                   &lt;element name="SMEVSignature" type="{urn://x-artefacts-smev-gov-ru/services/message-exchange/types/basic/1.3}XMLDSigSignatureType" minOccurs="0"/>
 *                 &lt;/sequence>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
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
    "requestMessage"
})
@XmlRootElement(name = "GetRequestResponse")
public class GetRequestResponse {

    @XmlElement(name = "RequestMessage")
    protected GetRequestResponse.RequestMessage requestMessage;

    /**
     * Gets the value of the requestMessage property.
     * 
     * @return
     *     possible object is
     *     {@link GetRequestResponse.RequestMessage }
     *     
     */
    public GetRequestResponse.RequestMessage getRequestMessage() {
        return requestMessage;
    }

    /**
     * Sets the value of the requestMessage property.
     * 
     * @param value
     *     allowed object is
     *     {@link GetRequestResponse.RequestMessage }
     *     
     */
    public void setRequestMessage(GetRequestResponse.RequestMessage value) {
        this.requestMessage = value;
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
     *         &lt;choice>
     *           &lt;sequence>
     *             &lt;element ref="{urn://x-artefacts-smev-gov-ru/services/message-exchange/types/1.3}Request"/>
     *             &lt;element ref="{urn://x-artefacts-smev-gov-ru/services/message-exchange/types/basic/1.3}AttachmentContentList" minOccurs="0"/>
     *           &lt;/sequence>
     *         &lt;/choice>
     *         &lt;element name="SMEVSignature" type="{urn://x-artefacts-smev-gov-ru/services/message-exchange/types/basic/1.3}XMLDSigSignatureType" minOccurs="0"/>
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
        "request",
        "attachmentContentList",
        "smevSignature"
    })
    public static class RequestMessage extends InformationMessage {

        @XmlElement(name = "Request")
        protected Request request;
        @XmlElement(name = "AttachmentContentList", namespace = "urn://x-artefacts-smev-gov-ru/services/message-exchange/types/basic/1.3")
        protected AttachmentContentList attachmentContentList;
        @XmlElement(name = "SMEVSignature")
        protected XMLDSigSignatureType smevSignature;

        /**
         * Gets the value of the request property.
         * 
         * @return
         *     possible object is
         *     {@link Request }
         *     
         */
        public Request getRequest() {
            return request;
        }

        /**
         * Sets the value of the request property.
         * 
         * @param value
         *     allowed object is
         *     {@link Request }
         *     
         */
        public void setRequest(Request value) {
            this.request = value;
        }

        /**
         * Gets the value of the attachmentContentList property.
         * 
         * @return
         *     possible object is
         *     {@link AttachmentContentList }
         *     
         */
        public AttachmentContentList getAttachmentContentList() {
            return attachmentContentList;
        }

        /**
         * Sets the value of the attachmentContentList property.
         * 
         * @param value
         *     allowed object is
         *     {@link AttachmentContentList }
         *     
         */
        public void setAttachmentContentList(AttachmentContentList value) {
            this.attachmentContentList = value;
        }

        /**
         * Gets the value of the smevSignature property.
         * 
         * @return
         *     possible object is
         *     {@link XMLDSigSignatureType }
         *     
         */
        public XMLDSigSignatureType getSMEVSignature() {
            return smevSignature;
        }

        /**
         * Sets the value of the smevSignature property.
         * 
         * @param value
         *     allowed object is
         *     {@link XMLDSigSignatureType }
         *     
         */
        public void setSMEVSignature(XMLDSigSignatureType value) {
            this.smevSignature = value;
        }

    }

}
