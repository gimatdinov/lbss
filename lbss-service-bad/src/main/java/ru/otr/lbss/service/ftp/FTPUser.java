package ru.otr.lbss.service.ftp;

import java.nio.file.FileSystems;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.apache.ftpserver.ftplet.Authority;
import org.apache.ftpserver.ftplet.AuthorizationRequest;
import org.apache.ftpserver.ftplet.User;
import org.apache.ftpserver.usermanager.impl.ConcurrentLoginPermission;
import org.apache.ftpserver.usermanager.impl.TransferRatePermission;
import org.apache.ftpserver.usermanager.impl.WritePermission;

public class FTPUser implements User {

	private final String ftpDirectory;
	private final String name;
	private String password;
	private final String folder;
	private List<Authority> authorities = new ArrayList<>();

	private boolean enabled = true;
	private int maxIdleTime;

	FTPUser(String name, String password, String ftpDirectory, String folder, boolean writePermission) {
		this.name = name.toLowerCase();
		this.password = password;
		this.ftpDirectory = ftpDirectory;
		this.folder = folder;
		authorities.add(new ConcurrentLoginPermission(10, 10));
		authorities.add(new TransferRatePermission(0, 0));
		setWritePermission(writePermission);
	}

	public void setName(String name) {
		throw new IllegalAccessError();
	}

	@Override
	public String getName() {
		return name;
	}

	@Override
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public int getMaxIdleTime() {
		return maxIdleTime;
	}

	public void setMaxIdleTime(int maxIdleTime) {
		this.maxIdleTime = (maxIdleTime < 0) ? 0 : maxIdleTime;
	}

	public String getFolder() {
		return folder;
	}

	@Override
	public boolean getEnabled() {
		return enabled;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}

	@Override
	public List<Authority> getAuthorities() {
		return (authorities != null) ? Collections.unmodifiableList(authorities) : null;

	}

	public void setAuthorities(List<Authority> authorities) {
		this.authorities = (authorities != null) ? Collections.unmodifiableList(authorities) : null;
	}

	@Override
	public AuthorizationRequest authorize(AuthorizationRequest request) {
		if (authorities == null) {
			return null;
		}
		boolean someoneCouldAuthorize = false;
		for (Authority authority : authorities) {
			if (authority.canAuthorize(request)) {
				someoneCouldAuthorize = true;
				request = authority.authorize(request);
				if (request == null) {
					return null;
				}
			}
		}
		if (someoneCouldAuthorize) {
			return request;
		} else {
			return null;
		}
	}

	@Override
	public List<Authority> getAuthorities(Class<? extends Authority> clazz) {
		List<Authority> selected = new ArrayList<Authority>();
		for (Authority authority : authorities) {
			if (authority.getClass().equals(clazz)) {
				selected.add(authority);
			}
		}
		return selected;
	}

	@Override
	public String getHomeDirectory() {
		return ftpDirectory + FileSystems.getDefault().getSeparator() + folder;
	}

	public boolean isWritePermission() {
		for (Authority authority : authorities) {
			if (authority.getClass().equals(WritePermission.class)) {
				return true;
			}
		}
		return false;
	}

	public void setWritePermission(boolean writePermission) {
		if (writePermission) {
			authorities.add(new WritePermission());
		} else {
			List<Authority> forRemove = new ArrayList<>();
			for (Authority authority : authorities) {
				if (authority.getClass().equals(WritePermission.class)) {
					forRemove.add(authority);
				}
			}
			authorities.removeAll(forRemove);
		}
	}

}
