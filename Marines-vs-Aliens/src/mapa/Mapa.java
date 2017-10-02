package mapa;

public class Mapa {
	private Celda mapa[][];
	private int width, height;

	public Mapa(int width, int height){
		this.width = width;
		this.height = height;
		this.mapa = new Celda[width][height];
		
		for(int i = 0; i < width; i++){
			for(int j = 0; j < height; j++){
				this.mapa[i][j] = new Celda(this, i, j);
			}
		}
	}
	
	public Celda[][] getMapa() {
		return mapa;
	}
	
	public Celda getCelda(int x, int y){
		int c,f;
		f=x/128;
		c=y/100;
		return mapa[f][c];
	}

	public int getWidth() {
		return width;
	}

	public int getHeight() {
		return height;
	}
}