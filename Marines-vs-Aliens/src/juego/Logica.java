package juego;

import mapa.*;
import entidad.*;

public class Logica {
	public Mapa mapa;
	
	public Logica(){
		mapa = new Mapa(6,10);
	}
	
	public void agregarUnPersonaje(){
		Marine m1 = new Marine(10,1,100,1500);
		mapa.getCelda(2, 2).setPersonaje(m1);
	}
}
