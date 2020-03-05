package Exercicio_4;
import java.util.Calendar;



public class Hora {
	
	int hora;
	int minutos;
	int segundos;
	
	Calendar rightNow = Calendar.getInstance();
		
	public Hora (int hora, int minutos, int segundos)
	{
		this.hora = hora;
		this.minutos = minutos;
		this.segundos = segundos;
	}
	
	public Hora ()
	{
		this.hora = rightNow.get(Calendar.HOUR_OF_DAY);
		this.minutos = rightNow.get(Calendar.MINUTE);
		this.segundos = rightNow.get(Calendar.SECOND);		
	}
	
	public String toString()
	{
		return "hora: " + hora + "Minutos: " + minutos + "segundos: " + segundos;
	}
	
	public void setHora(int hora)
	{
		this.hora = hora;
	}
	
	public void setMinutos (int minutos)
	{
		this.minutos = minutos;
	}
	
	public void setSegundos (int segundos)
	{
		this.segundos = segundos;
	}
	
	public int  gethora()
	{
		return hora;
	}
	
	public int getMinutos()
	{
		return minutos;
	}
	
	public int getSegundos()
	{
		return segundos;
	}
	
	public Boolean compareTo(Hora periodo1)
	{
		return hora == periodo1.hora && minutos == periodo1.minutos && segundos == periodo1.segundos;
	}
	
	public void somaHoras(int hora)
	{
		this.hora = this.hora + hora;
	}
	
	public void somaMinutos (int minutos)
	{
		this.minutos = this.minutos + minutos;
	}
	
	public void somaSegundos (int segundos)
	{
		this.segundos = this.segundos + segundos;
	}
	
	public int toDiferencaSegs(Hora periodo1, Hora periodo2)
	{
		return (((periodo1.hora - periodo2.hora) * 3600) + ((periodo1.minutos - periodo2.minutos)*60) +  (periodo1.segundos - periodo2.segundos));
	}
	
	public int toSegundos ()
	{
		return (hora * 3600) + (minutos * 60) + segundos;
	}
	
	public Hora clone (Hora periodo1)
	{		
		Hora periodo2 = new Hora();		
		periodo2.hora = periodo1.hora;
		periodo2.minutos = periodo1.minutos;
		periodo2.segundos = periodo1.segundos;	
		return periodo2;
	}
	
	
	
}
