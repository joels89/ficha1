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
	      if (eBisexto(data[0]))
	         dias[2] = 29;     
	      int totalDias = data[2] + data[0];
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
	     int diferençaDeDidasDoAno = calcularDataMaior(2010, 12, 6, 2010, 12, 6);
	      	      
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
	         System.out.println("O Ano 2 é maior que o Ano 1");
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
	   
	   calcularDiferençaEntreAnos(); //exercicio 9
	   	 
	}

}
