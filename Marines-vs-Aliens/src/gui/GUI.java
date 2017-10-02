package gui;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import juego.ContadorTiempo;
import juego.Logica;

public class GUI {

	private JFrame frame;
	private Logica logica;
	private ContadorTiempo tiempo;
	private JLabel puntaje;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUI window = new GUI();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public GUI() {
		logica = new Logica(this);	
		initialize();
		tiempo = new ContadorTiempo(logica,this);
		tiempo.start();
		
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(0, 0, 1366, 768);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		logica.crearMapa();
		
		JPanel panelMarket = new JPanel();
		panelMarket.setBounds(0, 663, 1350, 66);
		frame.getContentPane().add(panelMarket);
		
		JButton botonAliado = new JButton("Aliado");
		panelMarket.add(botonAliado);
		OyenteBotonAliado oyenteAliado = new OyenteBotonAliado();
		botonAliado.addActionListener(oyenteAliado);
		
		JButton botonEnemigo = new JButton("Enemigo");
		panelMarket.add(botonEnemigo);
		OyenteBotonEnemigo oyenteEnemigo = new OyenteBotonEnemigo();
		botonEnemigo.addActionListener(oyenteEnemigo);
		
		puntaje = new JLabel("0");
		panelMarket.add(puntaje);

	}
	
	private class OyenteBotonAliado implements ActionListener{
		public void actionPerformed(ActionEvent e){
			crearAliado(0, 200, 0);
			frame.repaint();
		}
	}
	
	private class OyenteBotonEnemigo implements ActionListener{
		public void actionPerformed(ActionEvent e){
			if (logica.getEnemigos().isEmpty()){
				crearEnemigo();
			} else {
				logica.getEnemigos().getFirst().recibirDisparo(100);
			}
		}
	}
	
	public void crearMapa(){
		JLabel mapa = new JLabel(new ImageIcon("C:\\Users\\Usuario\\Documents\\GitHub\\Marines-vs-Aliens\\Marines-vs-Aliens\\src\\juego\\mapa.png"));
		mapa.setBounds(0, 0, 1280, 760);
		frame.setContentPane(mapa);
	}
	
	public void crearAliado(int y, int x,int tipo){
		JLabel l = logica.crearAliado(x, y, tipo);
		frame.getContentPane().add(l);
	}
	
	public void crearEnemigo(){
		JLabel l = logica.crearEnemigo();
		frame.getContentPane().add(l);
	}
	
	public void removerLabel(JLabel j){
		frame.getContentPane().remove(j);
	}

	public void repaint() {
		puntaje.setText(""+logica.getPuntaje());
		frame.revalidate();
		frame.repaint();
	}
}