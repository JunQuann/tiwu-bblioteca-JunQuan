package com.twu.biblioteca;

public class Book {

    private final String title;
    private final String author;
    private final String yearPublished;
    private boolean available = true;

    protected Book(String title, String author, String yearPublished) {
        this.title = title;
        this.author = author;
        this.yearPublished = yearPublished;
    }

    public String getTitle() {
        return title;
    }

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }

    @Override
    public String toString() {
        return title + " - " + author + ", " + yearPublished;
    }

}
