package entidad;

import javax.swing.ImageIcon;
import javax.swing.JLabel;


public class Marine_3  extends ProtoMarine {
	
	public Marine_3 (){
		dano = 3;
		vida = 300;
		alcance = 2;
		precio = 150;
		grafico = new JLabel(new ImageIcon(this.getClass().getResource("/imagenes/Marine3.gif")));
	}
	
	//Clona el objeto
	public ProtoMarine clone(){
		ProtoMarine p = new Marine_3();
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