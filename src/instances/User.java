package instances;

import interfaces.ILoanPolicy;

import java.util.ArrayList;
import java.util.List;

public abstract class User {
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

    public abstract ILoanPolicy getLoanPolicy();  // Strategy

    public void addLoan(Loan loan) {
        this.loans.add(loan);
    }

    public void addReservation(Reservation reservation) {
        this.reservations.add(reservation);
    }

    // Getters e métodos de manipulação
    public int getCode() { 
        return code; 
    }
    
    public String getName() { 
        return name; 
    }

    public List<Loan> getLoans() {
        return loans;
    }

    public List<Reservation> getReservations() {
        return reservations;
    }
}
