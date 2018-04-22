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

}
