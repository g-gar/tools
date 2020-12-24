package com.ggar.tools.argsparser;

import com.ggar.tools.argsparser.condition.Condition;
import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.DefaultParser;
import org.apache.commons.cli.Options;
import org.apache.commons.cli.ParseException;

import java.util.HashMap;

public class ArgsParser {

    private static ArgsParser instance;
    private CommandLine commandLine;
    private HashMap<String, Condition> conditions = new HashMap<>();

    public static ArgsParser getInstance() {
        if (instance == null) {
            instance = new ArgsParser();
        }
        return instance;
    }

    public ArgsParser parse(Options options, String...args) throws ParseException {
        this.commandLine = new DefaultParser().parse(options, args);
        return this;
    }

    public ArgsParser register(Condition... conditions) {
        for (Condition condition : conditions) {
            if (!this.conditions.containsKey(condition.getIdentifier())) {
                this.conditions.put(condition.getIdentifier(), condition);
            }
        }
        return this;
    }

    public <T> T get(String string) {
        return this.conditions.getOrDefault(string, null).get(this.commandLine);
    }
}
