package cxc.jex.common.xml.dsig;

import java.io.ByteArrayInputStream;
import java.security.cert.CertificateException;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;
import java.util.Base64;

import javax.xml.crypto.dsig.XMLSignature;

import org.w3c.dom.Document;
import org.w3c.dom.Node;

import cxc.jex.common.exception.ExceptionWrapper;
import cxc.jex.common.xml.DOMUtil;

public class CertificateHelper {
	private CertificateFactory certificateFactory;

	public CertificateHelper() throws ExceptionWrapper {
		try {
			certificateFactory = CertificateFactory.getInstance("X.509");
		} catch (CertificateException e) {
			throw new ExceptionWrapper(e);
		}
	}

	public byte[] findSingleCertificate(Document signature) throws ExceptionWrapper {
		try {
			Node certificateNode = DOMUtil.findSingleNode(signature, XMLSignature.XMLNS, "X509Certificate");
			return Base64.getDecoder().decode(certificateNode.getFirstChild().getTextContent());
		} catch (Exception e) {
			throw new ExceptionWrapper(e);
		}
	}

	public X509Certificate decodeCertificate(String certificateBase64) throws ExceptionWrapper {
		try {
			return (X509Certificate) certificateFactory.generateCertificate(new ByteArrayInputStream(Base64.getDecoder().decode(certificateBase64)));
		} catch (CertificateException e) {
			throw new ExceptionWrapper(e);
		}
	}

}
