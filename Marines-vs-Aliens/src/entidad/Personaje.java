package entidad;

import javax.swing.JLabel;

import mapa.Celda;

public abstract class Personaje implements Entidad {
	
	protected JLabel grafico;
	protected Celda celda;
	protected int vida;
	protected int dano;
	protected int alcance;
	
	public Celda getCelda() {
		return celda;
	}
	
	public void setCelda(Celda c) {
		celda = c;
	}
	
	public JLabel getGrafico() {
		return grafico;
	}
	
	public void setGrafico(JLabel l) {
		grafico = l;
	}
	
	public abstract int getDano();
	
	public abstract int getAlcance();
	
	public abstract int getVida();
	
	public abstract void recibirDisparo(int d);
	
	public abstract void disparar();
}