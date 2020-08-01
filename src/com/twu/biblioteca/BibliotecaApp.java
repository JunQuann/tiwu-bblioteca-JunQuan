package com.twu.biblioteca;

import java.util.Scanner;

public class BibliotecaApp {
    private final Book[] books = new Book[] {
        new Book("Principles: Life and Work", "Ray Dalio", "Sep 2017"),
        new Book("When Breath Becomes Air", "Paul Kalanithi & Abraham Verghese", "Jan 2016"),
        new Book("Why We Sleep: Unlocking the Power of Sleep and Dreams", "Matthew Walker", "Oct 2017"),
    };

    public static void main(String[] args) {
        BibliotecaApp bibliotecaApp = new BibliotecaApp();
        bibliotecaApp.start();
        bibliotecaApp.listOptions();
        bibliotecaApp.selectOption();
    }

    public void start() {
        System.out.println("Welcome to Biblioteca. Your one-stop-shop for great book titles in Bangalore!");
    }

    public void listAllBooks() {
        for (Book book : books) {
            System.out.println(book);
        }
    }

    public void listOptions() {
        System.out.println("Please enter their respective number to select one of the following option:\n" +
                "1. List of books");
    }

    public void selectOption() {
        Scanner sc = new Scanner(System.in);
        int optionSelected = sc.nextInt();
        if (optionSelected == 1) {
            this.listAllBooks();
        }
    }
}
