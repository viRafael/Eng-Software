package main.java.com.library.repository;

import main.java.com.library.users.User;
import main.java.com.library.domain.Book;

import java.util.ArrayList;
import java.util.List;

public class LibraryData {
    private static LibraryData instance;

    private List<User> users;
    private List<Book> books;

    private LibraryData() {
        this.users = new ArrayList<>();
        this.books = new ArrayList<>();
    }

    // Métodos Utilitários
    public User findUserById(int userId) {
        // TODO
        return null;
    }

    public Book findBookById(int bookId) {
        // TODO
        return null;
    }

    // Métodos GET e SET
    public LibraryData getInstance() {
        if (instance == null) {
            instance = new LibraryData();
        }
        return instance;
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

    public List<Book> getBooks() {
        return books;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }
}

