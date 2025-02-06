package br.ufba.es.trabalho.biblioteca.policies;

import br.ufba.es.trabalho.biblioteca.domain.Livro;
import br.ufba.es.trabalho.biblioteca.domain.Exemplar;
import br.ufba.es.trabalho.biblioteca.domain.enums.ExemplarStatus;
import br.ufba.es.trabalho.biblioteca.users.User;

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