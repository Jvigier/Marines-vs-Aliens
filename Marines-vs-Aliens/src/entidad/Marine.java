package entidad;

public class Marine extends Personaje {
	protected int precio;
	
	public Marine(int da�o, int alcance, int vida, int precio){
		super(da�o,alcance,vida);
		this.precio = precio;
	}
	
	public int getPrecio(){
		return precio;
	}

}
