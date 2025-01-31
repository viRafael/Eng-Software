package main.java.com.library.commands;

import main.java.com.library.app.CarregadorParametros;
import main.java.com.library.domain.Livro;
import main.java.com.library.domain.Emprestimo;
import main.java.com.library.domain.Exemplar;
import main.java.com.library.domain.enums.ExemplarStatus;
import main.java.com.library.users.User;
import main.java.com.library.policies.PoliticaEmprestimo;
import main.java.com.library.repository.BibliotecaDados;

import java.time.LocalDate;

public class EmprestimoCommand implements Command {
    public void execute(CarregadorParametros carregadorParametros) {
        int codigoUser = Integer.parseInt(carregadorParametros.getParametroUm());
        int codigoLivro = Integer.parseInt(carregadorParametros.getParametroDois());

        BibliotecaDados data = BibliotecaDados.getInstance();
        User user = data.findUserById(codigoUser);
        Livro livro = data.findBookById(codigoLivro);

        // Verifica se o usuário e o livro existem
        if (user == null || livro == null) {
            System.out.println("Empréstimo não realizado: Usuário ou livro inexistente.");
            return;
        }

        // Verifica se o usuário pode pegar emprestado o livro
        PoliticaEmprestimo policy = user.getPoliticaEmprestimo();
        boolean canLoan = policy.podePegarEmprestado(user, livro);
        if (!canLoan) {
            System.out.println("Empréstimo não realizado para " + user.getName() +
                    ": Regras de empréstimo não atendidas.");
            return;
        }

        // Retorna um exemplar disponível
        Exemplar exemplar = (Exemplar) livro.findAvailableExemplar();
        if (exemplar == null) {
            System.out.println("Empréstimo não realizado: Não há exemplares disponíveis.");
            return;
        }

        // Realiza o empréstimo
        LocalDate start = LocalDate.now();
        LocalDate due = policy.calcularDataDevolucao(start);

        Emprestimo loan = new Emprestimo(user, exemplar, start, due);
        exemplar.setStatus(ExemplarStatus.EMPRESTADO);
        exemplar.setEmprestimoAtual(loan);
        user.addEmprestimo(loan);

        System.out.println("Empréstimo realizado com sucesso para "
                + user.getName() + " - Livro: " + livro.getTitle());
    }
}
