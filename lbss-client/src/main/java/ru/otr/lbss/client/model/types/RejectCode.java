package ru.otr.lbss.client.model.types;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for RejectCode.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="RejectCode">
 *   &lt;restriction base="{urn://x-artefacts-smev-gov-ru/services/message-exchange/types/basic/1.3}string-50">
 *     &lt;enumeration value="ACCESS_DENIED"/>
 *     &lt;enumeration value="NO_DATA"/>
 *     &lt;enumeration value="UNKNOWN_REQUEST_DESCRIPTION"/>
 *     &lt;enumeration value="FAILURE"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "RejectCode")
@XmlEnum
public enum RejectCode {

    ACCESS_DENIED,
    NO_DATA,
    UNKNOWN_REQUEST_DESCRIPTION,
    FAILURE;

    public String value() {
        return name();
    }

    public static RejectCode fromValue(String v) {
        return valueOf(v);
    }

}
