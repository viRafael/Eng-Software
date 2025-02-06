package br.ufba.es.trabalho.biblioteca.commands;

import br.ufba.es.trabalho.biblioteca.policies.PoliticaEmprestimo;
import br.ufba.es.trabalho.biblioteca.repository.BibliotecaDados;
import br.ufba.es.trabalho.biblioteca.app.CarregadorParametros;
import br.ufba.es.trabalho.biblioteca.domain.Livro;
import br.ufba.es.trabalho.biblioteca.domain.Emprestimo;
import br.ufba.es.trabalho.biblioteca.domain.Exemplar;
import br.ufba.es.trabalho.biblioteca.domain.enums.ExemplarStatus;
import br.ufba.es.trabalho.biblioteca.users.User;

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

        System.out.println("Empréstimo realizado com sucesso para " + user.getName() + " do Livro: " + livro.getTitle());
    }
}
