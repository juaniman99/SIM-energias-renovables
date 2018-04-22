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
	private boolean powerStatus;	//Considerar convertirlo en int, para más estados de la planta.
	private int id;
	private String nombre;
	private int posX;
	private int posY;
	private int trottle;
	protected int actualProduccion;
	private float produccionMaxima;
	private JLabel lblpanel8;	//Es el elemento que contiene la imagen en el mapa.
	
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
		powerStatus = false;
		anadir();
	}
	public void anadir() {
		lblpanel8 = new JLabel();
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
				Controlador.SelectRow(Modelo.SearchRownById(id));
			}
		});
	}
	
	public void powerOnPlant(boolean b) {	//Si es true, se encende. si no, se apaga.
		powerStatus = b ? true : false;
		
		if(powerStatus) {
			lblpanel8.setIcon(imgStatusOn);
			Maincontrol.table.setValueAt(actualProduccion + "kw", Modelo.SearchRownById(id), 3);
			Maincontrol.table.setValueAt(trottle + "%", Modelo.SearchRownById(id), 4);
		}else {
			lblpanel8.setIcon(imgStatusOff);
			Maincontrol.table.setValueAt("off", Modelo.SearchRownById(id), 3);
			Maincontrol.table.setValueAt("off", Modelo.SearchRownById(id), 4);
		}
	}
	
	public void Remover() {
		lblpanel8.setVisible(false);	//Por mejorar
	}
	public int getId() {
		return id;
	}
	public int getTrollet() {
		return trottle;
	}
	public boolean getPowerStatus() {
		return powerStatus;
	}
	
	public String getNombre() {
		return nombre;
	}
	public int getPosX() {
		return posX;
	}
	public int getPosY() {
		return posY;
	}
	public float getProduccionMaxima() {
		return produccionMaxima;
	}
	public void setTrollet(int value) {
		trottle = value;
		if(powerStatus)
			Maincontrol.table.setValueAt(trottle + "%", Modelo.SearchRownById(id), 4);
	}
}
