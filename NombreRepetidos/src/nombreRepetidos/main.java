package nombreRepetidos;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Collection;
import java.util.Iterator;
import java.util.Locale;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeMap;

public class main {

	public static void main(String[] args) throws IOException {
		Scanner sc;
		TreeMap<String, Integer> map = new TreeMap<String, Integer>();
		sc = new Scanner(new File("nombres.txt"));
		sc.useLocale(Locale.ENGLISH);
		int cant = sc.nextInt();
		int cantMostrar = sc.nextInt();

		for (int i = 0; i < cant; i++) {
			String nombre = sc.next();
			if (map.containsKey(nombre)) {
				int cantidad = map.get(nombre);
				map.put(nombre, cantidad + 1);
			} else {
				map.put(nombre, 1);
			}

		}
		sc.close();

		Iterator<Entry<String, Integer>> interator = map.entrySet().iterator();

		TreeMap<Integer, String> mapFinal = new TreeMap<Integer, String>();

		while (interator.hasNext()) {
			Entry<String, Integer> a = (Entry<String, Integer>) interator.next();

			mapFinal.put((-1) * a.getValue(), a.getKey());
		}

		PrintWriter salida = new PrintWriter(new FileWriter("nombresout.txt"));

		Iterator<Entry<Integer, String>> interador2 = mapFinal.entrySet().iterator();

		int j = 0;
		while (interador2.hasNext() && j < cantMostrar) {
			Entry<Integer, String> b = (Entry<Integer, String>) interador2.next();

			salida.println(b.getValue() + " " + (-1) * b.getKey());

			j++;
		}

		salida.close();

	}
}
