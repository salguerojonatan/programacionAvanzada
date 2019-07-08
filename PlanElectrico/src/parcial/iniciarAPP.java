package parcial;

import java.io.FileNotFoundException;

public class iniciarAPP {

	public static void main(String[] args) throws FileNotFoundException {
		Grafo grafo = new Grafo("electrificar.in");
		grafo.resolver();
		grafo.grabar();
	}

}
