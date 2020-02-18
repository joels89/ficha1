package ficha1;



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
	
	
	
	
	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		System.out.println(calcularValorAbs(-5));
		System.out.println(calcularValorEmSegundos(20,14,20));	
		System.out.println(calcularValorAbs(calcularValorEmSegundos(10,20,30) - calcularValorEmSegundos(23,15,60)));
		boolean isBisexto = eBisexto(2200);
		if (isBisexto)
			System.out.println("ano bisexto");
		System.out.println("nao e bisexto");
		
		int dias = isBisexto ? 366:365;
		System.out.println(dias);
		System.out.println(diasDoAno(1980, 12, 22));		
	}

}
