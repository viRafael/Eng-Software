package main.java.com.library.domain;

import main.java.com.library.observer.Observer;

import java.util.ArrayList;
import java.util.List;

public class Book {
    // Atributos
    private int code;
    private String title;
    private String publisher;
    private List<String> authors;
    private int edition;
    private int year;

    private List<Exemplar> exemplars;
    private List<Reservation> reservations;
    private List<Observer> observers;

    // Métodos CONSTRUTOR
    public Book(int code, String title, String publisher, List<String> authors, int edition, int year) {
        this.code = code;
        this.title = title;
        this.authors = authors;
        this.edition = edition;
        this.year = year;
        this.exemplars = new ArrayList<>();
        this.reservations = new ArrayList<>();
        this.observers = new ArrayList<>();
    }

    // Métodos Utilitários
    public void registerObserver(Observer obs) {
        observers.add(obs);
    }

    public void removeObserver(Observer obs) {
        observers.remove(obs);
    }

    // Chamado quando se faz uma nova reserva
    public void checkNotify() {
        if (reservations.size() > 2) {
            notifyObservers();
        }
    }

    private void notifyObservers() {
        for (Observer obs : observers) {
            obs.update(this);
        }
    }

    public void addReservation(Reservation r) {
        this.reservations.add(r);
        checkNotify();
    }

    // Métodos GET e SET
    public int getCode() {
        return code;
    }

    public String getTitle() {
        return title;
    }

    public List<Reservation> getReservations() {
        return reservations;
    }

    public List<Exemplar> getExemplars() {
        return exemplars;
    }
}

