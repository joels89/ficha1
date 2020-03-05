package teste;

import Exercicio_4.Hora;

public class TesteHora {

	public static void main(String[] args) {
		
		Hora hora[] = new Hora[3];
		
		hora[0] = new Hora();
		
		System.out.println(hora[0].toString());
		
		hora[1] = new Hora(14, 12, 15);
		
		System.out.println(hora[1].toString());
		
		hora[2] = hora[1].clone(hora[0]);
		
		System.out.println(hora[2].toString());
		
		System.out.println(hora[0].compareTo(hora[0]));
		
		System.out.println(hora[0].toSegundos());
		// TODO Auto-generated method stub
	}

}
