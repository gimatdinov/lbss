
package ru.otr.lbss.client.model.types.routing;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for RoutingStatusCodeType.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="RoutingStatusCodeType">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="success"/>
 *     &lt;enumeration value="recipientNotFound"/>
 *     &lt;enumeration value="invalidRegistryRecordId"/>
 *     &lt;enumeration value="signatureInvalid"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "RoutingStatusCodeType", namespace = "urn://x-artefacts-smev-gov-ru/services/message-exchange/types/routing/1.3")
@XmlEnum
public enum RoutingStatusCodeType {


    /**
     * Выполнено успешно
     * 
     */
    @XmlEnumValue("success")
    SUCCESS("success"),

    /**
     * Получатель сообщения не найден
     * 
     */
    @XmlEnumValue("recipientNotFound")
    RECIPIENT_NOT_FOUND("recipientNotFound"),

    /**
     * Некорректный идентификатор реестровой записи
     * 
     */
    @XmlEnumValue("invalidRegistryRecordId")
    INVALID_REGISTRY_RECORD_ID("invalidRegistryRecordId"),

    /**
     * Подпись реестровой записи невалидна
     * 
     */
    @XmlEnumValue("signatureInvalid")
    SIGNATURE_INVALID("signatureInvalid");
    private final String value;

    RoutingStatusCodeType(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static RoutingStatusCodeType fromValue(String v) {
        for (RoutingStatusCodeType c: RoutingStatusCodeType.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
