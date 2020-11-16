package com.ggar.tools.cli.task;

import java.util.logging.Logger;

public abstract class Task<R, S> {
	
	protected final Logger logger = Logger.getLogger(getClass().getName());

	public abstract R execute();
	
}
