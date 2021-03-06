package com.twu.biblioteca;

import com.twu.biblioteca.exception.BookNotAvailableException;
import com.twu.biblioteca.exception.BookNotValidException;

import java.util.ArrayList;
import java.util.Arrays;

public class Biblioteca {

    private static Biblioteca instance;
    private ArrayList<Book> books;

    private Biblioteca() {
        this.books = new ArrayList<>(Arrays.asList(
                new Book("Principles: Life and Work", "Ray Dalio", "Sep 2017"),
                new Book("When Breath Becomes Air", "Paul Kalanithi & Abraham Verghese", "Jan 2016"),
                new Book("Why We Sleep: Unlocking the Power of Sleep and Dreams", "Matthew Walker", "Oct 2017")
        ));
    }

    public static Biblioteca getInstance() {
        if (instance == null) {
            Biblioteca.instance = new Biblioteca();
        }
        return Biblioteca.instance;
    }

    public ArrayList<Book> getBooks() {
        return books;
    }

    public void checkOutBook(String bookTitle) throws BookNotAvailableException {
        Book selectedBook = books.stream()
                .filter(book -> bookTitle.equals(book.getTitle()) && book.isAvailable())
                .findFirst()
                .orElse(null);
        if (selectedBook != null) {
            selectedBook.setAvailable(false);
        } else {
            throw new BookNotAvailableException("Sorry, that book is not available");
        }
    }

    public void returnBook(String bookTitle) throws BookNotValidException {
        Book selectedBook = books.stream()
                .filter(book -> bookTitle.equals(book.getTitle()) && !book.isAvailable())
                .findFirst()
                .orElse(null);
        if (selectedBook != null) {
            selectedBook.setAvailable(true);
        } else {
            throw new BookNotValidException("That is not a valid book to return");
        }
    }
}
