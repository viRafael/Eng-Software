package br.ufba.es.trabalho.biblioteca.commands;

import br.ufba.es.trabalho.biblioteca.repository.BibliotecaDados;
import br.ufba.es.trabalho.biblioteca.app.CarregadorParametros;
import br.ufba.es.trabalho.biblioteca.domain.Emprestimo;
import br.ufba.es.trabalho.biblioteca.domain.Exemplar;
import br.ufba.es.trabalho.biblioteca.domain.Livro;
import br.ufba.es.trabalho.biblioteca.domain.enums.ExemplarStatus;
import br.ufba.es.trabalho.biblioteca.users.User;

import java.util.List;

public class DevolucaoCommand implements Command {

    @Override
    public void execute(CarregadorParametros carregadorParametros) {
        int codeUsuario = Integer.parseInt(carregadorParametros.getParametroUm());
        int codeLivro = Integer.parseInt(carregadorParametros.getParametroDois());

        BibliotecaDados dados = BibliotecaDados.getInstance();
        User user = dados.findUserById(codeUsuario);
        Livro livro = dados.findBookById(codeLivro);

        // Verifica se o usuário e o livro existem
        if (user == null || livro == null) {
            System.out.println("Devolução não realizada: Usuário ou livro inexistente.");
            return;
        }

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
}

