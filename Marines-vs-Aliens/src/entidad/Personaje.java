package entidad;

public class Personaje {
	protected int daño;
	protected int alcance;
	protected int vida;
	
	public Personaje(int daño, int alcance, int vida){
		this.daño = daño;
		this.alcance = alcance;
		this.vida = vida;
	}
	
	public int getDaño(){
		return daño;
	}
	
	public int getAlcance(){
		return alcance;
	}
	
	public int getVida(){
		return vida;
	}
	
	public void recibirDisparo(int d){
		if(vida > d)
			vida -= d;
		else vida = 0;
	}
}
