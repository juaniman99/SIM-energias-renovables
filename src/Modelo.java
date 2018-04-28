import java.util.ArrayList;

public class Modelo {
	private String[]  usuariosLogin = {"root", "juan", "nodex"};
	private String[]  contrasenasLogin = {"root", "1234", "4321"};
	private static ArrayList<Central> centrales;
	private ArrayList<Ciudadano> ciudadanos;
	private float consumoPoblacion;
	private float produccion;
	private float dinero = 500;
	
	Modelo(){
		centrales = new ArrayList<>();
		ciudadanos = new ArrayList<>();
		//Crea 3 centrales iniciales
		addCentral("Eolica", "11", 100, (int)(Math.random()*400), (int)(Math.random()*200), 200);
		addCentral("Eolica", "22", 101, (int)(Math.random()*400), (int)(Math.random()*200), 200);
		addCentral("Eolica", "33", 102, (int)(Math.random()*400), (int)(Math.random()*200), 200);
		addCentral("Eolica", "22", 103, (int)(Math.random()*400), (int)(Math.random()*200), 50);
		addCentral("Solar", "33", 104, (int)(Math.random()*400), (int)(Math.random()*200), 100);
		for(int i = 0; i < 10; i++) {	//El simulador empieza con 10 personas.
			ciudadanos.add(new Ciudadano());
		}
	}
	public void addPersona() {
		ciudadanos.add(new Ciudadano());
	}
	public  ArrayList<Ciudadano> getCiudadanos() {
		return ciudadanos;
	}
	public int getNumCiud() {
		return ciudadanos.size();
	}
	public void deleteCiud(int indice) {
		ciudadanos.remove(indice);
	}
	public void setProduccion(float i) {
		produccion = i;
	}
	public float getProduccion() {
		return produccion;
	}
	public void addCentral(String tipo, String nombre, int id, int posX, int posY, float produccionMaxima) {
		if(tipo.equals("Eolica"))
			centrales.add(new CentralEolica(id, nombre, posX, posY, produccionMaxima));
		else if(tipo.equals("Solar"))
			centrales.add(new CentralSolar(id, nombre, posX, posY, produccionMaxima));

		Maincontrol.model.addRow(new Object[] {id, nombre, tipo, "...", "25%"});
		centrales.get(centrales.size()-1).powerOnPlant(true);
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
	
	public Central getCentral(int id) {
		for(int i = 0; i < centrales.size(); i++) {
			System.out.println(centrales.get(i).getId() + " - " + id);
			if(centrales.get(i).getId() == id)
				return centrales.get(i);
		}
		System.out.println("Central no encontrada");
		return null;
	}
	public ArrayList<Central> getCentrales() {
		return centrales;
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
	
	public void addDinero(float i) {
		dinero += i;
	}
	public void removeDinero(int i) {
		dinero -= i;
	}
	public int getDinero() {
		return (int)(dinero);
	}
	
	public void setConsumoPoblacion(float value) {
		consumoPoblacion = value;
	}
	public float getConsumoPoblacion() {
		return consumoPoblacion;
	}
}
