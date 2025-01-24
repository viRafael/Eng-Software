package main.java.com.library.commands;

import main.java.com.library.app.CarregadorParametros;
import main.java.com.library.domain.Book;
import main.java.com.library.domain.Exemplar;
import main.java.com.library.domain.Loan;
import main.java.com.library.users.User;
import main.java.com.library.repository.LibraryData;

public class DevolucaoCommand implements Command {

    @Override
    public void execute(CarregadorParametros carregadorParametros) {
        int userId = Integer.parseInt(carregadorParametros.getParametroUm());
        int bookId = Integer.parseInt(carregadorParametros.getParametroDois());

        LibraryData data = LibraryData.getInstance();
        User user = data.findUserById(userId);
        Book book = data.findBookById(bookId);

        if (user == null || book == null) {
            System.out.println("Devolução não realizada: Usuário ou livro inexistente.");
            return;
        }

        Loan loan = user.findLoanByBook(book);
        if (loan == null) {
            System.out.println("Devolução não realizada: O usuário não possui empréstimo em aberto deste livro.");
            return;
        }

        loan.finalizeLoan();
        System.out.println("Devolução realizada com sucesso por " + user.getName() + " - Livro: " + book.getTitle());
    }
}

