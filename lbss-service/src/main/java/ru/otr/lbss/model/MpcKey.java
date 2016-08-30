package ru.otr.lbss.model;

import java.io.Serializable;

import org.bson.Document;

public class MpcKey implements Serializable {
    private static final long serialVersionUID = 9116370209029645147L;

    private String namespace;
    private String rootElement;

    public MpcKey(String namespace, String rootElement) {
        this.namespace = namespace;
        this.rootElement = rootElement;
    }

    public MpcKey(Document doc) {
        this.namespace = doc.getString("namespace");
        this.rootElement = doc.getString("rootElement");
    }

    public String getNamespace() {
        return namespace;
    }

    public void setNamespace(String namespace) {
        this.namespace = namespace;
    }

    public String getRootElement() {
        return rootElement;
    }

    public void setRootElement(String rootElement) {
        this.rootElement = rootElement;
    }

    public Document toDocument() {
        Document result = new Document();
        result.append("namespace", namespace);
        result.append("rootElement", rootElement);
        return result;
    }

    @Override
    public String toString() {
        return "{" + namespace + "}" + rootElement;
    }

}
