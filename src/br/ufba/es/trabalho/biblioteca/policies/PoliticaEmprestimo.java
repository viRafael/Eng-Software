package br.ufba.es.trabalho.biblioteca.policies;

import br.ufba.es.trabalho.biblioteca.domain.Livro;
import br.ufba.es.trabalho.biblioteca.users.User;

import java.time.LocalDate;

public interface PoliticaEmprestimo {
    boolean podePegarEmprestado(User user, Livro livro);

    LocalDate calcularDataDevolucao(LocalDate startDate);
}