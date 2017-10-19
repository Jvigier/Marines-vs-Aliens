package entidad;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class Alien_3 extends ProtoAlien {

	private int velocidad = 2;
	private int puntaje = 100;
	private int dano = 10;
	private int vida = 100;
	private int alcance = 1;
	private int monedas = 50;
	
	public Alien_3(){
		grafico = new JLabel(new ImageIcon(this.getClass().getResource("/juego/alien.gif")));
	}
	
	public ProtoAlien clone() {
		ProtoAlien a = new Alien_3();
		return a;
	}

	public int getVelocidad() {
		return velocidad;
	}

	public int getPuntaje() {
		return puntaje;
	}

	public int getMonedas() {
		return monedas;
	}

	public void mover() {
		// TODO Auto-generated method stub
		
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
		vida = vida - d;
	}

	public void disparar() {		
	}

}


