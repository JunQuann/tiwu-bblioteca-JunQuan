package com.twu.biblioteca.command;

import com.twu.biblioteca.Biblioteca;
import com.twu.biblioteca.Book;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.assertEquals;

public class BibliotecaCommandTest {
    private final PrintStream originalOut = System.out;

    private ByteArrayOutputStream outContent;
    private Biblioteca biblioteca;

    @Before
    public void setUp() {
        biblioteca = Biblioteca.getInstance();
        outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));
    }

    private String getOutContent() {
        return outContent.toString();
    }

    @After
    public void tearDown() {
        biblioteca = null;
        System.setOut(originalOut);
    }

    @Test
    public void testListAllBooks() {
        Command listAllBooksCommand = new listAllBooksCommand();
        listAllBooksCommand.execute();
        StringBuilder expectedString = new StringBuilder();
        for (Book book : biblioteca.getBooks()) {
            expectedString.append(book.toString()).append("\n");
        }
        assertEquals(expectedString.toString(), this.getOutContent());
    }
}
