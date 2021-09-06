
package com.otr.sufd.smev30supportservice;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;

/**
 * This object contains factory methods for each Java content interface and Java
 * element interface generated in the com.otr.sufd.smev30supportservice package.
 * <p>
 * An ObjectFactory allows you to programatically construct new instances of the
 * Java representation for XML content. The Java representation of XML content
 * can consist of schema derived interfaces and classes representing the binding
 * of schema type definitions, element declarations and model groups. Factory
 * methods for each of these are provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _CheckSignXmlResponse_QNAME = new QName("http://www.otr.com/sufd/smev30SupportService", "checkSignXmlResponse");
    private final static QName _CreateEPOVSignatureResponse_QNAME = new QName("http://www.otr.com/sufd/smev30SupportService", "createEPOVSignatureResponse");
    private final static QName _CheckSignXmlRequest_QNAME = new QName("http://www.otr.com/sufd/smev30SupportService", "checkSignXmlRequest");
    private final static QName _CheckEPSMEVSignatureResponse_QNAME = new QName("http://www.otr.com/sufd/smev30SupportService", "checkEPSMEVSignatureResponse");
    private final static QName _CheckEPOVSignatureRequest_QNAME = new QName("http://www.otr.com/sufd/smev30SupportService", "checkEPOVSignatureRequest");
    private final static QName _CheckEPOVSignatureResponse_QNAME = new QName("http://www.otr.com/sufd/smev30SupportService", "checkEPOVSignatureResponse");
    private final static QName _CheckEPSMEVSignatureRequest_QNAME = new QName("http://www.otr.com/sufd/smev30SupportService", "checkEPSMEVSignatureRequest");
    private final static QName _CreateEPOVSignatureRequest_QNAME = new QName("http://www.otr.com/sufd/smev30SupportService", "createEPOVSignatureRequest");
    private final static QName _SignXmlRequest_QNAME = new QName("http://www.otr.com/sufd/smev30SupportService", "signXmlRequest");
    private final static QName _SignXmlResponse_QNAME = new QName("http://www.otr.com/sufd/smev30SupportService", "signXmlResponse");

    /**
     * Create a new ObjectFactory that can be used to create new instances of
     * schema derived classes for package: com.otr.sufd.smev30supportservice
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link SignXmlParams }
     * 
     */
    public SignXmlParams createSignXmlParams() {
        return new SignXmlParams();
    }

    /**
     * Create an instance of {@link CheckResultResponse }
     * 
     */
    public CheckResultResponse createCheckResultResponse() {
        return new CheckResultResponse();
    }

    /**
     * Create an instance of {@link CheckSignXmlResult }
     * 
     */
    public CheckSignXmlResult createCheckSignXmlResult() {
        return new CheckSignXmlResult();
    }

    /**
     * Create an instance of {@link SignDetail }
     * 
     */
    public SignDetail createSignDetail() {
        return new SignDetail();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}
     * {@link CheckSignXmlResult }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.otr.com/sufd/smev30SupportService", name = "checkSignXmlResponse")
    public JAXBElement<CheckSignXmlResult> createCheckSignXmlResponse(CheckSignXmlResult value) {
        return new JAXBElement<CheckSignXmlResult>(_CheckSignXmlResponse_QNAME, CheckSignXmlResult.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link byte[]}
     * {@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.otr.com/sufd/smev30SupportService", name = "createEPOVSignatureResponse")
    public JAXBElement<byte[]> createCreateEPOVSignatureResponse(byte[] value) {
        return new JAXBElement<byte[]>(_CreateEPOVSignatureResponse_QNAME, byte[].class, null, ((byte[]) value));
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link byte[]}
     * {@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.otr.com/sufd/smev30SupportService", name = "checkSignXmlRequest")
    public JAXBElement<byte[]> createCheckSignXmlRequest(byte[] value) {
        return new JAXBElement<byte[]>(_CheckSignXmlRequest_QNAME, byte[].class, null, ((byte[]) value));
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}
     * {@link CheckResultResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.otr.com/sufd/smev30SupportService", name = "checkEPSMEVSignatureResponse")
    public JAXBElement<CheckResultResponse> createCheckEPSMEVSignatureResponse(CheckResultResponse value) {
        return new JAXBElement<CheckResultResponse>(_CheckEPSMEVSignatureResponse_QNAME, CheckResultResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link byte[]}
     * {@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.otr.com/sufd/smev30SupportService", name = "checkEPOVSignatureRequest")
    public JAXBElement<byte[]> createCheckEPOVSignatureRequest(byte[] value) {
        return new JAXBElement<byte[]>(_CheckEPOVSignatureRequest_QNAME, byte[].class, null, ((byte[]) value));
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}
     * {@link CheckResultResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.otr.com/sufd/smev30SupportService", name = "checkEPOVSignatureResponse")
    public JAXBElement<CheckResultResponse> createCheckEPOVSignatureResponse(CheckResultResponse value) {
        return new JAXBElement<CheckResultResponse>(_CheckEPOVSignatureResponse_QNAME, CheckResultResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link byte[]}
     * {@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.otr.com/sufd/smev30SupportService", name = "checkEPSMEVSignatureRequest")
    public JAXBElement<byte[]> createCheckEPSMEVSignatureRequest(byte[] value) {
        return new JAXBElement<byte[]>(_CheckEPSMEVSignatureRequest_QNAME, byte[].class, null, ((byte[]) value));
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link byte[]}
     * {@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.otr.com/sufd/smev30SupportService", name = "createEPOVSignatureRequest")
    public JAXBElement<byte[]> createCreateEPOVSignatureRequest(byte[] value) {
        return new JAXBElement<byte[]>(_CreateEPOVSignatureRequest_QNAME, byte[].class, null, ((byte[]) value));
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SignXmlParams }
     * {@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.otr.com/sufd/smev30SupportService", name = "signXmlRequest")
    public JAXBElement<SignXmlParams> createSignXmlRequest(SignXmlParams value) {
        return new JAXBElement<SignXmlParams>(_SignXmlRequest_QNAME, SignXmlParams.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link byte[]}
     * {@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.otr.com/sufd/smev30SupportService", name = "signXmlResponse")
    public JAXBElement<byte[]> createSignXmlResponse(byte[] value) {
        return new JAXBElement<byte[]>(_SignXmlResponse_QNAME, byte[].class, null, ((byte[]) value));
    }

}
