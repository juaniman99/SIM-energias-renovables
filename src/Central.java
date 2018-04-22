import java.awt.Color;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

// Project by Juan Torres Gomez

public class Central {
	private ImageIcon imgStatusOn;
	private ImageIcon imgStatusOff;
	private int id;
	private String nombre;
	private int posX;
	private int posY;
	private int trottle;
	private float produccionMaxima;
	
	Central(int id, String nombre, int posX, int posY, float produccionMaxima, ImageIcon imgStatusOn, ImageIcon imgStatusOff) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.posX = posX;
		this.posY = posY;
		this.produccionMaxima = produccionMaxima;
		this.imgStatusOff = imgStatusOff;
		this.imgStatusOn = imgStatusOn;
		trottle = 25;
		anadir();
	}
	public void anadir() {
		JLabel lblpanel8 = new JLabel();
		lblpanel8.setBounds(posX, posY, 70, 70);
		Mapwindow.panel_1.add(lblpanel8);
		lblpanel8.setIcon(imgStatusOn);
		lblpanel8.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent arg0) {
				lblpanel8.setBorder(BorderFactory.createLineBorder(Color.black));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				lblpanel8.setBorder(null);
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				Controlador.SelectRow(id);
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
