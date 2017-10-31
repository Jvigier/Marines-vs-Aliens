package entidad;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class Meteorito extends ObjetoMapaVida{
	private int vida = 50;
	
	public Meteorito(){
		grafico = new JLabel(new ImageIcon(this.getClass().getResource("/imagenes/Meteorito.png")));
	}
	
	public ObjetoMapaVida clone(){
		ObjetoMapaVida o = new Meteorito();
		return o;
	}
	
	public int getVida(){
		return vida;
	}
	
}
