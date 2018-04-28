//Project by Juan Torres G�mez

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JOptionPane;
import javax.swing.Timer;

import sun.applet.Main;

public class Controlador {
	private static Modelo modelo;
	private static Tiempo tiempo;
	static Loginwindow loginw;
	static Mapwindow mapw;
	static Climawindow climaw;
	static WindowConstruir contrucw;
	private static Central centralSeleccionada;
	
	public static void Iniciar(){
		loginw = new Loginwindow();
		mapw = new Mapwindow();
		climaw = new Climawindow();
		contrucw = new WindowConstruir();
		climaw.frmClima.setVisible(true);
		//loginw.frame.setVisible(true);
		mapw.frmMapa.setVisible(true);
		modelo = new Modelo();
		tiempo = new Tiempo();
		actualizarCiudadanos();
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
		//Inicia el asistente para seleccionar el tipo de planta y su posici�n.
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
				
		int ids = (int)(Math.random()*999-100)+100;
		while(modelo.CheckIfIdExist(ids)) {	//Comprueba que la id sea unica.
			ids = (int)(Math.random()*999-100)+100;
		}
		
		modelo.addCentral(tipo, nombre, ids, posX, posY, prodMax);
	}
	
	public static void DemolerPlanta() {
		modelo.removeCentral((int) Maincontrol.table.getValueAt(Maincontrol.table.getSelectedRow(), 0));
	}
	
	public static void TableSelectionChangued(int v) {	//Este metodo ser� llamado desde la tabla de MainCOntrol cada vez que se seleccione una fila.
		centralSeleccionada = modelo.getCentral(v);
		ReloadCentralData();
	}
	private static void ReloadCentralData() {
		Maincontrol.slider.setValue(centralSeleccionada.getTrollet());
		Maincontrol.lblNombre.setText("Nombre: " + centralSeleccionada.getNombre());
		Maincontrol.lblLocalidad.setText("Localizacion:" + "x: " + centralSeleccionada.getPosX() + ", y: " + centralSeleccionada.getPosY());
		Maincontrol.lblCapacidad.setText("Produccion MAX: " + centralSeleccionada.getProduccionMaxima() + "kw");
		String estadoaMostrar = "";
		if(centralSeleccionada.getPowerStatus())
			estadoaMostrar = "Encendida";
		else
			estadoaMostrar = "Apagada.";
		
		Maincontrol.lblEstado.setText("Estado: " + estadoaMostrar);
		if(centralSeleccionada.getPowerStatus()) {
			Maincontrol.btnArrancar.setEnabled(false);
			Maincontrol.btnDetener.setEnabled(true);
		}else {
			Maincontrol.btnArrancar.setEnabled(true);
			Maincontrol.btnDetener.setEnabled(false);
		}
	}
	public static void SetCentralTrotle(int value) {
		centralSeleccionada.setTrollet(value);
	}
	public static void apagarOEncenderCentral(boolean val) {	//Si es true, la enciende. False la apaga.
		centralSeleccionada.powerOnPlant(val);
		ReloadCentralData();
	}
	public static void SelectRow(int i) {
		Maincontrol.table.setRowSelectionInterval(i, i);
	}
	//El timer volver a ponerlo a 80.
	static Timer timer = new Timer (24, new ActionListener () {	//El coraz�n de todo el programa. El que le da vida.
		@Override
		public void actionPerformed(ActionEvent arg0) {
			// TODO ESTA ES LA FUNCI�N QUE SE EJECUTA
			NextStep();
		}
				
	});
	
	private static void NextStep() {	//Principalmente este m�todo ser� llamado desde el Timer de controlador, pero al ponerlo aqu� me permitir� en un futuro a�adir m�s funciones.
		tiempo.Step();
		CalcularDatos();
	}
	
	public static void CalcularDatos() {
		ArrayList<Central> centrales = modelo.getCentrales();	//Obtiene las centrales.
		float produccionTotal = 0;
		for(int i = 0; i < centrales.size(); i++) {
			Central cent = centrales.get(i);
			if(cent instanceof CentralEolica)
            {
                CentralEolica centralE = (CentralEolica) cent;
                centralE.Steep(tiempo);
            }
			if(cent instanceof CentralSolar)
            {
				CentralSolar centralS = (CentralSolar) cent;
                centralS.Steep(tiempo);
            }
			produccionTotal += centrales.get(i).getProduccionActual();
		}
		modelo.setProduccion(produccionTotal);
		if(centralSeleccionada != null)
			Maincontrol.lblProduccion.setText("Produccion: " + centralSeleccionada.getProduccionActual() + "kw");
		float dineroToAdd;
		if(modelo.getProduccion() >= modelo.getConsumoPoblacion()) {	//Solo se va a vender la electricidad solicitada, y la sobrante no. Sin embargo, si no se genera la suficiente para todo el mundo, se venderá toda la disponible.
			dineroToAdd = (modelo.getConsumoPoblacion()/80);	// Esta es la sencilla formula que simulará el precio del kw
		}else {
			dineroToAdd = (modelo.getProduccion()/80); 
		}
		modelo.addDinero(dineroToAdd);
		Maincontrol.label_3.setText(modelo.getDinero() + "€");
		Maincontrol.lblProducci.setText("Produccion: " + produccionTotal + "kw/h");
		Maincontrol.lblPoblacin.setText("Poblacion: " + modelo.getNumCiud());
	}	
	
	public static void actualizarCiudadanos() {	//Es llamado cada nuevo día desde TIEMPO.java
		ArrayList<Ciudadano> ciu = modelo.getCiudadanos();
		System.out.println("Ac ciu");
		float toGenerar = 0;
		int ramdonCiuToAdd = (int)(Math.random()*73)+13;
		for(int i = 0; i < ramdonCiuToAdd; i++) {	//Inserto personas de forma aleatoria.
			modelo.addPersona();
		}
		for(int i = 0; i < ciu.size(); i++) {
			ciu.get(i).addEdad();	//Va sumando la edad a todos.
			if(ciu.get(i).imDead())	//Segundo comprueba los que han de morir.
				modelo.deleteCiud(i);
			toGenerar += ciu.get(i).getConsumoMedio();
		}
		modelo.setConsumoPoblacion(toGenerar);	
		
		System.out.println("toGenerar: " + toGenerar);
		Maincontrol.lblEnergiaDemandada.setText("Demanda: " + toGenerar);
		Maincontrol.lblPoblacin.setText("Poblacion: " + modelo.getNumCiud());		
	}
}
