package com.ggar.tools.cli.task;

import java.io.InputStream;

public class GetProcessErrorStreamTask extends Task<InputStream, Void> {

	private final Process process;
	
	public GetProcessErrorStreamTask(Process process) {
		this.process = process;
	}
	
	@Override
	public InputStream execute() {
		return process.getInputStream();
	}

}
