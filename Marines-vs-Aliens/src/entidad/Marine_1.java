package entidad;

import javax.swing.ImageIcon;
import javax.swing.JLabel;


public class Marine_1  extends ProtoMarine {
	private int dano = 10;
	private int vida = 100;
	private int alcance = 2;
	private int precio = 50;
	
	public Marine_1 (){
		grafico = new JLabel(new ImageIcon(this.getClass().getResource("/juego/marine.gif")));

	}
	public ProtoMarine clone(){
		ProtoMarine p = new Marine_1();
		return p;
	}
	
	public int getPrecio() {
		return precio;
	}

	public int getDano() {
		return dano;
	}

	public int getAlcance() {
		return alcance;
	}

	public int getVida() {
		return vida;		
	}

	public void recibirDisparo(int d) {
		
	}

	public void disparar() {
		// TODO Auto-generated method stub
		
	}
}
