package juego;

import mapa.*;
import entidad.*;
import java.util.LinkedList;

public class Logica {
	protected Mapa mapa;
	protected LinkedList<Alien> enemigos;
	protected LinkedList<Marine> aliados;
	protected LinkedList<ObjetoMapa> objetos;
	protected GUI gui;
	
	public Logica(GUI gui){
		this.gui = gui;
		enemigos = new LinkedList<Alien>();
		aliados = new LinkedList<Marine>();
		objetos = new LinkedList<ObjetoMapa>();
		
	}
	
	public void crearMapa(){
		gui.crearMapa();
		mapa = new Mapa(6,10);
	}
	
	public void crearAliado(){
		Marine marine1 = new Marine(0,0,0,0);
		gui.crearAliado();
		mapa.getCelda(0,5).setPersonaje(marine1);
		aliados.addLast(marine1);
	}
}
