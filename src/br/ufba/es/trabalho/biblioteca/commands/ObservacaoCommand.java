package br.ufba.es.trabalho.biblioteca.commands;

import br.ufba.es.trabalho.biblioteca.app.CarregadorParametros;
import br.ufba.es.trabalho.biblioteca.domain.Livro;
import br.ufba.es.trabalho.biblioteca.observer.BookObserver;
import br.ufba.es.trabalho.biblioteca.repository.BibliotecaDados;
import br.ufba.es.trabalho.biblioteca.utils.Validador;

public class ObservacaoCommand implements Command {
    @Override
    public void execute(CarregadorParametros carregadorParametros) {
        var userOpt = Validador.getUserFromCode(carregadorParametros.getParametroUm());
        var livroOpt = Validador.getBookFromCode(carregadorParametros.getParametroDois());

        if (userOpt.isEmpty()) {
            System.out.println("Código do usuário informado é incorreto!");
            return;
        }
        if (livroOpt.isEmpty()) {
            System.out.println("Código do livro informado é incorreto!");
            return;
        }

        var user = userOpt.get();
        var livro = livroOpt.get();

        livro.registerObserver(user);

        System.out.println("Usuário " + user.getCode() + " agora será notificado das reservas do livro " + livro.getCode() + "!");
    }

    @Override
    public String getDescription() {
        return "Faz o usuário receber notificacoes quando um livro for reservado mais que duas vezes";
    }
}
