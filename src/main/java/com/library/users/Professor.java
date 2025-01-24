package main.java.com.library.users;

import main.java.com.library.domain.Book;
import main.java.com.library.observer.Observer;
import main.java.com.library.policies.ProfessorLoanPolicy;
import main.java.com.library.policies.LoanPolicy;


public class Professor extends User implements Observer {
    private LoanPolicy loanPolicy = new ProfessorLoanPolicy();
    private int notificationCount = 0;

    public Professor(int code, String name) {
        super(code, name);
    }

    @Override
    public LoanPolicy getLoanPolicy() {
        return loanPolicy;
    }

    // Implementação do métodos do Observer
    @Override
    public void update(Book book) {
        notificationCount++;
        // Exemplo de log ou mensagem:
        // System.out.println("Professor " + name + " notificado sobre reservas do livro: " + book.getTitle());
    }

    public int getNotificationCount() {
        return notificationCount;
    }
}