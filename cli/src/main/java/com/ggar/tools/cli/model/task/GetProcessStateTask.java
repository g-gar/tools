package com.ggar.tools.cli.model.task;

public class GetProcessStateTask extends Task<Integer, Void> {

	private final Process process;
	
	public GetProcessStateTask(Process process) {
		this.process = process;
	}
	
	@Override
	public Integer execute() {
		Integer result;
		try {
			result = process.exitValue();
		} catch (IllegalThreadStateException e) {
			result = null;
		}
		return result;
	}

}
