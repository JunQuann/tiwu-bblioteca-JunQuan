package com.twu.biblioteca.command;

import com.twu.biblioteca.Book;

import java.util.ArrayList;

public class listAllBooksCommand extends Command {

    public listAllBooksCommand() {
        super();
        this.name = "List all Books";
    }

    @Override
    public void execute() {
        ArrayList<Book> books = biblioteca.getBooks();
        for (Book book : books) {
            System.out.println(book);
        }
    }
}
