package br.ufba.es.trabalho.biblioteca.commands;

import br.ufba.es.trabalho.biblioteca.domain.enums.ExemplarStatus;
import br.ufba.es.trabalho.biblioteca.repository.BibliotecaDados;
import br.ufba.es.trabalho.biblioteca.app.CarregadorParametros;
import br.ufba.es.trabalho.biblioteca.domain.Exemplar;
import br.ufba.es.trabalho.biblioteca.domain.Livro;
import br.ufba.es.trabalho.biblioteca.domain.Reserva;
import br.ufba.es.trabalho.biblioteca.utils.Validador;

import java.util.Optional;

public class ConsultaLivroCommand implements Command  {
    @Override
    public void execute(CarregadorParametros carregadorParametros) {
        var codeLivroOpt = Validador.toInteger(carregadorParametros.getParametroUm());

        if (codeLivroOpt.isEmpty()) {
            System.out.println("Informe o número do código do livro!");
            return;
        }
        int codeLivro = codeLivroOpt.get();

        BibliotecaDados dados = BibliotecaDados.getInstance();
        Optional<Livro> livroOpt =  dados.findBookById(codeLivro);

        // Verifica se o livro existe
        if (livroOpt.isEmpty()) {
            System.out.println("Consulta não realizada: Livro inexistente.");
            return;
        }
        Livro livro = livroOpt.get();

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

    @Override
    public String getDescription() {
        return "Consulta o estado de um livro";
    }
}
