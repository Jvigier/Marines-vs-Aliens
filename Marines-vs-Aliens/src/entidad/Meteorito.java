package entidad;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class Meteorito extends ObjetoVida{
	private int vida = 500;
	
	public Meteorito(){
		grafico = new JLabel(new ImageIcon(this.getClass().getResource("/imagenes/Meteorito.png")));
	}
	
	public ObjetoVida clone(){
		ObjetoVida o = new Meteorito();
		return o;
	}
	
	public int getVida(){
		return vida;
	}
	
	public void recibirDano(int d){
		vida = vida-d;
	}
}
