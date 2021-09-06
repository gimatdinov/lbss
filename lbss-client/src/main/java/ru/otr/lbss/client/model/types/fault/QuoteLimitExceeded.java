package ru.otr.lbss.client.model.types.fault;

import ru.otr.lbss.client.model.types.basic.SmevFault;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for QuoteLimitExceeded complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="QuoteLimitExceeded">
 *   &lt;complexContent>
 *     &lt;extension base="{urn://x-artefacts-smev-gov-ru/services/message-exchange/types/basic/1.3}SmevFault">
 *       &lt;sequence>
 *         &lt;element name="RemainedTotalQuoteSize" type="{http://www.w3.org/2001/XMLSchema}long"/>
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
@XmlType(name = "QuoteLimitExceeded", namespace = "urn://x-artefacts-smev-gov-ru/services/message-exchange/types/faults/1.3", propOrder = {
    "remainedTotalQuoteSize",
    "realTotalAttachmentSize"
})
public class QuoteLimitExceeded
    extends SmevFault
{

    @XmlElement(name = "RemainedTotalQuoteSize")
    protected long remainedTotalQuoteSize;
    @XmlElement(name = "RealTotalAttachmentSize")
    protected long realTotalAttachmentSize;

    /**
     * Gets the value of the remainedTotalQuoteSize property.
     * 
     */
    public long getRemainedTotalQuoteSize() {
        return remainedTotalQuoteSize;
    }

    /**
     * Sets the value of the remainedTotalQuoteSize property.
     * 
     */
    public void setRemainedTotalQuoteSize(long value) {
        this.remainedTotalQuoteSize = value;
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
