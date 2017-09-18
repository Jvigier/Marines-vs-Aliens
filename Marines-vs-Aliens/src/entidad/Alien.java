package entidad;

public class Alien extends Personaje {
	protected int velocidad;
	protected int puntaje;
	protected int monedas;
	
	public Alien(int da�o, int alcance, int vida, int velocidad, int puntaje, int monedas){
		super(da�o, alcance, vida);
		this.velocidad = velocidad;
		this.puntaje = puntaje;
		this.monedas = monedas;
	}
	
	public int getVelocidad(){
		return velocidad;
	}
	
	public int getPuntaje(){
		return puntaje;
	}
	
	public int getMonedas(){
		return monedas;
	}
}
