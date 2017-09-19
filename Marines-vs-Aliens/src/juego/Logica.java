package juego;

import mapa.*;
import entidad.*;

public class Logica {
	protected Mapa mapa;
	protected Alien [] enemigos;
	protected Marine [] aliados;
	protected ObjetoMapa [] objetos;
	private GUI gui;
	
	public Logica(){
		mapa = new Mapa(6,10);
		gui = new GUI();
		gui.main(null);
	}
	
	public void crearAliado(int f, int c){
		Marine m = new Marine(10,1,100,1500);
		if(mapa.getCelda(f, c) == null)
			mapa.getCelda(f, c).setPersonaje(m);
		gui.addPersonaje();
	}
	
	public void disparar(Personaje p1, Personaje p2){
		p2.recibirDisparo(p1.getDaño());
	}
}
