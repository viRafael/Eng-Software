package main.java.com.library.app;
import main.java.com.library.commands.Command;

import java.util.Scanner;

public class ConsoleHandler {

    public void run() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.print("> ");
            String line = scanner.nextLine().trim();
            if (line.isEmpty()) continue;

            String[] args = line.split(" ");
            String command = args[0];
            CarregadorParametros carregadorParametros =
                    (args.length == 2) ? new CarregadorParametros(args[1]) :
                            (args.length == 3) ? new CarregadorParametros(args[1], args[2]) : null;

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
        scanner.close();
    }
}
