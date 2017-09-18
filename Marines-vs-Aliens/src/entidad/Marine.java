package entidad;

public class Marine extends Personaje {
	protected int precio;
	
	public Marine(int daño, int alcance, int vida, int precio){
		super(daño,alcance,vida);
		this.precio = precio;
	}
	
	public int getPrecio(){
		return precio;
	}

}
