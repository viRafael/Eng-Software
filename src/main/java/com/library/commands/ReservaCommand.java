package main.java.com.library.commands;

import main.java.com.library.app.CarregadorParametros;
import main.java.com.library.domain.Book;
import main.java.com.library.domain.Reservation;
import main.java.com.library.domain.User;
import main.java.com.library.repository.LibraryData;

import java.time.LocalDate;

public class ReservaCommand implements Command {
    @Override
    public void execute(CarregadorParametros carregadorParametros) {
        int userId = Integer.parseInt(carregadorParametros.getParametroUm());
        int bookId = Integer.parseInt(carregadorParametros.getParametroDois());

        LibraryData data = LibraryData.getInstance();
        User user = data.findUserById(userId);
        Book book = data.findBookById(bookId);

        if (user == null || book == null) {
            System.out.println("Reserva não realizada: Usuário ou livro inexistente.");
            return;
        }

        if (user.getReservations().size() >= 3) {
            System.out.println("Reserva não realizada: Limite de reservas simultâneas atingido.");
            return;
        }

        Reservation reservation = new Reservation(user, book, LocalDate.now());
        user.addReservation(reservation);
        book.addReservation(reservation);

        System.out.println("Reserva realizada com sucesso por " + user.getName() + " - Livro: " + book.getTitle());
    }
}
