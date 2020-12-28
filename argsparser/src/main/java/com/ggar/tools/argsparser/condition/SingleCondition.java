package com.ggar.tools.argsparser.condition;

import org.apache.commons.cli.CommandLine;

public abstract class SingleCondition implements Condition {

    protected final String option;

    public SingleCondition(String option) {
        this.option = option;
    }

    @Override
    public String getIdentifier() {
        return option;
    }

    @Override
    public boolean check(CommandLine commandLine) {
        return commandLine.hasOption(option);
    }

    @Override
    public <T> T get(CommandLine commandLine) {
        return (T) commandLine.getOptionValue(option);
    }
}
