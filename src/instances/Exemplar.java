package instances;

import enumeradores.EExemplarStatus;

public class Exemplar {
    private int codeExemplar;
    private EExemplarStatus status; 
    private Book book;
    private Loan currentLoan; 

    public Exemplar(int codeExemplar, Book book) {
        this.codeExemplar = codeExemplar;
        this.book = book;
        this.status = EExemplarStatus.DISPONIVEL;
    }

    // getters e setters

}
