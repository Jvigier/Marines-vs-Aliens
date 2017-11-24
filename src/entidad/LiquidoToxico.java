package entidad;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class LiquidoToxico extends ObjetoTiempo{
	
	public LiquidoToxico(){
		grafico = new JLabel(new ImageIcon(this.getClass().getResource("/imagenes/LiquidoToxico.png")));
	}
	
	public ObjetoTiempo clone(){
		ObjetoTiempo l = new LiquidoToxico();
		return l;
	}
	
	public void visit(ProtoAlien a){
		a.aumentarVelocidad();
	}
}
