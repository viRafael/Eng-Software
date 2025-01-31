package main.java.com.library.observer;

import main.java.com.library.domain.Livro;

public interface Observer {
    void update(Livro livro);
}