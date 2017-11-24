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
	protected LinkedList<ObjetoTiempo> objetosT;
	protected ProtoMarine[] marines;
	protected ProtoAlien[] aliens;
	protected ObjetoVida [] objetosVida;
	protected ObjetoTiempo [] objetosTiempo;
	protected int puntaje;
	protected int contadorPU;
	protected int monedas;
	
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
		objetosTiempo = new ObjetoTiempo[2];
		objetosTiempo[0] = new Agujero();
		objetosTiempo[1] = new LiquidoToxico();
		aliados = new LinkedList<ProtoMarine>();
		enemigos = new LinkedList<ProtoAlien>();
		objetos = new LinkedList<ObjetoVida>();
		objetosT = new LinkedList<ObjetoTiempo>();
		contadorPU = 0;
		monedas = 5000;
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
		c.setMarine(m);
		aliados.add(m);
		JLabel l = m.getGrafico();
		l.setBounds(c.getColumna()*CWIDTH, c.getFila()*CHEIGHT, CWIDTH, CHEIGHT);
		monedas = monedas-m.getPrecio();	
		deshabilitarBotones();
		return l;
	}
	
	public JLabel crearBastion(int fila, int columna){
		ProtoMarine m1 = marines[4].clone();
		ProtoMarine m2 = marines[4].clone();
		m1.setSegundo(m2);
		m2.setSegundo(m1);
		Celda c1 = mapa.getCelda(fila, columna);
		Celda c2 = mapa.getCelda(fila, columna).getArriba();
		m1.setCelda(c1);
		m2.setCelda(c2);
		c1.setMarine(m1);
		c2.setMarine(m2);
		aliados.add(m1);
		aliados.add(m2);
		JLabel l = m1.getGrafico();
		l.setBounds(c1.getColumna()*CWIDTH, c1.getFila()*CHEIGHT, CWIDTH, CHEIGHT*2);
		monedas = monedas-m1.getPrecio();	
		deshabilitarBotones();
		return l;
	}
	
	public int getMonedas(){
		return monedas;
	}
	
	//Crea un enemigo, y lo agrega grafica y logicamente
	public JLabel crearEnemigo(int tipo){
		Random rnd1 = new Random();
		ProtoAlien a = aliens[tipo].clone();
		Celda c = mapa.getCelda(rnd1.nextInt(650),1300);
		a.setCelda(c);
		c.getAliens().add(a);
		enemigos.add(a);
		JLabel l = a.getGrafico();	
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
			if(c.getAliens().isEmpty() && c.getObjeto() == null && c.getMarine()==null)
				celda_null = true;
		}
		o.setCelda(c);
		c.setObjeto(o);
		JLabel l = o.getGrafico();
		objetos.addLast(o);
		l.setBounds(c.getColumna()*CWIDTH, c.getFila()*CHEIGHT, CWIDTH, CHEIGHT);
		return l;
	}
	
	public JLabel crearObjetoT(){
		Random rnd = new Random();
		ObjetoTiempo o = null;
		if(rnd.nextInt(2) == 0)
			o = objetosTiempo[0].clone();
		else
			o = objetosTiempo[1].clone();
		Celda c = null;
		boolean celda_null = false;
		while(!celda_null){
			c = mapa.getCelda(rnd.nextInt(650), rnd.nextInt(1300));
			if(c.getAliens().isEmpty() && c.getObjeto()==null && c.getMarine()==null && c.getObjetoT()==null)
				celda_null = true;
		}
		o.setCelda(c);
		c.setObjetoT(o);
		JLabel l = o.getGrafico();
		objetosT.addLast(o);
		l.setBounds(c.getColumna()*CWIDTH, c.getFila()*CHEIGHT, CWIDTH, CHEIGHT);
		return l;
	}
	
	private boolean puedeMoverse(int fila, int columna, ProtoAlien a){
		boolean toReturn = false;
		if(a.getCelda().getColumna()!=0)
			toReturn = mapa.getCelda(fila, columna).getIzquierda().getMarine() == null 
						&& mapa.getCelda(fila, columna).getIzquierda().getObjeto() == null ;
		return toReturn;
	}
	
	//Mueve a los enemigos del juego
	public void mover(){		
		for (ProtoAlien a : enemigos){
			int fila = a.getGrafico().getY();
			int columna = a.getGrafico().getX();
			int columnaAux;
			if(puedeMoverse(fila,columna,a)){
				if(a.getCelda().getObjetoT()!=null){
					ObjetoTiempo o = a.getCelda().getObjetoT();
					a.accept(o);
					gui.removerLabel(o.getGrafico());
					o.getCelda().setObjetoT(null);
					o.setCelda(null);
					objetosT.remove(o);
				}
				columnaAux = columna;
				columna = a.getGrafico().getX()-a.getVelocidad();
				a.getGrafico().setLocation(columna, fila);
				a.setCelda(mapa.getCelda(fila,columna));
				if(columna != columnaAux){
					mapa.getCelda(fila, columnaAux).getAliens().remove(a);
					mapa.getCelda(fila, columna).getAliens().add(a);
				}
			}
			else{
				if(mapa.getCelda(fila,columna-a.getVelocidad()).getColumna() == a.getCelda().getColumna()){
					columna = columna - a.getVelocidad();
					a.getGrafico().setLocation(columna,fila);
				}
			}
			if(columna == 0)
				gui.gameOver();
		}
	}
	
	public void PowerUP(){
		Random rnd = new Random();
		int r = rnd.nextInt(3);
		ProtoMarine m;
		if(contadorPU == 5 && !aliados.isEmpty() && !enemigos.isEmpty()){
			m = aliados.getFirst();
			if(r == 0){
				m.campoProteccion();
				enemigos.getFirst().campoProteccion();
			}
			if(r == 1)
				m.escudo();
			if(r == 2)
				m.aumentarAlcance();
			contadorPU = 0;
		}
	}
	
	//Mata a aquellos personajes del juego que se encuentren con  una vida menor o igual que 0
	public void morir() {
		LinkedList<ProtoAlien> eliminarAliens = new LinkedList<>();
		LinkedList<ProtoMarine> eliminarMarines = new LinkedList<>();
		LinkedList<ObjetoVida> eliminarObjetos = new LinkedList<>();
		
		for (ProtoAlien a : enemigos)
			if (a.getVida() <= 0){
				eliminarAliens.add(a);
				contadorPU++;
			}
		
		for (ProtoMarine m : aliados)
			if (m.getVida() <= 0)
				eliminarMarines.add(m);
		
		for(ObjetoVida o : objetos)
			if(o.getVida() <= 0)
				eliminarObjetos.add(o);
		
		for (ProtoAlien a : eliminarAliens){
			gui.removerLabel(a.getGrafico());
			a.getCelda().getAliens().remove(a);
			a.setCelda(null);
			enemigos.remove(a);
			puntaje = puntaje+a.getPuntaje();
			monedas = monedas+a.getMonedas();
			habilitarBotones();		
		}
		
		for (ProtoMarine m : eliminarMarines){
			gui.removerLabel(m.getGrafico());
			m.getCelda().setMarine(null);
			m.setCelda(null);
			aliados.remove(m);
		}
		
		for(ObjetoVida o : eliminarObjetos){
			gui.removerLabel(o.getGrafico());
			o.getCelda().setObjeto(null);
			o.setCelda(null);
			objetos.remove(o);
		}	
	}
	
	private boolean puedeAtacar(Personaje p, Entidad e){
		return p.getCelda().getFila() == e.getCelda().getFila() 
				&& p.getCelda().getColumna()-e.getCelda().getColumna() <= p.getAlcance() 
				&& p.getCelda().getColumna()-e.getCelda().getColumna() > 0;
	}
	
	private boolean puedeAtacarM(Personaje p, Entidad e){
		return p.getCelda().getFila() == e.getCelda().getFila() 
				&& e.getCelda().getColumna()-p.getCelda().getColumna() <= p.getAlcance() 
				&& e.getCelda().getColumna()-p.getCelda().getColumna() > 0;
	}
	
	//Produce los ataques entre los personajes que estan a rango
	public void atacar(){
		ProtoAlien alien;
		ProtoMarine marine;
		
		for(ProtoAlien a : enemigos){
			marine = null;
			
			for(ObjetoVida o : objetos)
				if(puedeAtacar(a,o))
					o.accept(a);
			
			for(ProtoMarine m : aliados){
				if(puedeAtacar(a,m)){
					if(marine == null)
						marine = m;
					else
						if(m.getCelda().getColumna() > marine.getCelda().getColumna())
							marine = m;
				}
			}
			if(marine != null)
				marine.accept(a);
			
		}
		
		for(ProtoMarine m : aliados){
			alien = null;
			
			for(ProtoAlien a : enemigos){
				if(puedeAtacarM(m,a)){
					if(alien == null)
						alien = a;
					else
						if(a.getCelda().getColumna() < alien.getCelda().getColumna())
							alien = a;
				}
			}
			if(alien != null)
				alien.accept(m);
		}
	}
	
	public void deshabilitarBotones(){
		if(monedas<marines[0].getPrecio())
			gui.deshabilitarMarine1();
		else if(monedas>=marines[0].getPrecio() && monedas<marines[1].getPrecio())
				gui.deshabilitarMarine2();
		else if(monedas>=marines[1].getPrecio() && monedas<marines[2].getPrecio())
			gui.deshabilitarMarine3();
		else if(monedas>=marines[2].getPrecio() && monedas<marines[3].getPrecio())
			gui.deshabilitarMarine4();
		else if(monedas>=marines[3].getPrecio() && monedas<marines[4].getPrecio())
			gui.deshabilitarMarine5();
	}
	
	public void habilitarBotones(){
		if(monedas>=marines[4].getPrecio())
			gui.habilitarMarine5();
		else if(monedas>=marines[3].getPrecio() && monedas<marines[4].getPrecio())
				gui.habilitarMarine4();
		else if(monedas>=marines[2].getPrecio() && monedas<marines[3].getPrecio())
			gui.habilitarMarine3();
		else if(monedas>=marines[1].getPrecio() && monedas<marines[2].getPrecio())
			gui.habilitarMarine2();
		else if(monedas>=marines[0].getPrecio())
			gui.habilitarMarine1();
	}
}