package com.twu.biblioteca;


import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.assertEquals;

public class ExampleTest {

    @Test
    public void testWelcomeMessage() {
        final ByteArrayOutputStream outContent = new ByteArrayOutputStream();

        System.setOut(new PrintStream(outContent));
        BibliotecaApp.main(new String[0]);
        assertEquals("Welcome to Biblioteca. Your one-stop-shop for great book titles in Bangalore!\n", outContent.toString());
    }
}
