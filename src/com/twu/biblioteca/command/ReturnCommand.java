package com.twu.biblioteca.command;

import com.twu.biblioteca.exception.BookNotValidException;

import java.util.Scanner;

public class ReturnCommand extends Command {

    public ReturnCommand() {
        this.name = "Return a book";
    }

    @Override
    public void execute() {
        System.out.print("Please enter the title of the book that you are returning:\n");
        Scanner sc = new Scanner(System.in);

        try {
            String bookTitle = sc.nextLine();
            biblioteca.returnBook(bookTitle);
            System.out.println("Thank you for returning the book");
        } catch (BookNotValidException e) {
            System.out.println(e.getMessage());
        }

    }
}
