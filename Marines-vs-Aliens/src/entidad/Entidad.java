package entidad;

import javax.swing.JLabel;

import mapa.Celda;

//Interface Entidad
//Se declaran los comandos y consultas que posee una Entidad del mapa
public interface Entidad {
	
	//Retorna la celda donde esta ubicada la entidad
	public Celda getCelda();
	
	//Setea la celda donde se va a ubicar la entidad
	public void setCelda(Celda c);
	
	//Retorna el grafico asociado a la entidad
	public JLabel getGrafico();
	
	//Setea el grafico asociado a la entidad
	public void setGrafico(JLabel l);
}
