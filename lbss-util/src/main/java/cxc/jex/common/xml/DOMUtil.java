package cxc.jex.common.xml;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import cxc.jex.common.exception.ExceptionWrapper;

public final class DOMUtil {
	static {
		ExceptionWrapper.getMessageHelper().registerMessage("DOMUtil.NodeNotSingle", "[%1$s]%2$s", DOMUtil.class.getName());
		ExceptionWrapper.getMessageHelper().registerMessage("DOMUtil.NodeNotFound", "[%1$s]%2$s", DOMUtil.class.getName());
	}

	private DOMUtil() {
	}

	public static Node findSingleNode(Document dom, String namespaceURI, String localName) throws ExceptionWrapper {
		Node result = null;
		NodeList nodeList = dom.getElementsByTagName("*");
		for (int i = 0; i < nodeList.getLength(); i++) {
			Node item = nodeList.item(i);
			if (item.getNodeType() == Node.ELEMENT_NODE && namespaceURI.equals(item.getNamespaceURI()) && localName.equals(item.getLocalName())) {
				if (result == null) {
					result = item;
				} else {
					throw new ExceptionWrapper("DOMUtil.NodeNotSingle", namespaceURI, localName);
				}
			}
		}
		return result;
	}

	public static void resetSingleNode(Document dom, Node node) throws ExceptionWrapper {
		Node oldNode = findSingleNode(dom, node.getNamespaceURI(), node.getLocalName());
		if (oldNode == null) {
			throw new ExceptionWrapper("DOMUtil.NodeNotFound", node.getNamespaceURI(), node.getLocalName());
		}
		node = dom.importNode(node, true);
		oldNode.getParentNode().replaceChild(node, oldNode);
	}

}
