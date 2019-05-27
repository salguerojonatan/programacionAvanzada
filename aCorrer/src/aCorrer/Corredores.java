package aCorrer;

public class Corredores {
	public int edad;
	public char sexo;
	
	public Corredores(int edad, char sexo) {
		this.edad = edad;
		this.sexo = sexo;
	}
	
	public Corredores(Corredores c) {
		
		this.edad = c.edad;
		this.sexo = c.sexo;
	}
	
	
}
