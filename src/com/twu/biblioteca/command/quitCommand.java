package com.twu.biblioteca.command;

import com.twu.biblioteca.BibliotecaApp;

public class quitCommand extends Command {

    public quitCommand() {
        super();
        this.name = "Quit";
    }

    @Override
    public void execute() {
        BibliotecaApp.active = false;
    }
}