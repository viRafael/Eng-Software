package main.java.com.library.domain;

import main.java.com.library.users.User;

import java.time.LocalDate;

public class Loan {
    private User user;
    private Exemplar exemplar;
    private LocalDate startDate;
    private LocalDate dueDate;
    private LocalDate endDate; // se nulo, empréstimo em aberto

    public Loan(User user, Exemplar exemplar, LocalDate startDate, LocalDate dueDate) {
        this.user = user;
        this.exemplar = exemplar;
        this.startDate = startDate;
        this.dueDate = dueDate;
    }
    // Métodos Utilitários
    public Loan findLoanByBook(Book book) {
        // TODO
        return null;
    }

    public void finalizeLoan(Book book) {
        // TODO
        return;
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

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getDueDate() {
        return dueDate;
    }

    public void setDueDate(LocalDate dueDate) {
        this.dueDate = dueDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }
}

