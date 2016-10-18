package ru.otr.lbss.service.model.codec;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import javax.activation.DataSource;

public class InputStreamDataSource implements DataSource {
	private InputStream inputStream;
	private String contentType;

	public InputStreamDataSource(InputStream inputStream, String contentType) {
		this.inputStream = inputStream;
		this.contentType = contentType;
	}

	@Override
	public InputStream getInputStream() throws IOException {
		return inputStream;
	}

	@Override
	public OutputStream getOutputStream() throws IOException {
		throw new UnsupportedOperationException("Not supported");
	}

	@Override
	public String getContentType() {
		return contentType;
	}

	@Override
	public String getName() {
		return InputStreamDataSource.class.getName();
	}
}