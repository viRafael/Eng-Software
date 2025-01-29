package main.java.com.library.users;

import main.java.com.library.domain.Loan;
import main.java.com.library.domain.Reservation;
import main.java.com.library.policies.LoanPolicy;

import java.util.ArrayList;
import java.util.List;


public interface User {
    List<Loan> loans = new ArrayList<Loan>();
    List<Reservation> reservations = new ArrayList<Reservation>();

    // Métodos GET e SET
    public void addLoan(Loan loan);

    public void addReservation(Reservation reservation);

    public List<Loan> getLoans();

    public List<Reservation> getReservations();

    public LoanPolicy getLoanPolicy();

    public int getCode();

    public String getName();
}
 