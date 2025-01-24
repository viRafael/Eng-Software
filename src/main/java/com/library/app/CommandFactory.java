package main.java.com.library.app;

import main.java.com.library.commands.*;

public class CommandFactory {

    public static Command getCommand(String cmd) {
        return switch (cmd) {
            case "emp" -> new EmprestimoCommand();
            case "dev" -> new DevolucaoCommand();
            case "res" -> new ReservaCommand();
            case "obs" -> new ObservacaoCommand();
            case "liv" -> new ConsultaLivroCommand();
            case "usu" -> new ConsultaUsuarioCommand();
            case "ntf" -> new ConsultaNotificacoesCommand();
            case "sai" -> new SairCommand();
            default -> null;
        };
    }
}

