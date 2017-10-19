package juego;

import gui.*;
public class ContadorTiempo extends Thread {

	private Logica elJuego;
	private GUI gui;

	public ContadorTiempo(Logica j, GUI g) {
		this.elJuego = j;
		this.gui = g;
	}

	public void run() {
		while(true){
			try {
				Thread.sleep(60);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			elJuego.morir();
			elJuego.mover();
			elJuego.atacar();
			gui.repaint();
		}
	}
}
