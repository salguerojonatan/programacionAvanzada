package reinasEnConflicto;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class Tablero {

	int tamanio;
	int cantReinas;
	int[][] tablero;

	public Tablero(int f, int cantReinas) {
		this.tamanio = f;
		this.cantReinas = cantReinas;
		tablero = new int[f][f];
	}
	
	public void agregarReina(Reinas reina) {
		tablero[reina.x][reina.y] = reina.numeroReina;
		
	}

	public void mostrar() {
		for(int i = 0; i<tamanio;i++) {
			for(int j = 0;j<tamanio;j++)
				System.out.print(tablero[i][j]+ " ");
			System.out.println();
		}
	}
	
	
}
