import java.awt.Image;
import javax.swing.ImageIcon;

public class CentralSolar extends Central{
	
	CentralSolar(int id, String nombre, int posX, int posY, float produccionMaxima) {
		super(id, nombre, posX, posY, produccionMaxima, new ImageIcon(new ImageIcon("images/panel_on.gif").getImage().getScaledInstance(70, 70, Image.SCALE_DEFAULT)), new ImageIcon(new ImageIcon("images/panel_off.png").getImage().getScaledInstance(70, 70, Image.SCALE_DEFAULT)));
		// TODO Auto-generated constructor stub
	}
}
