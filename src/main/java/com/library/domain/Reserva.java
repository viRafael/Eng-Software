package main.java.com.library.domain;

import main.java.com.library.users.User;

import java.time.LocalDate;

public class Reserva {
    private User user;
    private Livro livro;
    private LocalDate dataReserva;

    public Reserva(User user, Livro livro) {
        this.user = user;
        this.livro = livro;
        this.dataReserva = LocalDate.now();
    }

    // Métodos GET
    public User getUser() {
        return user;
    }

    public Livro getBook() {
        return livro;
    }

    public LocalDate getDate() {
        return dataReserva;
    }
}
