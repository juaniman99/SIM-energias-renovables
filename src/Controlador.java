//Project by Juan Torres G�mez

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;
import javax.swing.Timer;

public class Controlador {
	private static Modelo modelo = new Modelo();
	private static Tiempo tiempo = new Tiempo();
	static Loginwindow loginw;
	static Mapwindow mapw;
	static Climawindow climaw;
	
	public static void Iniciar(){
		loginw = new Loginwindow();
		mapw = new Mapwindow();
		climaw = new Climawindow();
		loginw.frame.setVisible(true);
		mapw.frmMapa.setVisible(true);
		climaw.frmClima.setVisible(true);

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
	static Timer timer = new Timer (100, new ActionListener () {
		@Override
		public void actionPerformed(ActionEvent arg0) {
			// TODO ESTA ES LA FUNCI�N QUE SE EJECUTA
			NextStep();
		}
				
	});
	
	private static void NextStep() {	//Principalmente este m�todo ser� llamado desde el Timer de controlador, pero al ponerlo aqu� me permitir� en un futuro a�adir m�s funciones.
		tiempo.Step();
	}
}
