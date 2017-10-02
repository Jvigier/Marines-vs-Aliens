package entidad;

public abstract class ProtoAlien extends Personaje {
	
	public abstract ProtoAlien clone();
	
	public abstract int getVelocidad();
	
	public abstract int getPuntaje();
	
	public abstract int getMonedas();
	
	public abstract void mover();
}
