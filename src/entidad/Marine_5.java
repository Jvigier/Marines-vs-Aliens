package entidad;

import javax.swing.ImageIcon;
import javax.swing.JLabel;


public class Marine_5  extends ProtoMarine {
	protected ProtoMarine segundo;
	
	public Marine_5 (){
		dano = 4;
		vida = 500;
		alcance = 3;
		precio = 500;
		grafico = new JLabel(new ImageIcon(this.getClass().getResource("/imagenes/Bastion.gif")));
	}
	
	//Clona el objeto
	public ProtoMarine clone(){
		ProtoMarine p = new Marine_5();
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
	
	public void setSegundo(ProtoMarine s){
		segundo = s;
	}
	
	public void recibirDano(int d){
		vida = vida - d;
	}
	
	//Disminuye la vida del marine
	public void recibirDisparo(int d) {
		vida = vida-d;
		segundo.recibirDano(d);
	}
}