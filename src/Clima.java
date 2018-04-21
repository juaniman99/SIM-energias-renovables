//Project By Juan Torres Gómez

//	Esta clase la usará Tiempo.java . Almacena los datos de los distintos climas posibles.
public class Clima {
	private String nombre;
	private String img;
	private int tipo;	//0 normal (soleado, noche, nublado); 1: Condiciones un poco adversas(nieve, llovizna..); 2: Condiciones mas adversas(lluvia); 3: Condiciones muy adversas (tormenta)	(en realidad es el nivel de peligrosidad)
	private float temperaturaMedia;
	private float velocidadVientoMedia;
	
	
	public Clima(String nombre, String img, int tipo, float temperaturaMedia, float velocidadVientoMedia) {
		super();
		this.nombre = nombre;
		this.img = img;
		this.tipo = tipo;
		this.temperaturaMedia = temperaturaMedia;
		this.velocidadVientoMedia = velocidadVientoMedia;
	}
	
	public String getImg() {
		return img;
	}
	
	public float getTempMedia() {
		return temperaturaMedia;
	}
	public float getVientoMedia() {
		return velocidadVientoMedia;
	}
}
