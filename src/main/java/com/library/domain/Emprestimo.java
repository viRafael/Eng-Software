package main.java.com.library.domain;

import main.java.com.library.users.User;

import java.time.LocalDate;

public class Emprestimo {
    private User user;
    private Exemplar exemplar;
    private LocalDate startDate;
    private LocalDate dueDate;
    private LocalDate endDate; // se nulo, empréstimo em aberto

    public Emprestimo(User user, Exemplar exemplar, LocalDate startDate, LocalDate dueDate) {
        this.user = user;
        this.exemplar = exemplar;
        this.startDate = startDate;
        this.dueDate = dueDate;
    }

    // Métodos Utilitários
    public Emprestimo findLoanByBook(Livro livro) {
        // TODO
        return null;
    }

    public void finalizeLoan(Livro livro) {
        user.removerEmprestimo(Emprestimo.this);
    }

    public boolean estaAtrasado() {
        return LocalDate.now().isAfter(dueDate);
    }

    // Métodos GET e SET
    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Exemplar getExemplar() {
        return exemplar;
    }

    public void setExemplar(Exemplar exemplar) {
        this.exemplar = exemplar;
    }

    public LocalDate getDataEmprestimo() {
        return startDate;
    }

    public void getDataEmprestimo(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getDueDate() {
        return dueDate;
    }

    public void setDueDate(LocalDate dueDate) {
        this.dueDate = dueDate;
    }

    public LocalDate getDataDevolucao() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }
}

