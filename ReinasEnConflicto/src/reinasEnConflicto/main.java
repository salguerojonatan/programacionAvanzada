package reinasEnConflicto;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Locale;
import java.util.Scanner;

public class main {

	public static void main(String[] args) throws IOException {
		
		
		PrintWriter salida = new PrintWriter(new FileWriter("salida.txt"));
		
		Scanner sc = new Scanner(new File("damas.txt"));
		sc.useLocale(Locale.ENGLISH);
		
		int tamanio = sc.nextInt();
		int cantReinas = sc.nextInt();
		
		Tablero tablero = new Tablero(tamanio, cantReinas);
		Reinas [] reina = new Reinas[cantReinas];
		
		
		for(int i = 0; i < tablero.cantReinas; i++) {
			reina[i] = new Reinas(i+1, sc.nextInt()-1, sc.nextInt()-1);
			tablero.agregarReina(reina[i]);
		}
			
		sc.close();
//		tablero.mostrar();
		
		
		for(int i =0; i < cantReinas;i++) 
			reina[i].conflictos(tablero);
		
		for(int i =0; i< cantReinas; i++) {
			int cant = reina[i].cuantos();
			
			salida.print(cant + " ");
			
			for(int j = 0; j < reina[i].cantConflictos.length ; j++) {
				if(reina[i].cantConflictos[j] != 0)
					salida.print( (j+1) + " " );
			}
			
			salida.println();
			}
		
		
		salida.close();
		
		
		
	}

}
