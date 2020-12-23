package com.ggar.tools.argsparser;

import org.apache.commons.cli.*;

public class ArgsParser {

    public static CommandLine parse(Options options, String...args) throws ParseException {
        CommandLineParser parser = new DefaultParser();
        return parser.parse(options, args);
    }

}
