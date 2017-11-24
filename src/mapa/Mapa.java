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
	
	//Retorna el arreglo de celdas
	public Celda[][] getMapa() {
		return mapa;
	}
	
	//Retorna la celda en las coordenadas fila, columna
	public Celda getCelda(int fila, int columna){
		if (fila > 650 )
			fila=650;
		if (columna > 1300)
			columna = 1300;
		fila = fila/Logica.CHEIGHT;
		columna = columna/Logica.CWIDTH;
		return mapa[fila][columna];
	}
	
	//Retorna el ancho del mapa
	public int getWidth() {
		return width;
	}
	
	//Retorna el alto del mapa
	public int getHeight() {
		return height;
	}
}