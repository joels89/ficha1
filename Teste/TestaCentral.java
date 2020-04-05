package Teste;

import securest.recurso.CentralControlo;
import securest.recurso.Funcionario;
import securest.recurso.Instalacao;

public class TestaCentral {

	public static void main(String[] args) {
		
		Funcionario fs[] = new Funcionario[6];
		fs[0] = new Funcionario(10, "Decimo", 1);
		fs[1] = new Funcionario(11, "Decimo Primeiro", 2);
		fs[2] = new Funcionario(12, "Decimo Segundo", 3);
		fs[3] = new Funcionario(20, "Decimo terceiro", 4);
		
		
		Instalacao is[] = new Instalacao[6];
		is[0] = new Instalacao(1, "Sala 1", 1);
		is[1] = new Instalacao(2, "Sala 2", 2);
		is[2] = new Instalacao(3, "Sala 3", 3);
		is[3] = new Instalacao(8, "Sala 8", 4);
		
		CentralControlo cc = new CentralControlo();
		
		for(Funcionario f: fs){
			cc.addFuncionario(f);
		}
		
		for(Instalacao i: is) {
			cc.addInstalacao(i);
		}
		
		
		System.out.println(cc.getFuncionarios());
		System.out.println(cc.getInstalacoes());
		
		System.out.println(cc.getFuncionario(12));
		System.out.println(cc.getFuncionario(18));
		System.out.println(cc.getInstalacao(3));
		System.out.println(cc.getInstalacao(8));

	}

}
