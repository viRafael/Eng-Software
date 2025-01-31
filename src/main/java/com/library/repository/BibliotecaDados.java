package main.java.com.library.repository;

import main.java.com.library.domain.Emprestimo;
import main.java.com.library.domain.Livro;
import main.java.com.library.domain.Reserva;
import main.java.com.library.users.User;

import java.util.ArrayList;
import java.util.List;

public class BibliotecaDados {
    private static BibliotecaDados instance;

    private List<User> users;
    private List<Livro> livros;
    private List<Emprestimo> emprestimos;
    private List<Reserva> reservas;

    // Métodos Construtor
    private BibliotecaDados() {
        this.users = new ArrayList<>();
        this.livros = new ArrayList<>();
    }

    public static BibliotecaDados getInstance() {
        if (instance == null) {
            instance = new BibliotecaDados();
        }
        return instance;
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

    public Livro findBookById(int bookId) {
        for (Livro livro : this.livros) {
            if (livro.getCode() == bookId){
                return livro;
            }
        }
        return null;
    }

    // Métodos GET e SET
    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

    public List<Livro> getBooks() {
        return livros;
    }

    public void setBooks(List<Livro> livros) {
        this.livros = livros;
    }

    public List<Emprestimo> getEmprestimos() {
        return emprestimos;
    }

    public List<Reserva> getReservas() {
        return reservas;
    }
}

