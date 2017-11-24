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
	private JLabel monedas;
	private JButton botonAliado1;
	private JButton botonAliado2;
	private JButton botonAliado3;
	private JButton botonAliado4;
	private JButton botonAliado5;
	private int numeroAliado;
	private OyenteMouse o;
	private OyenteMouseB b;

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
		b = new OyenteMouseB();
		
		botonAliado1 = new JButton("Marine 1 - 50");
		panelMarket.add(botonAliado1);
		OyenteBotonAliado1 oyenteAliado1 = new OyenteBotonAliado1();
		botonAliado1.addActionListener(oyenteAliado1);
		
		botonAliado2 = new JButton("Marine 2 - 100");
		panelMarket.add(botonAliado2);
		OyenteBotonAliado2 oyenteAliado2 = new OyenteBotonAliado2();
		botonAliado2.addActionListener(oyenteAliado2);
		
		botonAliado3 = new JButton("Marine 3 - 150");
		panelMarket.add(botonAliado3);
		OyenteBotonAliado3 oyenteAliado3 = new OyenteBotonAliado3();
		botonAliado3.addActionListener(oyenteAliado3);
		
		botonAliado4 = new JButton("Marine 4 - 200");
		panelMarket.add(botonAliado4);
		OyenteBotonAliado4 oyenteAliado4 = new OyenteBotonAliado4();
		botonAliado4.addActionListener(oyenteAliado4);
		
		botonAliado5 = new JButton("Marine 5 - 500");
		panelMarket.add(botonAliado5);
		OyenteBotonAliado5 oyenteAliado5 = new OyenteBotonAliado5();
		botonAliado5.addActionListener(oyenteAliado5);
		
		logica.deshabilitarBotones();
		panelMarket.add(new JLabel("Puntaje:"));
		puntaje = new JLabel("0");
		panelMarket.add(puntaje);
		panelMarket.add(new JLabel("       Monedas:"));
		monedas = new JLabel("300");
		panelMarket.add(monedas);

	}
	private class OyenteMouse implements MouseListener{
		public void mouseClicked(MouseEvent e){
			int columna = e.getX();
			int fila = e.getY();
			Mapa m = logica.getMapa();
			if(m.getCelda(fila, columna).getMarine() == null && m.getCelda(fila, columna).getObjeto() == null && m.getCelda(fila, columna).getAliens().isEmpty() && m.getCelda(fila, columna).getObjetoT()==null){
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
	
	private class OyenteMouseB implements MouseListener{
		public void mouseClicked(MouseEvent e){
			int columna = e.getX();
			int fila = e.getY();
			Mapa m = logica.getMapa();
			if(m.getCelda(fila, columna).getMarine() == null && m.getCelda(fila, columna).getObjeto() == null && m.getCelda(fila, columna).getAliens().isEmpty() && m.getCelda(fila, columna).getObjetoT()==null && m.getCelda(fila, columna).getFila()!=5){
				if(m.getCelda(fila, columna).getArriba().getMarine() == null && m.getCelda(fila, columna).getArriba().getObjeto() == null && m.getCelda(fila, columna).getArriba().getAliens().isEmpty() && m.getCelda(fila, columna).getArriba().getObjetoT()==null)
						crearBastion(fila, columna);
					frame.getContentPane().removeMouseListener(b);
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
			frame.getContentPane().addMouseListener(b);
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
	
	public void crearObjetoT(){
		JLabel l = logica.crearObjetoT();
		frame.getContentPane().add(l);
	}
	
	public void crearAliado(int fila, int columna,int tipo){
		JLabel l = logica.crearAliado(fila, columna, tipo);
		frame.getContentPane().add(l);
	}
	
	public void crearBastion(int fila, int columna){
		JLabel l = logica.crearBastion(fila, columna);
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
		monedas.setText(""+logica.getMonedas());
		frame.revalidate();
		frame.repaint();
	}
	
	public void gameOver(){
		JOptionPane.showMessageDialog(null, "GAME OVER");
		System.exit(0);
	}
	
	public void SegundaOleada(){
		JOptionPane.showMessageDialog(null, "Has superado la primer oleada. Preparate para la segunda oleada!");
	}
	
	public void ganar(){
		JOptionPane.showMessageDialog(null, "GANASTE! Tu puntaje es: "+(logica.getPuntaje()+logica.getMonedas()));
		System.exit(0);
	}
	
	public void habilitarMarine1(){
		botonAliado1.setEnabled(true);
	}
	
	public void habilitarMarine2(){
		botonAliado1.setEnabled(true);
		botonAliado2.setEnabled(true);
	}
	
	public void habilitarMarine3(){
		botonAliado1.setEnabled(true);
		botonAliado2.setEnabled(true);
		botonAliado3.setEnabled(true);
	}
	
	public void habilitarMarine4(){
		botonAliado1.setEnabled(true);
		botonAliado2.setEnabled(true);
		botonAliado3.setEnabled(true);
		botonAliado4.setEnabled(true);
	}
	
	public void habilitarMarine5(){
		botonAliado1.setEnabled(true);
		botonAliado2.setEnabled(true);
		botonAliado3.setEnabled(true);
		botonAliado4.setEnabled(true);
		botonAliado5.setEnabled(true);
	}
	
	public void deshabilitarMarine1(){
		botonAliado1.setEnabled(false);
		botonAliado2.setEnabled(false);
		botonAliado3.setEnabled(false);
		botonAliado4.setEnabled(false);
		botonAliado5.setEnabled(false);
	}
	
	public void deshabilitarMarine2(){
		botonAliado2.setEnabled(false);
		botonAliado3.setEnabled(false);
		botonAliado4.setEnabled(false);
		botonAliado5.setEnabled(false);
	}
	
	public void deshabilitarMarine3(){
		botonAliado3.setEnabled(false);
		botonAliado4.setEnabled(false);
		botonAliado5.setEnabled(false);
	}
	
	public void deshabilitarMarine4(){
		botonAliado4.setEnabled(false);
		botonAliado5.setEnabled(false);
	}
	
	public void deshabilitarMarine5(){
		botonAliado5.setEnabled(false);
	}
}