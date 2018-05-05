import java.awt.Color;

import javax.swing.JOptionPane;

// Project by Juan Torres

/*
 * Esta clase solo será utilizada por WindowConstruir.java
 */

public class Construir {
	private int coste;
	private WindowConstruir wc;	//Prevengo poner los objetos y clases estáticas al traer los componentes.
	private boolean loaded;
	
	Construir(WindowConstruir wc){
		coste = 0;
		this.wc = wc;
		loaded = false;
	}
	public void setLoadedTrue() { //Al cargar todos los componentes, será llamado
		loaded = true;	
	}
	
	public void calcularCoste() {
		if(!loaded) return;	//Esto es importante, porque al iniciar el programa, mientras se cargan los elementos este metodo será llamado varias veces y lanzará varias excepciones al no estar los componentes inicializados.
		
		String tipoCentral = wc.comboBox.getSelectedItem().toString();
		String tamano = wc.comboBox_1.getSelectedItem().toString();
		coste = 0;
		
		if(tipoCentral.equals("Eolica"))
			coste += 450;
		if(tipoCentral.equals("Solar"))
			coste += 200;
		
		if(tamano.equals("S"))
			coste += 50;
		if(tamano.equals("M"))
			coste += 100;
		if(tamano.equals("L"))
			coste += 200;
		if(tamano.equals("XL"))
			coste += 400;
		
		wc.lblCoste.setText("Coste: " + coste + "€");
		if(coste > Controlador.getDinero())
			wc.lblCoste.setForeground(Color.RED);
		else
			wc.lblCoste.setForeground(Color.GREEN);
	}
	
	public void requestConstruir() {
		if(coste <= Controlador.getDinero()) {			
			Controlador.ConstruirPlanta(String.valueOf(wc.comboBox.getSelectedItem()), wc.textField.getText(), Integer.parseInt(wc.textField_1.getText()), Integer.parseInt(wc.textField_2.getText()), String.valueOf(wc.comboBox_1.getSelectedItem()), coste);	//el 10 hay que modificarlo
			wc.frmNuevaConstruccion.setVisible(false);
		}else {
			JOptionPane.showMessageDialog(null, "No tienes dinero suficiente para esta construccion.");
		}
	}
}
