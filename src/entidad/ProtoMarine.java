package entidad;


public abstract class ProtoMarine extends Personaje {
	protected int precio;
	
	//Retorna el precio del marine
	public abstract int getPrecio();
	
	//Clona el objeto
	public abstract ProtoMarine clone();
	
	//Visitor para efectuar el disparo
	public void visit(ProtoAlien p){
		p.recibirDisparo(getDano());
	}
	
	//Visitor para recibir el disparo
	public void accept(ProtoAlien p){
		p.visit(this);
	}
	
	public void recibirDano(int d){
	}
	
	public void setSegundo(ProtoMarine s){
	}
}
