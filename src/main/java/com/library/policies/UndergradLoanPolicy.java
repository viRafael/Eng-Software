package main.java.com.library.policies;

import main.java.com.library.domain.Book;
import main.java.com.library.users.User;

import java.time.LocalDate;

public class UndergradLoanPolicy implements LoanPolicy{
    @Override
    public boolean canLoan(User user, Book book) {
        // TODO
        return false;
    }

    @Override
    public LocalDate calcDueDate(LocalDate startDate) {
        return startDate.plusDays(3);
    }
}
