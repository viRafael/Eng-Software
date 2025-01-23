import java.time.LocalDate;

import interfaces.ILoanPolicy;
import instances.Book;
import instances.User;

public class UndergradLoanPolicy implements ILoanPolicy {
    
    @Override
    public boolean canLoan(User user, Book book) {
        // Implementa regras específicas para Aluno de Graduação
        // (limite de 2 livros, reserva, se está devedor, etc.)
        return false; // lógica
    }

    @Override
    public LocalDate calcDueDate(LocalDate startDate) {
        return startDate.plusDays(4); // 4 dias
    }
}