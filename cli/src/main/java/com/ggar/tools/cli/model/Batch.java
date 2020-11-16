package com.ggar.tools.cli.model;

import java.util.List;

import com.ggar.tools.cli.Cli;

public abstract class Batch {

	private final Cli cli;
	private final List<Command> commands;
	
	public Batch(Cli cli, List<Command> commands) {
		this.cli = cli;
		this.commands = commands;
	}
	
	public abstract Boolean execute();

}
