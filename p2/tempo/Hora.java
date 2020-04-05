package p2.tempo;
import java.util.Calendar;

/**
 * @author fsergio
 *
 */
public class Hora implements Cloneable {
	private int horas;
	private int minutos;
	private int segundos;
	
	// constantes para v�rios c�lculos
	public static final int SEGS_POR_MINUTO = 60;
	public static final int MINS_POR_HORA = 60;
	public static final int SEGS_POR_HORA = SEGS_POR_MINUTO * MINS_POR_HORA;
	public static final int HORAS_POR_DIA = 24;
	public static final int MINS_POR_DIA = HORAS_POR_DIA * MINS_POR_HORA;
	public static final int SEGS_POR_DIA = HORAS_POR_DIA * SEGS_POR_HORA;
	
	public static final int MAX_SEGS = SEGS_POR_MINUTO - 1;
	public static final int MAX_MINS = MINS_POR_HORA - 1;
	public static final int MAX_HORAS = HORAS_POR_DIA - 1; 
	
	
    public Hora( ){
		Calendar cal = Calendar.getInstance();
		horas = cal.get( Calendar.HOUR_OF_DAY );
		minutos = cal.get( Calendar.MINUTE );
		segundos = cal.get( Calendar.SECOND );    	
    }
    
    public Hora( int h, int m, int s){
    	setHoras( h );
    	setMinutos( m );
    	setSegundos( s );
    }
    
    public Hora( long nSegsMeiaNoite ){
        // verificar se n� de segundos n�o � inv�lido
        if( nSegsMeiaNoite < 0 )
        	nSegsMeiaNoite = 0;
        if( nSegsMeiaNoite >= SEGS_POR_DIA )
        	nSegsMeiaNoite = SEGS_POR_DIA - 1; // SEGS_POR_DIA - 1 porque segundos come�am em 0 
        
        // o (int) serve s� para evitar mensagens de warning
        horas = (int)(nSegsMeiaNoite / SEGS_POR_HORA);
        minutos = (int)((nSegsMeiaNoite % SEGS_POR_HORA) / SEGS_POR_MINUTO);
        segundos = (int)((nSegsMeiaNoite % SEGS_POR_HORA) % SEGS_POR_MINUTO);
    }
       
    public Hora( String hStr ){
	    // ler a string no formato dia/m�s/ano
		String str[] = hStr.split(":");	    
    
	    // verificar se valores s�o v�lidos
        setHoras( Integer.parseInt( str[0] ) );
	    setMinutos( Integer.parseInt( str[1] ) );
	    setSegundos( Integer.parseInt( str[2] ) );	        	
    }

    // fun��es de acesso
    public int getHoras( ) {
    	return horas;
    }
    
    public int getMinutos( ) {
    	return minutos;
    }
    
    public int getSegundos( ) {
    	return segundos;
    }
    
    public void setHoras( int h ){
    	horas = h < 0? 0: h;
    	if( horas > 23 )
    		horas = 23;    	
    }
    
    public void setMinutos( int m ){
    	minutos = m < 0? 0: m;
    	if( minutos > 59 )
    		minutos = 59;    	
    }
    
    public void setSegundos( int s ){
    	segundos = s < 0? 0: s;
    	if( segundos > 59 )
    		segundos = 59;    	
    }
    
    
    // m�todos de implementa��o
    // retornam quantas vezes passaram de 24 horas (n� de dias)
    public int somaHoras( int numHoras ){
        // para garantir que o n� de horas � entre 0 e 23 aceita-se apenas o resto
        // da divis�o por 24
        // exemplo: se Horas = 20 e se somar 10 fica = 30 dividindo por 24 d�
        //          30/24 = 1 e resto 6
        //          ficariam ent�o as horas como sendo 6 da manh�
       	int totalHoras = horas + numHoras;
        horas = totalHoras % 24;
        return totalHoras / 24;    	 	
    }
    
    public int somaMinutos( int numMinutos ){
        // somar os novos minutos ao j� existentes
        minutos += numMinutos;
        // se a soma dos minutos superar os 59 tem-se de somar horas,
        // tantas quantas couberem dentro dos minutos somados
        int nDias = somaHoras( minutos/SEGS_POR_MINUTO );
        // garantir que minutos est� emtre 0 e 59
        minutos = minutos % SEGS_POR_MINUTO;
        return nDias;    	
    }
    
    
    public int somaSegundos( long numSegundos ){
        // procedimento semelhante aos minutos
        // usa-se seg porque segundos � int e perde-se resolu��o ao somar com long
        long seg = segundos + numSegundos;
        int nDias = somaMinutos( (int)(seg/SEGS_POR_MINUTO) );  // convers�o long para int, para o compilador n�os e queixar
        segundos = (int)(seg%SEGS_POR_MINUTO);
        return nDias;     	
    }
    
    // m�todo que retorna o n� de segundos desde a meia-noite desse dia
    public int toSegundos( ) {
    	return horas * SEGS_POR_HORA + minutos * SEGS_POR_MINUTO + segundos;
    }
    
    // m�todo para comparar Horas    
    public int  compareTo( Hora outra){
        if( horas != outra.horas )
            return horas - outra.horas;
        if( minutos != outra.minutos )
            return minutos - outra.minutos;
        return segundos - outra.segundos;       	
    }
    
    public long getDiferencaSegs( Hora outra ){
        return toSegundos() - outra.toSegundos();    	
    }
    
    // m�todo para imprimir no �cran
    public String toString() {
    	return horas + ":" + minutos + ":" + segundos;
    }

	public Hora clone( ) {
		return new Hora( horas, minutos, segundos);
	}
}
