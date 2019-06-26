package coloreo;

import java.io.FileNotFoundException;
import java.util.Collections;

public class main {

	public static void main(String[] args) throws FileNotFoundException {
		
		Grafos grafo = new Grafos("Nodos.txt");
		
		grafo.grados();
		
//		grafo.mostrarGrafos();
		grafo.colorear();
		grafo.mostrarGrafos();
		
	}

}
