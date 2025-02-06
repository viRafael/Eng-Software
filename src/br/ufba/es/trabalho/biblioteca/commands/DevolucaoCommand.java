package br.ufba.es.trabalho.biblioteca.commands;

import br.ufba.es.trabalho.biblioteca.repository.BibliotecaDados;
import br.ufba.es.trabalho.biblioteca.app.CarregadorParametros;
import br.ufba.es.trabalho.biblioteca.domain.Emprestimo;
import br.ufba.es.trabalho.biblioteca.domain.Exemplar;
import br.ufba.es.trabalho.biblioteca.domain.Livro;
import br.ufba.es.trabalho.biblioteca.domain.enums.ExemplarStatus;
import br.ufba.es.trabalho.biblioteca.users.User;

import java.util.List;
import java.util.Optional;

public class DevolucaoCommand implements Command {

    @Override
    public void execute(CarregadorParametros carregadorParametros) {
        int codeUsuario = Integer.parseInt(carregadorParametros.getParametroUm());
        int codeLivro = Integer.parseInt(carregadorParametros.getParametroDois());

        BibliotecaDados dados = BibliotecaDados.getInstance();
        Optional<User> userOpt = dados.findUserById(codeUsuario);
        Optional<Livro> livroOpt = dados.findBookById(codeLivro);

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
            if (exemplar.getEmprestimoAtual().getUsuario().equals(user)) {
                // Se existir, finaliza o emprestimo e imprime mensagem de sucesso
                exemplar.setStatus(ExemplarStatus.DISPONIVEL);
                Emprestimo emprestimoAtual  = exemplar.getEmprestimoAtual();
                user.removerEmprestimo(emprestimoAtual);
                System.out.println("Devolução realizada com sucesso por " + user.getName() + " - Livro: " + livro.getTitle());
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

