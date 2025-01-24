package main.java.com.library.policies;

import main.java.com.library.domain.Book;
import main.java.com.library.users.User;

import java.time.LocalDate;

public class ProfessorLoanPolicy implements LoanPolicy {

    @Override
    public boolean canLoan(User user, Book book) {
        // TODO
        // Regras para Professor (sem limite de livros, ignora reserva, etc.)
        return true;
    }
    @Override
    public LocalDate calcDueDate(LocalDate startDate) {
        return startDate.plusDays(8);
    }
}