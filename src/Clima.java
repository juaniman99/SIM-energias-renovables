import java.awt.Image;

import javax.swing.ImageIcon;

//Project By Juan Torres G�mez

//	Esta clase la usar� Tiempo.java . Almacena los datos de los distintos climas posibles.
//	PD: Cada clima deber�a detener la volatilidad de cada tipo (el rango de variacion de la temperatura media por ejemplo). Para no complicarme demasiado, este dato ser� fijo en Tiempo.CambiarClima();
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
	
	public ImageIcon getImg() {
		return new ImageIcon(new ImageIcon(img).getImage().getScaledInstance(129, 129, Image.SCALE_DEFAULT));
	}
	
	public float getTempMedia() {
		return temperaturaMedia;
	}
	public float getVientoMedia() {
		return velocidadVientoMedia;
	}
	public int getTipo() {
		return tipo;
	}
}
