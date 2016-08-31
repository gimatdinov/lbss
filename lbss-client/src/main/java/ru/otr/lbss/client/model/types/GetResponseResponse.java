
package ru.otr.lbss.client.model.types;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

import ru.otr.lbss.client.model.InformationMessage;
import ru.otr.lbss.client.model.types.basic.AttachmentContentList;
import ru.otr.lbss.client.model.types.basic.XMLDSigSignatureType;

/**
 * <p>
 * Java class for anonymous complex type.
 * 
 * <p>
 * The following schema fragment specifies the expected content contained within
 * this class.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;choice minOccurs="0">
 *         &lt;element name="ResponseMessage">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element ref="{urn://x-artefacts-smev-gov-ru/services/message-exchange/types/1.1}Response"/>
 *                   &lt;element ref="{urn://x-artefacts-smev-gov-ru/services/message-exchange/types/basic/1.1}AttachmentContentList" minOccurs="0"/>
 *                   &lt;element name="SMEVSignature" type="{urn://x-artefacts-smev-gov-ru/services/message-exchange/types/basic/1.1}XMLDSigSignatureType" minOccurs="0"/>
 *                 &lt;/sequence>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *       &lt;/choice>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = { "responseMessage" })
@XmlRootElement(name = "GetResponseResponse")
public class GetResponseResponse {

	@XmlElement(name = "ResponseMessage")
	protected GetResponseResponse.ResponseMessage responseMessage;

	/**
	 * Gets the value of the responseMessage property.
	 * 
	 * @return possible object is {@link GetResponseResponse.ResponseMessage }
	 * 
	 */
	public GetResponseResponse.ResponseMessage getResponseMessage() {
		return responseMessage;
	}

	/**
	 * Sets the value of the responseMessage property.
	 * 
	 * @param value
	 *            allowed object is {@link GetResponseResponse.ResponseMessage }
	 * 
	 */
	public void setResponseMessage(GetResponseResponse.ResponseMessage value) {
		this.responseMessage = value;
	}

	/**
	 * <p>
	 * Java class for anonymous complex type.
	 * 
	 * <p>
	 * The following schema fragment specifies the expected content contained
	 * within this class.
	 * 
	 * <pre>
	 * &lt;complexType>
	 *   &lt;complexContent>
	 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
	 *       &lt;sequence>
	 *         &lt;element ref="{urn://x-artefacts-smev-gov-ru/services/message-exchange/types/1.1}Response"/>
	 *         &lt;element ref="{urn://x-artefacts-smev-gov-ru/services/message-exchange/types/basic/1.1}AttachmentContentList" minOccurs="0"/>
	 *         &lt;element name="SMEVSignature" type="{urn://x-artefacts-smev-gov-ru/services/message-exchange/types/basic/1.1}XMLDSigSignatureType" minOccurs="0"/>
	 *       &lt;/sequence>
	 *     &lt;/restriction>
	 *   &lt;/complexContent>
	 * &lt;/complexType>
	 * </pre>
	 * 
	 * 
	 */
	@XmlAccessorType(XmlAccessType.FIELD)
	@XmlType(name = "", propOrder = { "response", "attachmentContentList", "smevSignature" })
	public static class ResponseMessage extends InformationMessage {

		@XmlElement(name = "Response", required = true)
		protected Response response;
		@XmlElement(name = "AttachmentContentList", namespace = "urn://x-artefacts-smev-gov-ru/services/message-exchange/types/basic/1.1")
		protected AttachmentContentList attachmentContentList;
		@XmlElement(name = "SMEVSignature")
		protected XMLDSigSignatureType smevSignature;

		/**
		 * Gets the value of the response property.
		 * 
		 * @return possible object is {@link Response }
		 * 
		 */
		public Response getResponse() {
			return response;
		}

		/**
		 * Sets the value of the response property.
		 * 
		 * @param value
		 *            allowed object is {@link Response }
		 * 
		 */
		public void setResponse(Response value) {
			this.response = value;
		}

		/**
		 * Gets the value of the attachmentContentList property.
		 * 
		 * @return possible object is {@link AttachmentContentList }
		 * 
		 */
		public AttachmentContentList getAttachmentContentList() {
			return attachmentContentList;
		}

		/**
		 * Sets the value of the attachmentContentList property.
		 * 
		 * @param value
		 *            allowed object is {@link AttachmentContentList }
		 * 
		 */
		public void setAttachmentContentList(AttachmentContentList value) {
			this.attachmentContentList = value;
		}

		/**
		 * Gets the value of the smevSignature property.
		 * 
		 * @return possible object is {@link XMLDSigSignatureType }
		 * 
		 */
		public XMLDSigSignatureType getSMEVSignature() {
			return smevSignature;
		}

		/**
		 * Sets the value of the smevSignature property.
		 * 
		 * @param value
		 *            allowed object is {@link XMLDSigSignatureType }
		 * 
		 */
		public void setSMEVSignature(XMLDSigSignatureType value) {
			this.smevSignature = value;
		}

	}

}
