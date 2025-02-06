package br.ufba.es.trabalho.biblioteca.utils;

import java.util.Optional;

public class Validador {

    public static Optional<Integer> toInteger(String param) {
        try {
            return Optional.of(Integer.parseInt(param));
        } catch (Exception ignored) {
            return Optional.empty();
        }
    }

}
