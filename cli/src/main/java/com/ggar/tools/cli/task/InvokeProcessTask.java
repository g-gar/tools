package com.ggar.tools.cli.task;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

public class InvokeProcessTask extends Task<Process, Void> {
	
	private final ProcessBuilder builder;
	private final List<String> command;
	
	public InvokeProcessTask(ProcessBuilder builder, List<String> command) {
		super();
		this.builder = builder;
		this.command = command;
	}

	@Override
	public Process execute() {
		Process process = null;
		try {
			logger.info(String.format("Process starting with command [%s]\n", this.command.stream().collect(Collectors.joining(","))));
			process = builder.command(this.command).start();
			logger.info(String.format("Process started with command [%s]\n", this.command.stream().collect(Collectors.joining(","))));
		} catch (IOException e) {
			logger.info(String.format("Error starting process with command [%s]\nTrace:%s\n", this.command.stream().collect(Collectors.joining(",")), e.getMessage()));
		}
		return process;
	}

}
