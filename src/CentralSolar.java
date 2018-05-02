//Project by Juan Torres

import java.awt.Image;
import javax.swing.ImageIcon;

public class CentralSolar extends Central{
	
	CentralSolar(int id, String nombre, int posX, int posY, float produccionMaxima) {
		super(id, nombre, posX, posY, produccionMaxima, new ImageIcon(new ImageIcon("images/panel_on.gif").getImage().getScaledInstance(70, 70, Image.SCALE_DEFAULT)), new ImageIcon(new ImageIcon("images/panel_off.png").getImage().getScaledInstance(70, 70, Image.SCALE_DEFAULT)));
		// TODO Auto-generated constructor stub
	}
	public void Steep(Tiempo tiempo) {	//Calculará la producción en base al clima.
		float prod = 0;
		int f = 0;
		if(tiempo.getSol() > 3) {
			prod = (float)((tiempo.getSol()/3))/(100/super.getTrollet());
			prod += (super.getPosY()/300)*7;
		}
		System.out.println("prod: " + prod);
		prod = prod < 0 ? 0 : prod;
		super.setProduccionActual((float) Math.round(prod * 10) / 10);	//Redondeo a 1 decimal; 	//Esta bien usar una variable protegida?
	}
}
