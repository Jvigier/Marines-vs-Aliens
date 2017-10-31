package mapa;

import java.util.LinkedList;
import entidad.Personaje;
import juego.Logica;
import entidad.ObjetoMapaVida;
import entidad.Entidad;

public class Celda {
	protected Personaje personaje;
	protected ObjetoMapaVida objeto;
	//nuevo
	protected Entidad entidad;
	protected Mapa mapa;
	protected int fila;
	protected int columna;
	
	public Celda(Mapa mapa, int fila, int columna){
		this.personaje = null;
		this.objeto = null;
		//nuevo
		this.entidad = null;
		this.mapa = mapa;
		this.fila = fila;
		this.columna = columna;
	}
	
	//nuevo
	public void setEntidad(Entidad e){
		entidad = e;
	}
	
	//nuevo
	public Entidad getEntidad(){
		return entidad;
	}
	
	//Setea un objeto en la celda
	public void setObjeto(ObjetoMapaVida o){
		objeto = o;
	}
	
	//Retorna el objeto de la celda
	public ObjetoMapaVida getObjeto(){
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
		return mapa.getCelda(fila*Logica.CHEIGHT, (columna-1)*Logica.CWIDTH);
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