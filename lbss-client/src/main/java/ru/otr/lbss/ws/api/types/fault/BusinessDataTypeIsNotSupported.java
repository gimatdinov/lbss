
package ru.otr.lbss.ws.api.types.fault;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

import ru.otr.lbss.ws.api.types.basic.SmevFault;

/**
 * <p>
 * Java class for BusinessDataTypeIsNotSupported complex type.
 * 
 * <p>
 * The following schema fragment specifies the expected content contained within
 * this class.
 * 
 * <pre>
 * &lt;complexType name="BusinessDataTypeIsNotSupported">
 *   &lt;complexContent>
 *     &lt;extension base="{urn://x-artefacts-smev-gov-ru/services/message-exchange/types/basic/1.1}SmevFault">
 *       &lt;sequence>
 *         &lt;element name="RootElementLocalName" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="RootElementNamespaceURI" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "BusinessDataTypeIsNotSupported", propOrder = { "rootElementLocalName", "rootElementNamespaceURI" })
public class BusinessDataTypeIsNotSupported extends SmevFault {

	@XmlElement(name = "RootElementLocalName", required = true)
	protected String rootElementLocalName;
	@XmlElement(name = "RootElementNamespaceURI", required = true)
	protected String rootElementNamespaceURI;

	/**
	 * Gets the value of the rootElementLocalName property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getRootElementLocalName() {
		return rootElementLocalName;
	}

	/**
	 * Sets the value of the rootElementLocalName property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setRootElementLocalName(String value) {
		this.rootElementLocalName = value;
	}

	/**
	 * Gets the value of the rootElementNamespaceURI property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getRootElementNamespaceURI() {
		return rootElementNamespaceURI;
	}

	/**
	 * Sets the value of the rootElementNamespaceURI property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setRootElementNamespaceURI(String value) {
		this.rootElementNamespaceURI = value;
	}

}
