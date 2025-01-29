package main.java.com.library.users;

import main.java.com.library.domain.Loan;
import main.java.com.library.domain.Reservation;
import main.java.com.library.policies.LoanPolicy;
import main.java.com.library.policies.PostgradLoanPolicy;

import java.util.List;

public class PostgradStudent implements User {
    private int code;
    private String name;

    private LoanPolicy loanPolicy = new PostgradLoanPolicy();

    // Métodos Construtor
    public PostgradStudent(int code, String name) {
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
}