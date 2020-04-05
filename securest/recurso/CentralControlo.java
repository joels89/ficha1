package securest.recurso;

import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Esta clase representa a central de controlo do sistema
 * Possui as listas de instala��es e de funcion�rios
 * Sufgere-se que usem um mapa para melhorar a pesquisa por id de funcion�rios e de instala��es
 * @author 
 */
public class CentralControlo {

	private Map<Integer,Instalacao> instalacoes = new HashMap<Integer,Instalacao>();
	private Map<Integer,Funcionario> funcionarios = new HashMap<Integer,Funcionario>();

	public CentralControlo(){			
	}		

	/**
	 * adicionar um funcion�rio � central de comendoa
	 * @param Funcionario novo funcion�rio a adicionar
	 */
	public void addFuncionario(Funcionario Funcionario) 
	{
		funcionarios.put(Funcionario.getId(), Funcionario);
	}
	
	/**
	 * devolve o funcion�rio com o identificador especificado
	 * @param id identificador do Funcionario a obter
	 * @return Funcion�rio com o identificador especificado
	 */
	public Funcionario getFuncionario(int id) {		
		return funcionarios.get(id);
	}

	/**
	 * remove o funcion�rio do sistema
	 * @param id identificado do Funcionario a remover
	 */
	public void removeFuncionario( int id ){
		funcionarios.remove( id );
	}
	
	/**
	 * devolve uma cole��o com todos os funcion�rios existentes no sistema
	 * @return uma cole��o com todas os funcion�rios existentes no sistema
	 */
	public Collection<Funcionario> getFuncionarios(){
		return Collections.unmodifiableCollection( funcionarios.values() );
	}	

	/**
	 * adiciona uma instala��o ao sistema
	 * @param inst instala��o a adicionar
	 */
	public void addInstalacao(Instalacao inst) {
		
		instalacoes.put(inst.getId(), inst);

	}
	
	/**
	 * devolve a instala��o com o identificador especificado
	 * @param id identificador da instala��o pretendida
	 * @return a instala��o com o identificador especificado
	 */
	public Instalacao getInstalacao(int id) {
		return instalacoes.get( id );		
	}
	
	/**
	 * remove uma instala��o do sistema
	 * @param id identificador da instal��oa  remover
	 */
	public void removeInstalacao( int id ){
		instalacoes.remove( id );
	}

	/**
	 * devolve uma cole��o com todas as instala��es existentes no sistema
	 * @return uma cole��o com todas as instala��es existentes no sistema
	 */
	public Collection<Instalacao> getInstalacoes(){
		return Collections.unmodifiableCollection( instalacoes.values() );
	}
}
