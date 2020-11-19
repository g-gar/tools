package com.ggar.tools.cli;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

import com.ggar.tools.cli.model.Command;
import com.ggar.tools.cli.model.ProcessInfo;
import com.ggar.tools.cli.model.exception.ProcessNotFoundException;
import com.ggar.tools.cli.model.task.GetProcessIdTask;
import com.ggar.tools.cli.model.task.GetProcessStateTask;
import com.ggar.tools.cli.model.task.InvokeProcessTask;

public class Cli {

	private final ProcessBuilder builder;
	private final Map<Long, Process> processes = new HashMap<>();

	public Cli(ProcessBuilder builder) {
		this.builder = builder;
	}

	public ProcessInfo start(Command command) {
		ProcessInfo processInfo = null;
		Long pid = null;
		Process process = new InvokeProcessTask(builder, command.get()).execute();
		if (process != null) {
			pid = new GetProcessIdTask(process).execute();
			processInfo = new ProcessInfo(pid, command.get(), process.getInputStream(), process.getErrorStream(), process.getOutputStream());
			processes.put(pid, process);
		}
		return processInfo;
	}

	public boolean isProcessRunning(Long pid) throws ProcessNotFoundException {
		return findAndExecute(pid, p -> new GetProcessStateTask(p).execute() == null);
	}
	
	public Integer getProcessExitValue(Long pid) throws ProcessNotFoundException {
		return findAndExecute(pid, p -> new GetProcessStateTask(p).execute());
	}

	private <R> R findAndExecute(Long pid, Function<Process, R> fn) throws ProcessNotFoundException {
		R result = null;
		Process process = null;
		if ((process = processes.get(pid)) != null) {
			result = fn.apply(process);
		} else throw new ProcessNotFoundException();
		return result;
	}
	
	public Boolean stop(Long pid) {
		return false;
	}
	
	public Boolean stop() {
		return null;
	}
}
