package br.ufba.es.trabalho.biblioteca.commands;

import br.ufba.es.trabalho.biblioteca.repository.BibliotecaDados;
import br.ufba.es.trabalho.biblioteca.app.CarregadorParametros;
import br.ufba.es.trabalho.biblioteca.users.User;
import br.ufba.es.trabalho.biblioteca.utils.Validador;

import java.util.Optional;

public class ConsultaNotificacoesCommand implements Command {
    @Override
    public void execute(CarregadorParametros carregadorParametros) {
        var codigoUserOpt = Validador.toInteger(carregadorParametros.getParametroUm());

        if (codigoUserOpt.isEmpty()) {
            System.out.println("Informe o número do código do usuário!");
            return;
        }

        int codigoUser = codigoUserOpt.get();

        BibliotecaDados dados = BibliotecaDados.getInstance();
        Optional<User> professorOpt = dados.findUserById(codigoUser);

        if (professorOpt.isEmpty()) {
            System.out.println("Consulta cancelada: Usuário inexistente.");
            return;
        }
        User professor = professorOpt.get();

        // TODO: Implementar a lógica de notificações
    }

    @Override
    public String getDescription() {
        return "Consulta as notificacoes de um usuário";
    }
}
