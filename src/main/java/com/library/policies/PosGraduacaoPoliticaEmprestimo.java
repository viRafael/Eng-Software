package main.java.com.library.policies;

import main.java.com.library.domain.Livro;
import main.java.com.library.domain.Exemplar;
import main.java.com.library.domain.Reserva;
import main.java.com.library.domain.enums.ExemplarStatus;
import main.java.com.library.users.User;

import java.time.LocalDate;

public class PosGraduacaoPoliticaEmprestimo implements PoliticaEmprestimo {
    @Override
    public boolean podePegarEmprestado(User user, Livro livro) {
        if (user.isDevedor()) {
            return false;
        }

        if (!user.temEspacoParaLivro()) {
            return false;
        }

        int numLivroEmprestado = 0;
        for (Exemplar exemplar : livro.getExemplares()) {
            if (exemplar.getStatus() == ExemplarStatus.EMPRESTADO) {
                if (exemplar.getEmprestimoAtual().getUsuario().equals(user)) {
                    return false;
                }
                numLivroEmprestado += 1;
            }
        }
        if (numLivroEmprestado == livro.getExemplares().size()) {
            return false;
        }

        if (livro.getReservas().size() > livro.getExemplares().size() - numLivroEmprestado) {
            return false;
        }

        for (Reserva reserva : livro.getReservas()) {
            if (reserva.getUser().equals(user)) {
                return true;
            }
        }

        return false;
    }

    @Override
    public LocalDate calcularDataDevolucao(LocalDate startDate) {
        return startDate.plusDays(5);
    }
}
