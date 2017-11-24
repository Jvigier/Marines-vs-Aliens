package entidad;

import javax.swing.ImageIcon;
import javax.swing.JLabel;


public class Marine_4  extends ProtoMarine {
	
	public Marine_4 (){
		dano = 3;
		vida = 400;
		alcance = 2;
		precio = 200;
		grafico = new JLabel(new ImageIcon(this.getClass().getResource("/imagenes/Marine4.gif")));
	}
	
	//Clona el objeto
	public ProtoMarine clone(){
		ProtoMarine p = new Marine_4();
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