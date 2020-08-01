package com.twu.biblioteca.command;

import com.twu.biblioteca.Biblioteca;
import com.twu.biblioteca.BibliotecaApp;
import com.twu.biblioteca.Book;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;
import java.util.ArrayList;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

public class BibliotecaCommandTest {
    private final PrintStream originalOut = System.out;
    private final InputStream originalIn = System.in;

    private ByteArrayOutputStream outContent;
    private Biblioteca biblioteca;

    @Before
    public void setUp() {
        biblioteca = Biblioteca.getInstance();
        outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));
    }

    private void provideInput(String input) {
        ByteArrayInputStream inContent = new ByteArrayInputStream(input.getBytes());
        System.setIn(inContent);
    }

    private String getOutContent() {
        return outContent.toString();
    }

    @After
    public void tearDown() {
        biblioteca = null;
        System.setIn(originalIn);
        System.setOut(originalOut);
    }

    @Test
    public void testListAllBooks() {
        Command listAllBooksCommand = new ListAllBooksCommand();
        listAllBooksCommand.execute();
        StringBuilder expectedString = new StringBuilder();

        for (Book book : biblioteca.getBooks()) {
            if (book.isAvailable()) {
                expectedString.append(book.toString()).append("\n");
            }
        }

        assertEquals(expectedString.toString(), this.getOutContent());
    }

    @Test
    public void testQuit() {
        Command quitCommand = new QuitCommand();
        quitCommand.execute();
        assertFalse(BibliotecaApp.active);
    }

    @Test
    public void testCheckoutAvailableBooks() {
        ArrayList<Book> books = biblioteca.getBooks();
        Command checkoutCommand = new CheckOutCommand();
        StringBuilder expectedString = new StringBuilder();
        expectedString.append("Please enter the title of book that you will like to checkout:\n\n");

        for (Book book : biblioteca.getBooks()) {
            if (book.isAvailable()) {
                expectedString.append(book.toString()).append("\n");
            }
        }

        Book selectedBook = books.get(0);
        provideInput(selectedBook.getTitle());

        expectedString.append("Thank you! Enjoy the book\n");

        checkoutCommand.execute();
        assertEquals(expectedString.toString(), this.getOutContent());
        assertFalse(selectedBook.isAvailable());
    }

    @Test
    public void testCheckoutUnavailableBook() {
        Command checkoutCommand = new CheckOutCommand();
        StringBuilder expectedString = new StringBuilder();
        expectedString.append("Please enter the title of book that you will like to checkout:\n\n");

        for (Book book : biblioteca.getBooks()) {
            if (book.isAvailable()) {
                expectedString.append(book.toString()).append("\n");
            }
        }

        String invalidBook = "Invalid book";
        provideInput(invalidBook);
        checkoutCommand.execute();

        expectedString.append("Sorry, that book is not available\n");
        assertEquals(expectedString.toString(), this.getOutContent());
    }

    @Test
    public void testReturnValidBook() {
        Command returnCommand = new ReturnCommand();
        StringBuilder expectedString = new StringBuilder();
        expectedString.append("Please enter the title of the book that you are returning:\n");

        Book selectedBook = biblioteca.getBooks().get(0);
        selectedBook.setAvailable(false);

        String bookTitle = selectedBook.getTitle();
        provideInput(bookTitle);
        returnCommand.execute();

        expectedString.append("Thank you for returning the book\n");
        assertEquals(expectedString.toString(), this.getOutContent());
    }

    @Test
    public void returnInvalidBook() {
        Command returnCommand = new ReturnCommand();
        StringBuilder expectedString = new StringBuilder();
        expectedString.append("Please enter the title of the book that you are returning:\n");

        String invalidBookTitle = "Invalid book";
        provideInput(invalidBookTitle);
        returnCommand.execute();

        expectedString.append("That is not a valid book to return\n");
        assertEquals(expectedString.toString(), this.getOutContent());
    }
}
