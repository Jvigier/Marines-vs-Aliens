package entidad;

public class PU_CampoProteccion implements State{
	public void cambiarEstado(Personaje p){
		//cambiar imagen
		p.setState(this);
	}
	
	public String toString(){
		return "campoProteccion";
	}
}
