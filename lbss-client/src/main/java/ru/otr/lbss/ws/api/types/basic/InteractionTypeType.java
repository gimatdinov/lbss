
package ru.otr.lbss.ws.api.types.basic;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;

/**
 * <p>
 * Java class for InteractionTypeType.
 * 
 * <p>
 * The following schema fragment specifies the expected content contained within
 * this class.
 * <p>
 * 
 * <pre>
 * &lt;simpleType name="InteractionTypeType">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="PGU2OIV"/>
 *     &lt;enumeration value="OIV2OIV"/>
 *     &lt;enumeration value="OIV2sameOIV"/>
 *     &lt;enumeration value="Charger2PaymentGate"/>
 *     &lt;enumeration value="PaymentGate2Treasury"/>
 *     &lt;enumeration value="OIV2Treasury"/>
 *     &lt;enumeration value="other"/>
 *     &lt;enumeration value="NotDetected"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "InteractionTypeType")
@XmlEnum
public enum InteractionTypeType implements Serializable {

	/**
	 * Взаимодействие портала государственных и/или муниципальных услуг с
	 * органом власти.
	 * 
	 */
	@XmlEnumValue("PGU2OIV") PGU_2_OIV("PGU2OIV"),

	/**
	 * Взаимодействие между органами власти.
	 * 
	 */
	@XmlEnumValue("OIV2OIV") OIV_2_OIV("OIV2OIV"),

	/**
	 * Взаимодействие между различными информационными системами одного органа
	 * исполнительной власти через СМЭВ.
	 * 
	 */
	@XmlEnumValue("OIV2sameOIV") OIV_2_SAME_OIV("OIV2sameOIV"),

	/**
	 * Взаимодействие информационно-платежного шлюза с поставщиками начислений
	 * для оплаты услуг в электронном виде.
	 * 
	 */
	@XmlEnumValue("Charger2PaymentGate") CHARGER_2_PAYMENT_GATE("Charger2PaymentGate"),

	/**
	 * Взаимодействие информационно-платежного шлюза с системой УНИФО ФК для
	 * получения начислений и фактов оплаты для пользователей ПГУ.
	 * 
	 */
	@XmlEnumValue("PaymentGate2Treasury") PAYMENT_GATE_2_TREASURY("PaymentGate2Treasury"),

	/**
	 * Взаимодействие ОИВ с системой УНИФО ФК для передачи начислений и
	 * получения фактов оплаты.
	 * 
	 */
	@XmlEnumValue("OIV2Treasury") OIV_2_TREASURY("OIV2Treasury"),

	/**
	 * Другие типы взаимодействия.
	 * 
	 */
	@XmlEnumValue("other") OTHER("other"),

	/**
	 * Не удалось определить тип взаимодействия.
	 * 
	 */
	@XmlEnumValue("NotDetected") NOT_DETECTED("NotDetected");
	private final String value;

	InteractionTypeType(String v) {
		value = v;
	}

	public String value() {
		return value;
	}

	public static InteractionTypeType fromValue(String v) {
		for (InteractionTypeType c : InteractionTypeType.values()) {
			if (c.value.equals(v)) {
				return c;
			}
		}
		throw new IllegalArgumentException(v);
	}

}
