package entidad;

import javax.swing.JLabel;

import mapa.Celda;

public interface Entidad {
	
	public Celda getCelda();
	
	public void setCelda(Celda c);
	
	public JLabel getGrafico();
	
	public void setGrafico(JLabel l);
}
