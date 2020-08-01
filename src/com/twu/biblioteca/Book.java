package com.twu.biblioteca;

public class Book {

    private final String title;
    private final String author;
    private final String yearPublished;

    protected Book(String title, String author, String yearPublished) {
        this.title = title;
        this.author = author;
        this.yearPublished = yearPublished;
    }

    @Override
    public String toString() {
        return title + " - " + author + ", " + yearPublished;
    }
}
