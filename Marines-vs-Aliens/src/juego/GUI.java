package juego;

import java.awt.*;
import javax.swing.*;

public class GUI {

	private JFrame frame;

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
		
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel marinelabel = new JLabel();
		marinelabel.setIcon(new ImageIcon("C:\\Users\\Usuario\\Documents\\GitHub\\Marines-vs-Aliens\\Marines-vs-Aliens\\src\\juego\\Sin t\u00EDtulo-1.png"));
		marinelabel.setBounds(10, 169, 44, 81);
		frame.getContentPane().add(marinelabel);
	}
}
