package com.twu.biblioteca;

public class Book {
    private String title;
    private String author;
    private String yearPublished;

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
