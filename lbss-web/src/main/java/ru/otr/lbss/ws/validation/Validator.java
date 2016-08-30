package ru.otr.lbss.ws.validation;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.StringReader;

import javax.xml.XMLConstants;
import javax.xml.transform.Source;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;

import org.xml.sax.SAXException;

import cxc.jex.common.exception.ExceptionWrapper;

public class Validator {

	private javax.xml.validation.Validator xsdValidator;

	public Validator() throws ExceptionWrapper {
		try {
			SchemaFactory factory = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
			StreamSource basic = new StreamSource(new FileInputStream(this.getClass().getResource("/smev-message-exchange-basic-1.2.xsd").getFile()));
			StreamSource types = new StreamSource(new FileInputStream(this.getClass().getResource("/smev-message-exchange-types-1.2.xsd").getFile()));
			Schema schema = factory.newSchema(new Source[] { basic, types });
			xsdValidator = schema.newValidator();
		} catch (SAXException e) {
			throw new ExceptionWrapper(e);
		} catch (FileNotFoundException e) {
			throw new ExceptionWrapper(e);		
		}
	}

	public ExceptionWrapper validate(String xml) {
		try {			
			xsdValidator.validate(new StreamSource(new StringReader(xml)));
			return null;
		} catch (SAXException e) {
			return new ExceptionWrapper(e);
		} catch (IOException e) {
			return new ExceptionWrapper(e);
		}
	}

}
