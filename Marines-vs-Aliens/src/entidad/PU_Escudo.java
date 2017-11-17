package entidad;

public class PU_Escudo implements State {
	public void cambiarEstado(Personaje p){
		p.escudoON();
		//cambiar imagen
		p.setState(this);
	}
	
	public String toString(){
		return "escudo";
	}
}
