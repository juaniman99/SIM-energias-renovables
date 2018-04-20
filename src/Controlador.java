import javax.swing.JOptionPane;

public class Controlador {
	private static Modelo modelo = new Modelo();
	static Loginwindow loginw;
	static Mapwindow mapw;
	static Climawindow climaw;
	
	public static void IniciarVentanas(){
		loginw = new Loginwindow();
		mapw = new Mapwindow();
		climaw = new Climawindow();
		loginw.frame.setVisible(true);
		mapw.frmMapa.setVisible(true);
		climaw.frmClima.setVisible(true);
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
}
