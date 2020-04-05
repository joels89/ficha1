package Teste;

import securest.recurso.Funcionario;
import securest.recurso.Instalacao;

public class TestFuncionário {

	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		
		Funcionario funcionario1 = new Funcionario(100, "Joel", 4);
		Funcionario funcionario2 = new Funcionario(9, "Helder", 5);
		Funcionario funcionario3 = new Funcionario(-1, "João", 1);
		
		System.out.println(funcionario1);
		System.out.println(funcionario2);
		System.out.println(funcionario3);
		
		System.out.println(funcionario1.equals(funcionario2));
		
		
		
		

		

	}

}
