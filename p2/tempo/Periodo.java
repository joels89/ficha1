package p2.tempo;

/**
 * Esta classe representa um per�odo de tempo

 */
public class Periodo {

	private Hora ini;
	private Hora fim;
	
	/**
	 * Criar um per�odo indicando a hora inicial e final
	 * garantindo que a inicial � menor que a final
	 * @param ini hora inicial do periodo
	 * @param fim hora final do periodo
	 */
	public Periodo(Hora ini, Hora fim) {
		if( ini.compareTo(fim) > 0 ){
			this.ini = fim;
			this.fim = ini;			
		}
		else {
			this.ini = ini;
			this.fim = fim;
		}
	}	

	/**
	 * Criar um per�odo indicando a hora inicial e a dura��o em segundos
	 * @param ini hora inicial do per�odo
	 * @param duracao dura��o do per�odo em segundos
	 */
	public Periodo(Hora ini, int duracao ) {
		this.ini = ini;
		// tem de ser um clone sen�o na linha seguinte altera tamb�m a hora inicial
		fim = ini.clone();  
		fim.somaSegundos( duracao );
	}	


	/**
	 * devolve a hora final
	 * @return a hora final
	 */
	public Hora getFim() {
		return fim;
	}


	/**
	 * altera a hora final
	 * @param fim a nova hora final
	 */
	public void setFim(Hora fim) {
		if( fim.compareTo( ini) >= 0)
			this.fim = fim;
	}


	/**
	 * devolve a hora inicial
	 * @return a hora inicial
	 */
	public Hora getIni() {
		return ini;
	}


	/**
	 * altera a hora inicial
	 * @param ini a nova hora inicial
	 */
	public void setIni(Hora ini) {
		if( ini.compareTo( fim ) <= 0)
			this.ini = ini;
	}

	/**
	 * retorna o Per�odo em forma de String
	 * @return o Per�odo em forma de String
	 */
	public String toString(){
		return "[ " + ini + " - " + fim + " ]";
	}

	/**
	 * indica se uma dada hora est� dentro deste per�odo de tempo
	 * @param h a hora que se pretende verificar se est� dentro do per�odo de tempo
	 * @return se a hora est� dentro ou n�o
	 */
	public boolean estaDentro( Hora h ){
		return h.compareTo( ini ) >= 0 && h.compareTo( fim ) <= 0;
	}
	
	
	/**
	 * Verifica se outro periodo de tempo interseta ou n�o este per�odo
	 * @param outro per�odo que se pretende verificar a interse��o
	 * @return se outro per�odo intersecta o nosso
	 */
	public boolean interseta( Periodo outro ){
		if( outro.fim.compareTo( ini ) <= 0 )
			return false;
		if( outro.ini.compareTo( fim ) >= 0 )
			return false;		
		return true;		
	}
	
	
	/**
	 * indica se o nosso per�odo est� englobado dentro do periodo p 
	 * Um periodo est� englobado noutro se estiver completamente dentro dele 
	 * @param p onde o nosso pode estar englobado 
	 * @return se o nosso per�odo est� englobado em p  
	 */
	public boolean estaContido( Periodo p ){
		return p.ini.compareTo( ini ) < 0 && p.fim.compareTo( fim ) > 0;
	}
	
	
	/**
	 * indica se o periodo p est� englobado do nosso per�odo
	 * Um periodo est� englobado noutro se estiver completamente dentro dele 
	 * @param p per�odo que pode estar englobado no nosso
	 * @return se p est� englobado no nosso per�odo
	 */
	public boolean contem( Periodo p ){
		return p.estaContido( this );
	}
	
	
	/**
	 * Junta o per�odo p ao nosso. A jun��o s� � v�lida se os per�odos se intersetarem,
	 * caso contr�rio, n�o h� jun��o
	 * @param p per�odo a juntar ao nosso
	 */
	public void junta( Periodo p ){
		if( !interseta(p))
			return;
		
		if( p.ini.compareTo(ini) < 0 )
			ini = p.ini.clone();
		if( p.fim.compareTo(fim) > 0 )
			fim = p.fim.clone();		
	}
	
	
	/**
	 * devolve a uni�o do nosso per�odo com o per�odo p
	 * Se os per�odos n�o se intersetarem n�o h� uni�o. Se se intersetarem
	 * a uni�o indica o maior periodo de tempo poss�vel juntando os dois
	 * @param p per�odo a testar
	 * @return a uni�o do nosso per�odo com o per�odo p
	 */
	public Periodo getUniao( Periodo p){
		if( !interseta( p ))
			return null;
		Hora i = p.ini.compareTo(ini) < 0? p.ini.clone(): ini.clone();
		Hora f = p.fim.compareTo(fim) > 0? p.fim.clone(): fim.clone();
		return new Periodo( i, f);
	}
	
	
	/**
	 * Indica a interse��o do nosso per�odo com o per�odo p, ou seja,
	 * qual o per�odo de tempo que possuem em comum
	 * @param p per�odo a testar
	 * @return o per�odo de tempo que possuem em comum, null se n�o se intersetarem
	 */
	public Periodo getInterseccao( Periodo p){
		if( !interseta(p) )
			return null;
		
		Hora i = p.ini.compareTo(ini) > 0? p.ini.clone(): ini.clone();
		Hora f = p.fim.compareTo(fim) < 0? p.fim.clone(): fim.clone();
		return new Periodo( i, f);
	}
}
