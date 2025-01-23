import java.util.HashMap;

public class InterfaceUsuario {
	private HashMap<String,Comando> comandos = new HashMap<String,Comando>();
	
	private void inicializarComandos() {
		comandos.put("emp", new EmprestarComando());
		comandos.put("usu", new ConsultarUsuarioComando());
	}
	
	public void executarComando(String strComando, CarregadorParametros parametros) {
		Comando comando = comandos.get(strComando);
		comando.executar(parametros);
	}
	
	//M�todos abaixo para fazer a interface com usu�rio via linha de commando
	//...
	

}
