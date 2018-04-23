//Project by Juan Torres G�mez

/*	Esta clase almacena la hora y la fecha simulada, as� como el clima y el proceso para calcularlo.
 * 	Tambi�n controla los elementos que se mostrar�n en la ventana de CLIMA
 */
public class Tiempo {
	private Clima[] climas;
	private Clima climaActual;
	private int minuto;
	private int hora;
	private int dia;
	private int mes;
	private int anyo;
	
	private int viento;	//en km/h
	private int sol;
	private float temperatura;
	
	private int ticksToNextEvent;	//Cuando llegue a 0, el clima cambiar�. La variable se reestablecer� a un valor aleatorio.
	private int TicksToNextDates;	//NO CONFUNDIR. cada vez que llegue a 0, se calcular� unos datos al azar basado en el clima actual.
	
	public Tiempo() {
		this.minuto = 00;
		this.hora = 00;
		this.dia = 1;
		this.mes = 1;
		this.anyo = 2018;
		climas = new Clima[6];
		climas[0] = new Clima("soleado", 	"images/clima/dia-soleado.png", 	0, 	26, 25);
		climas[1] = new Clima("nublado", 	"images/clima/nublado.png", 		0, 	12, 30);
		climas[2] = new Clima("nevando", 	"images/clima/nevando.png", 		1, 	0, 	25);
		climas[3] = new Clima("llovizna", 	"images/clima/llovizna.png", 		1, 	12, 10);
		climas[4] = new Clima("lluvia", 	"images/clima/dia-lluvioso.png", 	2, 	6, 	50);
		climas[5] = new Clima("tormenta", 	"images/clima/tormenta.png", 		3, 	13, 60);
		
		//climaActual = climas[1];	//Solo para pruebas
	}
	
	
	public void Step() {	//Se ejecuta por cada ciclo de reloj.
		minuto += 4;	//Cada ciclo de reloj, ser� 22 minutos.
		
		if(minuto >= 60) {
			minuto -= 60;
			hora++;
		}
		if(hora >= 24) {
			hora = 0;
			dia++;
		}
		if(dia > 31) {
			dia = 1;
			mes++;
		}
		if(mes > 12) {
			mes = 1;
			anyo ++;
		}
		
		CheckTicks();
		SetValuesToWindow();
	}
	
	private void SetValuesToWindow() {	//Este metodo plasma la mayor�a de datos sobre la ventana.
		Climawindow.lblFecha.setText(dateToString());
		Climawindow.lblc.setText(temperatura + "�c");
		Climawindow.lblkmh.setText(viento + "km/k");
	}
	
	
	private void CheckTicks() {
		System.out.println(ticksToNextEvent + " \t " + TicksToNextDates  + " \t " + temperatura);
		ticksToNextEvent--;
		TicksToNextDates--;
		if(ticksToNextEvent <= 0) {
			ticksToNextEvent = (int)(Math.random()*260-80)+80;
			CambiarClima();
		}
		if(TicksToNextDates <= 0) {
			TicksToNextDates = 27;
			GenerarClima();
		}
	}
	
	private void GenerarClima() {	//Este metodo va variando a lo largo de los ticks los datos del clima actual.
		if(hora > 5 && hora < 18)
			temperatura = (float) (temperatura + (-2.6 + Math.random() * (2 - -2.6)));
		else
			temperatura = (float) (temperatura + (-2.6 + Math.random() * (2 - -2.6)));
		
		temperatura = (float) Math.round(temperatura * 100) / 100;	//Redondeo a 2 decimales
		viento = (int) (climaActual.getVientoMedia() + (-30 + Math.random() * (30 - -30)));
		if(viento < 0) viento = 0;
	}
	
	private void CambiarClima() {	//Este metodo selecciona otro clima y setea la imagen climatica correspondiente.
		
		climaActual = climas[(int)(Math.random()*6)];
		
		Climawindow.lbliconoClimatologico.setIcon(climaActual.getImg());
		temperatura = (float) (climaActual.getTempMedia() + (-10.01 + Math.random() * (10.01 - -10.01)));
		temperatura = (float) Math.round(temperatura * 100) / 100;	//Redondeo a 2 decimales
		viento = (int) (climaActual.getVientoMedia() + (-20 + Math.random() * (30 - -20)));
		if(viento < 0) viento = 0;
	}

	public String dateToString() {
		String minToReturn = minuto < 10 ? "0"+minuto : minuto+"";
		String horToReturn = hora < 10 ? "0"+hora : hora+"";
		String diaToReturn = dia < 10 ? "0"+dia: dia+"";
		String mesToReturn = mes< 10 ? "0"+mes: mes+"";
		String anyoToReturn = anyo< 10 ? "0"+anyo : anyo+"";
		
		return diaToReturn + "/" + mesToReturn + "/" + anyoToReturn + " - " + horToReturn + ":" + minToReturn;
	}


	public Clima getClimaActual() {
		return climaActual;
	}


	public int getViento() {
		return viento;
	}


	public int getSol() {
		return sol;
	}


	public float getTemperatura() {
		return temperatura;
	}
	
	
}