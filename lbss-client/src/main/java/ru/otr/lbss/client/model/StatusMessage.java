package ru.otr.lbss.client.model;

import javax.xml.bind.annotation.XmlTransient;

import ru.otr.lbss.client.model.types.MessageMetadata.Recipient;

public abstract class StatusMessage extends BaseMessage {

	private boolean delivered;
	private Recipient recipient;

	@XmlTransient
	public boolean isDelivered() {
		return delivered;
	}

	public void setDelivered(boolean delivered) {
		this.delivered = delivered;
	}

	@XmlTransient
	public Recipient getRecipient() {
		return recipient;
	}

	public void setRecipient(Recipient recipient) {
		this.recipient = recipient;
	}

}
