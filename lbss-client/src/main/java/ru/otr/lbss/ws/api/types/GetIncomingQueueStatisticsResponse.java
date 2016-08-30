
package ru.otr.lbss.ws.api.types;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

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
 *       &lt;sequence>
 *         &lt;element name="QueueStatistics" maxOccurs="unbounded" minOccurs="0">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;attribute name="queueName" type="{urn://x-artefacts-smev-gov-ru/services/message-exchange/types/basic/1.1}string-200" />
 *                 &lt;attribute name="pendingMessageNumber" type="{http://www.w3.org/2001/XMLSchema}long" />
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
@XmlType(name = "", propOrder = { "queueStatistics" })
@XmlRootElement(name = "GetIncomingQueueStatisticsResponse")
public class GetIncomingQueueStatisticsResponse {

	@XmlElement(name = "QueueStatistics")
	protected List<GetIncomingQueueStatisticsResponse.QueueStatistics> queueStatistics;

	/**
	 * Gets the value of the queueStatistics property.
	 * 
	 * <p>
	 * This accessor method returns a reference to the live list, not a
	 * snapshot. Therefore any modification you make to the returned list will
	 * be present inside the JAXB object. This is why there is not a
	 * <CODE>set</CODE> method for the queueStatistics property.
	 * 
	 * <p>
	 * For example, to add a new item, do as follows:
	 * 
	 * <pre>
	 * getQueueStatistics().add(newItem);
	 * </pre>
	 * 
	 * 
	 * <p>
	 * Objects of the following type(s) are allowed in the list
	 * {@link GetIncomingQueueStatisticsResponse.QueueStatistics }
	 * 
	 * 
	 */
	public List<GetIncomingQueueStatisticsResponse.QueueStatistics> getQueueStatistics() {
		if (queueStatistics == null) {
			queueStatistics = new ArrayList<GetIncomingQueueStatisticsResponse.QueueStatistics>();
		}
		return this.queueStatistics;
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
	 *       &lt;attribute name="queueName" type="{urn://x-artefacts-smev-gov-ru/services/message-exchange/types/basic/1.1}string-200" />
	 *       &lt;attribute name="pendingMessageNumber" type="{http://www.w3.org/2001/XMLSchema}long" />
	 *     &lt;/restriction>
	 *   &lt;/complexContent>
	 * &lt;/complexType>
	 * </pre>
	 * 
	 * 
	 */
	@XmlAccessorType(XmlAccessType.FIELD)
	@XmlType(name = "")
	public static class QueueStatistics {

		@XmlAttribute(name = "queueName")
		protected String queueName;
		@XmlAttribute(name = "pendingMessageNumber")
		protected Long pendingMessageNumber;

		/**
		 * Gets the value of the queueName property.
		 * 
		 * @return possible object is {@link String }
		 * 
		 */
		public String getQueueName() {
			return queueName;
		}

		/**
		 * Sets the value of the queueName property.
		 * 
		 * @param value
		 *            allowed object is {@link String }
		 * 
		 */
		public void setQueueName(String value) {
			this.queueName = value;
		}

		/**
		 * Gets the value of the pendingMessageNumber property.
		 * 
		 * @return possible object is {@link Long }
		 * 
		 */
		public Long getPendingMessageNumber() {
			return pendingMessageNumber;
		}

		/**
		 * Sets the value of the pendingMessageNumber property.
		 * 
		 * @param value
		 *            allowed object is {@link Long }
		 * 
		 */
		public void setPendingMessageNumber(Long value) {
			this.pendingMessageNumber = value;
		}

	}

}
