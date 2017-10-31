package entidad;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class Barril extends ObjetoMapaVida{
	private int vida = 80;
	
	public Barril(){
		grafico = new JLabel(new ImageIcon(this.getClass().getResource("/imagenes/Barril.png")));
	}
	
	public ObjetoMapaVida clone(){
		ObjetoMapaVida o = new Barril();
		return o;
	}
	
	public int getVida(){
		return vida;
	}
}
