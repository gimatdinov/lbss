
package ru.otr.lbss.ws.api.types.fault;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.XmlValue;

import ru.otr.lbss.ws.api.types.basic.SmevFault;

/**
 * <p>
 * Java class for InvalidContent complex type.
 * 
 * <p>
 * The following schema fragment specifies the expected content contained within
 * this class.
 * 
 * <pre>
 * &lt;complexType name="InvalidContent">
 *   &lt;complexContent>
 *     &lt;extension base="{urn://x-artefacts-smev-gov-ru/services/message-exchange/types/basic/1.1}SmevFault">
 *       &lt;sequence>
 *         &lt;element name="ValidationError" maxOccurs="unbounded">
 *           &lt;complexType>
 *             &lt;simpleContent>
 *               &lt;extension base="&lt;http://www.w3.org/2001/XMLSchema>string">
 *                 &lt;attribute name="errorPosition" use="required" type="{http://www.w3.org/2001/XMLSchema}int" />
 *               &lt;/extension>
 *             &lt;/simpleContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "InvalidContent", propOrder = { "validationError" })
public class InvalidContent extends SmevFault {

	@XmlElement(name = "ValidationError", required = true)
	protected List<InvalidContent.ValidationError> validationError;

	/**
	 * Gets the value of the validationError property.
	 * 
	 * <p>
	 * This accessor method returns a reference to the live list, not a
	 * snapshot. Therefore any modification you make to the returned list will
	 * be present inside the JAXB object. This is why there is not a
	 * <CODE>set</CODE> method for the validationError property.
	 * 
	 * <p>
	 * For example, to add a new item, do as follows:
	 * 
	 * <pre>
	 * getValidationError().add(newItem);
	 * </pre>
	 * 
	 * 
	 * <p>
	 * Objects of the following type(s) are allowed in the list
	 * {@link InvalidContent.ValidationError }
	 * 
	 * 
	 */
	public List<InvalidContent.ValidationError> getValidationError() {
		if (validationError == null) {
			validationError = new ArrayList<InvalidContent.ValidationError>();
		}
		return this.validationError;
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
	 *   &lt;simpleContent>
	 *     &lt;extension base="&lt;http://www.w3.org/2001/XMLSchema>string">
	 *       &lt;attribute name="errorPosition" use="required" type="{http://www.w3.org/2001/XMLSchema}int" />
	 *     &lt;/extension>
	 *   &lt;/simpleContent>
	 * &lt;/complexType>
	 * </pre>
	 * 
	 * 
	 */
	@XmlAccessorType(XmlAccessType.FIELD)
	@XmlType(name = "", propOrder = { "value" })
	public static class ValidationError {

		@XmlValue
		protected String value;
		@XmlAttribute(name = "errorPosition", required = true)
		protected int errorPosition;

		/**
		 * Gets the value of the value property.
		 * 
		 * @return possible object is {@link String }
		 * 
		 */
		public String getValue() {
			return value;
		}

		/**
		 * Sets the value of the value property.
		 * 
		 * @param value
		 *            allowed object is {@link String }
		 * 
		 */
		public void setValue(String value) {
			this.value = value;
		}

		/**
		 * Gets the value of the errorPosition property.
		 * 
		 */
		public int getErrorPosition() {
			return errorPosition;
		}

		/**
		 * Sets the value of the errorPosition property.
		 * 
		 */
		public void setErrorPosition(int value) {
			this.errorPosition = value;
		}

	}

}
