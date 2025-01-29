package main.java.com.library.users;

import main.java.com.library.domain.Book;
import main.java.com.library.domain.Loan;
import main.java.com.library.domain.Reservation;
import main.java.com.library.observer.Observer;
import main.java.com.library.policies.ProfessorLoanPolicy;
import main.java.com.library.policies.LoanPolicy;

import java.util.List;


public class Professor implements User, Observer {
    private int code;
    private String name;

    private LoanPolicy loanPolicy = new ProfessorLoanPolicy();
    private int notificationCount = 0;

    // Métodos Construtor
    public Professor(int code, String name) {
        this.code = code;
        this.name = name;
    }

    // Métodos GET e SET
    @Override
    public void addLoan(Loan loan) {
        this.loans.add(loan);
    }

    @Override
    public void addReservation(Reservation reservation) {
        this.reservations.add(reservation);
    }

    @Override
    public List<Loan> getLoans() {
        return loans;
    }

    @Override
    public List<Reservation> getReservations() {
        return reservations;
    }

    @Override
    public LoanPolicy getLoanPolicy() {
        return loanPolicy;
    }

    @Override
    public int getCode() {
        return this.code;
    }

    @Override
    public String getName() {
        return this.name;
    }

    // Implementação do método do Observer
    @Override
    public void update(Book book) {
        notificationCount++;
        // Exemplo de log ou mensagem:
        // System.out.println("Professor " + name + " notificado sobre reservas do livro: " + book.getTitle());
    }

    public int getNotificationCount() {
        return notificationCount;
    }
}