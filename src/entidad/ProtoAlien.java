package entidad;

public abstract class ProtoAlien extends Personaje {
	protected int velocidad, puntaje, monedas;
	
	public void reducirVelocidad(){
		velocidad = 1;
	}
	
	public void aumentarVelocidad(){
		velocidad+=2;
	}

	//Clona el objeto
	public abstract ProtoAlien clone();
	
	//Retorna la velocidad del alien
	public abstract int getVelocidad();
	
	//Retorna el puntaje del alien
	public abstract int getPuntaje();
	
	//Retorna las monedas del alien
	public abstract int getMonedas();
	
	//Visitor para atacar un objeto
	public void visit(ObjetoVida o){
		o.recibirDano(getDano());
	}
	
	//Visitor para efectuar el disparo
	public void visit(ProtoMarine p){
		p.recibirDisparo(getDano());
	}
	
	//Visitor para recibir el disparo
	public void accept(ProtoMarine p){
		p.visit(this);
	}
	
	public void accept(ObjetoTiempo o){
		o.visit(this);
	}
}