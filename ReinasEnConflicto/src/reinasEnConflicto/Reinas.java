package reinasEnConflicto;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class Reinas {
	int numeroReina;
	int x;
	int y;
	int[] cantConflictos;

	public Reinas(int n, int x, int y) {
		this.numeroReina = n;
		this.x = x;
		this.y = y;
	}
	
	
	public int cuantos() {
		int cant=0;
		
		for(int i = 0; i < cantConflictos.length;i++)
			if(cantConflictos[i] != 0)
				cant++;
		
		return cant;
	}
	
	public void mostrarConflictos() {
		int cant = 0;
		for (int i = 0; i < cantConflictos.length; i++)
			if (cantConflictos[i] != 0)
				cant++;

		System.out.print(cant + " ");

		for (int i = 0; i < cantConflictos.length; i++) {

			if (cantConflictos[i] != 0)
				System.out.print((i + 1) + " ");
		}
	}

	public void conflictos(Tablero tablero) {

		cantConflictos = new int[tablero.cantReinas];

		for (int i = this.x - 1; i >= 0; i--)
			if (tablero.tablero[i][this.y] != 0) {
				cantConflictos[(tablero.tablero[i][this.y]) - 1] = 1;
				break;
			}

		for (int i = this.x + 1; i < tablero.tamanio; i++) {
			if (tablero.tablero[i][this.y] != 0) {
				cantConflictos[(tablero.tablero[i][this.y]) - 1] = 1;
				break;
			}
		}

		for (int i = this.y + 1; i < tablero.tamanio; i++) {
			if (tablero.tablero[this.x][i] != 0) {
				cantConflictos[(tablero.tablero[this.x][i]) - 1] = 1;
				break;
			}
		}

		for (int i = this.y - 1; i >= 0; i--) {

			if (tablero.tablero[this.x][i] != 0) {
				cantConflictos[(tablero.tablero[this.x][i]) - 1] = 1;
				break;
			}
		}

		for (int i = this.x - 1, j = this.y + 1; i >= 0 && j < tablero.tamanio; i--, j++) {

			if (tablero.tablero[i][j] != 0) {
				cantConflictos[(tablero.tablero[i][j]) - 1] = 1;
				break;
			}
		}

		for (int i = this.x - 1, j = this.y - 1; i >= 0 && j >= 0; i--, j--) {

			if (tablero.tablero[i][j] != 0) {
				cantConflictos[(tablero.tablero[i][j]) - 1] = 1;
				break;
			}
		}

		for (int i = this.x + 1, j = this.y + 1; i < tablero.tamanio && j < tablero.tamanio; i++, j++) {

			if (tablero.tablero[i][j] != 0) {
				cantConflictos[(tablero.tablero[i][j]) - 1] = 1;
				break;
			}
		}

		for (int i = this.x + 1, j = this.y - 1; i < tablero.tamanio && j >= 0; i++, j--) {

			if (tablero.tablero[i][j] != 0) {
				cantConflictos[(tablero.tablero[i][j]) - 1] = 1;
				break;
			}
		}

	}

}
