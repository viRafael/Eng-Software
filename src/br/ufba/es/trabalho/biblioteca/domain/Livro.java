package br.ufba.es.trabalho.biblioteca.domain;

import br.ufba.es.trabalho.biblioteca.observer.BookObserver;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class Livro {
    // Atributos
    private int code;
    private String title;
    private String publisher;
    private List<String> authors;
    private int edition;
    private int year;

    private List<Exemplar> exemplars;
    private List<Reserva> reservas;
    private List<BookObserver> observers;

    // Métodos CONSTRUTOR
    public Livro(int code, String title, String publisher, List<String> authors, int edition, int year) {
        this.code = code;
        this.title = title;
        this.authors = authors;
        this.edition = edition;
        this.year = year;
        this.exemplars = new ArrayList<>();
        this.reservas = new ArrayList<>();
        this.observers = new ArrayList<>();
    }

    // Métodos Utilitários
    public Stream<Exemplar> exemplaresDisponiveis() {
        return this.exemplars.stream().filter(Exemplar::isDisponivel);
    }

    // Métodos de Observer
    public void registerObserver(BookObserver obs) {
        observers.add(obs);
    }

    public void removeObserver(BookObserver obs) {
        observers.remove(obs);
    }

    private void notifyObservers() {
        for (BookObserver obs : observers) {
            obs.onBookUpdate(this);
        }
    }

    // Métodos add
    public void addReserva(Reserva r) {
        this.reservas.add(r);
        notifyObservers();
    }

    public void addExemplar(Exemplar exemplar) {
        this.exemplars.add(exemplar);
    }

    // Métodos GET e SET
    public int getCode() {
        return code;
    }

    public String getTitle() {
        return title;
    }

    public List<Reserva> getReservas() {
        return reservas;
    }

    public List<Exemplar> getExemplares() {
        return exemplars;
    }
}

