package br.ufba.es.trabalho.biblioteca.app;

import br.ufba.es.trabalho.biblioteca.commands.Command;
import br.ufba.es.trabalho.biblioteca.domain.Exemplar;
import br.ufba.es.trabalho.biblioteca.domain.Livro;
import br.ufba.es.trabalho.biblioteca.repository.BibliotecaDados;
import br.ufba.es.trabalho.biblioteca.users.AlunoGraduacao;
import br.ufba.es.trabalho.biblioteca.users.PosGraduacao;
import br.ufba.es.trabalho.biblioteca.users.Professor;

import java.util.List;
import java.util.Scanner;

public class ConsoleHandler {
    public void run() {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.print("Console> ");
            String line = scanner.nextLine();

            if (line.isEmpty())
                continue;

            String[] argumentos = line.split(" ");
            String command = argumentos[0];

            CarregadorParametros carregadorParametros = new CarregadorParametros(
                    (argumentos.length > 1) ? argumentos[1] : null,
                    (argumentos.length > 2) ? argumentos[2] : null
            );

            Command cmd = CommandFactory.getCommand(command.toLowerCase());
            if (cmd == null) {
                System.out.println("Comando não reconhecido. Digite 'ajuda' para ver os comandos disponíveis.");
                continue;
            }

            cmd.execute(carregadorParametros);
        }
    }

    // Popula com os dados de teste da atividade
    public void popular() {
        BibliotecaDados dados = BibliotecaDados.getInstance();
        dados.addUsuarios(new AlunoGraduacao(123, "João da Silva"));
        dados.addUsuarios(new PosGraduacao(456, "Luiz Fernando Rodrigues"));
        dados.addUsuarios(new AlunoGraduacao(789, "Pedro Paulo"));
        dados.addUsuarios(new Professor(100, "Carlos Lucena"));

        dados.addLivro(new Livro(100, "Engenharia de Software", "Addison-Wesley", null, 6, 2000));
        dados.addLivro(new Livro(101, "UML - Guia do Usuário", "Campus", null, 2, 2002));
        dados.addLivro(new Livro(200, "Code Complete", "Microsoft Press", null, 2, 1993));
        dados.addLivro(new Livro(201, "agile software development", "Addison-Wesley", null, 2, 2002));
        dados.addLivro(new Livro(300, "Refactoring", "Addison-Wesley", null, 6, 2000));
        dados.addLivro(new Livro(301, "Software Metric", "aleatorio 1", null, 2, 1990));

        // Esses são extras
        dados.addLivro(new Livro(400, "The Mythical", "Campus", null, 2, 2002));
        dados.addLivro(new Livro(401, "The Psychology of Computer Programming", "Addison-Wesley", null, 2, 1998));

        List<Livro> livros = dados.getLivros();
        livros.getFirst().addExemplar(new Exemplar(1, livros.getFirst()));
        livros.getFirst().addExemplar(new Exemplar(2, livros.getFirst()));
        livros.get(1).addExemplar(new Exemplar(3, livros.get(1)));
        livros.get(2).addExemplar(new Exemplar(4, livros.get(2)));
        livros.get(3).addExemplar(new Exemplar(5, livros.get(3)));
        livros.get(4).addExemplar(new Exemplar(6, livros.get(4)));
        livros.get(4).addExemplar(new Exemplar(7, livros.get(4)));
        livros.get(6).addExemplar(new Exemplar(8, livros.get(6)));
        livros.get(6).addExemplar(new Exemplar(9, livros.get(6)));
    }
}
