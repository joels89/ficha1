package ficha1;
import java.io.Reader;
import java.util.Scanner;




/**
 * @author joels
 *
 */
public class Ficha1 {
   


	/**
	 * @param args
	 */
	static int calcularValorAbs(int num) 
	{
		//int resultado = Math.abs(num); usando a biblioteca matematica
		//if (num<0)		
			//return num * (-1);	// usando a condiçao if else			
		//return num;
		
		return (num<0)? -num:num; // condição ternaria
	}
	
	static int calcularValorEmSegundos (int hora, int minutos, int segundos)
	{
		int hoursToSeconds = ((hora * 3600) + (minutos * 60) + (segundos));
		return hoursToSeconds;		
	}
	
	static boolean eBisexto (int ano)
	{
		return (((ano%4 == 0) && !(ano%100 == 0)) || (ano%400 == 0));			
	}
	
	static boolean eBisexto (int [] ano)
	{
	   return (((ano[0]%4 == 0) && !(ano[0]%100 == 0)) || (ano[0]%400 == 0));        
	}
	
	static int diasDoAno(int a, int m,int d)
	{
		int [] dias = {0,31,28,31,30,31,30,31,31,30,31,30,31};
		if (eBisexto(a))
			dias[2] = 29;		
		int totalDias = d;
		for (int i = 1; i<m;i++)
		{
			totalDias = totalDias + dias[i];
		}		
		return totalDias;	
	}
	
	  static int diasDoAno(int [] data)
	   {
	      int [] dias = {0,31,28,31,30,31,30,31,31,30,31,30,31};
	      int totalDiasano, totalDiasAno1 = 0;
	      
	      
	      if (eBisexto(data[0]))
	         dias[2] = 29;
	      
	      //int numeroDeDiasAno = eBisexto(data[0]) ? 366:365;
	      
	      for (int i = 1; i<data[0]; i++)
	      {
	    	  totalDiasano = eBisexto(i) ? 366:365;
	    	  totalDiasAno1 = totalDiasano + totalDiasAno1;
	      }
	      System.out.println(totalDiasAno1);
	      
	      int totalDias = data[2] + data[0] * totalDiasAno1;
	      
	      for (int i = 1; i<data[1];i++)
	      {
	         totalDias = totalDias + dias[i];
	      }     
	      return totalDias; 
	   }
	
	static int calcularDataMaior (int a1, int m1, int d1, int a2, int m2, int d2)
	{
	   int [] dias = {0,31,28,31,30,31,30,31,31,30,31,30,31};
	   	   
	   int totalDiasAno1 = d1 + a1 * 365;
	   int totalDiasAno2 = d2 + a2 * 365;
	   	   
	   for (int i = 1;i < m1; i++){
	      totalDiasAno1 = totalDiasAno1 + dias[i];
	   }
	   
	   for (int j = 1;j < m2; j++){
	      totalDiasAno2 = totalDiasAno2 + dias[j];
	   }
	   return totalDiasAno1 - totalDiasAno2;	   	   
	}
	
	static void imprimirDiferençaDeDidas()
	{
	     int diferençaDeDidasDoAno = calcularDataMaior(2010, 1, 6, 2019, 12, 6);
	      	      
	      System.out.println(diferençaDeDidasDoAno);
	      
	      if(diferençaDeDidasDoAno < 0)
	      {
	         System.out.println("o Ano 2 é maior que o Ano 1");
	      }
	      else if (diferençaDeDidasDoAno == 0)
	      {
	         System.out.println("O Ano 1 é igual ao Ano 2");    
	      }
	      else if (diferençaDeDidasDoAno > 0)
	      {
	         System.out.println("O Ano 1 é maior que o Ano 2");
	      }
	}
	
	static String choiceCivilStatus(char estadoCivil)
	{
		switch (estadoCivil)
		{
		case 's':
		case 'S':
			return "Solteiro";
		case 'c':
		case 'C':
			return "Casado";
		case 'v':
		case 'V':
			return "Viuvo";
		case 'd':
		case 'D':
			return "Divorciado";
		default:
			return "Estado civil invalido";
		}		
	}
	
 	static void calcularDiferençaEntreAnos()

	{
	   Scanner scanner = new Scanner (System.in);
	   
	   int [] data1 = {0,0,0};
      int [] data2 = {0,0,0};
      
      System.out.println("Insira a primeira data com a seguinte ordem ANO ENTER/MES ENTER/DIAS ENTER");
      for (int i = 0; i <3; i++)
      {
         data1[i] = scanner.nextInt();
      }
      System.out.println("Insira a segunda data com a seguinte ordem ANO ENTER/MES ENTER/DIAS ENTER");
      for (int j = 0; j <=2; j++)
      {
         data2[j] = scanner.nextInt();
      }
      
      System.out.println("data 1 inserida: " + data1[0] + "/" + data1[1] + "/" + data1[2]);
      System.out.println("data 2 inserida: " + data2[0] + "/" + data2[1] + "/" + data2[2]);
      
      scanner.close();
    
      int total = diasDoAno(data1) - diasDoAno(data2);
      System.out.println(total);
	}
	
	
	static void printPessoa(String nome, String morada, 
			String codigoPostal, String Telefone, int dNasc, int mNasc, int aNasc, char estadoCivil)
	{
		System.out.println(nome);
		System.out.println(morada);
		System.out.println(codigoPostal);
		System.out.println(Telefone);
		System.out.println(dNasc + "/" + mNasc + "/" + aNasc);
		System.out.println("Estado Civil: " + choiceCivilStatus(estadoCivil));
		System.out.println("-----------------------------------------------------------------------");		
	}
	
