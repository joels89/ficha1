package Teste;

import securest.recurso.*;
import securest.recurso.Instalacao;

public class TestaInstalacao {

	public static void main(String[] args) {
		
		
		// TODO Auto-generated method stub
		
		Instalacao i1 = new Instalacao(1, "Sala 1", 3);
		System.out.println(i1);
		
		Instalacao i2 = new Instalacao(2, "Sala 2", -3);
		System.out.println(i2);
		
		Instalacao i3 = new Instalacao(3, "Sala 3", 8);
		System.out.println(i3);
		
		Instalacao i4 = new Instalacao(4, "Lab 4", 2);
		System.out.println(i4);
		
		Instalacao i5 = new Instalacao(5, "Sala 5", 5);
		System.out.println(i5);
		
		Funcionario f1 = new Funcionario(100, "Lopes", 1);
		i5.addAutorizados(f1);
		
		Funcionario f2 = new Funcionario(101, "Joel", 5);
		i5.addAutorizados(f2);
		
		System.out.println(i5.getAutorizados());
		
		System.out.println(i5.entrar(f1));
		
		
		

	}

}
