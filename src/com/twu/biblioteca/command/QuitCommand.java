package com.twu.biblioteca.command;

import com.twu.biblioteca.BibliotecaApp;

public class QuitCommand extends Command {

    public QuitCommand() {
        super();
        this.name = "Quit";
    }

    @Override
    public void execute() {
        BibliotecaApp.active = false;
    }
}