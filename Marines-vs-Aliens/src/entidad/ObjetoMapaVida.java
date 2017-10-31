package entidad;

import javax.swing.JLabel;
import mapa.Celda;

public abstract class ObjetoMapaVida implements Entidad{
	protected int vida;
	protected Celda celda;
	protected JLabel grafico;
	
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
	
	public int getVida(){
		return vida;
	}
	
	public void accept(ProtoAlien p){
		recibirDano(p.dano);
	}
	
	public void recibirDano(int d){
		vida = vida-d;
	}
}
