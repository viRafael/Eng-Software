package main.java.com.library.domain;

import main.java.com.library.domain.enums.ExemplarStatus;

public class Exemplar {
    private int codeExemplar;
    private ExemplarStatus status;
    private Livro livro;
    private Emprestimo emprestimoAtual; // se estiver emprestado

    public Exemplar(int codeExemplar, Livro livro) {
        this.codeExemplar = codeExemplar;
        this.livro = livro;
        this.status = ExemplarStatus.DISPONIVEL;
    }

    //Métodos GET e SET
    public boolean isDisponivel() {
        return status == ExemplarStatus.DISPONIVEL;
    }

    public int getCode() {
        return codeExemplar;
    }

    public ExemplarStatus getStatus() {
        return status;
    }

    public Livro getBook() {
        return livro;
    }

    public Emprestimo getEmprestimoAtual() {
        return emprestimoAtual;
    }

    public void setStatus(ExemplarStatus exemplarStatus) {
        this.status = exemplarStatus;
    }

    public void setEmprestimoAtual(Emprestimo loan) {
        this.emprestimoAtual = loan;
    }
}