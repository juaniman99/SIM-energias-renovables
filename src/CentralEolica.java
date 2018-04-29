import java.awt.Image;

import javax.swing.ImageIcon;

public class CentralEolica extends Central{


	CentralEolica(int id, String nombre, int posX, int posY, float produccionMaxima) {
		super(id, nombre, posX, posY, produccionMaxima, new ImageIcon(new ImageIcon("images/molino_on.gif").getImage().getScaledInstance(70, 70, Image.SCALE_DEFAULT)), new ImageIcon(new ImageIcon("images/molino_off.png").getImage().getScaledInstance(70, 70, Image.SCALE_DEFAULT)));

		//anadir();		
	}
	@Override
	public void anadir() {
		super.anadir();
	}
	
	public void Steep(Tiempo tiempo) {	//Calculará la producción en base al clima.
		float prod = 0;
		int f = 0;
		if(super.getPowerStatus())
			prod = ((tiempo.getViento()/2)+(super.getPosY()/2))/(100/super.getTrollet());
		super.setProduccionActual((float) Math.round(prod * 10) / 10);	//Redondeo a 1 decimal; 	//Esta bien usar una variable protegida?	}
	}
}
