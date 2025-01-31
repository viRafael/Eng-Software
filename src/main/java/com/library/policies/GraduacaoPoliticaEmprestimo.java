package main.java.com.library.policies;

import main.java.com.library.domain.Livro;
import main.java.com.library.domain.Exemplar;
import main.java.com.library.domain.Reserva;
import main.java.com.library.domain.enums.ExemplarStatus;
import main.java.com.library.users.User;

import java.time.LocalDate;

public class GraduacaoPoliticaEmprestimo implements PoliticaEmprestimo {
    @Override
    public boolean podePegarEmprestado(User user, Livro livro) {
        // Verifica se o usuário é devedor
        if (user.isDevedor()) {
            return false;
        }

        // Verifica se o usuário tem espaço para pegar emprestado
        if (!user.temEspacoParaLivro()) {
            return false;
        }

        // Verifica se o User já tem o livro emprestado
        int numLivroEmprestado = 0;
        for (Exemplar exemplar : livro.getExemplares()) {
            if (exemplar.getStatus() == ExemplarStatus.EMPRESTADO) {
                if (exemplar.getEmprestimoAtual().getUser().equals(user)) {
                    return false;
                }
                numLivroEmprestado += 1;
            }
        }
        if (numLivroEmprestado == livro.getExemplares().size()) {
            return false;
        }

        // Verifica se tem um exemplar disponível
        if (livro.getReservas().size() > livro.getExemplares().size() - numLivroEmprestado) {
            return false;
        }

        // Verifica se o User já reservou o livro
        for (Reserva reserva : livro.getReservas()) {
            if (reserva.getUser().equals(user)) {
                return true;
            }
        }

        return false;
    }

    @Override
    public LocalDate calcularDataDevolucao(LocalDate startDate) {
        return startDate.plusDays(3);
    }
}
