package main.java.com.library.domain;

import main.java.com.library.observer.Observer;

import java.util.ArrayList;
import java.util.List;

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
    private List<Observer> observers;

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
    public List<Exemplar> findAvailableExemplar() {
        List<Exemplar> exemplaresDisponiveis = new ArrayList<>();
        for(Exemplar exemplar : exemplars) {
            if(exemplar.isDisponivel()){
                exemplaresDisponiveis.add(exemplar);
            }
        }
        return exemplaresDisponiveis;
    }

    // Métodos de Observer
    public void registerObserver(Observer obs) {
        observers.add(obs);
    }

    public void removeObserver(Observer obs) {
        observers.remove(obs);
    }

    // Chamado quando se faz uma nova reserva
    public void checkNotify() {
        if (reservas.size() > 2) {
            notifyObservers();
        }
    }

    private void notifyObservers() {
        for (Observer obs : observers) {
            obs.update(this);
        }
    }

    public void addReserva(Reserva r) {
        this.reservas.add(r);
        checkNotify();
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

