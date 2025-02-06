package br.ufba.es.trabalho.biblioteca.commands;

import br.ufba.es.trabalho.biblioteca.repository.BibliotecaDados;
import br.ufba.es.trabalho.biblioteca.app.CarregadorParametros;
import br.ufba.es.trabalho.biblioteca.domain.Emprestimo;
import br.ufba.es.trabalho.biblioteca.domain.Exemplar;
import br.ufba.es.trabalho.biblioteca.domain.Livro;
import br.ufba.es.trabalho.biblioteca.domain.enums.ExemplarStatus;
import br.ufba.es.trabalho.biblioteca.users.User;
import br.ufba.es.trabalho.biblioteca.utils.Validador;

import java.util.List;
import java.util.Optional;

public class DevolucaoCommand implements Command {

    @Override
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

        BibliotecaDados dados = BibliotecaDados.getInstance();
        Optional<User> userOpt = dados.findUserById(codeUsuarioOpt.get());
        Optional<Livro> livroOpt = dados.findBookById(codeLivroOpt.get());

        // Verifica se o usuário e o livro existem
        if (userOpt.isEmpty() || livroOpt.isEmpty()) {
            System.out.println("Devolução não realizada: Usuário ou livro inexistente.");
            return;
        }
        Livro livro = livroOpt.get();
        User user = userOpt.get();

        // Verifica se o emprestimo com esse user e book existe
        List<Exemplar> exemplaresDoLivro = livro.getExemplares();
        for (Exemplar exemplar : exemplaresDoLivro) {
            if (exemplar.getEmprestimoAtual() == null) {
                continue;
            }
            if (exemplar.getEmprestimoAtual().getUsuario().equals(user)) {
                // Se existir, finaliza o emprestimo e imprime mensagem de sucesso
                exemplar.setStatus(ExemplarStatus.DISPONIVEL);
                Emprestimo emprestimoAtual  = exemplar.getEmprestimoAtual();
                user.removerEmprestimo(emprestimoAtual);
                System.out.println("Devolução realizada com sucesso por " + user.getName() + " - Livro: " + livro.getTitle());
                return;
            }
        }

        // Se não existir, imprime mensagem de erro e retorna
        System.out.println("Devolução não realizada: O usuário não possui empréstimo em aberto deste livro.");
    }

    @Override
    public String getDescription() {
        return "Devolve um livro";
    }
}

