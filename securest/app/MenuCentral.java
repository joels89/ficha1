package securest.app;


import consola.SConsola;
import p2.tempo.Hora;
import p2.tempo.Periodo;
import securest.recurso.CentralControlo;
import securest.recurso.Funcionario;
import securest.recurso.Instalacao;

/**
 * Classe que trata dos menus da central de comandos
 */
public class MenuCentral {
	
	private SConsola consola = new SConsola();
	private CentralControlo central;
	
	public MenuCentral( CentralControlo central ){
		this.central = central;
	}

	/**
	 * menu principal da aplica��o
	 */
	public void menuPrincipal(){
		String menu = "Central de controlo - controlo de acessos\n" + 
				"1- Info sobre instala��o\n"+
				"2- Info sobre funcion�rio\n" + 
				"3- Entrada de funcion�rio\n"+
				"4- Sa�da de funcion�rio\n"+
				"5- Listar presen�as em todas as instala��es\n"+
				"\n0- Sair";

		char opcao = 0;
		do {
			consola.clear();
			consola.println( menu );
			opcao = consola.readChar();
			switch( opcao ){
			case '1':
				printInstalacao();
				break;
			case '2':
				printFuncionario();
				break;
			case '3':
				entradaFuncionario();
				break;
			case '4':
				saidaFuncionario();
				break;
			case '5':
				listarPresencas();
				consola.readLine();
				break;
			case '0': break;
			default:
				consola.println( "op��o inv�lida");
				consola.readLine();
			}
		} while( opcao != '0' );

		consola.close();					// desligar o menu da central		
	}

	/**
	 * imprime a informa��o de uma instala��o 
	 */
	private void printInstalacao( ) {
		Instalacao inst = getInstalacao( "C�digo da instala��o? ");
		consola.clear();
		consola.println( "<NOME da istala��o>" + inst.getDescricao());		
		consola.println("id: <ID inst>" + inst.getId() );
		consola.println("nivel acesso: <NIVEL inst>" + inst.getNivel());
		consola.print("Autorizados: " + inst.getAutorizados());
		for (Funcionario f : inst.getAutorizados())			
		{
			consola.print( "<NOME FUNC>, " + f.getNome() + "," );
		}
		// para todos os autorizados apresentar			
		consola.println();
		consola.print("Presentes: " );
		for (Funcionario f : inst.getPresentes())			
		{
			consola.print( "<NOME FUNC>, " + f.getNome() + "," );
		}
		// para todos os presentes apresentar
			
		consola.println();
		consola.println("Hor�rio funcionamento");
		for (Periodo p: inst.getHorario().getPeriodos())
		{
			consola.println(p.toString());
		}


		consola.readLine();
	}

	/**
	 * imprime a informa��o de um funcion�rio 
	 */
	private void printFuncionario( ) {
		Object f = getFuncionario( "C�digo do funcion�rio? ");
		consola.clear();
		consola.println( "<NOME FUNC>" );		
		consola.println("id: <ID FUNC>" );
		consola.println("nivel acesso: <NIVEL FUNC>" );
		if( true /* se est� presente numa instala��o */ )
			consola.print("Presente em <NOME INST>" );
		else
			consola.print("N�o est� presente neste momento em lado nenhum" );
		consola.readLine();
	}

	
	/**
	 * processa a entrada de um funcion�rio
	 */
	private void entradaFuncionario() {
		Object f = getFuncionario( "C�digo do funcion�rio a entrar? ") ;
		Object i = getInstalacao( "C�digo da instala��o onde vai entrar? ");
		
		consola.println( /*pode entrar?*/ true? "Pode entrar" : "Impedido de entrar!");
		consola.readLine();
	}

	/**
	 * processa a sa�da de um funcion�rio
	 */
	private void saidaFuncionario() {
		Object f = getFuncionario( "C�digo do funcion�rio a sair? ") ;
		if( true /* est� oresente num a instala��o */ ){
			// processar sa�da da instala��o onde est�
			consola.println("O funcion�rio <NOME FUNC> saiu de <NOME INST>" );
		}
		else
		{
			consola.println("O funcion�rio <NOME FUNC> n�o est� em nenhuma instala��o!");
		}
		consola.readLine();
	}


	/**
	 * pergunta ao utilizador qual o id do funcion�rio que vai ser processado
	 * e retorna o funcion�rio correspondente
	 * @param msg a mensagem a pedir o funcion�rio
	 * @return o funcion�rio pedido
	 */
	private Object getFuncionario( String msg ){
		Object f = null;
		do {
			consola.print( msg );
			int id = consola.readInt();
			f = central.getFuncionario( id );
			if( f == null ){
				consola.println("Esse funcion�rio n�o existe!");
				consola.readLine();
			}
		}while( f == null );
		return f;
	}

	/**
	 * pergunta ao utilizador qual o id da instala��o que vai ser processada
	 * e retorna a instala��o correspondente
	 * @param msg a mensagem a pedir a instala��o
	 * @return a instala��o pedida
	 */
	private Instalacao getInstalacao( String msg ){
		Instalacao i = null;
		do {
			consola.print( msg );
			int id = consola.readInt();
			i = central.getInstalacao( id );
			if( i == null ){
				consola.println("Essa instala��o n�o existe!");
				consola.readLine();
			}
		}while( i == null );
		return i;
	}
	
	/**
	 * lista todas as presen�as em todas as instala��es 
	 */
	private void listarPresencas() {
		consola.clear();
		/* para todas as instala��es */ {
			consola.println( "presentes em <NOME INST>  (NIVEL INST>" );
			/* para todos os funcion�rios */
				consola.println( "<NOME FUNC>   (NIVEL FUNC)" );
			consola.println( "-----------------" );
		}		
	}
	
}
