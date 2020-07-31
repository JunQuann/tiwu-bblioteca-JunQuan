package com.twu.biblioteca;


import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.assertEquals;

public class ExampleTest {
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;

    @Before
    public void setUpStream() {
        System.setOut(new PrintStream(outContent));
    }

    @After
    public void restoreStream() {
        System.setOut(originalOut);
    }

    @Test
    public void testWelcomeMessage() {
        BibliotecaApp bibliotecaApp = new BibliotecaApp();
        bibliotecaApp.start();
        assertEquals("Welcome to Biblioteca. Your one-stop-shop for great book titles in Bangalore!\n", outContent.toString());
    }

    @Test
    public void testListAllBooks() {
        BibliotecaApp bibliotecaApp = new BibliotecaApp();
        bibliotecaApp.listAllBooks();
        assertEquals("Principles: Life and Work\nWhen Breath Becomes Air\nWhy We Sleep: Unlocking the Power of Sleep and Dreams\n", outContent.toString());
    }
}
