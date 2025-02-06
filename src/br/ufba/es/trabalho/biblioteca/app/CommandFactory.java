package br.ufba.es.trabalho.biblioteca.app;

import br.ufba.es.trabalho.biblioteca.commands.*;

import java.util.Map;

public class CommandFactory {

    private static final Map<String, Command> commands = Map.of(
            "emp", new EmprestimoCommand(),
            "dev", new DevolucaoCommand(),
            "res", new ReservaCommand(),
            "obs", new ObservacaoCommand(),
            "liv", new ConsultaLivroCommand(),
            "usu", new ConsultaUsuarioCommand(),
            "ntf", new ConsultaNotificacoesCommand(),
            "sai", new SairCommand(),
            "ajuda", new AjudaCommand()
    );

    public static Command getCommand(String cmd) {
        return commands.get(cmd);
    }

    public static Map<String, Command> getCommands() {
        return commands;
    }

}

