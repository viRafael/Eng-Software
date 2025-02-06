package br.ufba.es.trabalho.biblioteca.utils;

import br.ufba.es.trabalho.biblioteca.domain.Livro;
import br.ufba.es.trabalho.biblioteca.repository.BibliotecaDados;
import br.ufba.es.trabalho.biblioteca.users.User;

import java.awt.print.Book;
import java.util.Optional;

public class Validador {

    public static Optional<Integer> toInteger(String param) {
        try {
            return Optional.of(Integer.parseInt(param));
        } catch (Exception ignored) {
            return Optional.empty();
        }
    }

    public static Optional<Livro> getBookFromCode(String codeString) {
        BibliotecaDados dados = BibliotecaDados.getInstance();
        var integer = toInteger(codeString);
        return integer.map(dados::findBookById).flatMap(opt -> opt);
    }

    public static Optional<User> getUserFromCode(String codeString) {
        BibliotecaDados dados = BibliotecaDados.getInstance();
        var integer = toInteger(codeString);
        return integer.map(dados::findUserById).flatMap(opt -> opt);
    }

}
