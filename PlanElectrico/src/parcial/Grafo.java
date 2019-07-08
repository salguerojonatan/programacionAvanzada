package parcial;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Grafo {
	PriorityQueue<Aristas> cola = new PriorityQueue<Aristas>();
	List<Aristas> lista = new ArrayList<Aristas>();

	private int[][] matriz;
	
	private int ciudadAConectar;
	private boolean [] electrica;
	private int[] ciudadElectrificada;
	private int costo=0;

	public Grafo(String path) throws FileNotFoundException {
		int cantCiudad;
		Scanner sc = new Scanner(new File(path));
		int cant = sc.nextInt();
		cantCiudad = sc.nextInt();

		ciudadElectrificada = new int[cantCiudad];
		
		ciudadAConectar = cant - cantCiudad;
		
		
		electrica = new boolean[cant];
		
		for(int i = 0; i < electrica.length;i++)
				electrica[i] = false;
		
		
		for (int i = 0; i < ciudadElectrificada.length; i++)
			ciudadElectrificada[i] = sc.nextInt();

		matriz = new int[cant][cant];

		for (int i = 0; i < matriz.length; i++)
			for (int j = 0; j < matriz.length; j++)
				matriz[i][j] = sc.nextInt();

		for (int i = 0; i < matriz.length; i++)
			for (int j = 0; j < matriz.length; j++) {
				if (matriz[i][j] != 0) {
					Aristas arista = new Aristas(i + 1, j + 1, matriz[i][j]);
					cola.add(arista);
				}

			}
		
		for(int i =0; i<ciudadElectrificada.length;i++) {
			electrica[ciudadElectrificada[i]-1]=true;
		}
		
		for(int i =0; i<electrica.length;i++)
			System.out.println(electrica[i]);
		sc.close();
	}
	
	public void resolver() throws FileNotFoundException {
		
		Aristas aris = new Aristas();
		aris = cola.poll();
		while(cola.isEmpty() ==false && ciudadAConectar != 0 ) {
			if(electrica[aris.getNodo1()-1] != true) {
				lista.add(aris);
				ciudadAConectar--;
			}
			aris = cola.poll();
		}
		for(Aristas i : lista) {
			costo+=i.getPeso();
		}
	}
	
	public void grabar() throws FileNotFoundException {
		PrintWriter salida = new PrintWriter(new File("salida.out"));
		salida.println(costo);
		if(costo == 0)
			salida.println("TODAS LAS CIUDADES SON CENTRALES ELECTRICAS");
		else 
			for (Aristas i : lista) 
				salida.println( i.getNodo1() + " " + i.getNodo2());
			
			
		
		salida.close();
			}
		
		
}
