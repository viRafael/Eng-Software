package br.ufba.es.trabalho.biblioteca.commands;

import br.ufba.es.trabalho.biblioteca.policies.PoliticaEmprestimo;
import br.ufba.es.trabalho.biblioteca.repository.BibliotecaDados;
import br.ufba.es.trabalho.biblioteca.app.CarregadorParametros;
import br.ufba.es.trabalho.biblioteca.domain.Livro;
import br.ufba.es.trabalho.biblioteca.domain.Emprestimo;
import br.ufba.es.trabalho.biblioteca.domain.Exemplar;
import br.ufba.es.trabalho.biblioteca.domain.enums.ExemplarStatus;
import br.ufba.es.trabalho.biblioteca.users.User;
import br.ufba.es.trabalho.biblioteca.utils.Validador;

import java.time.LocalDate;
import java.util.Optional;
import java.util.stream.Stream;

public class EmprestimoCommand implements Command {
    public void execute(CarregadorParametros carregadorParametros) {
        var codeUsuarioOpt = Validador.toInteger(carregadorParametros.getParametroUm());
        var codeLivroOpt = Validador.toInteger(carregadorParametros.getParametroDois());

        if (codeUsuarioOpt.isEmpty()) {
            System.out.println("Informe o número do código do usuário!");
            return;
        }
        if (codeLivroOpt.isEmpty()) {
            System.out.println("Informe o número do código do livro!");
            return;
        }

        BibliotecaDados data = BibliotecaDados.getInstance();
        Optional<User> userOpt = data.findUserById(codeUsuarioOpt.get());
        Optional<Livro> livroOpt = data.findBookById(codeLivroOpt.get());

        // Verifica se o usuário e o livro existem
        if (userOpt.isEmpty() || livroOpt.isEmpty()) {
            System.out.println("Empréstimo não realizado: Usuário ou livro inexistente.");
            return;
        }
        User user = userOpt.get();
        Livro livro = livroOpt.get();

        // Verifica se o usuário pode pegar emprestado o livro
        PoliticaEmprestimo policy = user.getPoliticaEmprestimo();
        boolean canLoan = policy.podePegarEmprestado(user, livro);
        if (!canLoan) {
            System.out.println("Empréstimo não realizado para " + user.getName() +
                    ": Regras de empréstimo não atendidas.");
            return;
        }

        // Retorna um exemplar disponível
        Stream<Exemplar> exemplaresDisponiveis = livro.exemplaresDisponiveis();
        Optional<Exemplar> primeiroOpt = exemplaresDisponiveis.findFirst();
        if (primeiroOpt.isEmpty()) {
            System.out.println("Empréstimo não realizado: Não há exemplares disponíveis.");
            return;
        }
        Exemplar exemplar = primeiroOpt.get();

        // Realiza o empréstimo
        LocalDate start = LocalDate.now();
        LocalDate due = policy.calcularDataDevolucao(start);

        Emprestimo loan = new Emprestimo(user, exemplar, start, due);
        exemplar.setStatus(ExemplarStatus.EMPRESTADO);
        exemplar.setEmprestimoAtual(loan);
        user.addEmprestimo(loan);

        System.out.println("Empréstimo realizado com sucesso para " + user.getName() + " do Livro: " + livro.getTitle());
    }

    @Override
    public String getDescription() {
        return "Realiza o empréstimo de um livro";
    }
}
