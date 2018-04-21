import java.awt.Color;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

// Project by Juan Torres Gomez

public class Central {
	private int id;
	private String nombre;
	private int posX;
	private int posY;
	private int trottle;
	private float produccionMaxima;
	
	Central(int id, String nombre, int posX, int posY, float produccionMaxima) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.posX = posX;
		this.posY = posY;
		this.produccionMaxima = produccionMaxima;
		
		anadir();
	}
	public void anadir() {
		ImageIcon panelOn;
		if((int)(Math.random()*100) > 50)
			panelOn = new ImageIcon(new ImageIcon("images/panel_on.gif").getImage().getScaledInstance(70, 70, Image.SCALE_DEFAULT));
		else
			panelOn = new ImageIcon(new ImageIcon("images/molino_on.gif").getImage().getScaledInstance(70, 70, Image.SCALE_DEFAULT));
		
		JLabel lblpanel8 = new JLabel();
		lblpanel8.setBounds(posX, posY, 70, 70);
		Mapwindow.panel_1.add(lblpanel8);
		lblpanel8.setIcon(panelOn);
		lblpanel8.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent arg0) {
				lblpanel8.setBorder(BorderFactory.createLineBorder(Color.black));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				lblpanel8.setBorder(null);
			}
		});
	}
	
	public int getTrollet() {
		return trottle;
	}
	public void setTrollet(int value) {
		trottle = value;
	}
}
