package main.java.com.library.commands;

import main.java.com.library.app.CarregadorParametros;
import main.java.com.library.domain.Book;
import main.java.com.library.domain.Reserva;
import main.java.com.library.repository.BibliotecaDados;
import main.java.com.library.users.User;

import java.time.LocalDate;

public class ReservaCommand implements Command {
    @Override
    public void execute(CarregadorParametros carregadorParametros) {
        int userId = Integer.parseInt(carregadorParametros.getParametroUm());
        int bookId = Integer.parseInt(carregadorParametros.getParametroDois());

        BibliotecaDados data = BibliotecaDados.getInstance();
        User user = data.findUserById(userId);
        Book book = data.findBookById(bookId);

        if (user == null || book == null) {
            System.out.println("Reserva não realizada: Usuário ou livro inexistente.");
            return;
        }

        if (user.getReservas().size() >= 3) {
            System.out.println("Reserva não realizada: Limite de reservas simultâneas atingido.");
            return;
        }

        Reserva reserva = new Reserva(user, book);
        user.addReserva(reserva);
        book.addReservation(reserva);

        System.out.println("Reserva realizada com sucesso por " + user.getName() + " - Livro: " + book.getTitle());
    }
}
