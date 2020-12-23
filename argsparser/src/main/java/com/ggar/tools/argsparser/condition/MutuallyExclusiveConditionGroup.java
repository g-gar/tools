package com.ggar.tools.argsparser.condition;

import org.apache.commons.cli.CommandLine;

import java.util.LinkedHashMap;

public abstract class MutuallyExclusiveConditionGroup extends ConditionGroup {

    public MutuallyExclusiveConditionGroup(Character option) {
        super(option);
    }

    public MutuallyExclusiveConditionGroup(Character option, LinkedHashMap<Character, Condition> conditions) {
        super(option, conditions);
    }

    @Override
    public boolean check(CommandLine commandLine) {
        return this.conditions.values().stream()
            .map(e -> commandLine.hasOption(e.getIdentifier()))
            .filter(Boolean::booleanValue)
            .count() == 1;
    }

    @Override
    public <T> T get(CommandLine commandLine) {
        return this.check(commandLine)
                ? this.conditions.values().stream()
                    .filter(condition -> commandLine.hasOption(condition.getIdentifier()))
                    .findFirst()
                    .get()
                    .get(commandLine)
                : null;
    }
}
