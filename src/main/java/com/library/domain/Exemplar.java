package main.java.com.library.domain;

import main.java.com.library.domain.enums.ExemplarStatus;

public class Exemplar {
    private int codeExemplar;
    private ExemplarStatus status;
    private Book book;
    private Loan currentLoan; // se estiver emprestado

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

    public Book getBook() {
        return book;
    }

    public Loan getCurrentLoan() {
        return currentLoan;
    }

    public void setStatus(ExemplarStatus status) {
        this.status = status;
    }

    public void setCurrentLoan (Loan Loan) {
        this.currentLoan = Loan;
    }
}
