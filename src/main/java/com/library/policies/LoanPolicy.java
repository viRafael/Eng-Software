package main.java.com.library.policies;

import main.java.com.library.domain.Book;
import main.java.com.library.users.User;

import java.time.LocalDate;

public interface LoanPolicy {
    boolean canLoan(User user, Book book);
    LocalDate calcDueDate(LocalDate startDate);
}