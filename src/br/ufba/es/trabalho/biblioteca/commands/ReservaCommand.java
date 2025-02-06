package br.ufba.es.trabalho.biblioteca.commands;

import br.ufba.es.trabalho.biblioteca.repository.BibliotecaDados;
import br.ufba.es.trabalho.biblioteca.app.CarregadorParametros;
import br.ufba.es.trabalho.biblioteca.domain.Livro;
import br.ufba.es.trabalho.biblioteca.domain.Reserva;
import br.ufba.es.trabalho.biblioteca.users.User;

import java.util.Optional;

public class ReservaCommand implements Command {
    @Override
    public void execute(CarregadorParametros carregadorParametros) {
        int userId = Integer.parseInt(carregadorParametros.getParametroUm());
        int bookId = Integer.parseInt(carregadorParametros.getParametroDois());

        BibliotecaDados dados = BibliotecaDados.getInstance();
        Optional<User> userOpt = dados.findUserById(userId);
        Optional<Livro> livroOpt = dados.findBookById(bookId);

        // Verifica se o usuário e o livro existem
        if (userOpt.isEmpty() || livroOpt.isEmpty()) {
            System.out.println("Reserva não realizada: Usuário ou livro inexistente.");
            return;
        }
        Livro livro = livroOpt.get();
        User usuario = userOpt.get();

        // Verifica se o usuario tem espaço para a reseva
        if (usuario.getReservas().size() >= 3) {
            System.out.println("Reserva não realizada: Limite de reservas simultâneas atingido.");
            return;
        }

        // Faz a reserva do livro
        Reserva reserva = new Reserva(usuario, livro);
        usuario.addReserva(reserva);
        livro.addReserva(reserva);

        // Mensagem de sucesso
        System.out.println("Reserva realizada com sucesso por " + usuario.getName() + " - Livro: " + livro.getTitle());
    }

    @Override
    public String getDescription() {
        return "Reserva um livro";
    }
}
