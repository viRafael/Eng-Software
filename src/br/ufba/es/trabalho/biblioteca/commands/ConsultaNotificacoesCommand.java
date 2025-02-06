package br.ufba.es.trabalho.biblioteca.commands;

import br.ufba.es.trabalho.biblioteca.repository.BibliotecaDados;
import br.ufba.es.trabalho.biblioteca.app.CarregadorParametros;
import br.ufba.es.trabalho.biblioteca.users.User;

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
