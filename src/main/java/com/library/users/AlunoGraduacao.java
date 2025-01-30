package main.java.com.library.users;

import main.java.com.library.domain.Emprestimo;
import main.java.com.library.domain.Reserva;
import main.java.com.library.policies.PoliticaEmprestimo;
import main.java.com.library.policies.GraduacaoPoliticaEmprestimo;

import java.util.List;

public class AlunoGraduacao implements User {
    private int code;
    private String name;

    private PoliticaEmprestimo politicaEmprestimo = new GraduacaoPoliticaEmprestimo();

    //Métodos Construtor
    public AlunoGraduacao(int code, String name) {
        this.code = code;
        this.name = name;
    }

    // Métodos Utilitários
    @Override
    public boolean temEspacoParaLivro() {
        if(emprestimos.size() >= 5) {
            return false;
        }
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

    // Métodos GET e SET
    @Override
    public void addEmprestimo(Emprestimo loan) {
        emprestimos.add(loan);
    }

    @Override
    public void addReserva(Reserva reserva) {
        reservas.add(reserva);
    }

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
}
