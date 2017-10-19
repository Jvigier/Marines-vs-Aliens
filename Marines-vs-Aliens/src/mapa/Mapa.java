package mapa;

import juego.Logica;

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
	
	
	public Celda getCelda(int x, int y ){
		int c,f;
		if (y>650 )
			y=650;
		if (x>1300)
			x = 1300;
		f = x/Logica.CWIDTH;
		c = y/Logica.CHEIGHT;
		return mapa[c][f];
	}

	public int getWidth() {
		return width;
	}

	public int getHeight() {
		return height;
	}
}