package br.ufba.es.trabalho.biblioteca.commands;

import br.ufba.es.trabalho.biblioteca.app.CarregadorParametros;

public interface Command {
    void execute(CarregadorParametros carregadorParametros);

}

