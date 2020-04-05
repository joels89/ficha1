package securest.app;

import p2.tempo.Hora;
import p2.tempo.Periodo;
import securest.recurso.CentralControlo;
import securest.recurso.Funcionario;
import securest.recurso.Horario;
import securest.recurso.Instalacao;

public class AppMain {

	/**
	 * despoleta a aplicação
	 */
	public static void main( String []args ){
		
		// criar a central de controlo
		CentralControlo central = new CentralControlo( );

		Funcionario fs[] = new Funcionario[10];
		
		fs[0] = new Funcionario(1, "Asdrúbal", 1);
		fs[1] = new Funcionario(2, "Josefina", 2);
		fs[2] = new Funcionario(3, "Ambrosio", 3);
		fs[3] = new Funcionario(4, "Albertina", 4);
		fs[4] = new Funcionario(5, "Zé Bigboss", 5);
		fs[5] = new Funcionario(6, "Josefa", 3);
		
		
		Hora hora8= new Hora("8:00:00");
		Hora hora12 = new Hora("12:00:00");
		Hora hora10 = new Hora ("10:00:00");
		Hora hora14 = new Hora ("14:00:00");
		Hora hora16= new Hora ("16:00:00");
		Hora hora19= new Hora ("19:00:00");
		Hora hora00= new Hora ("00:00:00");
		Hora hora730= new Hora ("07:30:00");
		Hora hora21= new Hora ("21:00:00");
		Hora hora2359= new Hora ("23:59:00");
		Hora hora930= new Hora ("09:30:00");
		Hora hora1630= new Hora ("16:30:00");
		Hora hora1730= new Hora ("17:30:00");
		Hora hora2030= new Hora ("20:30:00");	
		Hora hora20= new Hora("20:00:00");
		
		
		
		
		Horario h1 = new Horario();
		h1.addPeriodo(new Periodo(hora8,hora12));
		Instalacao is1 = new Instalacao(1, "sala 1", 1,h1);
		central.addInstalacao(is1);
		
		Horario h2 = new Horario();
		h2.addPeriodo(new Periodo(hora8, hora12));
		h2.addPeriodo(new Periodo(hora14, hora20));
		Instalacao is2 = new Instalacao(2, "sala 2", 2,h2);
		central.addInstalacao(is2);
		
		Horario h3 = new Horario();
		h3.addPeriodo(new Periodo(hora10, hora14));
		h3.addPeriodo(new Periodo(hora16, hora19));
		Instalacao is3 = new Instalacao(3, "sala 3", 3,h3);
		central.addInstalacao(is3);
		
		Horario h4 = new Horario();
		h4.addPeriodo(new Periodo(hora00, hora730));
		h4.addPeriodo(new Periodo(hora21, hora2359));
		Instalacao is4 = new Instalacao(4, "Laboratorio Secreto", 4,h4);
		is4.addAutorizados(central.getFuncionario(2));
		is4.addAutorizados(central.getFuncionario(3));
		central.addInstalacao(is4);
		
		Horario h5 = new Horario();
		h5.addPeriodo(new Periodo(hora00, hora2359));
		Instalacao is5 = new Instalacao(5, "Jacuzzi", 5,h5);
		is5.addAutorizados(central.getFuncionario(2));
		is5.addAutorizados(central.getFuncionario(4));
		is5.addAutorizados(central.getFuncionario(6));
		central.addInstalacao(is5);
		
		Horario h6 = new Horario();
		h6.addPeriodo(new Periodo(hora930, hora1630));
		h6.addPeriodo(new Periodo(hora1730, hora2030));
		Instalacao is6 = new Instalacao(6, "Laboratorio 3", 3,h6);
		is5.addAutorizados(central.getFuncionario(1));
		central.addInstalacao(is6);
		
		
		
		
		// criar a aplicação propriamente dita
		MenuCentral app = new MenuCentral( central );
		app.menuPrincipal();
	}

}
