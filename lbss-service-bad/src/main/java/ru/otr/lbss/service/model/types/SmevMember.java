package ru.otr.lbss.service.model.types;

import java.util.ArrayList;
import java.util.List;

import ru.otr.lbss.client.model.types.MessageMetadata.Recipient;
import ru.otr.lbss.client.model.types.MessageMetadata.Sender;

public class SmevMember {
	public static enum Type {
		OIV, PGU
	}

	private String mnemonic;
	private String humanReadableName;
	private Type type;
	private String ftpUserPassword;
	private String certificateHash;
	private List<MpcKey> mpcRegistrationList = new ArrayList<>();


	@Override
	public String toString(){
		return mnemonic +" : " + humanReadableName;
	}

	public SmevMember(String mnemonic, String humanReadableName) {
		this.mnemonic = mnemonic;
		this.humanReadableName = humanReadableName;
	}

	public Sender toSender() {
		Sender result = new Sender();
		result.setMnemonic(mnemonic);
		result.setHumanReadableName(humanReadableName);
		return result;
	}

	public Recipient toRecipient() {
		Recipient result = new Recipient();
		result.setMnemonic(mnemonic);
		result.setHumanReadableName(humanReadableName);
		return result;
	}

	@Override
	public int hashCode() {
		return (mnemonic != null) ? mnemonic.hashCode() : 0;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj != null && obj instanceof SmevMember) {
			SmevMember member = (SmevMember) obj;
			return (this.mnemonic != null && this.mnemonic.equals(member.getMnemonic()));
		} else {
			return false;
		}
	}

	public String getMnemonic() {
		return mnemonic;
	}

	public void setMnemonic(String mnemonic) {
		this.mnemonic = mnemonic;
	}

	public String getHumanReadableName() {
		return humanReadableName;
	}

	public void setHumanReadableName(String humanReadableName) {
		this.humanReadableName = humanReadableName;
	}

	public String getFtpUserPassword() {
		return ftpUserPassword;
	}

	public void setFtpUserPassword(String ftpUserPassword) {
		this.ftpUserPassword = ftpUserPassword;
	}

	public Type getType() {
		return type;
	}

	public void setType(Type type) {
		this.type = type;
	}

	public String getCertificateHash() {
		return certificateHash;
	}

	public void setCertificateHash(String certificateHash) {
		this.certificateHash = certificateHash;
	}

	public List<MpcKey> getMpcRegistrationList() {
		return mpcRegistrationList;
	}

}
