package main.java.com.library.commands;

import main.java.com.library.app.CarregadorParametros;
import main.java.com.library.domain.Emprestimo;
import main.java.com.library.domain.Exemplar;
import main.java.com.library.domain.Livro;
import main.java.com.library.domain.enums.ExemplarStatus;
import main.java.com.library.users.User;
import main.java.com.library.repository.BibliotecaDados;

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
            if (exemplar.getEmprestimoAtual().getUser().equals(user)) {
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

