import java.util.ArrayList;

public class Modelo {
	private String[]  usuariosLogin = {"root", "juan", "nodex"};
	private String[]  contrasenasLogin = {"root", "1234", "4321"};
	private static ArrayList<Central> centrales;
	
	Modelo(){
		centrales = new ArrayList<>();
	}
	public void addCentral(String tipo, String nombre, int id, int posX, int posY, float produccionMaxima) {
		if(tipo.equals("Eolica"))
			centrales.add(new CentralEolica(id, nombre, posX, posY, produccionMaxima));
		else if(tipo.equals("Solar"))
			centrales.add(new CentralSolar(id, nombre, posX, posY, produccionMaxima));

		Maincontrol.model.addRow(new Object[] {id, nombre, tipo, "...", "25%"});			
	}
	public void removeCentral(int idToRemove) {
		Maincontrol.model.removeRow(SearchRownById(idToRemove));
		int centralaRemover = FindCentral(idToRemove);
		centrales.get(centralaRemover).Remover();
		centrales.remove(centralaRemover);
	}
	
	public int FindCentral(int id) {
		for(int i = 0; i < centrales.size(); i++) {
			if(centrales.get(i).getId() == id)
				return i;
		}
		return -1;
	}
	
	public boolean CheckIfIdExist(int id) {
		for(int i = 0; i < centrales.size(); i++) {
			if(centrales.get(i).getId() == id)
				return true;
		}
		return false;
	}
	
	public static int SearchRownById(int idToSearch) {	//Este metodo buscar� en la tabla la central con dicha id y retornar� su posicion en esta.
		for(int i = 0; i < centrales.size(); i++) {
			if((int) Maincontrol.table.getValueAt(i, 0) == idToSearch)
				return i;
		}
		return -1;
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
