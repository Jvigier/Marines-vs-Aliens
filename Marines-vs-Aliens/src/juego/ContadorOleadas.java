package juego;
import java.util.Random;
import gui.GUI;

public class ContadorOleadas extends Thread {
	private GUI gui;
	private Logica logica;
	private int cantidad;
	private int objetos;
	private Random rnd;
	
	public ContadorOleadas(Logica l, GUI g){
		this.gui = g;
		this.logica = l;
		cantidad = 0;
		objetos = 0;
		rnd = new Random();
	}

	public void run() {
		while(true){
			try {
				Thread.sleep(4000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			if(objetos == 2)
				gui.crearObjetoT();
			if(objetos == 4){
				gui.crearObjeto();
				objetos = 0;
			}
			objetos++;
			if(cantidad <= 10){
				gui.crearEnemigo(rnd.nextInt(4));
				cantidad++;
			}
			if(cantidad == 10){
				try {
					Thread.sleep(15000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				gui.SegundaOleada();
			}
			if(cantidad >= 11 && cantidad < 20){
				gui.crearEnemigo(rnd.nextInt(3)+3);
				cantidad++;
			}
			if(cantidad == 20){
				if(logica.getEnemigos().isEmpty())
					gui.ganar();
			}
		}
	}
}
