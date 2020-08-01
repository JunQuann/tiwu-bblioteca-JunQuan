package com.twu.biblioteca;

import com.twu.biblioteca.command.Command;
import com.twu.biblioteca.command.listAllBooksCommand;

import java.util.Scanner;

public class BibliotecaApp {

    final Command[] OPTIONS = new Command[] {
        new listAllBooksCommand()
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

    public void listOptions() {
        System.out.println("Please enter their respective number to select one of the following option:");
        for (int i = 0; i < OPTIONS.length; i++) {
            System.out.println(i + 1 + ". " + OPTIONS[i]);
        }
    }

    public void selectOption() {
        Scanner sc = new Scanner(System.in);
        try {
            int selectedOption = sc.nextInt();
            this.OPTIONS[selectedOption - 1].execute();
        } catch(Exception e) {
            System.out.println("Please select a valid option!");
        }
    }
}
