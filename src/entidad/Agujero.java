package entidad;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class Agujero extends ObjetoTiempo{
	
	public Agujero(){
		grafico = new JLabel(new ImageIcon(this.getClass().getResource("/imagenes/Agujero.png")));
	}
	
	public ObjetoTiempo clone(){
		ObjetoTiempo a = new Agujero();
		return a;
	}
	
	public void visit(ProtoAlien a){
		a.reducirVelocidad();
	}
}
