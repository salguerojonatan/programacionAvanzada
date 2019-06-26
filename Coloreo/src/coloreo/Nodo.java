package coloreo;

public class Nodo implements Comparable<Nodo>{
	private int nroGrafo;
	private int color;
	private int grado;
	
	
	public Nodo() {}
	
	public Nodo(int n) {
		this.nroGrafo = n;
		this.grado = 0;
		this.color = 0;
	}
	
	public int getNroGrafo() {
		return nroGrafo;
	}
	
	public void setGrado(int grado) {
		this.grado = grado;
	}
	

	public void setColor(int c) {
		this.color =c;
	}
	
	public int getColor() {
		return color;
	}

	@Override
	public String toString() {
		return "Nodo [nroGrafo=" + nroGrafo + ", color=" + color + " , " + " grado=" + grado + "]";
	}

	@Override
	public int compareTo(Nodo o) {
		if(this.grado > o.grado)
			return 1;
		else 
			return -1;
		
	}
}
