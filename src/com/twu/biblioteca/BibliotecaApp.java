package com.twu.biblioteca;

public class BibliotecaApp {
    private final Book[] books = new Book[] {
        new Book("Principles: Life and Work", "Ray Dalio", "Sep 2017"),
        new Book("When Breath Becomes Air", "Paul Kalanithi & Abraham Verghese", "Jan 2016"),
        new Book("Why We Sleep: Unlocking the Power of Sleep and Dreams", "Matthew Walker", "Oct 2017"),
    };

    public static void main(String[] args) {
        BibliotecaApp bibliotecaApp = new BibliotecaApp();
        bibliotecaApp.start();
        bibliotecaApp.listAllBooks();
    }

    public void start() {
        System.out.println("Welcome to Biblioteca. Your one-stop-shop for great book titles in Bangalore!");
    }

    public void listAllBooks() {
        for (Book book : books) {
            System.out.println(book);
        }
    }
}
