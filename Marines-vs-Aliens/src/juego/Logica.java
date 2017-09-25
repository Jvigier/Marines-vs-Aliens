package juego;

import mapa.*;
import entidad.*;

public class Logica {
	protected Mapa mapa;
	protected Alien [] enemigos;
	protected Marine [] aliados;
	protected ObjetoMapa [] objetos;
	protected GUI gui;
	
	public Logica(GUI gui){
		this.gui = gui;
		enemigos = new Alien[5];
		aliados = new Marine[5];
		objetos = new ObjetoMapa[4];
		gui.crearAliado();
		gui.crearMapa();
	}
	
	public void crearMapa(){
		gui.crearMapa();
		mapa = new Mapa(6,10);
	}
	
	public void crearAliado(){
		gui.crearAliado();
		mapa.getCelda(0,5).setPersonaje(p);;
	}
}
