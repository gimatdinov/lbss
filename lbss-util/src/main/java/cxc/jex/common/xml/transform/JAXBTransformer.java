package cxc.jex.common.xml.transform;

import java.io.StringReader;
import java.io.StringWriter;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import javax.xml.transform.TransformerFactoryConfigurationError;

import cxc.jex.common.exception.ExceptionWrapper;

public class JAXBTransformer extends GeneralTransformer {
	private static final String PROPERTY_xml_bind_xmlDeclaration = "com.sun.xml.bind.xmlDeclaration";

	private JAXBContext jaxbContext;
	private Marshaller marshaller;
	private Unmarshaller unmarshaller;

	public JAXBTransformer(String jaxbContextPath, boolean xmlDeclaration) throws ExceptionWrapper {
		try {
			jaxbContext = JAXBContext.newInstance(jaxbContextPath);
			marshaller = jaxbContext.createMarshaller();
			marshaller.setProperty(PROPERTY_xml_bind_xmlDeclaration, xmlDeclaration);
			unmarshaller = jaxbContext.createUnmarshaller();

		} catch (JAXBException e) {
			throw new ExceptionWrapper(e);
		} catch (TransformerFactoryConfigurationError e) {
			throw new ExceptionWrapper(e);
		}
	}

	public String obj2xml(Object jaxbElement) throws ExceptionWrapper {
		if (jaxbElement == null) {
			throw new ExceptionWrapper("InvalidEmptyValue");
		}
		try {
			StringWriter sw = new StringWriter();
			marshaller.marshal(jaxbElement, sw);
			return sw.toString();
		} catch (JAXBException e) {
			throw new ExceptionWrapper(e);
		}

	}

	public String obj2base(Object jaxbElement) throws ExceptionWrapper {
		if (jaxbElement == null) {
			throw new ExceptionWrapper("InvalidEmptyValue");
		}
		try {
			StringWriter sw = new StringWriter();
			marshaller.marshal(jaxbElement, sw);
			return xml2base(sw.toString());
		} catch (JAXBException e) {
			throw new ExceptionWrapper(e);
		}
	}

	public Object xml2obj(String xml) throws ExceptionWrapper {
		if (xml == null) {
			throw new ExceptionWrapper("InvalidEmptyValue");
		}
		try {
			return unmarshaller.unmarshal(new StringReader(xml));
		} catch (JAXBException e) {
			throw new ExceptionWrapper("InvalidXML", e, xml);
		}
	}

	public Object base2obj(String base64) throws ExceptionWrapper {
		if (base64 == null) {
			throw new ExceptionWrapper("InvalidEmptyValue");
		}
		try {
			return unmarshaller.unmarshal(new StringReader(base2xml(base64)));
		} catch (JAXBException e) {
			throw new ExceptionWrapper(e);
		}
	}
}
