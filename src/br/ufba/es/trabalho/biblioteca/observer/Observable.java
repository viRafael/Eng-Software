package br.ufba.es.trabalho.biblioteca.observer;

public interface Observable {
    void adicionarObserver(Observer observer);
    void removerObserver(Observer observer);
    void notificarObservers();
}
