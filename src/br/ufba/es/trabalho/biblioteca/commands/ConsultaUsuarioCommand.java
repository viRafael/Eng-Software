package br.ufba.es.trabalho.biblioteca.commands;

import br.ufba.es.trabalho.biblioteca.repository.BibliotecaDados;
import br.ufba.es.trabalho.biblioteca.app.CarregadorParametros;
import br.ufba.es.trabalho.biblioteca.domain.Emprestimo;
import br.ufba.es.trabalho.biblioteca.domain.Reserva;
import br.ufba.es.trabalho.biblioteca.users.User;
import br.ufba.es.trabalho.biblioteca.utils.Validador;

import java.util.Optional;

public class ConsultaUsuarioCommand implements Command {
    @Override
    public void execute(CarregadorParametros carregadorParametros) {
        var codigoUserOpt = Validador.toInteger(carregadorParametros.getParametroUm());
        if (codigoUserOpt.isEmpty()) {
            System.out.println("Código do usuário passado é inválido!");
            return;
        }
        Integer codigoUser = codigoUserOpt.get();

        BibliotecaDados dados = BibliotecaDados.getInstance();
        Optional<User> userOpt = dados.findUserById(codigoUser);

        // Verifica se o usuário e o livro existem
        if (userOpt.isEmpty()) {
            System.out.println("Empréstimo não realizado: Usuário inexistente.");
            return;
        }
        User user = userOpt.get();

        System.out.println("Código: " + user.getCode());
        System.out.println("Nome: " + user.getName());
        System.out.println("Tipo de usuário: " + user.getTipoUsuario());

        // Imprime os empréstimos e reservas do usuário
        System.out.println("Empréstimos do usuário: ");
        if (!user.getEmprestimos().isEmpty()) {
            int contadorEmprestimos = 0;
            for (Emprestimo emprestimo : user.getEmprestimos()) {
                System.out.println("Emprestimo " + (++contadorEmprestimos));
                System.out.println("Livro: " + emprestimo.getExemplar().getBook().getTitle());
                System.out.println("Data de emprestimo: " + emprestimo.getDataEmprestimo());
                System.out.println("Data de entrega: " + emprestimo.getDataDevolucao());
            }
        } else {
            System.out.println("  - Usuário não tem empréstimos");
        }

        System.out.println("Reservas do usuário: ");
        if (!user.getReservas().isEmpty()) {
            for (Reserva reserva : user.getReservas()) {
                int contadorReservas = 0;
                System.out.println("Emprestimo " + (++contadorReservas));
                System.out.println("Livro: " + reserva.getBook().getTitle());
                System.out.println("Data de reserva: " + reserva.getDate());
            }
        } else {
            System.out.println("  - Usuário não tem reservas");
        }
    }

    @Override
    public String getDescription() {
        return "Consulta o estado de um usuário";
    }
}