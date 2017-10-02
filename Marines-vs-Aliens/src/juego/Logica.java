package juego;

import mapa.*;

import java.util.LinkedList;

import javax.swing.JLabel;

import entidad.*;

public class Logica {
	protected Mapa mapa;
	protected LinkedList<ProtoAlien> enemigos;
	protected LinkedList<ProtoMarine> aliados;
	protected ProtoMarine[] marines;
	protected ProtoAlien[] aliens;
	protected ObjetoMapa [] objetos;
	protected GUI gui;
	protected int puntaje;
	
	public Logica(GUI gui){
		mapa = new Mapa(6,10);
		this.gui = gui;
		marines = new ProtoMarine[5];
		marines[0] = new Marine_1();
		aliens = new ProtoAlien[5];
		objetos = new ObjetoMapa[4];
		aliados = new LinkedList<ProtoMarine>();
	}
	
	public void crearMapa(){
		gui.crearMapa();
		mapa = new Mapa(6,10);
	}
	
	public JLabel crearAliado(int x, int y, int tipo){
		ProtoMarine m = marines[tipo].clone();
		Celda c = mapa.getCelda(x, y);
		m.setCelda(c);
		c.setPersonaje(m);
		aliados.add(m);
		JLabel l = m.getGrafico();
		l.setBounds(c.getX()*128, c.getY()*100, 128, 100);
		return l;
	}
	
	public void mover(){
		//for(Alien e : enemigos){
			
		//	e.mover();
		//}
	}
}