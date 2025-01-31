package main.java.com.library.commands;

import main.java.com.library.app.CarregadorParametros;
import main.java.com.library.domain.Exemplar;
import main.java.com.library.domain.Livro;
import main.java.com.library.domain.Reserva;
import main.java.com.library.domain.enums.ExemplarStatus;
import main.java.com.library.repository.BibliotecaDados;

public class ConsultaLivroCommand implements Command  {
    @Override
    public void execute(CarregadorParametros carregadorParametros) {
        int codeLivro = Integer.parseInt(carregadorParametros.getParametroDois());

        BibliotecaDados dados = BibliotecaDados.getInstance();
        Livro livro =  dados.findBookById(codeLivro);

        // Verifica se o livro existe
        if (livro == null) {
            System.out.println("Consulta não realizada: Livro inexistente.");
            return;
        }

        // Imprime o título do livro
        System.out.println("Título: " + livro.getTitle());

        // Imprime Reservas e seus usuarios
        System.out.println("Reservas:" + livro.getReservas().size());
        int contadorReservas = 1;
        if (!livro.getReservas().isEmpty()) {
            for (Reserva reserva : livro.getReservas()) {
                System.out.println("Reserva " + contadorReservas + ": " + reserva.getUser().getName());
            }
        }

        // Imprime o estatus e codigo para cada usuario
        for (Exemplar exemplar : livro.getExemplares()) {
            System.out.println("Código: " + exemplar.getCode());
            System.out.println("Status: " + exemplar.getStatus());

            if (exemplar.getStatus() == ExemplarStatus.EMPRESTADO) {
                System.out.println("Status: Emprestado");
                System.out.println("Usuário: " + exemplar.getEmprestimoAtual().getUsuario().getName());
                System.out.println("Data de empréstimo: " + exemplar.getEmprestimoAtual().getDataEmprestimo());
                System.out.println("Data de devolução: " + exemplar.getEmprestimoAtual().getDataDevolucao());
            }
        }
    }
}
