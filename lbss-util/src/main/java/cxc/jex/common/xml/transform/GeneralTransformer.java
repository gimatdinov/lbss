package cxc.jex.common.xml.transform;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.StringWriter;
import java.io.UnsupportedEncodingException;
import java.util.Base64;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.soap.MessageFactory;
import javax.xml.soap.MimeHeaders;
import javax.xml.soap.SOAPException;
import javax.xml.soap.SOAPMessage;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.TransformerFactoryConfigurationError;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.xml.sax.SAXException;

import cxc.jex.common.exception.ExceptionWrapper;

public class GeneralTransformer {

	private Transformer transformerNode;
	private DocumentBuilderFactory docBuilderFactory;

	private MessageFactory soapMsgFactory;

	public GeneralTransformer() throws ExceptionWrapper {
		try {
			transformerNode = TransformerFactory.newInstance().newTransformer();
			transformerNode.setOutputProperty(OutputKeys.OMIT_XML_DECLARATION, "yes");

			docBuilderFactory = DocumentBuilderFactory.newInstance();
			docBuilderFactory.setNamespaceAware(true);

			soapMsgFactory = MessageFactory.newInstance();
		} catch (TransformerConfigurationException e) {
			throw new ExceptionWrapper(e);
		} catch (TransformerFactoryConfigurationError e) {
			throw new ExceptionWrapper(e);
		} catch (SOAPException e) {
			throw new ExceptionWrapper(e);
		}
	}

	public String xml2base(String xml) throws ExceptionWrapper {
		if (xml == null) {
			throw new ExceptionWrapper("InvalidEmptyValue");
		}
		try {
			return new String(Base64.getEncoder().encode(xml.getBytes("UTF-8")));
		} catch (UnsupportedEncodingException e) {
			throw new ExceptionWrapper(e);
		}
	}

	public String base2xml(String base64) throws ExceptionWrapper {
		if (base64 == null) {
			throw new ExceptionWrapper("InvalidEmptyValue");
		}
		try {
			return new String(Base64.getDecoder().decode(base64), "UTF-8");
		} catch (UnsupportedEncodingException e) {
			throw new ExceptionWrapper(e);
		}
	}

	public String dom2xml(Node dom) throws ExceptionWrapper {
		if (dom == null) {
			throw new ExceptionWrapper("InvalidEmptyValue");
		}
		try {
			StringWriter result = new StringWriter();
			transformerNode.transform(new DOMSource(dom), new StreamResult(result));
			return result.toString();
		} catch (TransformerException e) {
			throw new ExceptionWrapper(e);
		}
	}

	public Document xml2dom(String xml) throws ExceptionWrapper {
		if (xml == null) {
			throw new ExceptionWrapper("InvalidEmptyValue");
		}
		try (InputStream bais = new ByteArrayInputStream(xml.getBytes("UTF-8"))) {
			DocumentBuilder xmlDocBuilder = docBuilderFactory.newDocumentBuilder();
			Document result = xmlDocBuilder.parse(bais);
			return result;
		} catch (IOException e) {
			throw new ExceptionWrapper(e);
		} catch (SAXException e) {
			throw new ExceptionWrapper(e);
		} catch (ParserConfigurationException e) {
			throw new ExceptionWrapper(e);
		} finally {
		}
	}

	public String msg2xml(SOAPMessage msg) throws ExceptionWrapper {
		if (msg == null) {
			throw new ExceptionWrapper("InvalidEmptyValue");
		}
		try (ByteArrayOutputStream result = new ByteArrayOutputStream()) {
			msg.writeTo(result);
			return new String(result.toByteArray(), "UTF-8");
		} catch (SOAPException e) {
			throw new ExceptionWrapper(e);
		} catch (IOException e) {
			throw new ExceptionWrapper(e);
		} finally {
		}

	}

	public SOAPMessage xml2msg(String xml) throws ExceptionWrapper {
		if (xml == null) {
			throw new ExceptionWrapper("InvalidEmptyValue");
		}
		try (ByteArrayInputStream bais = new ByteArrayInputStream(xml.getBytes("UTF-8"))) {
			return soapMsgFactory.createMessage(new MimeHeaders(), bais);
		} catch (UnsupportedEncodingException e) {
			throw new ExceptionWrapper(e);
		} catch (IOException e) {
			throw new ExceptionWrapper(e);
		} catch (SOAPException e) {
			throw new ExceptionWrapper(e);
		} finally {
		}

	}

}
