package entidad;

import javax.swing.ImageIcon;
import javax.swing.JLabel;


public class Marine_1  extends ProtoMarine {
	private int dano = 0;
	private int vida = 100;
	private int alcance = 1;
	private int precio = 50;
	
	public Marine_1 (){
		grafico = new JLabel(new ImageIcon(this.getClass().getResource("/juego/marine.gif")));
	}
	
	//Clona el objeto
	public ProtoMarine clone(){
		ProtoMarine p = new Marine_1();
		return p;
	}
	
	//Retorna el precio del marine
	public int getPrecio() {
		return precio;
	}
	
	//Retorna el dano del marine
	public int getDano() {
		return dano;
	}
	
	//Retorna el alcance del marine
	public int getAlcance() {
		return alcance;
	}
	
	//Retorna la vida del marine
	public int getVida() {
		return vida;		
	}
	
	//Disminuye la vida del marine
	public void recibirDisparo(int d) {
		vida = vida-d;
	}
}
