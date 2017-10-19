package entidad;


public abstract class ProtoMarine extends Personaje {
	
	public abstract int getPrecio();

	public abstract ProtoMarine clone();
	
	public void visit(ProtoAlien p){
		p.recibirDisparo(getDano());
	}
	
	public void accept(ProtoAlien p){
		p.visit(this);
	}
}
