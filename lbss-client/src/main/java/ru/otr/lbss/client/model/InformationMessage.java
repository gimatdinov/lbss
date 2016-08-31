package ru.otr.lbss.client.model;

import javax.xml.bind.annotation.XmlTransient;

public abstract class InformationMessage extends BaseMessage {

	private String mpcNamespace;
	private String mpcRootElement;

	private Long acknowledgmentTimestamp;

	@XmlTransient
	public String getMpcNamespace() {
		return mpcNamespace;
	}

	public void setMpcNamespace(String mpcNamespace) {
		this.mpcNamespace = mpcNamespace;
	}

	@XmlTransient
	public String getMpcRootElement() {
		return mpcRootElement;
	}

	public void setMpcRootElement(String mpcRootElement) {
		this.mpcRootElement = mpcRootElement;
	}

	@XmlTransient
	public Long getAcknowledgmentTimestamp() {
		return acknowledgmentTimestamp;
	}

	public void setAcknowledgmentTimestamp(Long acknowledgmentTimestamp) {
		this.acknowledgmentTimestamp = acknowledgmentTimestamp;
	}

}
