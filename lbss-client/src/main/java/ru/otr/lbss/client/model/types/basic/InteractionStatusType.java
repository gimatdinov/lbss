
package ru.otr.lbss.client.model.types.basic;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;

/**
 * <p>
 * Java class for InteractionStatusType.
 * 
 * <p>
 * The following schema fragment specifies the expected content contained within
 * this class.
 * <p>
 * 
 * <pre>
 * &lt;simpleType name="InteractionStatusType">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="doesNotExist"/>
 *     &lt;enumeration value="requestIsQueued"/>
 *     &lt;enumeration value="requestIsAcceptedBySmev"/>
 *     &lt;enumeration value="requestIsRejectedBySmev"/>
 *     &lt;enumeration value="underProcessing"/>
 *     &lt;enumeration value="responseIsAcceptedBySmev"/>
 *     &lt;enumeration value="cancelled"/>
 *     &lt;enumeration value="responseIsDelivered"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "InteractionStatusType")
@XmlEnum
public enum InteractionStatusType implements Serializable{

	/**
	 * Запрос с таким Id не найден в БД СМЭВ.
	 * 
	 */
	@XmlEnumValue("doesNotExist") DOES_NOT_EXIST("doesNotExist"),

	/**
	 * Запрос находится в очереди на асинхронную валидацию.
	 * 
	 */
	@XmlEnumValue("requestIsQueued") REQUEST_IS_QUEUED("requestIsQueued"),

	/**
	 * Запрос доставляется поставщику.
	 * 
	 */
	@XmlEnumValue("requestIsAcceptedBySmev") REQUEST_IS_ACCEPTED_BY_SMEV("requestIsAcceptedBySmev"),

	/**
	 * Запрос не прошёл асинхронную валидацию.
	 * 
	 */
	@XmlEnumValue("requestIsRejectedBySmev") REQUEST_IS_REJECTED_BY_SMEV("requestIsRejectedBySmev"),

	/**
	 * Обрабатывается поставщиком сервиса.
	 * 
	 */
	@XmlEnumValue("underProcessing") UNDER_PROCESSING("underProcessing"),

	/**
	 * Запрос выполнен или отвергнут поставщиком сервиса; ответ находится в
	 * очереди СМЭВ.
	 * 
	 */
	@XmlEnumValue("responseIsAcceptedBySmev") RESPONSE_IS_ACCEPTED_BY_SMEV("responseIsAcceptedBySmev"),

	/**
	 * Запрос отменён потребителем сервиса.
	 * 
	 */
	@XmlEnumValue("cancelled") CANCELLED("cancelled"),

	/**
	 * Ответ получен потребителем сервиса.
	 * 
	 */
	@XmlEnumValue("responseIsDelivered") RESPONSE_IS_DELIVERED("responseIsDelivered");
	private final String value;

	InteractionStatusType(String v) {
		value = v;
	}

	public String value() {
		return value;
	}

	public static InteractionStatusType fromValue(String v) {
		for (InteractionStatusType c : InteractionStatusType.values()) {
			if (c.value.equals(v)) {
				return c;
			}
		}
		throw new IllegalArgumentException(v);
	}

}
