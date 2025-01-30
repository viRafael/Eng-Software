package main.java.com.library.repository;

import main.java.com.library.users.User;
import main.java.com.library.domain.Book;

import java.util.ArrayList;
import java.util.List;

public class BibliotecaDados {
    private static BibliotecaDados instance;

    private List<User> users;
    private List<Book> books;

    // Métodos Construtor
    private BibliotecaDados() {
        this.users = new ArrayList<>();
        this.books = new ArrayList<>();
    }

    // Métodos Utilitários
    public User findUserById(int userId) {
        for (User user : this.users) {
            if (user.getCode() == userId){
                return user;
            }
        }
        return null;
    }

    public Book findBookById(int bookId) {
        for (Book book : this.books) {
            if (book.getCode() == bookId){
                return book;
            }
        }
        return null;
    }

    // Métodos GET e SET
    public static BibliotecaDados getInstance() {
        if (instance == null) {
            instance = new BibliotecaDados();
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

