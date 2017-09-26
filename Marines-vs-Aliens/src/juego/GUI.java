package juego;

import java.awt.*;

import javax.swing.*;

public class GUI {

	private JFrame frame;
	private Logica logica;

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
		initialize();
		logica = new Logica(this);
		logica.crearMapa();
		logica.crearAliado();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(0, 0, 1366, 768);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
	}
	
	public void crearMapa(){
		JLabel mapa = new JLabel(new ImageIcon("C:\\Users\\Usuario\\Documents\\GitHub\\Marines-vs-Aliens\\Marines-vs-Aliens\\src\\juego\\mapa.png"));
		mapa.setBounds(0, 0, 1366, 768);
		frame.setContentPane(mapa);
	}
	
	public void crearAliado(){
		JLabel aliado = new JLabel(new ImageIcon("C:\\Users\\Usuario\\Documents\\GitHub\\Marines-vs-Aliens\\Marines-vs-Aliens\\src\\juego\\marine.gif"));
		aliado.setBounds(0, 480, 157, 196);
		frame.getContentPane().add(aliado);
	}
}
