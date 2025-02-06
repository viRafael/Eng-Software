package br.ufba.es.trabalho.biblioteca.commands;

import br.ufba.es.trabalho.biblioteca.app.CarregadorParametros;

public class SairCommand implements Command {
    @Override
    public void execute(CarregadorParametros carregadorParametros) {
        System.out.println("Comando saída, encerrando o sistema...");
        System.exit(0);
    }
}
