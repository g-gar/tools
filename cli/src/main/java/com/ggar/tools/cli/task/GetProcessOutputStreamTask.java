package com.ggar.tools.cli.task;

import java.io.InputStream;

public class GetProcessOutputStreamTask extends Task<InputStream, Void> {

	private final Process process;
	
	public GetProcessOutputStreamTask(Process process) {
		this.process = process;
	}
	
	@Override
	public InputStream execute() {
		return process.getInputStream();
	}

}
