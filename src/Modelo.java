import java.util.ArrayList;

public class Modelo {
	private String[]  usuariosLogin = {"root", "juan", "nodex"};
	private String[]  contrasenasLogin = {"root", "1234", "4321"};
	private ArrayList<Central> centrales;
	
	Modelo(){
		centrales = new ArrayList<>();
	}
	public void addCentral(String tipo, String nombre, int posX, int posY, float produccionMaxima) {
		if(tipo.equals("Eolica"))
			centrales.add(new CentralEolica(centrales.size(), nombre, posX, posY, produccionMaxima));
		else if(tipo.equals("Solar"))
			centrales.add(new CentralSolar(centrales.size(), nombre, posX, posY, produccionMaxima));

		Maincontrol.model.addRow(new Object[] {nombre, tipo, "...", "25%"});			
	}
	public void removeCentral(int idToRemove) {
		Maincontrol.model.removeRow(Maincontrol.table.getSelectedRow());
	}
	
	public boolean checkCredentials(String user, String pass) {
		System.out.println(user);
		System.out.println(pass);
		for(int i = 0; i < usuariosLogin.length; i++) {
			if(user.equals(usuariosLogin[i]) && pass.equals(contrasenasLogin[i])) {
				return true;
			}
		}
		return false;
	}
	
}
