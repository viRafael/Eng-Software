package main.java.com.library.policies;

import main.java.com.library.domain.Livro;
import main.java.com.library.domain.Exemplar;
import main.java.com.library.domain.enums.ExemplarStatus;
import main.java.com.library.users.User;

import java.time.LocalDate;

public class ProfessorPoliticaEmprestimo implements PoliticaEmprestimo {

    @Override
    public boolean podePegarEmprestado(User user, Livro livro) {
        if (user.isDevedor()) {
            return false;
        }

        int count = 0;
        for (Exemplar exemplar : livro.getExemplares()) {
            if (exemplar.getStatus() == ExemplarStatus.EMPRESTADO) {
                count = count + 1;
            }
        }

        return count != livro.getExemplares().size();
    }

    @Override
    public LocalDate calcularDataDevolucao(LocalDate startDate) {
        return startDate.plusDays(8);
    }
}