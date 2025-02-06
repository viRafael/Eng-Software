package br.ufba.es.trabalho.biblioteca.commands;

import br.ufba.es.trabalho.biblioteca.repository.BibliotecaDados;
import br.ufba.es.trabalho.biblioteca.app.CarregadorParametros;
import br.ufba.es.trabalho.biblioteca.domain.Emprestimo;
import br.ufba.es.trabalho.biblioteca.domain.Reserva;
import br.ufba.es.trabalho.biblioteca.users.User;

public class ConsultaUsuarioCommand implements Command {
    @Override
    public void execute(CarregadorParametros carregadorParametros) {
        int codigoUser = Integer.parseInt(carregadorParametros.getParametroUm());

        BibliotecaDados dados = BibliotecaDados.getInstance();
        User user = dados.findUserById(codigoUser);

        // Verifica se o usuário e o livro existem
        if (user == null) {
            System.out.println("Empréstimo não realizado: Usuário inexistente.");
            return;
        }

        // Imprime os empréstimos e reservas do usuário
        int contadorEmprestimos = 0;
        for (Emprestimo emprestimo : user.getEmprestimos()) {
            System.out.println("Emprestimo " + (++contadorEmprestimos));
            System.out.println("Livro: " + emprestimo.getExemplar().getBook().getTitle());
            System.out.println("Data de emprestimo: " + emprestimo.getDataEmprestimo());
            System.out.println("Data de entrega: " + emprestimo.getDataDevolucao());
        }

        int contadorReservas = 0;
        for (Reserva reserva : user.getReservas()) {
            System.out.println("Emprestimo " + (++contadorReservas));
            System.out.println("Livro: " + reserva.getBook().getTitle());
            System.out.println("Data de reserva: " + reserva.getDate());
        }
    }

    @Override
    public String getDescription() {
        return "Consulta o estado de um usuário";
    }
}