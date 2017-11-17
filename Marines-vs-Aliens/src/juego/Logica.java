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
	protected LinkedList<ObjetoVida> objetos;
	protected ProtoMarine[] marines;
	protected ProtoAlien[] aliens;
	protected ObjetoVida [] objetosVida;
	protected int puntaje;
	protected int contadorPowerUP;
	
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
		objetosVida = new ObjetoVida[2];
		objetosVida[0] = new Barril();
		objetosVida[1] = new Meteorito();
		aliados = new LinkedList<ProtoMarine>();
		enemigos = new LinkedList<ProtoAlien>();
		objetos = new LinkedList<ObjetoVida>();
		contadorPowerUP = 0;
	}
	
	//Crea el mapa del juego
	public void crearMapa(){
		gui.crearMapa();
		mapa = new Mapa(6,10);
	}
	
	public Mapa getMapa(){
		return mapa;
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
	public JLabel crearEnemigo(int tipo){
		Random rnd1 = new Random();
		ProtoAlien a = aliens[tipo].clone();
		Celda c = mapa.getCelda(rnd1.nextInt(650),1300);
		a.setCelda(c);
		c.setPersonaje(a);
		enemigos.add(a);
		JLabel l = a.getGrafico();
		if(rnd1.nextInt(10) == 1){
			PU_CampoProteccion CP = new PU_CampoProteccion();
			CP.cambiarEstado(a);
			//a.setGrafico(a.getGraficoPU());
		}
		l.setBounds(c.getColumna()*CWIDTH, c.getFila()*CHEIGHT, CWIDTH, CHEIGHT);
		return l;
	}
	
	public JLabel crearObjeto(){
		Random rnd = new Random();
		ObjetoVida o = null;
		if(rnd.nextInt(2) == 0)
			o = objetosVida[0].clone();
		else
			o = objetosVida[1].clone();
		Celda c = null;
		boolean celda_null = false;
		while(!celda_null){
			c = mapa.getCelda(rnd.nextInt(650), rnd.nextInt(1300));
			if(c.getPersonaje() == null && c.getObjeto() == null)
				celda_null = true;
		}
		o.setCelda(c);
		c.setObjeto(o);
		JLabel l = o.getGrafico();
		objetos.addLast(o);
		l.setBounds(c.getColumna()*CWIDTH, c.getFila()*CHEIGHT, CWIDTH, CHEIGHT);
		return l;
	}
	
	//Mueve a los enemigos del juego
	public void mover(){		
		for (ProtoAlien a : enemigos){
			System.out.println(a.getCelda().getPersonaje());
			int fila = a.getGrafico().getY();
			int columna = a.getGrafico().getX();
			if(mapa.getCelda(fila, columna-a.getVelocidad()).getPersonaje() == null && mapa.getCelda(fila, columna-a.getVelocidad()).getObjeto() == null && columna-a.getVelocidad()>=0){
				mapa.getCelda(fila, columna).setPersonaje(null);
				columna = a.getGrafico().getX()-a.getVelocidad();
				a.getGrafico().setLocation(columna, fila);
				a.setCelda(mapa.getCelda(fila,columna));
				mapa.getCelda(fila, columna).setPersonaje(a);
			}
			if(columna == 0)
				gui.gameOver();
		}
	}
	
	//Mata a aquellos personajes del juego que se encuentren con  una vida menor o igual que 0
	public void morir() {
		LinkedList<ProtoAlien> eliminarAliens = new LinkedList<>();
		LinkedList<ProtoMarine> eliminarMarines = new LinkedList<>();
		LinkedList<ObjetoVida> eliminarObjetos = new LinkedList<>();
		for (ProtoAlien a : enemigos){
			if (a.getVida() <= 0){
				eliminarAliens.add(a);
				contadorPowerUP++;
			}
		}
		for (ProtoMarine m : aliados){
			if (m.getVida() <= 0){
				eliminarMarines.add(m);
			}
		}
		for(ObjetoVida o : objetos)
			if(o.getVida() <= 0)
				eliminarObjetos.add(o);
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
		for(ObjetoVida o : eliminarObjetos){
			gui.removerLabel(o.getGrafico());
			o.getCelda().setObjeto(null);
			o.setCelda(null);
			objetos.remove(o);
		}
		
		/*Random r = new Random();
		if(r.nextInt(20) < contadorPowerUP){
			PU_CampoProteccion CP = new PU_CampoProteccion();
			PU_Escudo E = new PU_Escudo();
			PU_Beast B = new PU_Beast();
			int r2 = r.nextInt(3);
			ProtoMarine p = aliados.getFirst();
			if(r2 == 0){
				CP.cambiarEstado(p);
				p.setGrafico(p.getGraficoPU());
			}
			else
				if(r2 == 1){
					E.cambiarEstado(p);
					p.setGrafico(p.getGraficoPU());
				}
				else{
					B.cambiarEstado(p);
					p.setGrafico(p.getGraficoPU());
				}
		}*/
			
	}
	
	//Produce los ataques entre los personajes que estan a rango
	public void atacar(){
		ProtoAlien alien;
		ProtoMarine marine;
		for(ProtoAlien a : enemigos){
			marine = null;
			for(ObjetoVida o : objetos)
				if(a.getCelda().getFila() == o.getCelda().getFila() && a.getCelda().getColumna()-o.getCelda().getColumna() <= a.getAlcance())
					o.accept(a);
			for(ProtoMarine m : aliados){
				if(m.getCelda().getFila() == a.getCelda().getFila() && a.getCelda().getColumna()-m.getCelda().getColumna() <= a.getAlcance() && a.getCelda().getColumna()-m.getCelda().getColumna() > 0){
					if(marine == null)
						marine = m;
					else
						if(m.getCelda().getColumna() > marine.getCelda().getColumna())
							marine = m;
				}
			}
			if(marine != null){
				marine.accept(a);
				if(a.getState().toString() == "campoProteccion" && a.getCelda().getColumna()-marine.getCelda().getColumna() == 1){
					marine.recibirDisparo(1000);
					PU_Off s = new PU_Off();
					s.cambiarEstado(a);
					//a.setGrafico(a.getGrafico());
				}
			}
		}
		for(ProtoMarine m : aliados){
			alien = null;
			for(ProtoAlien a : enemigos){
				if(a.getCelda().getFila() == m.getCelda().getFila() && a.getCelda().getColumna()-m.getCelda().getColumna() <= m.getAlcance() && a.getCelda().getColumna()-m.getCelda().getColumna()>0){
					if(alien == null)
						alien = a;
					else
						if(a.getCelda().getColumna() < alien.getCelda().getColumna())
							alien = a;
				}
			}
			if(alien != null){
				alien.accept(m);
				if(m.getState().toString() == "campoProteccion" && alien.getCelda().getColumna()-m.getCelda().getColumna() == 1){
					alien.recibirDisparo(1000);
					PU_Off s = new PU_Off();
					s.cambiarEstado(m);
					m.setGrafico(m.getGrafico());
				}
			}
		}
	}
}