//Project by Juan Torres Gómez

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;
import javax.swing.Timer;

public class Controlador {
	private static Modelo modelo;
	private static Tiempo tiempo;
	static Loginwindow loginw;
	static Mapwindow mapw;
	static Climawindow climaw;
	static WindowConstruir contrucw;
	
	public static void Iniciar(){
		loginw = new Loginwindow();
		mapw = new Mapwindow();
		climaw = new Climawindow();
		contrucw = new WindowConstruir();
		climaw.frmClima.setVisible(true);
		loginw.frame.setVisible(true);
		mapw.frmMapa.setVisible(true);
		modelo = new Modelo();
		tiempo = new Tiempo();

	    timer.start();
	}
	
	public static void Login(String user, String pass) {
		if(modelo.checkCredentials(user, pass)) {
			//Credenciales correctas.
			loginw.frame.setVisible(false);
		}else {
			//Credenciales incorrectas.
			JOptionPane.showMessageDialog(null,"Credenciales incorrectas.");
		}
	}
	public static void AnadirPlanta() {
		//Inicia el asistente para seleccionar el tipo de planta y su posición.
		contrucw.frmNuevaConstruccion.setVisible(true);
	}
	
	public static void ConstruirPlanta(String tipo, String nombre, int posX, int posY, String produccionMaxima) {
		int prodMax = 0;
		if(produccionMaxima.equals("XS"))
			prodMax = 10;
		else if(produccionMaxima.equals("S"))
			prodMax = 15;
		else if(produccionMaxima.equals("M"))
			prodMax = 50;
		else if(produccionMaxima.equals("L"))
			prodMax = 200;
		else if(produccionMaxima.equals("XL"))
			prodMax = 500;
				
		modelo.addCentral(tipo, nombre, posX, posY, prodMax);
	}
	
	public static void DemolerPlanta() {
		modelo.removeCentral(1);
	}
	
	public static void SelectRow(int i) {
		Maincontrol.table.setRowSelectionInterval(i, i);
	}
	
	static Timer timer = new Timer (100, new ActionListener () {	//El corazón de todo el programa. El que le da vida.
		@Override
		public void actionPerformed(ActionEvent arg0) {
			// TODO ESTA ES LA FUNCIÓN QUE SE EJECUTA
			NextStep();
		}
				
	});
	
	private static void NextStep() {	//Principalmente este método será llamado desde el Timer de controlador, pero al ponerlo aquí me permitirá en un futuro añadir más funciones.
		tiempo.Step();
	}
}
