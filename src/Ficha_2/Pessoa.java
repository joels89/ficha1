package Ficha_2;

import java.time.Year;

public class Pessoa {
	//vars de estancia
	private String nome;
	private String morada;
	private String codigoPostal;
	private String localidade;
	private String telefone;
	private int dNasc, mNasc, aNasc;
	private char estadoCivil;
	private int numeroBI;
	
	public Pessoa(String nome, String morada, String codigoPostal, String localidade, String telefone, int dNasc,
			int mNasc, int aNasc, char estadoCivil, int numeroBI) {
		
		this.nome = nome;
		this.morada = morada;
		this.codigoPostal = codigoPostal;
		this.localidade = localidade;
		this.telefone = telefone;
		this.dNasc = dNasc;
		this.mNasc = mNasc;
		this.aNasc = aNasc;
		this.estadoCivil = estadoCivil;
		this.numeroBI = numeroBI;
	}

	public Pessoa() {
		// TODO Auto-generated constructor stub
	}

	public int getNumeroBI()
	{
		return numeroBI;
	}
	
	public void setNumeroBI(int numeroBI) {
		this.numeroBI = numeroBI;
	}
	
	//criar metodos de acesso Gets e Sets;
	//Gets and Setters
	public void setNome (String nome)
	{
		this.nome = nome;
	}
	
	public String getNome () 
	{
		return nome;
	}

	public String getMorada() {
		return morada;
	}

	public void setMorada(String morada) {
		this.morada = morada;
	}

	public String getCodigoPostal() {
		return codigoPostal;
	}

	public void setCodigoPostal(String codigoPostal) {
		this.codigoPostal = codigoPostal;
	}

	public String getLocalidade() {
		return localidade;
	}

	public void setLocalidade(String localidade) {
		this.localidade = localidade;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public int getdNasc() {
		return dNasc;
	}

	public void setdNasc(int dNasc) {
		this.dNasc = dNasc;
	}

	public int getmNasc() {
		return mNasc;
	}

	public void setmNasc(int mNasc) {
		this.mNasc = mNasc;
	}

	public int getaNasc() {
		return aNasc;
	}

	public void setaNasc(int aNasc) {
		this.aNasc = aNasc;
	}

	public char getEstadoCivil() {
		return estadoCivil;
	}

	public void setEstadoCivil(char estadoCivil) {
		this.estadoCivil = estadoCivil;
	}
	
	public String choiceCivilStatus()
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
	
	public int getIdade(int aRef) {
		return aRef - aNasc;		
	}
	
	public Boolean eMaiorIdade(int aRef) {
		
		return getIdade(aRef) >= 18;
	}

	@Override
	public String toString() {
		return "nome=" + nome + "\n morada=" + morada + "\n codigoPostal=" + codigoPostal + "\n localidade="
				+ localidade + "\n telefone=" + telefone + "\n Data de Nascimento=" + dNasc + "/" + mNasc + "/" + aNasc + "idade: "
				+ "\n estadoCivil=" + estadoCivil + "\n";
	}
	
	

	
	
		
}












