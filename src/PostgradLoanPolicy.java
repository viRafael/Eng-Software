import java.time.LocalDate;

import interfaces.ILoanPolicy;
import instances.Book;
import instances.User;

public class PostgradLoanPolicy implements ILoanPolicy {

    @Override
    public boolean canLoan(User user, Book book) {
        // Regras para Aluno de Pós-Graduação (limite 3, etc.)
        return false; 
    }
    
    @Override
    public LocalDate calcDueDate(LocalDate startDate) {
        return startDate.plusDays(5); 
    }
}
