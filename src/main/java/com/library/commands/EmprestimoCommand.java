package main.java.com.library.commands;

import main.java.com.library.app.CarregadorParametros;
import main.java.com.library.domain.Book;
import main.java.com.library.domain.Emprestimo;
import main.java.com.library.domain.Exemplar;
import main.java.com.library.domain.enums.ExemplarStatus;
import main.java.com.library.users.User;
import main.java.com.library.policies.PoliticaEmprestimo;
import main.java.com.library.repository.BibliotecaDados;

import java.time.LocalDate;

public class EmprestimoCommand implements Command {
    @Override
    public void execute(CarregadorParametros carregadorParametros) {
        int userId = Integer.parseInt(carregadorParametros.getParametroUm());
        int bookId = Integer.parseInt(carregadorParametros.getParametroDois());

        BibliotecaDados data = BibliotecaDados.getInstance();
        User user = data.findUserById(userId);
        Book book = data.findBookById(bookId);

        if (user == null || book == null) {
            System.out.println("Empréstimo não realizado: Usuário ou livro inexistente.");
            return;
        }

        PoliticaEmprestimo policy = user.getPoliticaEmprestimo();
        boolean canLoan = policy.podePegarEmprestado(user, book);
        if (!canLoan) {
            System.out.println("Empréstimo não realizado para " + user.getName() +
                    ": Regras de empréstimo não atendidas.");
            return;
        }

        Exemplar exemplar = (Exemplar) book.findAvailableExemplar();
        if (exemplar == null) {
            System.out.println("Empréstimo não realizado: Não há exemplares disponíveis.");
            return;
        }

        LocalDate start = LocalDate.now();
        LocalDate due = policy.calcularDataDevolucao(start);

        Emprestimo loan = new Emprestimo(user, exemplar, start, due);
        exemplar.setStatus(ExemplarStatus.EMPRESTADO);
        exemplar.setCurrentLoan(loan);
        user.addEmprestimo(loan);

        System.out.println("Empréstimo realizado com sucesso para "
                + user.getName() + " - Livro: " + book.getTitle());
    }
}
