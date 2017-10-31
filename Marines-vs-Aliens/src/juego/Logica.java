package juego;

import mapa.*;

import java.util.LinkedList;
import java.util.Random;

import javax.swing.JLabel;

import entidad.*;
import gui.GUI;

public class Logica {
	public static final int CWIDTH = 136;
	public static final int CHEIGHT = 111;
	protected GUI gui;
	protected Mapa mapa;
	protected LinkedList<ProtoAlien> enemigos;
	protected LinkedList<ProtoMarine> aliados;
	protected ProtoMarine[] marines;
	protected ProtoAlien[] aliens;
	protected ObjetoMapaVida [] objetos;
	protected int puntaje;
	
	public Logica(GUI gui){
		this.gui = gui;
		marines = new ProtoMarine[5];
		marines[0] = new Marine_1();
		marines[1] = new Marine_2();
		marines[2] = new Marine_3();
		marines[3] = new Marine_4();
		marines[4] = new Marine_5();
		aliens = new ProtoAlien[6];
		aliens[0] = new Alien_1();
		aliens[1] = new Alien_2();
		aliens[2] = new Alien_3();
		aliens[3] = new Alien_4();
		aliens[4] = new Alien_5();
		aliens[5] = new Alien_6();
		objetos = new ObjetoMapaVida[4];
		aliados = new LinkedList<ProtoMarine>();
		enemigos = new LinkedList<ProtoAlien>();
	}
	
	//Crea el mapa del juego
	public void crearMapa(){
		gui.crearMapa();
		mapa = new Mapa(6,10);
	}
	
	//Retorna el puntaje del juego
		public int getPuntaje(){
			return puntaje;
	}
	
	//Retorna una lista de enemigos del juego
	public LinkedList<ProtoAlien> getEnemigos(){
		return enemigos;
	}
	
	//Crea un aliado, y lo agrega grafica y logicamente
	public JLabel crearAliado(int fila, int columna, int tipo){
		//crearObjeto();
		ProtoMarine m = marines[tipo].clone();
		Celda c = mapa.getCelda(fila, columna);
		m.setCelda(c);
		c.setPersonaje(m);
		aliados.add(m);
		JLabel l = m.getGrafico();
		l.setBounds(c.getColumna()*CWIDTH, c.getFila()*CHEIGHT, CWIDTH, CHEIGHT);
		return l;
	}
	
	//Crea un enemigo, y lo agrega grafica y logicamente
	public JLabel crearEnemigo(){
		Random rnd = new Random();
		ProtoAlien a = aliens[0].clone();
		Celda c = mapa.getCelda(rnd.nextInt(650),1300);
		a.setCelda(c);
		c.setPersonaje(a);
		enemigos.add(a);
		JLabel l = a.getGrafico();
		l.setBounds(c.getColumna()*CWIDTH, c.getFila()*CHEIGHT, CWIDTH, CHEIGHT);
		return l;
	}
	
	/**public JLabel crearObjeto(){
		ObjetoMapaVida o = new Barril();
		Celda c = mapa.getCelda(300, 400);
		o.setCelda(c);
		c.setEntidad(o);
		JLabel l = o.getGrafico();
		l.setBounds(c.getColumna()*CWIDTH, c.getFila()*CHEIGHT, CWIDTH, CHEIGHT);
		return l;
	}**/
	
	//Mueve a los enemigos del juego
	public void mover(){		
		for (ProtoAlien a : enemigos){
			int fila = a.getGrafico().getY();
			int columna = a.getGrafico().getX();
			if(mapa.getCelda(fila, columna-a.getVelocidad()).getPersonaje() == null && mapa.getCelda(fila, columna-a.getVelocidad()).getObjeto() == null && columna-a.getVelocidad()>=0){
				columna = a.getGrafico().getX()-a.getVelocidad();
				a.getGrafico().setLocation(columna, fila);
				a.setCelda(mapa.getCelda(fila,columna));
			}
		}
	}
	
	//Mata a aquellos personajes del juego que se encuentren con  una vida menor o igual que 0
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
			aliados.remove(m);
			
		}
	}
	
	//Produce los ataques entre los personajes que estan a rango
	public void atacar(){
		for(ProtoAlien a : enemigos){
			for(ProtoMarine m : aliados){
				if(m.getCelda().getFila() == a.getCelda().getFila() && a.getCelda().getColumna()-m.getCelda().getColumna() <= a.getAlcance())
					a.visit(m);
			}
		}
		for(ProtoMarine m : aliados){
			for(ProtoAlien a : enemigos){
				if(a.getCelda().getFila() == m.getCelda().getFila() && a.getCelda().getColumna()-m.getCelda().getColumna() <= m.getAlcance())
					m.visit(a);
			}
		}
	}
}