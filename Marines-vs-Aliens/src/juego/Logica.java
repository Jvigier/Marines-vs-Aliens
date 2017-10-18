package juego;

import mapa.*;

import java.util.LinkedList;
import java.util.Random;

import javax.swing.JLabel;

import entidad.*;
import gui.GUI;

public class Logica {
	protected Mapa mapa;
	protected LinkedList<ProtoAlien> enemigos;
	protected LinkedList<ProtoMarine> aliados;
	protected ProtoMarine[] marines;
	protected ProtoAlien[] aliens;
	protected ObjetoMapa [] objetos;
	protected GUI gui;
	protected int puntaje;
	
	public static final int CWIDTH = 136;
	public static final int CHEIGHT = 111;
	//public static final int MOFFSET = 100;
	
	
	public Logica(GUI gui){
		mapa = new Mapa(6,10);
		this.gui = gui;
		marines = new ProtoMarine[5];
		marines[0] = new Marine_1();
		aliens = new ProtoAlien[5];
		aliens[0] = new Alien_1();
		objetos = new ObjetoMapa[4];
		aliados = new LinkedList<ProtoMarine>();
		enemigos = new LinkedList<ProtoAlien>();
	}
	
	public int getPuntaje(){
		return puntaje;
	}
	
	public void crearMapa(){
		gui.crearMapa();
		mapa = new Mapa(6,10);
	}
	
	public LinkedList<ProtoAlien> getEnemigos(){
		return enemigos;
	}
	
	public JLabel crearAliado(int x, int y, int tipo){
		ProtoMarine m = marines[tipo].clone();
		Celda c = mapa.getCelda(y, x);
		//Celda c = mapa.getCelda(1230,670);
		m.setCelda(c);
		c.setPersonaje(m);
		aliados.add(m);
		JLabel l = m.getGrafico();
		//System.out.println(c.getX()*CWIDTH, c.getY()*CHEIGHT+MOFFSET, CWIDTH, CHEIGHT);
		l.setBounds(c.getY()*CWIDTH, c.getX()*CHEIGHT, CWIDTH, CHEIGHT);
		return l;
	}
	
	
	public JLabel crearEnemigo(){
		Random rnd = new Random();
		ProtoAlien a = aliens[0].clone();
		Celda c = mapa.getCelda(1300,rnd.nextInt(650));
		a.setCelda(c);
		c.setPersonaje(a);
		enemigos.add(a);
		JLabel l = a.getGrafico();
		l.setBounds(c.getY()*CWIDTH, c.getX()*CHEIGHT, CWIDTH, CHEIGHT);
		return l;
	}
	
	public void mover(){
		for (ProtoAlien a : enemigos){
			a.getGrafico().setLocation(a.getGrafico().getX()-a.getVelocidad(), a.getGrafico().getY());
		}
			
	}

	public void morir() {
		LinkedList<ProtoAlien> eliminarAliens = new LinkedList<>();
		LinkedList<ProtoMarine> eliminarMarines = new LinkedList<>();
		for (ProtoAlien a : enemigos){
			if (a.getVida() <= 0){
				eliminarAliens.add(a);
			}
		}
		for (ProtoMarine m : aliados){
			if (m.getVida() <= 0){
				eliminarMarines.add(m);
			}
		}
		for (ProtoAlien a : eliminarAliens){
			gui.removerLabel(a.getGrafico());
			a.getCelda().setPersonaje(null);
			a.setCelda(null);
			enemigos.remove(a);
			puntaje = puntaje+a.getPuntaje();
			
		}
		for (ProtoMarine m : eliminarMarines){
			gui.removerLabel(m.getGrafico());
			m.getCelda().setPersonaje(null);
			m.setCelda(null);
			enemigos.remove(m);
			
		}
	}
}