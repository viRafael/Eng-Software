package main.java.com.library.commands;

import main.java.com.library.app.CarregadorParametros;

public interface Command {
    void execute(CarregadorParametros carregadorParametros);

}

