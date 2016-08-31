
package ru.otr.lbss.client.model.types.basic;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAnyElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import org.w3c.dom.Element;

/**
 * 
 * Элекронная подпись в формате XMLDSig.
 * 
 * 
 * <p>
 * Java class for XMLDSigSignatureType complex type.
 * 
 * <p>
 * The following schema fragment specifies the expected content contained within
 * this class.
 * 
 * <pre>
 * &lt;complexType name="XMLDSigSignatureType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;any processContents='skip' namespace='http://www.w3.org/2000/09/xmldsig#'/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "XMLDSigSignatureType", propOrder = { "any" })
@XmlRootElement
public class XMLDSigSignatureType {


	@XmlAnyElement
	protected Element any;

	/**
	 * Gets the value of the any property.
	 * 
	 * @return possible object is {@link Element }
	 * 
	 */
	public Element getAny() {
		return any;
	}

	/**
	 * Sets the value of the any property.
	 * 
	 * @param value
	 *            allowed object is {@link Element }
	 * 
	 */
	public void setAny(Element value) {
		this.any = value;
	}

}
