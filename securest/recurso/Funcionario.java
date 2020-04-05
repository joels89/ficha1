package securest.recurso;

public class Funcionario {
	
	/*
	 * Esta classe representa um funcion�rio da empresa. Cada funcion�rio deve ter
	 * um c�digo identificador �nico, um nome e um n�vel de acesso. O funcion�rio
	 * tamb�m deve guardar informa��o sobre qual a instala��o onde est� presente (se
	 * alguma). Esta classe deve ter o construtor, getters e setters e os seguintes
	 * m�todos: public boolean equals( Funcionario f ){ indica se um funcion�rio �
	 * igual a outro (s�o iguais se id for o mesmo) public boolean estaPresente( ){
	 * indica se um funcion�rio est� presente em alguma instala��o public void sair(
	 * ){ faz com que o funcion�rio saia da instala��o onde est�
	 */

	
	public final static int NIVEL_MINIMO = 0;
	public final static int NIVEL_MAXIMO = 5;
	
	private int id;
	private String nome;
	private int nivelAcesso;
	
	private Instalacao instalacao = null;
	
	
	public Funcionario(int id, String nome, int nivelAcesso) {	
		setId(id);
		setNome(nome);
		setNivelAcesso(nivelAcesso);
	}
	
	public boolean estaPresente() {
		
		return instalacao != null;
	}
	
	public void sair() {
		instalacao = null;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) { // id Positivo? como se testa ID unico? h� formulas para calcular o id?
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getNivelAcesso() {
		return nivelAcesso;
	}

	public void setNivelAcesso(int nivelAcesso) { 
		if(nivelAcesso >= NIVEL_MINIMO && nivelAcesso <= NIVEL_MAXIMO)
		{
			this.nivelAcesso = nivelAcesso;
		}
		else
		{
			this.nivelAcesso = NIVEL_MINIMO;
		}
		
	}

	public Instalacao getInstalacao() {
		return instalacao;
	}

	void setInstalacao(Instalacao instalacao) {
		this.instalacao = instalacao;
	}

	
	public String toString() {
		return "Funcionario [id=" + id + ", nome=" + nome + ", nivelAcesso=" + nivelAcesso + ", instalacao="
				+ instalacao + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		return result;
	}

	/*
	 * @Override public boolean equals(Object obj) { if (this == obj) return true;
	 * if (obj == null) return false; if (getClass() != obj.getClass()) return
	 * false; Funcionario other = (Funcionario) obj; if (id != other.id) return
	 * false; return true; }
	 */
	
	public boolean equals (Funcionario funcionario)
	{
		return this.id == funcionario.id;
	}
	
	
	

}
