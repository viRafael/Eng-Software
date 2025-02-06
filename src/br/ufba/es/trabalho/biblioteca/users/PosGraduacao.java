package br.ufba.es.trabalho.biblioteca.users;

import br.ufba.es.trabalho.biblioteca.domain.Emprestimo;
import br.ufba.es.trabalho.biblioteca.domain.Reserva;
import br.ufba.es.trabalho.biblioteca.policies.PoliticaEmprestimo;
import br.ufba.es.trabalho.biblioteca.policies.PosGraduacaoPoliticaEmprestimo;

import java.util.List;

public class PosGraduacao implements User {
    private int code;
    private String name;

    private final PoliticaEmprestimo politicaEmprestimo = new PosGraduacaoPoliticaEmprestimo();

    // Métodos Construtor
    public PosGraduacao(int code, String name) {
        this.code = code;
        this.name = name;
    }

    // Métodos Utilitários
    @Override
    public boolean temEspacoParaLivro() {
        if(emprestimos.size() >= 3){
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
    
    // Métodos add e remove
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
}