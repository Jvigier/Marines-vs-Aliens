package gui;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.*;
import juego.ContadorOleadas;
import juego.ContadorTiempo;
import juego.Logica;
import mapa.Mapa;

public class GUI {

	private JFrame frame;
	private Logica logica;
	private ContadorTiempo tiempo;
	private ContadorOleadas oleadas;
	private JLabel puntaje;
	private JButton botonAliado1;
	private JButton botonAliado2;
	private JButton botonAliado3;
	private JButton botonAliado4;
	private JButton botonAliado5;
	private int numeroAliado;
	private OyenteMouse o;

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
		oleadas = new ContadorOleadas(logica,this);
		oleadas.start();
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
		
		o = new OyenteMouse();
		
		botonAliado1 = new JButton("Aliado1");
		panelMarket.add(botonAliado1);
		OyenteBotonAliado1 oyenteAliado1 = new OyenteBotonAliado1();
		botonAliado1.addActionListener(oyenteAliado1);
		
		botonAliado2 = new JButton("Aliado2");
		panelMarket.add(botonAliado2);
		OyenteBotonAliado2 oyenteAliado2 = new OyenteBotonAliado2();
		botonAliado2.addActionListener(oyenteAliado2);
		
		botonAliado3 = new JButton("Aliado3");
		panelMarket.add(botonAliado3);
		OyenteBotonAliado3 oyenteAliado3 = new OyenteBotonAliado3();
		botonAliado3.addActionListener(oyenteAliado3);
		
		botonAliado4 = new JButton("Aliado4");
		panelMarket.add(botonAliado4);
		OyenteBotonAliado4 oyenteAliado4 = new OyenteBotonAliado4();
		botonAliado4.addActionListener(oyenteAliado4);
		
		botonAliado5 = new JButton("Aliado5");
		panelMarket.add(botonAliado5);
		OyenteBotonAliado5 oyenteAliado5 = new OyenteBotonAliado5();
		botonAliado5.addActionListener(oyenteAliado5);
		
		puntaje = new JLabel("0");
		panelMarket.add(puntaje);

	}
	private class OyenteMouse implements MouseListener{
		public void mouseClicked(MouseEvent e){
			int columna = e.getX();
			int fila = e.getY();
			Mapa m = logica.getMapa();
			if(m.getCelda(fila, columna).getPersonaje() == null && m.getCelda(fila, columna).getObjeto() == null){
				//System.out.println(arg0);
				crearAliado(fila, columna, numeroAliado);
				frame.getContentPane().removeMouseListener(o);
			}
		}

		@Override
		public void mouseEntered(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseExited(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mousePressed(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseReleased(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}
	}
	
	private class OyenteBotonAliado1 implements ActionListener{
		public void actionPerformed(ActionEvent e){
			numeroAliado = 0;
			frame.getContentPane().addMouseListener(o);
		}
	}
	
	private class OyenteBotonAliado2 implements ActionListener{
		public void actionPerformed(ActionEvent e){
			numeroAliado = 1;
			frame.getContentPane().addMouseListener(o);
		}
	}
	
	private class OyenteBotonAliado3 implements ActionListener{
		public void actionPerformed(ActionEvent e){
			numeroAliado = 2;
			frame.getContentPane().addMouseListener(o);
		}
	}
	
	private class OyenteBotonAliado4 implements ActionListener{
		public void actionPerformed(ActionEvent e){
			numeroAliado = 3;
			frame.getContentPane().addMouseListener(o);
		}
	}
	
	private class OyenteBotonAliado5 implements ActionListener{
		public void actionPerformed(ActionEvent e){
			numeroAliado = 4;
			frame.getContentPane().addMouseListener(o);
		}
	}
	
	public void crearMapa(){
		JLabel mapa = new JLabel(new ImageIcon(this.getClass().getResource("/imagenes/Mapa.png")));
		mapa.setBounds(0, 0, 1280, 760);
		frame.setContentPane(mapa);
	}
	
	public void crearObjeto(){
		JLabel l = logica.crearObjeto();
		frame.getContentPane().add(l);
	}
	
	public void crearAliado(int fila, int columna,int tipo){
		JLabel l = logica.crearAliado(fila, columna, tipo);
		frame.getContentPane().add(l);
	}
	
	public void crearEnemigo(int tipo){
		JLabel l = logica.crearEnemigo(tipo);
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
	
	public void gameOver(){
		JOptionPane.showMessageDialog(null, "GAME OVER");
		System.exit(0);
	}
	
	public void ganar(){
		JOptionPane.showMessageDialog(null, "GANASTE!");
		System.exit(0);
	}
}