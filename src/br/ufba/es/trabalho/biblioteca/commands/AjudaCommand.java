package br.ufba.es.trabalho.biblioteca.commands;

import br.ufba.es.trabalho.biblioteca.app.CarregadorParametros;
import br.ufba.es.trabalho.biblioteca.app.CommandFactory;

import java.util.Map;

public class AjudaCommand implements Command{
    @Override
    public void execute(CarregadorParametros carregadorParametros) {

        var commands = CommandFactory.getCommands();

        System.out.println("Comandos disponíveis:");

        for (Map.Entry<String, Command> entry : commands.entrySet()) {
            System.out.println("  - " + entry.getKey() + ": " + entry.getValue().getDescription());
        }

    }

    @Override
    public String getDescription() {
        return "Mostra os comandos disponíveis";
    }
}
