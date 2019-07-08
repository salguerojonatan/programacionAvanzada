package parcial;

public class Aristas implements Comparable<Aristas> {
	

	private int nodo1;
	private int nodo2;
	private int peso;
	
	public Aristas() {}
	
	public Aristas(int n1, int n2, int p) {
		this.nodo1 = n1;
		this.nodo2 = n2;
		this.peso = p;
	}

	public int getNodo1() {
		return nodo1;
	}

	public void setNodo1(int nodo1) {
		this.nodo1 = nodo1;
	}

	public int getNodo2() {
		return nodo2;
	}

	public void setNodo2(int nodo2) {
		this.nodo2 = nodo2;
	}

	public int getPeso() {
		return peso;
	}

	public void setPeso(int peso) {
		this.peso = peso;
	}

	@Override
	public int compareTo(Aristas o) {
		
		if(this.getPeso() > o.getPeso())
			return 1;
		else
			return -1;
		
		
	}
	
	@Override
	public String toString() {
		return "Aristas [nodo1=" + nodo1 + ", nodo2=" + nodo2 + ", peso=" + peso + "]";
	}
}
