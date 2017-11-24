package entidad;

import javax.swing.JLabel;
import mapa.Celda;

public abstract class Personaje implements Entidad {
	protected JLabel grafico;
	protected Celda celda;
	protected int vida;
	protected int dano;
	protected int alcance;
	
	//Retorna la celda del personaje
	public Celda getCelda() {
		return celda;
	}
	
	//Setea la celda del personaje
	public void setCelda(Celda c) {
		celda = c;
	}
	
	//Retorna el grafico del personaje
	public JLabel getGrafico() {
		return grafico;
	}
	
	//Setea el grafico del personaje
	public void setGrafico(JLabel l) {
		grafico = l;
	}
	
	//Retorna el dano del personaje
	public abstract int getDano();
	
	//Retorna el alcance del personaje
	public abstract int getAlcance();
	
	//Retorna la vida del personaje
	public abstract int getVida();
	
	//Disminuye la vida del personaje
	public abstract void recibirDisparo(int d);
	
	public void escudo(){
		vida = vida + 300;
	}
	
	public void aumentarAlcance(){
		alcance++;
	}
	
	public void campoProteccion(){
		dano = dano + 1000;
		alcance = 1;
	}
}