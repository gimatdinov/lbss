package ru.otr.lbss.client.model.exceptions;
import ru.otr.lbss.client.model.types.fault.InvalidContent;

import javax.xml.ws.WebFault;


/**
 * 
 *                     Содержательная часть сообщения (//SendRequestRequest/PrimaryContent/element()) не прошла валидацию по XSD,
 *                     зарегистрированной в СМЭВ для этого типа запросов.
 *                     Бизнес-конверт (//SendRequestRequest) содержит не все подэлементы, обязательные для заполнения, либо имеет неверный формат.
 *                     Действия клиента: исправить ошибки и послать запрос повторно.
 *                 
 * 
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2.9-b130926.1035
 * Generated source version: 2.2
 * 
 */
@WebFault(name = "InvalidContent", targetNamespace = "urn://x-artefacts-smev-gov-ru/services/message-exchange/types/faults/1.3")
public class InvalidContentException
    extends Exception
{

    /**
     * Java type that goes as soapenv:Fault detail element.
     * 
     */
    private InvalidContent faultInfo;

    /**
     * 
     * @param faultInfo
     * @param message
     */
    public InvalidContentException(String message, InvalidContent faultInfo) {
        super(message);
        this.faultInfo = faultInfo;
    }

    /**
     * 
     * @param faultInfo
     * @param cause
     * @param message
     */
    public InvalidContentException(String message, InvalidContent faultInfo, Throwable cause) {
        super(message, cause);
        this.faultInfo = faultInfo;
    }

    /**
     * 
     * @return
     *     returns fault bean: ru.otr.lbss.client.model.InvalidContent
     */
    public InvalidContent getFaultInfo() {
        return faultInfo;
    }

}
