package br.ufba.es.trabalho.biblioteca.users;

import br.ufba.es.trabalho.biblioteca.domain.Emprestimo;
import br.ufba.es.trabalho.biblioteca.domain.Livro;
import br.ufba.es.trabalho.biblioteca.domain.Reserva;
import br.ufba.es.trabalho.biblioteca.observer.BookObserver;
import br.ufba.es.trabalho.biblioteca.policies.PoliticaEmprestimo;

import java.util.ArrayList;
import java.util.List;


public interface User extends BookObserver {
    List<Emprestimo> emprestimos = new ArrayList<Emprestimo>();
    List<Reserva> reservas = new ArrayList<Reserva>();
    List<String> notificacoes = new ArrayList<>();

    // Métodos Utilitarios
    public boolean temEspacoParaLivro();

    public boolean isDevedor();

    // Métodos GET e SET
    public void addEmprestimo(Emprestimo loan);

    public void removerEmprestimo(Emprestimo loan);

    public void addReserva(Reserva reserva);

    public List<Emprestimo> getEmprestimos();

    public List<Reserva> getReservas();

    public PoliticaEmprestimo getPoliticaEmprestimo();

    public int getCode();

    public String getName();

    public String getTipoUsuario();

    public default void adicionarNotificacao(String notificacao) {
        notificacoes.add(notificacao);
    }

    public default List<String> getNotificacoes() {
        return notificacoes;
    }

    @Override
    default void onBookUpdate(Livro livro) {
        // Não faz nada por padrão...
    }
}
 