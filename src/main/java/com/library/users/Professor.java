package main.java.com.library.users;

import main.java.com.library.domain.Livro;
import main.java.com.library.domain.Emprestimo;
import main.java.com.library.domain.Reserva;
import main.java.com.library.observer.Observer;
import main.java.com.library.policies.ProfessorPoliticaEmprestimo;
import main.java.com.library.policies.PoliticaEmprestimo;

import java.util.List;


public class Professor implements User, Observer {
    private int code;
    private String name;

    private PoliticaEmprestimo politicaEmprestimo = new ProfessorPoliticaEmprestimo();
    private int notificationCount = 0;

    // Métodos Construtor
    public Professor(int code, String name) {
        this.code = code;
        this.name = name;
    }

    //Métodos Utilitários
    @Override
    public boolean temEspacoParaLivro() {
        return true;
    }

    @Override
    public boolean isDevedor() {
        for (Emprestimo emprestimo : emprestimos) {
            if (emprestimo.estaAtrasado()) {
                return true;
            }
        }
        return false;
    }

    // Métotod add e remove
    @Override
    public void addEmprestimo(Emprestimo loan) {
        emprestimos.add(loan);
    }

    public void removerEmprestimo(Emprestimo loan) {
        emprestimos.remove(loan);
    }

    @Override
    public void addReserva(Reserva reserva) {
        reservas.add(reserva);
    }
    
    // Métodos GET
    @Override
    public List<Emprestimo> getEmprestimos() {
        return emprestimos;
    }

    @Override
    public List<Reserva> getReservas() {
        return reservas;
    }

    @Override
    public PoliticaEmprestimo getPoliticaEmprestimo() {
        return politicaEmprestimo;
    }

    @Override
    public int getCode() {
        return this.code;
    }

    @Override
    public String getName() {
        return this.name;
    }

    public int getNotificationCount() {
        return notificationCount;
    }

    // Implementação do método do Observer
    @Override
    public void update(Livro livro) {
        notificationCount++;
    }
}