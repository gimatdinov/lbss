
package ru.otr.lbss.client.model.types.fault;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

import ru.otr.lbss.client.model.types.basic.SmevFault;

/**
 * <p>
 * Java class for AttachmentSizeLimitExceeded complex type.
 * 
 * <p>
 * The following schema fragment specifies the expected content contained within
 * this class.
 * 
 * <pre>
 * &lt;complexType name="AttachmentSizeLimitExceeded">
 *   &lt;complexContent>
 *     &lt;extension base="{urn://x-artefacts-smev-gov-ru/services/message-exchange/types/basic/1.1}SmevFault">
 *       &lt;sequence>
 *         &lt;element name="PermittedTotalAttachmentSize" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="RealTotalAttachmentSize" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "AttachmentSizeLimitExceeded", propOrder = { "permittedTotalAttachmentSize", "realTotalAttachmentSize" })
public class AttachmentSizeLimitExceeded extends SmevFault {

	@XmlElement(name = "PermittedTotalAttachmentSize")
	protected long permittedTotalAttachmentSize;
	@XmlElement(name = "RealTotalAttachmentSize")
	protected long realTotalAttachmentSize;

	/**
	 * Gets the value of the permittedTotalAttachmentSize property.
	 * 
	 */
	public long getPermittedTotalAttachmentSize() {
		return permittedTotalAttachmentSize;
	}

	/**
	 * Sets the value of the permittedTotalAttachmentSize property.
	 * 
	 */
	public void setPermittedTotalAttachmentSize(long value) {
		this.permittedTotalAttachmentSize = value;
	}

	/**
	 * Gets the value of the realTotalAttachmentSize property.
	 * 
	 */
	public long getRealTotalAttachmentSize() {
		return realTotalAttachmentSize;
	}

	/**
	 * Sets the value of the realTotalAttachmentSize property.
	 * 
	 */
	public void setRealTotalAttachmentSize(long value) {
		this.realTotalAttachmentSize = value;
	}

}
