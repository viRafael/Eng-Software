package command;

import instances.Book;
import instances.Exemplar;
import instances.Loan;
import instances.User;
import LibraryData;

public class EmprestimoCommand implements ICommand {
    @Override
    public void execute(String[] args) {
        // args[1] = userId, args[2] = bookId
        int userId = Integer.parseInt(args[1]);
        int bookId = Integer.parseInt(args[2]);

        LibraryData data = LibraryData.getInstance();
        User user = data.findUserById(userId);
        Book book = data.findBookById(bookId);

        if (user == null || book == null) {
            System.out.println("Empréstimo não realizado: Usuário ou livro inexistente.");
            return;
        }

        // Verifica, via LoanPolicy, se pode emprestar
        LoanPolicy policy = user.getLoanPolicy();
        boolean canLoan = policy.canLoan(user, book);
        if (!canLoan) {
            System.out.println("Empréstimo não realizado para " + user.getName() + 
                               ": Regras de empréstimo não atendidas.");
            return;
        }

        // Cria o Loan
        LocalDate start = LocalDate.now();
        LocalDate due = policy.calcDueDate(start);
        // encontra um exemplar disponível, se existir
        Exemplar exemplar = // ... localizar exemplar DISPONIVEL do book
        if (exemplar == null) {
            System.out.println("Empréstimo não realizado: Não há exemplares disponíveis.");
            return;
        }

        // Cancela reserva, se o usuário já tinha
        // ...

        Loan loan = new Loan(user, exemplar, start, due);
        exemplar.setStatus(ExemplarStatus.EMPRESTADO);
        exemplar.setCurrentLoan(loan);
        user.addLoan(loan);

        System.out.println("Empréstimo realizado com sucesso para " 
                + user.getName() + " - Livro: " + book.getTitle());
    }
}
