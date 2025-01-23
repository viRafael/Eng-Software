import java.util.Scanner;

import command.ICommand;

public class ConsoleHandler {
    public void run() {
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.print("> ");
            String line = sc.nextLine().trim();
            if (line.isEmpty()) {
                continue;
            }
            String[] args = line.split(" ");
            String cmd = args[0];

            ICommand command = CommandFabrica.getCommand(cmd);
            if (command == null) {
                System.out.println("Comando inválido!");
                continue;
            }

            command.execute(args);

            if (cmd.equals("sai")) {
                break; // encerra loop
            }
        }
        sc.close();
    }
}
