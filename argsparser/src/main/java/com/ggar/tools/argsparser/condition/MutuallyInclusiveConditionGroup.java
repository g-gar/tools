package com.ggar.tools.argsparser.condition;

import org.apache.commons.cli.CommandLine;

import java.util.LinkedHashMap;

public abstract class MutuallyInclusiveConditionGroup extends ConditionGroup {

    public MutuallyInclusiveConditionGroup(String option) {
        super(option);
    }

    public MutuallyInclusiveConditionGroup(String option, LinkedHashMap<String, Condition> conditions) {
        super(option, conditions);
    }

    @Override
    public boolean check(CommandLine commandLine) {
        return this.conditions.values().stream().map(e -> commandLine.hasOption(e.getIdentifier())).reduce((a,b) -> a && b).orElse(false);
    }

}
