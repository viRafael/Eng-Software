package main.java.com.library.policies;

import main.java.com.library.domain.Book;
import main.java.com.library.users.User;

import java.time.LocalDate;

public class PostgradLoanPolicy implements LoanPolicy {
    @Override
    public boolean canLoan(User user, Book book) {
        // TODO
        // Regras para Aluno de Pós-Graduação (limite 3, etc.)
        return false;
    }
    @Override
    public LocalDate calcDueDate(LocalDate startDate) {
        return startDate.plusDays(5);
    }
}
