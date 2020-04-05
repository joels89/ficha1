package securest.recurso;

import securest.recurso.Horario;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import p2.tempo.Hora;


public class Instalacao {
	
	//Variaveis de instancia
	
	
	private int id;
	private int nivel;
	private String descricao;
	private Horario funcionamento = new Horario();
	private ArrayList<Funcionario> autorizados = new ArrayList<Funcionario>();
	private ArrayList<Funcionario> presentes = new ArrayList<Funcionario>();
	private Horario horario;
	
	
	
	
	public Instalacao(int id, String descricao, int nivelDeAcesso, Horario horario)
	{
		setId(id);
		setDescricao(descricao);
		setNivel(nivelDeAcesso);
		setHorario(horario);
	}
	
	
	public Instalacao (int id, String descricao, int nivelDeAcesso)
	{
		this(id,descricao,nivelDeAcesso, new Horario());
	}
	
	public boolean podeEntrar (Funcionario funcionario, Hora h)
	{	
		if (!horario.estaDentro(h) )
		{
			return false;
		}
		
		return funcionario.getNivelAcesso() > getNivel() || autorizados.contains(funcionario);				
	}
	
	public boolean entrar (Funcionario funcionario) {
		if (this.podeEntrar(funcionario, new Hora()))
		{
			funcionario.setInstalacao(this);
			presentes.add(funcionario);
			return true;
		}
		return false;
	}
	
	
	public void addAutorizados(Funcionario funcionario)
	{
		autorizados.add(funcionario);
	}
	
	public void removeAutorizados (Funcionario funcionario)
	{
		autorizados.remove(funcionario);
	}
	
	public void addPresentes(Funcionario funcionario)
	{
		presentes.add(funcionario);
	}
	
	public void removePresentes(Funcionario funcionario)
	{
		presentes.remove(funcionario);
	}
	
	public List <Funcionario> getAutorizados()
	{
		return Collections.unmodifiableList(autorizados);
	}
	
	public List <Funcionario> getPresentes()
	{
		return Collections.unmodifiableList(presentes);
	}
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public int getNivel() {
		return nivel;
	}
	
	public void setNivel(int nivel) {
		if(nivel >= Funcionario.NIVEL_MINIMO && nivel <= Funcionario.NIVEL_MAXIMO)
		{
			this.nivel = nivel;
		}
		else
		{
			this.nivel = Funcionario.NIVEL_MAXIMO;
		}
	}
	
	public void setHorario(Horario horario) {
		this.horario = horario;
	}
	
	public Horario getHorario()
	{
		return this.horario;
	}

	
	public String getDescricao() {
		return descricao;
	}
	
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
	public Horario getFuncionamento() {
		return funcionamento;
	}
	
	public void setFuncionamento(Horario funcionamento) {
		this.funcionamento = funcionamento;
	}


	@Override
	public String toString() {
		return "Instalacao [id=" + id + ", nivel=" + nivel + ", descricao=" + descricao + "]";
	}
	
	
	

	
	
	
}
