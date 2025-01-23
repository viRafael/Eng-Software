import java.time.LocalDate;

import interfaces.ILoanPolicy;
import instances.Book;
import instances.User;

public class ProfessorLoanPolicy implements ILoanPolicy {

    @Override
    public boolean canLoan(User user, Book book) {
        // Regras para Professor (sem limite de livros, ignora reserva, etc.)
        return true;
    }

    @Override
    public LocalDate calcDueDate(LocalDate startDate) {
        return startDate.plusDays(8);
    }
}