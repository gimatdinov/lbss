
package com.otr.sufd.smev30supportservice;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.xml.bind.annotation.XmlSeeAlso;

/**
 * Подсистема подписания документов
 * 
 * This class was generated by the JAX-WS RI. JAX-WS RI 2.2.9-b130926.1035
 * Generated source version: 2.2
 * 
 */
@WebService(name = "smev30SupportServicePortType", targetNamespace = "http://www.otr.com/sufd/smev30SupportService")
@SOAPBinding(parameterStyle = SOAPBinding.ParameterStyle.BARE)
@XmlSeeAlso({ com.otr.sufd.smev30supportservice.ObjectFactory.class, com.otr.sufd.smev30supportservice.xml.faultmessage.ObjectFactory.class })
public interface Smev30SupportServicePortType {

    /**
     * Метод формирования ЭП-ОВ СМЭВ 3.0
     * 
     * @param soapEnvelop
     * @return returns byte[]
     * @throws FaultMessage
     */
    @WebMethod
    @WebResult(name = "createEPOVSignatureResponse", targetNamespace = "http://www.otr.com/sufd/smev30SupportService", partName = "signedSoapEnvelop")
    public byte[] createEPOVSignature(
            @WebParam(name = "createEPOVSignatureRequest", targetNamespace = "http://www.otr.com/sufd/smev30SupportService", partName = "soapEnvelop") byte[] soapEnvelop)
            throws FaultMessage;

    /**
     * Метод проверки ЭП-СМЭВ 3.0
     * 
     * @param signedSoapEnvelop
     * @return returns com.otr.sufd.smev30supportservice.CheckResultResponse
     * @throws FaultMessage
     */
    @WebMethod
    @WebResult(name = "checkEPSMEVSignatureResponse", targetNamespace = "http://www.otr.com/sufd/smev30SupportService", partName = "checkResult")
    public CheckResultResponse checkEPSMEVSignature(
            @WebParam(name = "checkEPSMEVSignatureRequest", targetNamespace = "http://www.otr.com/sufd/smev30SupportService", partName = "signedSoapEnvelop") byte[] signedSoapEnvelop)
            throws FaultMessage;

    /**
     * Метод проверки ЭП-ОВ 3.0
     * 
     * @param signedSoapEnvelop
     * @return returns com.otr.sufd.smev30supportservice.CheckResultResponse
     * @throws FaultMessage
     */
    @WebMethod
    @WebResult(name = "checkEPOVSignatureResponse", targetNamespace = "http://www.otr.com/sufd/smev30SupportService", partName = "checkResult")
    public CheckResultResponse checkEPOVSignature(
            @WebParam(name = "checkEPOVSignatureRequest", targetNamespace = "http://www.otr.com/sufd/smev30SupportService", partName = "signedSoapEnvelop") byte[] signedSoapEnvelop)
            throws FaultMessage;

    /**
     * Метод подписания xml документа
     * 
     * @param signXmlParams
     * @return returns byte[]
     * @throws FaultMessage
     */
    @WebMethod
    @WebResult(name = "signXmlResponse", targetNamespace = "http://www.otr.com/sufd/smev30SupportService", partName = "signedXml")
    public byte[] signXml(
            @WebParam(name = "signXmlRequest", targetNamespace = "http://www.otr.com/sufd/smev30SupportService", partName = "signXmlParams") SignXmlParams signXmlParams)
            throws FaultMessage;

    /**
     * Метод проверки ЭП xml документа
     * 
     * @param signedXml
     * @return returns com.otr.sufd.smev30supportservice.CheckSignXmlResult
     * @throws FaultMessage
     */
    @WebMethod
    @WebResult(name = "checkSignXmlResponse", targetNamespace = "http://www.otr.com/sufd/smev30SupportService", partName = "checkResult")
    public CheckSignXmlResult checkSignXml(
            @WebParam(name = "checkSignXmlRequest", targetNamespace = "http://www.otr.com/sufd/smev30SupportService", partName = "signedXml") byte[] signedXml)
            throws FaultMessage;

}
