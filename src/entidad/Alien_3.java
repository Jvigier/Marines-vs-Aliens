package entidad;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class Alien_3 extends ProtoAlien {
	
	public Alien_3(){
		velocidad = 2;
		puntaje = 100;
		dano = 2;
		vida = 200;
		alcance = 1;
		monedas = 50;
		grafico = new JLabel(new ImageIcon(this.getClass().getResource("/imagenes/Alien3.gif")));
	}
	
	//Clona el objeto
	public ProtoAlien clone() {
		ProtoAlien a = new Alien_3();
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