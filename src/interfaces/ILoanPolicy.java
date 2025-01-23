package interfaces;

import java.time.LocalDate;

import instances.Book;
import instances.User;

public interface ILoanPolicy {
    boolean canLoan(User user, Book book);
    LocalDate calcDueDate(LocalDate startDate);
}