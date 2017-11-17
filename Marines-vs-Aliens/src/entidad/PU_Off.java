package entidad;

public class PU_Off implements State {
	public void cambiarEstado(Personaje p){
		State state = p.getState();
		if(state.toString() == "escudo")
			p.escudoOFF();
		if(state.toString() == "beast")
			p.beastOFF();
		p.setState(this);
	}
	
	public String toString(){
		return "off";
	}
}
