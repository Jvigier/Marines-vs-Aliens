package entidad;

public class ObjetoMapa {
	public void accept(ProtoAlien p){
		p.visit(this);
	}
	public void recibirDano(int d){}
}
