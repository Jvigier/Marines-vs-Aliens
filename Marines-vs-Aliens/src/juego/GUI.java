package juego;

import java.awt.*;

import javax.swing.*;

import juego.Logica;

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
		logica = new Logica(this);	
		initialize();
	
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(0, 0, 1280, 760);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		logica.crearMapa();
		crearAliado(200, 200 , 0);
	}
	
	public void crearMapa(){
		JLabel mapa = new JLabel(new ImageIcon("C:\\Users\\Usuario\\Documents\\GitHub\\Marines-vs-Aliens\\Marines-vs-Aliens\\src\\juego\\mapa.png"));
		mapa.setBounds(0, 0, 1280, 760);
		frame.setContentPane(mapa);
	}
	
	public void crearAliado(int x, int y,int tipo){
		JLabel l = logica.crearAliado(x, y, tipo);
		frame.getContentPane().add(l);
		
	}
}