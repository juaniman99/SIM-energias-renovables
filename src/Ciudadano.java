//Project By Juan Torres
//	Este m�todo incluye b�sicamente el edad del ciudadano y a que edad morir�.
/*	En un principio, cada ciudadano iba a tener ciertas caracter�sticas que permitieran controlar la natalidad
*	de forma m�s realista (dinero de cada ciudadano, pareja, sexo, edad, enfermedades...).
*/
public class Ciudadano {
	private int edad;
	private int edadMuerte;
	private int sexo;	//0 mujer, 1 hombre;
	private float consumoMedio;	//Lo que este ciudadano consumir� de media a lo largo de su vida (expresado en KW).
	
	Ciudadano(){
		edad = 0;
		edadMuerte = (int)(Math.random()*8)+4;	//Es extraa�o, pero he sacrificado realismo (suponiendo que las personas como mucho pueden vivir 11 dias) por "funcionalidad".
		sexo =  (int)(Math.random()*2);
		double conMedioToSet = 0.01 + Math.random() * (1.9 - 0.01);
		consumoMedio = (float)conMedioToSet;
	}
	
	public boolean imDead() {
		if(edad >= edadMuerte)
			return true;
		return false;
	}
	public void addEdad() {
		edad++;
	}
	public float getConsumoMedio() {
		return consumoMedio;
	}
}
