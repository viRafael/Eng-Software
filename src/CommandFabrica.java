import command.ConsultaLivroCommand;
import command.ConsultaNotificacoesCommand;
import command.ConsultaUsuarioCommand;
import command.DevolucaoCommand;
import command.EmprestimoCommand;
import command.ICommand;
import command.ObservacaoCommand;
import command.ReservaCommand;
import command.SairCommand;

public class CommandFabrica {
    public static ICommand getCommand(String command) {
        switch (command) {
            case "emp":
                return new EmprestimoCommand();
            case "dev":
                return new DevolucaoCommand();
            case "res":
                return new ReservaCommand();
            case "obs":
                return new ObservacaoCommand();
            case "liv":
                return new ConsultaLivroCommand();
            case "usu":
                return new ConsultaUsuarioCommand();
            case "ntf":
                return new ConsultaNotificacoesCommand();
            case "sai":
                return new SairCommand();
            default:
                return null;
        }
    }
}
