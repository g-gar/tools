package com.ggar.tools.argsparser.condition;

import java.util.HashMap;

public abstract class ConditionGroup implements Condition {

    protected final String option;
    protected final HashMap<String, Condition> conditions;

    public ConditionGroup(String option) {
        this(option, new HashMap<String, Condition>());
    }

    public ConditionGroup(String option, HashMap<String, Condition> conditions) {
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
    public String getIdentifier() {
        return option;
    }

}
