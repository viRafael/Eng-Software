package main.java.com.library;

import main.java.com.library.app.CarregadorParametros;
import main.java.com.library.app.CommandFactory;
import main.java.com.library.commands.Command;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.print("Console> ");
            String line = scanner.nextLine();

            if (line.isEmpty())
                continue;

            String[] argumentos = line.split(" ");
            String command = argumentos[0];
            CarregadorParametros carregadorParametros =
                    (argumentos.length == 2) ? new CarregadorParametros(argumentos[1]) :
                            (argumentos.length == 3) ? new CarregadorParametros(argumentos[1], argumentos[2]) : null;

            if (carregadorParametros == null) {
                System.out.println("Parâmetros inválidos.");
                continue;
            }

            Command cmd = CommandFactory.getCommand(command);
            if (cmd == null) {
                System.out.println("Comando não reconhecido.");
                continue;
            }

            cmd.execute(carregadorParametros);

            if (command.equals("sai")) break;
        }
    }
}
