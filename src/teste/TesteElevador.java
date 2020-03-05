package teste;

import Exercicio_3.Elevador;

public class TesteElevador {

	public static void main(String[] args) {
		
		Elevador elevador[] = new Elevador[3];
		
		elevador[0] = new Elevador(10, -3, 5);
		elevador[1] = new Elevador(12, -1, -1);
		elevador[2] = new Elevador(4, 0, 0);
		
		System.out.println(elevador[0].toString());
		System.out.println(elevador[1].toString());
		System.out.println(elevador[2].toString());
		
		
		elevador[0].desce(7);
		elevador[1].irPara(-4);
		elevador[2].sobe(8);
		
		System.out.println(elevador[0].toString());
		System.out.println(elevador[1].toString());
		System.out.println(elevador[2].toString());
		

	}

}
