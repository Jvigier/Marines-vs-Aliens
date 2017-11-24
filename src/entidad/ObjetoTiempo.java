package entidad;

import javax.swing.JLabel;
import mapa.Celda;

public abstract class ObjetoTiempo implements Entidad{
	protected Celda celda;
	protected JLabel grafico;
	
	public abstract void visit(ProtoAlien a);
	
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
	
	public abstract ObjetoTiempo clone();
}
