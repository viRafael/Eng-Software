package br.ufba.es.trabalho.biblioteca.repository;

import br.ufba.es.trabalho.biblioteca.domain.Livro;
import br.ufba.es.trabalho.biblioteca.users.User;

import java.util.ArrayList;
import java.util.List;

public class BibliotecaDados {
    private static BibliotecaDados instance;

    private List<User> users;
    private List<Livro> livros;

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

    // Métodos add
    public void addUsuarios(User user) {
        this.users.add(user);
    }

    public void addLivro(Livro livro) {
        this.livros.add(livro);
    }


    // Métodos GET e SET
    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

    public List<Livro> getLivros() {
        return livros;
    }
}

