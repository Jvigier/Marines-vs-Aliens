package entidad;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class Barril extends ObjetoVida{
	private int vida = 800;
	
	public Barril(){
		grafico = new JLabel(new ImageIcon(this.getClass().getResource("/imagenes/Barril.png")));
	}
	
	public ObjetoVida clone(){
		ObjetoVida o = new Barril();
		return o;
	}
	
	public int getVida(){
		return vida;
	}
	
	public void recibirDano(int d){
		vida = vida-d;
	}
}
