package com.twu.biblioteca.command;

import com.twu.biblioteca.Biblioteca;

public abstract class Command {
    protected String name;
    protected Biblioteca biblioteca;

    public Command() {
        this.biblioteca = Biblioteca.getInstance();
    }

    public abstract void execute();

    @Override
    public String toString() {
        return name;
    }
}
