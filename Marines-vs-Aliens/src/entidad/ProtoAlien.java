package entidad;

public abstract class ProtoAlien extends Personaje {
	
	public abstract ProtoAlien clone();
	
	public abstract int getVelocidad();
	
	public abstract int getPuntaje();
	
	public abstract int getMonedas();
	
	public void visit(ObjetoMapa o){
		o.recibirDano(getDano());
	}
	
	public void visit(ProtoMarine p){
		p.recibirDisparo(getDano());
	}
	
	public void accept(ProtoMarine p){
		p.visit(this);
	}
}
