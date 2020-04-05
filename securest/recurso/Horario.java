package securest.recurso;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import p2.tempo.Hora;
import p2.tempo.Periodo;

public class Horario {

	private ArrayList<Periodo> periodos = new ArrayList<Periodo>();

// 2 - Construtores
	public Horario() {
	}

// 2A - Métodos de funcionamento
	// 3 - criar métodos de acesso (get e set) e outros 
	public void addPeriodo(Periodo p) { // part 1 do setter
		for (int i = periodos.size() - 1; i >= 0; i--) {// qd é para remover elementos é melhor comecar de tras para a
														// frente e mantenho a ordem dos indices
			Periodo patual = periodos.get(i);
			if (p.interseta(patual)) {
				p.junta(patual);// juntamos
				periodos.remove(i);// removemos o pactual q estamos a iterar
			}
		}
		periodos.add(p);// no final se ja nao intersecta com ninguem adiciona

	}

	public void removePeriodo(int idx) {// part 1 do setter
		periodos.remove(idx);
	}

	public List<Periodo> getPeriodos() {// get da lista
		return Collections.unmodifiableList(periodos);
	}
	
	public boolean estaDentro(Hora h) {
		for (Periodo p : periodos) {
			if (p.estaDentro(h)) {
				return true;
			}
		}
		return false;
	}
	
	@Override
	public String toString() {
		return "Horario [periodos=" + periodos + "]";

	}
}