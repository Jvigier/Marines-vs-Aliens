package entidad;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class Alien_2 extends ProtoAlien {
	
	public Alien_2(){
		velocidad = 2;
		puntaje = 75;
		dano = 2;
		vida = 300;
		alcance = 1;
		monedas = 75;
		grafico = new JLabel(new ImageIcon(this.getClass().getResource("/imagenes/Alien2.gif")));
	}
	
	//Clona el objeto
	public ProtoAlien clone() {
		ProtoAlien a = new Alien_2();
		return a;
	}
	
	//Retorna la velocidad del alien
	public int getVelocidad() {
		return velocidad;
	}
	
	//Retorna el puntaje del alien
	public int getPuntaje() {
		return puntaje;
	}
	
	//Retorna las monedas del alien
	public int getMonedas() {
		return monedas;
	}
	
	//Retorna el dano del alien
	public int getDano() {
		return dano;
	}
	
	//Retorna el alcance del alien
	public int getAlcance() {
		return alcance;
	}
	
	//Retorna la vida del alien
	public int getVida() {
		return vida;
	}
	
	//Disminuye la vida del alien
	public void recibirDisparo(int d) {
		vida = vida - d;
	}
}