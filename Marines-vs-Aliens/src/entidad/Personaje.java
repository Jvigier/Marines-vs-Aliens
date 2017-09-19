package entidad;

public class Personaje {
	protected int da�o;
	protected int alcance;
	protected int vida;
	
	public Personaje(int da�o, int alcance, int vida){
		this.da�o = da�o;
		this.alcance = alcance;
		this.vida = vida;
	}
	
	public int getDa�o(){
		return da�o;
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
