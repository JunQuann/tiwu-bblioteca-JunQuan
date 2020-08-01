package com.twu.biblioteca.command;

import com.twu.biblioteca.exception.BookNotAvailableException;

import java.util.Scanner;

public class CheckOutCommand extends Command {

    public CheckOutCommand() {
        super();
        this.name = "Checkout a book";
    }

    @Override
    public void execute() {
        listAvailableBooksForCheckout();
        checkOutSelectedBook();
    }

    private void listAvailableBooksForCheckout() {
        System.out.print("Please enter the title of book that you will like to checkout:\n\n");
        new ListAllBooksCommand().execute();
    }

    private void checkOutSelectedBook() {
        Scanner sc = new Scanner(System.in);

        try {
            String selectedBookTitle = sc.nextLine();
            biblioteca.checkOutBook(selectedBookTitle);
            System.out.println("Thank you! Enjoy the book");
        } catch (BookNotAvailableException e) {
            System.out.println(e.getMessage());
        }
    }
}
