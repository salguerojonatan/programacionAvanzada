package aCorrer;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Locale;
import java.util.Scanner;

public class ACorrer {

	public int[] vectorCarrera;
	public int[][] matrizEdadF;
	public int[][] matrizEdadM;
	public int[][] matrizCategoriaF;
	public int[][] matrizCategoriaM;

	public int[] indicePodiosF;
	public int[] indicePodiosM;

	Corredores[] competidor;

	public ACorrer(String path) {

		int cantLlegadas;
		int cantCompetidores;
		int cantF;
		int cantM;
		Scanner sc;
		try {
			sc = new Scanner(new File(path));
		
		sc.useLocale(Locale.ENGLISH);

		cantCompetidores = sc.nextInt();
		cantF = sc.nextInt();
		cantM = sc.nextInt();
		cantLlegadas = sc.nextInt();

		matrizEdadF = new int[cantF][2];
		matrizEdadM = new int[cantM][2];
		
		matrizCategoriaM = new int[cantM][3];
		matrizCategoriaF = new int[cantF][3];
		indicePodiosF = new int[cantF];
		indicePodiosM = new int[cantM];

		for (int i = 0; i < cantF; i++) {
			matrizEdadF[i][0] = sc.nextInt();
			matrizEdadF[i][1] = sc.nextInt();
		}

		for (int i = 0; i < cantM; i++) {
			matrizEdadM[i][0] = sc.nextInt();
			matrizEdadM[i][1] = sc.nextInt();
		}

		competidor = new Corredores[cantCompetidores];
		for (int i = 0; i < cantCompetidores; i++)
			competidor[i] = new Corredores(sc.nextInt(), sc.next().charAt(0));

		vectorCarrera = new int[cantLlegadas];

		for (int i = 0; i < cantLlegadas; i++)
			vectorCarrera[i] = sc.nextInt();
		sc.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
		for (int i = 0; i < vectorCarrera.length; i++) {
			
			int numeroJugador = vectorCarrera[i];

			Corredores a = new Corredores(competidor[numeroJugador - 1]);
			
			
			
	
			if (a.sexo == 'F' ) {
				int indice = -1;

				for (int j = 0; j < matrizEdadF.length; j++) {
					if (a.edad >= matrizEdadF[j][0] && a.edad <= matrizEdadF[j][1]) {
						indice = j;
						break;
					}
				}

				if (indicePodiosF[indice] < 3) {
					matrizCategoriaF[indice][indicePodiosF[indice]] = numeroJugador;
					indicePodiosF[indice]++;
				}

			} else {
				int indice = -1;
					
				for (int j = 0; j < matrizEdadM.length; j++) {
					
					if (a.edad >= matrizEdadM[j][0] && a.edad <= matrizEdadM[j][1]) {
						indice = j;
						break;
					}
				}
					
				if (indicePodiosM[indice] < 3) {
					matrizCategoriaM[indice][indicePodiosM[indice]] = numeroJugador;
					indicePodiosM[indice]++;
				}

			}

		}
			
		
		for(int i = 0; i < matrizCategoriaF.length; i++) {
			System.out.print(i+1 + " ");
			for(int j = 0; j < 3; j++) {
				System.out.print(matrizCategoriaF[i][j] + " ");
				
			}
			System.out.println("");
		}
		

		for(int i = 0; i < matrizCategoriaM.length; i++) {
			System.out.print(i+1 + " ");
			for(int j = 0; j < 3; j++) {
				System.out.print(matrizCategoriaM[i][j] + " ");
				
			}
			System.out.println("");
		}
		
		
		try {
			PrintWriter salida = new PrintWriter(new FileWriter("corredoresSalida.txt"));
			
			for(int i = 0; i < matrizCategoriaF.length; i++) {
				salida.print(i+1 + " ");
				for(int j = 0; j < 3; j++) {
					salida.print(matrizCategoriaF[i][j] + " ");
					
				}
				salida.println("");
			}
			

			for(int i = 0; i < matrizCategoriaM.length; i++) {
				salida.print(i+1 + " ");
				for(int j = 0; j < 3; j++) {
					salida.print(matrizCategoriaM[i][j] + " ");
					
				}
				salida.println("");
			}
			
			
			salida.close();
		} catch (IOException e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		} 
		
	}

}
