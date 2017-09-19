package juego;

import java.awt.*;
import javax.swing.*;

public class GUI {

	private JFrame frmMarinesvsaliens;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUI window = new GUI();
					window.frmMarinesvsaliens.setVisible(true);
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
		
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmMarinesvsaliens = new JFrame();
		frmMarinesvsaliens.setTitle("Marines-vs-Aliens");
		frmMarinesvsaliens.setBounds(100, 100, 450, 300);
		frmMarinesvsaliens.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmMarinesvsaliens.getContentPane().setLayout(null);
		
		JLabel marinelabel = new JLabel();
		marinelabel.setIcon(new ImageIcon("C:\\Users\\Usuario\\Documents\\GitHub\\Marines-vs-Aliens\\Marines-vs-Aliens\\src\\juego\\marine.png"));
		marinelabel.setBounds(10, 0, 86, 101);
		frmMarinesvsaliens.getContentPane().add(marinelabel);
		
		JLabel mapa = new JLabel("");
		mapa.setIcon(new ImageIcon("C:\\Users\\Usuario\\Desktop\\green-td.jpg"));
		mapa.setBounds(0, 0, 434, 261);
		frmMarinesvsaliens.getContentPane().add(mapa);
	}
	
	public void addPersonaje(){
		JLabel marinelabel = new JLabel();
		marinelabel.setIcon(new ImageIcon("C:\\Users\\Usuario\\Documents\\GitHub\\Marines-vs-Aliens\\Marines-vs-Aliens\\src\\juego\\marine.png"));
		marinelabel.setBounds(10, 149, 86, 101);
		frmMarinesvsaliens.getContentPane().add(marinelabel);
	}
}
