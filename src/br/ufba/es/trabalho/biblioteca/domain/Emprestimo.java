package br.ufba.es.trabalho.biblioteca.domain;

import br.ufba.es.trabalho.biblioteca.users.User;

import java.time.LocalDate;

public class Emprestimo {
    private User usuario;
    private Exemplar exemplar;
    private LocalDate startDate;
    private LocalDate dueDate;
    private LocalDate endDate; // se nulo, empréstimo em aberto

    public Emprestimo(User usuario, Exemplar exemplar, LocalDate startDate, LocalDate dueDate) {
        this.usuario = usuario;
        this.exemplar = exemplar;
        this.startDate = startDate;
        this.dueDate = dueDate;
    }

    // Métodos Utilitários
    public void finalizeLoan(Livro livro) {
        usuario.removerEmprestimo(Emprestimo.this);
    }

    public boolean estaAtrasado() {
        return LocalDate.now().isAfter(dueDate);
    }

    // Métodos GET e SET
    public User getUsuario() {
        return usuario;
    }

    public Exemplar getExemplar() {
        return exemplar;
    }

    public LocalDate getDataEmprestimo() {
        return startDate;
    }

    public LocalDate getDueDate() {
        return dueDate;
    }

    public LocalDate getDataDevolucao() {
        return endDate;
    }
}