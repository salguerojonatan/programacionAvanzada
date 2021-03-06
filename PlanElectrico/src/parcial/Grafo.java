package parcial;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Grafo {
	PriorityQueue<Aristas> cola = new PriorityQueue<Aristas>();
	List<Aristas> lista = new ArrayList<Aristas>();

	private int[][] matriz;

	private int ciudadAConectar;
	private boolean[] electrica;
	private int[] ciudadElectrificada;
	private int costo = 0;

	public Grafo(String path) throws FileNotFoundException {
		int cantCiudad;
		Scanner sc = new Scanner(new File(path));
		int cant = sc.nextInt();
		cantCiudad = sc.nextInt();

		ciudadElectrificada = new int[cantCiudad];

		ciudadAConectar = cant - cantCiudad;

		electrica = new boolean[cant];

		for (int i = 0; i < electrica.length; i++)
			electrica[i] = false;

		for (int i = 0; i < ciudadElectrificada.length; i++)
			ciudadElectrificada[i] = sc.nextInt();

		matriz = new int[cant][cant];

		for (int i = 0; i < matriz.length; i++)
			for (int j = 0; j < matriz.length; j++)
				matriz[i][j] = sc.nextInt();

		for (int i = 0; i < matriz.length; i++)
			for (int j = i + 1; j < matriz.length; j++) {
				if (matriz[i][j] != 0) {
					Aristas arista = new Aristas(i + 1, j + 1, matriz[i][j]);
					cola.add(arista);
				}

			}

		for (int i = 0; i < electrica.length; i++)
			System.out.println(electrica[i]);

		sc.close();
	}

	public boolean sonCentralesConectadas(int n1, int n2) {

		if (n1 > ciudadElectrificada.length || n2 > ciudadElectrificada.length)
			return false;

		if (n1 == ciudadElectrificada[n1 - 1])
			return true;
		if (n2 == ciudadElectrificada[n2 - 1])
			return true;

		return false;
	}

	public void resolver() throws FileNotFoundException {

		Aristas aris = new Aristas();
		aris = cola.poll();
		while (cola.isEmpty() == false && ciudadAConectar != 0) {

			if (sonCentralesConectadas(aris.getNodo1(), aris.getNodo2()) == false) {

				if (electrica[aris.getNodo1() - 1] == false || electrica[aris.getNodo2() - 1] == false) {
					lista.add(aris);
					electrica[aris.getNodo1() - 1] = true;
					electrica[aris.getNodo2() - 1] = true;
					ciudadAConectar--;
				}

			}
			aris = cola.poll();
		}

		for (Aristas i : lista) {
			costo += i.getPeso();
		}

		for (Aristas i : lista) {
			System.out.println(i);
			if (i.getNodo1() > i.getNodo2()) {
				int aux = i.getNodo1();
				i.setNodo1(i.getNodo2());
				i.setNodo2(aux);
			}
		}
		
	}

	public void grabar() throws FileNotFoundException {
		PrintWriter salida = new PrintWriter(new File("salida.out"));
		Collections.sort(lista);
		salida.println(costo);
		if (costo == 0)
			salida.println("TODAS LAS CIUDADES SON CENTRALES ELECTRICAS");
		else
			for (Aristas i : lista) {
				salida.println(i.getNodo1() + " " + i.getNodo2());
			}

		salida.close();
	}

}
