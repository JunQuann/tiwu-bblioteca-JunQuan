package com.twu.biblioteca.command;

import com.twu.biblioteca.Book;

import java.util.ArrayList;

public class ListAllBooksCommand extends Command {

    public ListAllBooksCommand() {
        super();
        this.name = "List all Books";
    }

    @Override
    public void execute() {
        StringBuilder finalString = new StringBuilder();
        for (Book book : biblioteca.getBooks()) {
            if (book.isAvailable()) {
                finalString.append(book.toString()).append("\n");
            }
        }
        System.out.print(finalString);
    }
}
