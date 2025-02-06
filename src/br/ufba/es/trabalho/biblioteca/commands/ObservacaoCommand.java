package br.ufba.es.trabalho.biblioteca.commands;

import br.ufba.es.trabalho.biblioteca.app.CarregadorParametros;

public class ObservacaoCommand implements Command {
    @Override
    public void execute(CarregadorParametros carregadorParametros) {
        // TODO: Implementar método
    }

    @Override
    public String getDescription() {
        return "Faz o usuário receber notificacoes quando um livro for reservado mais que duas vezes";
    }
}
