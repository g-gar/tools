package com.ggar.tools.argsparser;

// TODO: add support for mutually exclusive groups
// TODO: add support for mutually inclusive groups
// TODO: add support for hierarchies
// TODO: add option-function mappings
public abstract class Generator<T> {

    private final GeneratorMappings mappings;

    protected Generator(GeneratorMappings mappings) {
        this.mappings = mappings;
    }

    public T get(String...args) {
        return null;
    }

}
