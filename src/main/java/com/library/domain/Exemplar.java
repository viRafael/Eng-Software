package main.java.com.library.domain;

import main.java.com.library.domain.enums.ExemplarStatus;

public class Exemplar {
    private int codeExemplar;
    private ExemplarStatus status;
    private Book book;
    private Emprestimo currentLoan; // se estiver emprestado

    public Exemplar(int codeExemplar, Book book) {
        this.codeExemplar = codeExemplar;
        this.book = book;
        this.status = ExemplarStatus.DISPONIVEL;
    }

    //Métodos GET e SET
    public int getCodeExemplar() {
        return codeExemplar;
    }

    public ExemplarStatus getStatus() {
        return status;
    }

    public boolean isDisponivel() {
        return status == ExemplarStatus.DISPONIVEL;
    }

    public Book getBook() {
        return book;
    }

    public Emprestimo getCurrentLoan() {
        return currentLoan;
    }

    public void setStatus(ExemplarStatus status) {
        this.status = status;
    }

    public void setCurrentLoan (Emprestimo Loan) {
        this.currentLoan = Loan;
    }
}
