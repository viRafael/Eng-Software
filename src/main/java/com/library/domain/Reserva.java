package main.java.com.library.domain;

import main.java.com.library.users.User;

import java.time.LocalDate;

public class Reserva {
    private User user;
    private Book book;
    private LocalDate dataReserva;

    public Reserva(User user, Book book) {
        this.user = user;
        this.book = book;
        this.dataReserva = LocalDate.now();
    }

    // Métodos GET
    public User getUser() {
        return user;
    }

    public Book getBook() {
        return book;
    }

    public LocalDate getDate() {
        return dataReserva;
    }
}
