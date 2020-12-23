package com.ggar.tools.argsparser.condition;

import org.apache.commons.cli.CommandLine;

public abstract class SingleCondition implements Condition {

    protected final Character option;

    public SingleCondition(Character option) {
        this.option = option;
    }

    @Override
    public Character getIdentifier() {
        return option;
    }

    @Override
    public boolean check(CommandLine commandLine) {
        return commandLine.hasOption(option);
    }

}
