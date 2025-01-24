package main.java.com.library.app;

public class CarregadorParametros {
    private String parametroUm;
    private String parametroDois;

    public CarregadorParametros(String parametroUm) {
        this.parametroUm = parametroUm;
    }

    public CarregadorParametros(String parametroUm, String parametroDois) {
        this.parametroUm = parametroUm;
        this.parametroDois = parametroDois;
    }

    public String getParametroUm() {
        return parametroUm;
    }

    public String getParametroDois() {
        return parametroDois;
    }
}
