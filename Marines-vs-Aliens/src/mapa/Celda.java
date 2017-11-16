package mapa;

import java.util.LinkedList;
import entidad.Personaje;
import juego.Logica;
import entidad.ObjetoVida;
import entidad.Entidad;

public class Celda {
	protected Personaje personaje;
	protected ObjetoVida objeto;
	protected Mapa mapa;
	protected int fila;
	protected int columna;
	
	public Celda(Mapa mapa, int fila, int columna){
		this.personaje = null;
		this.objeto = null;
		this.mapa = mapa;
		this.fila = fila;
		this.columna = columna;
	}
	
	//Setea un objeto en la celda
	public void setObjeto(ObjetoVida o){
		objeto = o;
	}
	
	//Retorna el objeto de la celda
	public ObjetoVida getObjeto(){
		return objeto;
	}
	
	//Setea el personaje de la celda
	public void setPersonaje(Personaje p){
		personaje = p;
	}
	
	//Retorna el personaje de la celda
	public Personaje getPersonaje(){
		return personaje;
	}
	
	//Retorna las celdas vecinas a la actual
	public LinkedList<Celda> getVecinas() {
		LinkedList<Celda> toReturn = new LinkedList<Celda>();
		if(mapa.getCelda(fila+1, columna) != null)
			toReturn.addLast(mapa.getCelda(fila+1, columna));
		if(mapa.getCelda(fila-1, columna) != null)
			toReturn.addLast(mapa.getCelda(fila-1, columna));
		if(mapa.getCelda(fila, columna+1) != null)
			toReturn.addLast(mapa.getCelda(fila, columna+1));
		if(mapa.getCelda(fila, columna-1) != null)
			toReturn.addLast(mapa.getCelda(fila, columna-1));
		return toReturn;
	}
	
	//Retorna la celda de la izquierda a la actual
	public Celda getSiguiente(){
		if(columna == 0)
			return null;
		else
			return mapa.getCelda(fila*Logica.CHEIGHT, (columna-1)*Logica.CWIDTH);
	}
	
	public Celda getDerecha(){
		if(columna == 9)
			return null;
		else
			return mapa.getCelda(fila*Logica.CHEIGHT, (columna+1)*Logica.CWIDTH);
	}
	
	//Retorna la fila del mapa en la que se encuentra la celda
	public int getFila() {
		return fila;
	}
	
	//Retorna la columna del mapa en la que se encuentra la celda
	public int getColumna() {
		return columna;
	}
}