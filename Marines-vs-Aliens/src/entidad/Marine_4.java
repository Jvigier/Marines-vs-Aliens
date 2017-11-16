package entidad;

import javax.swing.ImageIcon;
import javax.swing.JLabel;


public class Marine_4  extends ProtoMarine {
	private int dano = 14;
	private int vida = 400;
	private int alcance = 2;
	private int precio = 200;
	
	public Marine_4 (){
		state = new PU_Off();
		grafico = new JLabel(new ImageIcon(this.getClass().getResource("/imagenes/Marine4.gif")));
		graficoPU = new JLabel(new ImageIcon(this.getClass().getResource("/imagenes/Marine4PU.gif")));
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