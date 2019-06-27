package coloreo;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Grafos {
	private int[][] matrizAdyacencia;
	List<Nodo> Lista;
	private  int cantiColores;
	private int cantidadNodos;

	public Grafos() {
	}

	public Grafos(String path) throws FileNotFoundException {

		Scanner sc = new Scanner(new File(path));

		int cant = sc.nextInt();
		cantidadNodos = cant;
		matrizAdyacencia = new int[cant][cant];

		Lista = new ArrayList<Nodo>();

		for (int i = 0; i < matrizAdyacencia.length; i++)
			for (int j = 0; j < matrizAdyacencia.length; j++)
				matrizAdyacencia[i][j] = -1;

		for (int i = 0; i < cant; i++) {
			Nodo nodo = new Nodo(sc.nextInt());
			int guardar = sc.nextInt();
			while (guardar != -1) {
				matrizAdyacencia[nodo.getNroGrafo() - 1][guardar - 1] = 1;
				matrizAdyacencia[guardar - 1][nodo.getNroGrafo() - 1] = 1;
				guardar = sc.nextInt();
			}
			Lista.add(nodo);
		}
		sc.close();
	}

	public void mostrarGrafos() {

		for (Nodo a : Lista)
			System.out.println(a);
	}

	public void grados() {
		for (Nodo nodo : Lista) {
			int cont = 0;
			for (int i = 0; i < matrizAdyacencia.length; i++) {

				if (matrizAdyacencia[nodo.getNroGrafo() - 1][i] != -1)
					cont++;
			}
			nodo.setGrado(cont);

		}
		Collections.sort(Lista);
	}

	public int buscarIndexEnLista(int index) {
		int cont = 0;
		for (Nodo nodo : Lista) {
			if (nodo.getNroGrafo() == index)
				return cont;
			cont++;
		}

		return -1;
	}

	public void  colorear() {
		int pinto = 0;
		int color = 1;
		int primero = 1;
		int cant = 0;
		int cc = 1;
		
		while (cant < Lista.size()) {
			pinto = 0;
			if (primero == 1) {
				Lista.get(primero - 1).setColor(color);
				primero = 0;
			} 
			else {
				for (int i = 0; i < matrizAdyacencia.length; i++) {
				
					if (matrizAdyacencia[Lista.get(cant).getNroGrafo() - 1][i] != -1) {
						int j = buscarIndexEnLista(i + 1);

						if (Lista.get(j).getColor() > 0) {
							int n = Lista.get(j).getColor()+1;
						Lista.get(cant).setColor(n);
						cc++;
						pinto = 1;
						}
						
					}
				}
				if(pinto ==0)
					Lista.get(cant).setColor(color);
			}

			
				cant++;
		}
		cantColores();
	}
	
	public void cantColores() {
		int cant = 0;
		for(Nodo nodo: Lista) {
			cant = nodo.getColor();	
			
		}
		
		cantiColores= cant;
	}
	public void grabar() throws FileNotFoundException {
		
		PrintWriter salida = new PrintWriter(new File("salida.txt"));
		
		salida.println(cantidadNodos + " " + cantiColores);
		for(Nodo nodo : Lista) {
			salida.println( nodo.getNroGrafo() + " " + nodo.getColor() );
		}
		salida.close();
		
	}
}
