package cxc.jex.common.xml.dsig;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import cxc.jex.common.exception.ExceptionWrapper;
import cxc.jex.common.xml.transform.GeneralTransformer;

public class SignatureProtector {
	public static final String XML_SignatureNamespaceURI = "http://www.w3.org/2000/09/xmldsig#";
	public static final String XML_SignatureLocalName = "Signature";

	public static final String XML_ProtectorNamespaceURI = "http://jex.cxc/common/xml/SignatureProtector";
	public static final String XML_ProtectorLocalName = "Signature";

	private GeneralTransformer transform;

	public SignatureProtector() throws ExceptionWrapper {
		transform = new GeneralTransformer();
	}

	public boolean isSignature(Node node) {
		return (node.getNodeType() == Node.ELEMENT_NODE && XML_SignatureNamespaceURI.equals(node.getNamespaceURI())
		        && XML_SignatureLocalName.equals(node.getLocalName()));
	}

	public boolean isPackedSignature(Node node) {
		return (node.getNodeType() == Node.ELEMENT_NODE && XML_ProtectorNamespaceURI.equals(node.getNamespaceURI())
		        && XML_ProtectorLocalName.equals(node.getLocalName()));
	}

	public void packAllSignatures(Document dom) throws ExceptionWrapper {
		NodeList nodeList = dom.getElementsByTagName("*");
		for (int i = 0; i < nodeList.getLength(); i++) {
			Node item = nodeList.item(i);
			if (isSignature(item)) {
				Node packedItem = packSignature(item).getDocumentElement();
				packedItem = dom.importNode(packedItem, true);
				item.getParentNode().replaceChild(packedItem, item);

			}
		}
	}

	public void unpackAllSignatures(Document dom) throws ExceptionWrapper {
		NodeList nodeList = dom.getElementsByTagName("*");
		for (int i = 0; i < nodeList.getLength(); i++) {
			Node packedItem = nodeList.item(i);
			if (isPackedSignature(packedItem)) {
				Node item = unpackSignature(packedItem).getDocumentElement();
				item = dom.importNode(item, true);
				packedItem.getParentNode().replaceChild(item, packedItem);
			}
		}
	}

	public String packSignature(String signature) throws ExceptionWrapper {
		String signatureBase64 = transform.xml2base(signature);
		return "<" + XML_ProtectorLocalName + " xmlns=\"" + XML_ProtectorNamespaceURI + "\">" + signatureBase64 + "</" + XML_ProtectorLocalName + ">";
	}

	public Document packSignature(Node signature) throws ExceptionWrapper {
		return transform.xml2dom(packSignature(transform.dom2xml(signature)));
	}

	public Document unpackSignature(Node packedSignature) throws ExceptionWrapper {
		if (isPackedSignature(packedSignature)) {
			if (packedSignature.getFirstChild() != null) {
				String signatureBase64 = packedSignature.getFirstChild().getTextContent();
				String signature = transform.base2xml(signatureBase64);
				return transform.xml2dom(signature);
			} else {
				throw new ExceptionWrapper(new IllegalArgumentException());
			}
		} else {
			throw new ExceptionWrapper(new IllegalArgumentException());
		}
	}

}
