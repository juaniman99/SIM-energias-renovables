
public class Modelo {
	private String[]  usuariosLogin = {"root", "juan", "nodex"};
	private String[]  contrasenasLogin = {"root", "1234", "4321"};
	
	
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
