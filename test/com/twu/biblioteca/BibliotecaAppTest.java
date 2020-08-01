package com.twu.biblioteca;


import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.*;

import static org.junit.Assert.assertEquals;

public class BibliotecaAppTest {
    private BibliotecaApp bibliotecaApp;
    private final InputStream originalIn = System.in;
    private final PrintStream originalOut = System.out;

    private ByteArrayOutputStream outContent;
    private ByteArrayInputStream inContent;

    @Before
    public void setUp() {
        bibliotecaApp = new BibliotecaApp();
        outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));
    }

    private void provideInput(String input) {
        inContent = new ByteArrayInputStream(input.getBytes());
        System.setIn(inContent);
    }

    private String getOutContent() {
        return outContent.toString();
    }

    @After
    public void tearDown() {
        bibliotecaApp = null;
        System.setIn(originalIn);
        System.setOut(originalOut);
    }

    @Test
    public void testWelcomeMessage() {
        bibliotecaApp.start();
        assertEquals("Welcome to Biblioteca. Your one-stop-shop for great book titles in Bangalore!\n", this.getOutContent());
    }

    @Test
    public void testListAllBooks() {
        bibliotecaApp.listAllBooks();
        assertEquals(
                "Principles: Life and Work - Ray Dalio, Sep 2017\n" +
                        "When Breath Becomes Air - Paul Kalanithi & Abraham Verghese, Jan 2016\n" +
                        "Why We Sleep: Unlocking the Power of Sleep and Dreams - Matthew Walker, Oct 2017\n"
                , this.getOutContent());
    }

    @Test
    public void testListOptions() {
        bibliotecaApp.listOptions();
        assertEquals(
                "Please enter their respective number to select one of the following option:\n" +
                        "1. List of books\n"
        , this.getOutContent());
    }

    @Test
    public void selectListAllBookOption() {
        String selectedOption = "1";
        this.provideInput(selectedOption);
        bibliotecaApp.selectOption();
        assertEquals("Principles: Life and Work - Ray Dalio, Sep 2017\n" +
                "When Breath Becomes Air - Paul Kalanithi & Abraham Verghese, Jan 2016\n" +
                "Why We Sleep: Unlocking the Power of Sleep and Dreams - Matthew Walker, Oct 2017\n"
        , this.getOutContent());
    }
}
