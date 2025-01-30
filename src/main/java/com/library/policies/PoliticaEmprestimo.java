package main.java.com.library.policies;

import main.java.com.library.domain.Book;
import main.java.com.library.users.User;

import java.time.LocalDate;

public interface PoliticaEmprestimo {
    boolean podePegarEmprestado(User user, Book book);

    LocalDate calcularDataDevolucao(LocalDate startDate);
}