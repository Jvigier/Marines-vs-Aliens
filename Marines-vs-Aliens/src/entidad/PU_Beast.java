package entidad;

public class PU_Beast implements State{
	public void cambiarEstado(Personaje p){
		p.beastON();
		//cambiar imagen
		p.setState(this);
	}
	
	public String toString(){
		return "beast";
	}
}
