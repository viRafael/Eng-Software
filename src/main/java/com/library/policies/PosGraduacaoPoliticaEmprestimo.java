package main.java.com.library.policies;

import main.java.com.library.domain.Book;
import main.java.com.library.domain.Exemplar;
import main.java.com.library.domain.Reserva;
import main.java.com.library.domain.enums.ExemplarStatus;
import main.java.com.library.users.User;

import java.time.LocalDate;

public class PosGraduacaoPoliticaEmprestimo implements PoliticaEmprestimo {
    @Override
    public boolean podePegarEmprestado(User user, Book book) {
        if (user.isDevedor()) {
            return false;
        }

        if (!user.temEspacoParaLivro()) {
            return false;
        }

        int numLivroEmprestado = 0;
        for (Exemplar exemplar : book.getExemplares()) {
            if (exemplar.getStatus() == ExemplarStatus.EMPRESTADO) {
                if (exemplar.getCurrentLoan().getUser().equals(user)) {
                    return false;
                }
                numLivroEmprestado += 1;
            }
        }
        if (numLivroEmprestado == book.getExemplares().size()) {
            return false;
        }

        if (book.getReservas().size() > book.getExemplares().size() - numLivroEmprestado) {
            return false;
        }

        for (Reserva reserva : book.getReservas()) {
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
