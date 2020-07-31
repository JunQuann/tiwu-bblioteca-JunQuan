package com.twu.biblioteca;

public class BibliotecaApp {
    private final String[] books = new String[] {
        "Principles: Life and Work",
        "When Breath Becomes Air",
        "Why We Sleep: Unlocking the Power of Sleep and Dreams",
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
        for (String book : books) {
            System.out.println(book);
        }
    }
}
