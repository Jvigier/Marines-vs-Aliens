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
	
	public Celda getCelda(int y, int x ){
		//No tocar, x e y estan al reves. PELIGRO SE ROMPE TODO
		int c,f;
		if (x>650 )
			x=650;
		if (y>1300)
			y = 1300;
		f=x/Logica.CHEIGHT;
		c=(y)/Logica.CWIDTH;
		return mapa[f][c];
	}

	public int getWidth() {
		return width;
	}

	public int getHeight() {
		return height;
	}
}