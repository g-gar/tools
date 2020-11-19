package com.ggar.tools.cli.model;

import java.io.InputStream;
import java.io.OutputStream;
import java.util.List;

public class ProcessInfo {

	private final Long pid;
	private final List<String> command;
	private final InputStream stdout;
	private final InputStream stderr;
	private final OutputStream stdin;
	
	public ProcessInfo(Long pid, List<String> command, InputStream stdout, InputStream stderr, OutputStream stdin) {
		this.pid = pid;
		this.command = command;
		this.stdout = stdout;
		this.stderr = stderr;
		this.stdin = stdin;
	}

	public Long getPid() {
		return pid;
	}

	public List<String> getCommand() {
		return command;
	}

	public InputStream getStdout() {
		return stdout;
	}

	public InputStream getStderr() {
		return stderr;
	}

	public OutputStream getStdin() {
		return stdin;
	}

}
