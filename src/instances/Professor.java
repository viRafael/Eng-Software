package instances;

import interfaces.ILoanPolicy;
import interfaces.Observer;

public class Professor extends User implements Observer {
    private ILoanPolicy loanPolicy =  new ProfessorLoanPolicy();
    private int notificationCount = 0;

    public Professor(int code, String name) {
        super(code, name);
    }

    @Override
    public ILoanPolicy getLoanPolicy() {
        return loanPolicy;
    }

    // Implementação do método do Observer
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
