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
    public int getCode() {
        return codeExemplar;
    }

    public ExemplarStatus getStatus() {
        return status;
    }

    public boolean isDisponivel() {
        return status == ExemplarStatus.DISPONIVEL;
    }

    public Livro getBook() {
        return livro;
    }

    public Emprestimo getEmprestimoAtual() {
        return emprestimoAtual;
    }

    public void setStatus(ExemplarStatus status) {
        this.status = status;
    }

    public void setEmprestimoAtual(Emprestimo Loan) {
        this.emprestimoAtual = Loan;
    }
}
