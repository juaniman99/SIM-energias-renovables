import java.util.ArrayList;

public class Modelo {
	private String[]  usuariosLogin = {"root", "juan", "nodex"};
	private String[]  contrasenasLogin = {"root", "1234", "4321"};
	private ArrayList<Central> centrales;
	
	Modelo(){
		centrales = new ArrayList<>();
	}
	public void addCentral(String tipo, String nombre, int id, int posX, int posY, float produccionMaxima) {
		centrales.add(new Central(id, nombre, posX, posY, produccionMaxima));
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
