package main.java.com.library.domain;

import main.java.com.library.users.User;

import java.time.LocalDate;

public class Reservation {
    private User user;
    private Book book;
    private LocalDate date;

    public Reservation(User user, Book book, LocalDate date) {
        this.user = user;
        this.book = book;
        this.date = date;
    }

    // Métodos GET
    public User getUser() {
        return user;
    }

    public Book getBook() {
        return book;
    }

    public LocalDate getDate() {
        return date;
    }
}
