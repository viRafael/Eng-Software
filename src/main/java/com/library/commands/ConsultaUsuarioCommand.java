package main.java.com.library.commands;

import main.java.com.library.app.CarregadorParametros;
import main.java.com.library.domain.Emprestimo;
import main.java.com.library.domain.Reserva;
import main.java.com.library.repository.BibliotecaDados;
import main.java.com.library.users.User;

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
}