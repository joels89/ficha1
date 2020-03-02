package teste;

import java.time.Year;

import Ficha_2.Pessoa;

public class TestaPessoa {

	public static void main(String[] args) {
		
		
		Pessoa pessoas [] = new Pessoa[5];
		
		pessoas [0] = new Pessoa("Joel Sousa", "Quinta do Beirão", "6000-098", "Teixoso", "275922909", 2, 12, 1989, 'S', 987123654);
		

		
		
		
		
	
		
		//p.nome = "Pedro"; errado
		
		/*
		 * pessoas[0].setNome("Joel"); pessoas[0].setMorada("Rua do Joel");
		 * pessoas[0].setCodigoPostal("6000-999"); pessoas[0].setLocalidade("Teixoso");
		 * pessoas[0].setTelefone("965829320"); pessoas[0].setdNasc(2);
		 * pessoas[0].setmNasc(12); pessoas[0].setaNasc(1989);
		 * pessoas[0].setEstadoCivil('S'); pessoas[3].setNumeroBI(654321789);
		 * 
		 * pessoas[1].setNome("Carminho"); pessoas[1].setMorada("Rua Torta, Nº 1555 1");
		 * pessoas[1].setCodigoPostal("6200-867 Teixoso 1");
		 * pessoas[1].setLocalidade("Boidobra"); pessoas[1].setTelefone("965829320 1");
		 * pessoas[1].setdNasc(03); pessoas[1].setmNasc(11); pessoas[1].setaNasc(2012);
		 * pessoas[1].setEstadoCivil('C'); pessoas[3].setNumeroBI(654321789);
		 * 
		 * pessoas[2].setNome("Helder The King");
		 * pessoas[2].setMorada("Rua Torta, Nº 1555 4");
		 * pessoas[2].setCodigoPostal("6200-867 Teixoso 1232");
		 * pessoas[2].setLocalidade("Oleiros");
		 * pessoas[2].setTelefone("965829320 1231232"); pessoas[2].setdNasc(03);
		 * pessoas[2].setmNasc(11); pessoas[2].setaNasc(2015);
		 * pessoas[2].setEstadoCivil('V'); pessoas[3].setNumeroBI(654321789);
		 * 
		 * pessoas[3].setNome("Joel Sousa 94");
		 * pessoas[3].setMorada("Rua Torta, Nº 1555 7");
		 * pessoas[3].setCodigoPostal("6200-867 Teixoso 12");
		 * pessoas[3].setLocalidade("Covilhã"); pessoas[3].setTelefone("965829320 12");
		 * pessoas[3].setdNasc(03); pessoas[3].setmNasc(5); pessoas[3].setaNasc(1985);
		 * pessoas[3].setEstadoCivil('S'); pessoas[3].setNumeroBI(987654321);
		 * 
		 * pessoas[4].setNome("Ana Rita");
		 * pessoas[4].setMorada("Rua Torta, Nº 1555 3434f");
		 * pessoas[4].setCodigoPostal("6200-867 Teixoso sdff");
		 * pessoas[4].setLocalidade("CB"); pessoas[4].setTelefone("965829320 sdfddf");
		 * pessoas[4].setdNasc(03); pessoas[4].setmNasc(5); pessoas[4].setaNasc(1983);
		 * pessoas[4].setEstadoCivil('S'); pessoas[4].setNumeroBI(123456789);
		 */
		
		
		

		
		/*
		 * System.out.println("nome: " + p.getNome()); System.out.println("morada: " +
		 * p.getMorada()); System.out.println("Codigo Postal: " + p.getCodigoPostal() +
		 * " " + p.getLocalidade()); System.out.println("Telefone: " + p.getTelefone());
		 * System.out.println("Data de Nascimento: " + p.getdNasc() + "/" + p.getmNasc()
		 * + "/" + p.getaNasc()); System.out.println("Estado Civil: " +
		 * p.choiceCivilStatus());
		 */
		for(int i = 0; i<pessoas.length; i++)
		{
			if (pessoas[i].eMaiorIdade(Year.now().getValue()))
			{
				System.out.println("teste maior de idade");
				System.out.println(pessoas[i]);
			}			
		}

		for (int i = 0; i<pessoas.length; i++)
		{
			if (pessoas[i].getEstadoCivil() == 'V')
			{
				System.out.println("Teste estado civil");
				System.out.println(pessoas[i]);
			}
		}
		
		for (int i = 0; i<pessoas.length; i++)
		{
			Pessoa p=pessoas[i];
			if (p.getCodigoPostal().contains("6000"))
			{
				System.out.println("Teste codigo postal");
				System.out.println(p);
			}
		}
		
		for (Pessoa p:pessoas)
		{
			if (p.getNome().contains("Ana"))
			{
				System.out.println("Teste numero de telefone");
				System.out.println(p.getTelefone());
			}
		}
		
		/*
		 * System.out.println("Idade da pessoa: " + p.getIdade(Year.now().getValue()));
		 * System.out.println("Maior de idade?: " +
		 * p.eMaiorIdade(Year.now().getValue()));
		 */
		
		

	}

}
