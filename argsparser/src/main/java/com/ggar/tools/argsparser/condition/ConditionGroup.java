package com.ggar.tools.argsparser.condition;

import java.util.LinkedHashMap;

public abstract class ConditionGroup implements Condition {

    protected final Character option;
    protected final LinkedHashMap<Character, Condition> conditions;

    public ConditionGroup(Character option) {
        this(option, new LinkedHashMap<Character, Condition>());
    }

    public ConditionGroup(Character option, LinkedHashMap<Character, Condition> conditions) {
        this.option = option;
        this.conditions = conditions;
    }

    public <G extends ConditionGroup> G addCondition(Condition condition) {
        if (!conditions.containsKey(condition.getIdentifier())) {
            this.conditions.put(condition.getIdentifier(), condition);
        }
        return (G) this;
    }

    @Override
    public Character getIdentifier() {
        return option;
    }

}
