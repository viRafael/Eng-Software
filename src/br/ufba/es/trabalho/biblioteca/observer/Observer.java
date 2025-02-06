package br.ufba.es.trabalho.biblioteca.observer;

import br.ufba.es.trabalho.biblioteca.domain.Livro;

public interface Observer {
    void update(Livro livro);
}