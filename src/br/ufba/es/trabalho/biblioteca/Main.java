package br.ufba.es.trabalho.biblioteca;

import br.ufba.es.trabalho.biblioteca.app.ConsoleHandler;

public class Main {
    public static void main(String[] args) {
        ConsoleHandler consoleHandler = new ConsoleHandler();
        consoleHandler.popular();
        consoleHandler.run();
    }
}