	static int getIdade (int anoNasc, int anoReferencia)
	{		
		return anoReferencia - anoNasc;
	}
	
	static boolean eMaiorIdade(int anoNasc, int anoReferencia)
	{
		return getIdade(anoNasc, anoReferencia) >= 18;
	}
	
	static int getIdade( int d, int m, int a, int dRef, int mRef, int aRef)
	{
		if (aRef <= a)
		{
			return 0;
		}
		
		if (mRef > m)
			return getIdade(a, aRef);
		
		if (mRef < m)
			return getIdade(a, aRef) - 1;
		
		if (dRef >= d)
			return getIdade(a, aRef);
		else
			return getIdade(a, aRef) - 1;		
	}
	
	static void printPessoas(String []nms, String [] moradas, String []codigosPostais, String [] telefones,
			int [] dNasc, int []mNasc, int []aNasc, char []estadosCivis)
	{
		for (int i = 0; i < nms.length; i++)
		{
			printPessoa(nms[i], moradas[i], codigosPostais[i], telefones[i], 
					dNasc[i], mNasc[i], aNasc[i], estadosCivis[i]);
		}
	}
	

	
	
	
	public static void main(String[] args) 
	{
	   
		// TODO Auto-generated method stub
		//System.out.println(calcularValorAbs(-5)); //exercicio 1
		//System.out.println(calcularValorEmSegundos(20,14,20));	
		//System.out.println(calcularValorAbs(calcularValorEmSegundos(10,20,30) - calcularValorEmSegundos(23,15,60)));
		//boolean isBisexto = eBisexto(2200);
		//if (isBisexto)
			//System.out.println("ano bisexto");
		//System.out.println("nao e bisexto");
		
		//int dias = eBisexto(2020) ? 366:365;
		//System.out.println(dias);
		
		//System.out.println(diasDoAno(1980, 12, 22));
	   //imprimirDiferençaDeDidas(); 
	   
	   //calcularDiferençaEntreAnos(); //exercicio 8
	   
		/*
		 * String nome = "João Silva"; String morada = "Rua torta, nº15"; String
		 * codigoPostal = "6000-007 Pedreiras"; String Telefone = "965829320"; int dNasc
		 * = 2, mNasc = 4, aNasc = 2000; char estadoCivil = 's';
		 * 
		 * printPessoa(nome, morada, codigoPostal, Telefone, dNasc, mNasc, aNasc,
		 * estadoCivil);
		 */ 
		
		
		//System.out.println(getIdade(02, 12, 1989, 03, 12, 1989));
		
		String nomes [] = new String [5];
		String moradas [] = new String [5];
		String codigosPostais [] = new String [5];
		String telefones [] = new String [5];
		int dsNasc [] = new int [5];
		int msNasc [] = new int [5];
		int asNasc [] = new int [5];
		char estadosCivis[] = new char [5];
		
		nomes[0] = "Joel Sousa";
		moradas[0] = "Rua Torta, Nº 1555";
		codigosPostais[0] = "6200-867 Teixoso";
		telefones[0] = "965829320";
		dsNasc[0] = 02;
		msNasc[0] = 12;
		asNasc[0] = 1989;
		estadosCivis[0] = 's';
		
		nomes[1] = "Joel Sousa 1";
		moradas[1] = "Rua Torta, Nº 1555 1";
		codigosPostais[1] = "6200-867 Teixoso 1";
		telefones[1] = "965829320 1";
		dsNasc[1] = 03;
		msNasc[1] = 12;
		asNasc[1] = 1990;
		estadosCivis[1] = 'c';
		
		nomes[2] = "Joel Sousa 2";
		moradas[2] = "Rua Torta, Nº 1555 2";
		codigosPostais[2] = "6200-867 Teixoso 2";
		telefones[2] = "965829320 2";
		dsNasc[2] = 04;
		msNasc[2] = 12;
		asNasc[2] = 1991;
		estadosCivis[2] = 'c';
		
		nomes[2] = "Joel Sousa 2";
		moradas[2] = "Rua Torta, Nº 1555 2";
		codigosPostais[2] = "6200-867 Teixoso 2";
		telefones[2] = "965829320 2";
		dsNasc[2] = 04;
		msNasc[2] = 12;
		asNasc[2] = 1991;
		estadosCivis[2] = 'c';
		
		nomes[3] = "Joel Sousa 3";
		moradas[3] = "Rua Torta, Nº 1555 3";
		codigosPostais[3] = "6200-867 Teixoso 3";
		telefones[3] = "965829320 3";
		dsNasc[3] = 05;
		msNasc[3] = 12;
		asNasc[3] = 1992;
		estadosCivis[3] = 'c';
		
		nomes[4] = "Joel Sousa 4";
		moradas[4] = "Rua Torta, Nº 1555 4";
		codigosPostais[4] = "6200-867 Teixoso 4";
		telefones[4] = "965829320 4";
		dsNasc[4] = 06;
		msNasc[4] = 12;
		asNasc[4] = 1993;
		estadosCivis[4] = 'c';
		
		
		printPessoas(nomes, moradas, codigosPostais, telefones, dsNasc, msNasc, asNasc, estadosCivis);
				
	}
	
	
	

}
