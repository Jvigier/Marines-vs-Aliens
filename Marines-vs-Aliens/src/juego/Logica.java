package juego;

import mapa.*;

import java.util.LinkedList;
import java.util.Random;

import javax.swing.JLabel;

import entidad.*;
import gui.GUI;

//Clase Logica
//Es la que maneja la parte logica del juego
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
	public JLabel crearAliado(int x, int y, int tipo){
		ProtoMarine m = marines[tipo].clone();
		Celda c = mapa.getCelda(y, x);
		m.setCelda(c);
		c.setPersonaje(m);
		aliados.add(m);
		JLabel l = m.getGrafico();
		l.setBounds(c.getY()*CWIDTH, c.getX()*CHEIGHT, CWIDTH, CHEIGHT);
		return l;
	}
	
	//Crea un enemigo, y lo agrega grafica y logicamente
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
	
	//Mueve a los enemigos del juego
	public void mover(){		
		for (ProtoAlien a : enemigos){
			int x = a.getGrafico().getX();
			int y = a.getGrafico().getY();
			//if(mapa.getCelda(x-a.getVelocidad(), y).getPersonaje() == null && mapa.getCelda(x-a.getVelocidad(), y).getObjeto() == null)
			if(a.getCelda().getSiguiente().getPersonaje() == null && a.getCelda().getSiguiente().getObjeto() == null){
				x = a.getGrafico().getX()-a.getVelocidad();
				a.getGrafico().setLocation(x, y);
				a.setCelda(mapa.getCelda(x,y));
				//System.out.println(a.getCelda().getX()+""+a.getCelda().getY());
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
				System.out.println("Y alien: "+a.getCelda().getY()+" X alien: "+a.getCelda().getX()+" Y marine: "+m.getCelda().getY()+" X marine: "+m.getCelda().getX());
				if(m.getCelda().getY() == a.getCelda().getY() && a.getCelda().getX()-m.getCelda().getX() <= a.getAlcance())
					a.visit(m);
			}
		}
		for(ProtoMarine m : aliados){
			for(ProtoAlien a : enemigos){
				if(a.getCelda().getY() == m.getCelda().getY() && a.getCelda().getX()-m.getCelda().getX() <= m.getAlcance())
					m.visit(a);
			}
		}
	}
}