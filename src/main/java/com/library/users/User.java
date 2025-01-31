package main.java.com.library.users;

import main.java.com.library.domain.Emprestimo;
import main.java.com.library.domain.Reserva;
import main.java.com.library.policies.PoliticaEmprestimo;

import java.util.ArrayList;
import java.util.List;


public interface User {
    List<Emprestimo> emprestimos = new ArrayList<Emprestimo>();
    List<Reserva> reservas = new ArrayList<Reserva>();

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
}
 