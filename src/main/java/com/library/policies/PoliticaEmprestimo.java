package main.java.com.library.policies;

import main.java.com.library.domain.Livro;
import main.java.com.library.users.User;

import java.time.LocalDate;

public interface PoliticaEmprestimo {
    boolean podePegarEmprestado(User user, Livro livro);

    LocalDate calcularDataDevolucao(LocalDate startDate);
}