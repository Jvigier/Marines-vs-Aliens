package mapa;

import java.util.LinkedList;
import entidad.Personaje;
import entidad.ObjetoMapa;

public class Celda {
	protected Personaje personaje;
	protected ObjetoMapa objeto;
	protected Mapa mapa;
	
	protected int x;
	protected int y;
	
	public Celda(Mapa mapa, int x, int y){
		this.personaje = null;
		this.objeto = null;
		this.mapa = mapa;
		
		this.x = x;
		this.y = y;
	}
	
	public void setObjeto(ObjetoMapa o){
		objeto = o;
	}
	
	public ObjetoMapa getObjeto(){
		return objeto;
	}
	
	public void setPersonaje(Personaje p){
		personaje = p;
	}
	
	public Personaje getPersonaje(){
		return personaje;
	}
	
	public LinkedList<Celda> getVecinas() {
		LinkedList<Celda> toReturn = new LinkedList<Celda>();
		if(mapa.getCelda(x+1, y) != null)
			toReturn.addLast(mapa.getCelda(x+1, y));
		if(mapa.getCelda(x-1, y) != null)
			toReturn.addLast(mapa.getCelda(x-1, y));
		if(mapa.getCelda(x, y+1) != null)
			toReturn.addLast(mapa.getCelda(x, y+1));
		if(mapa.getCelda(x, y-1) != null)
			toReturn.addLast(mapa.getCelda(x, y-1));
		return toReturn;
	}
	
	public Celda getSiguiente(){
		return mapa.getCelda(x-1, y);
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}
}
