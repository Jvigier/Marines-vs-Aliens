package mapa;

import java.util.LinkedList;
import entidad.*;
import juego.Logica;

public class Celda {
	protected LinkedList<ProtoAlien> alien;
	protected ProtoMarine marine;
	protected ObjetoVida objeto;
	protected ObjetoTiempo objetoT;
	protected Mapa mapa;
	protected int fila;
	protected int columna;
	
	public Celda(Mapa mapa, int fila, int columna){
		this.alien = new LinkedList<ProtoAlien>();
		this.marine = null;
		this.objeto = null;
		this.objetoT = null;
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
	
	//Setea un objeto en la celda
	public void setObjetoT(ObjetoTiempo o){
		objetoT = o;
	}
		
	//Retorna el objeto de la celda
	public ObjetoTiempo getObjetoT(){
		return objetoT;
	}
	
	//Retorna el personaje de la celda
	public LinkedList<ProtoAlien> getAliens(){
		return alien;
	}
	
	//Setea el personaje de la celda
	public void setMarine(ProtoMarine m){
		marine = m;
	}
		
	//Retorna el personaje de la celda
	public ProtoMarine getMarine(){
		return marine;
	}
	
	//Retorna las celdas vecinas a la actual
	public Celda getArriba(){
		return mapa.getCelda((fila+1)*Logica.CHEIGHT, columna*Logica.CWIDTH);
	}
	
	//Retorna la celda de la izquierda a la actual
	public Celda getIzquierda(){
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