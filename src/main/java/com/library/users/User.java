package main.java.com.library.users;

import main.java.com.library.domain.Loan;
import main.java.com.library.domain.Reservation;
import main.java.com.library.policies.LoanPolicy;

import java.util.ArrayList;
import java.util.List;


public class User {
    protected int code;
    protected String name;
    protected List<Loan> loans;
    protected List<Reservation> reservations;

    public User(int code, String name) {
        this.code = code;
        this.name = name;
        this.loans = new ArrayList<>();
        this.reservations = new ArrayList<>();
    }

    // Padrão Strategy
    public abstract LoanPolicy getLoanPolicy();

    // Métodos GET e SET
    public int getCode() {
        return code;
    }

    public String getName() {
        return name;
    }

    public void addLoan(Loan loan) {
        this.loans.add(loan);
    }

    public void addReservation(Reservation reservation) {
        this.reservations.add(reservation);
    }

    public List<Loan> getLoans() {
        return loans;
    }

    public List<Reservation> getReservations() {
        return reservations;
    }
}
