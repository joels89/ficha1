package Exercicio_3;

public class Elevador {
	
	private int andarAtual;
	private int andarInferior;
	private int andarSuperior;
	
	
	//primeiro construtor
	public Elevador (int andarSuperior, int andarInferior, int andarAtual)
	{
		this.andarAtual = andarAtual;
		this.andarInferior = andarInferior;
		this.andarSuperior = andarSuperior;
	}
	
	//segundo construtor
	public Elevador (int andarSuperior, int andarInferior) {
		this.andarAtual = andarInferior;
		this.andarSuperior = andarSuperior;
	}
	
	public Elevador (int andarSuperior) {
		this.andarSuperior = andarSuperior;
	}
	
	public String toString() {
		return "Andar atual:" + andarAtual + "\nAndar Superior:" + andarSuperior + "\nAndar Inferior:" + andarInferior + "\n";
	}
	
	public int getAndarAtual() {
		return andarAtual;
	}
	
	public int getAndarInferior() {
		return andarInferior;
	}
	
	public int getAndarSuperior() {
		return andarSuperior;
	}
	
	public void setAndarAtual(int andarAtual)
	{
		this.andarAtual = andarAtual;
	}
	
	public void setAndarInferior(int andarInferior)
	{
		this.andarInferior = andarInferior;
	}
	
	public void setAndarSuperior(int setAndarSuperior)
	{
		this.andarSuperior = setAndarSuperior;
	}
	
	public Boolean estaTopo()
	{
		return andarAtual == andarSuperior;
	}
	
	public Boolean estaFundo()
	{
		return andarAtual == andarInferior;
	}
	
	public void acede (int andar)
	{
		
	}
	
	public void sobe (int andar)
	{		
		for(int i = 0;i < andar; i++)
		{
			if(!estaTopo())
			{
				andarAtual++;
			}				
		}
	}
	
	public void desce (int andar)
	{
		for(int i = 0;i < andar ; i++)
		{
			if (!estaFundo()) 
			{
				andarAtual--;
			}
				
		}                                  						
	}
	
	
	/*
	 * public void irPara(int andar) { if (andar > andarAtual) { for (int i =
	 * andarAtual; i < andar; i++) { sobe(1); } } else { for (int i = andarAtual; i
	 * > andar; i--) { desce(1); } }
	 * 
	 * }
	 */
	 
	
	
	public void irPara(int andar) {
		if (andar > andarAtual) {
			sobe(andar - andarAtual);
		} else {
			desce(andarAtual - andar);
		}
	}
	 
	
	
	
	
	
	
	
	
	
	

}
