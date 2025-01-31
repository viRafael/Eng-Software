package main.java.com.library.commands;

import main.java.com.library.app.CarregadorParametros;
import main.java.com.library.repository.BibliotecaDados;
import main.java.com.library.users.User;

public class ConsultaNotificacoesCommand implements Command {
    @Override
    public void execute(CarregadorParametros carregadorParametros) {
        int codigoUser = Integer.parseInt(carregadorParametros.getParametroUm());

        BibliotecaDados dados = BibliotecaDados.getInstance();
        User professor = dados.findUserById(codigoUser);

        if (professor == null) {
            System.out.println("Consulta cancelada: Usuário inexistente.");
            return;
        }

        // TODO: Implementar a lógica de notificações
    }
}
