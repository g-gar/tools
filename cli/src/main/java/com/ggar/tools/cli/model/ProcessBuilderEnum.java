package com.ggar.tools.cli.model;

import java.util.Arrays;
import java.util.List;

public enum ProcessBuilderEnum {
	
	POWERSHELL("powershell.exe"),
	CMD("cmd.exe"),
	BASH("bash"),
	CUSTOM();
 
    private final List<String> command;
    
    private ProcessBuilderEnum(String...commands) {
        this.command = Arrays.asList(commands);
    }

	public List<String> getCommand() {
		return command;
	}
	
	public ProcessBuilder get() {
		return new ProcessBuilder(command);
	}
}
