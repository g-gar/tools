package com.ggar.tools.argsparser.condition;

import org.apache.commons.cli.CommandLine;

public interface Condition {

    public Character getIdentifier();
    public abstract boolean check(CommandLine commandLine);
    public abstract <T> T get(CommandLine commandLine);

}
