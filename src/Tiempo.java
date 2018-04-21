//Project by Juan Torres Gómez

/*	Esta clase almacena la hora y la fecha simulada, así como el clima y el proceso para calcularlo.
 * 	También controla los elementos que se mostrarán en la ventana de CLIMA
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
	
	private int ticksToNextEvent;	//Cuando llegue a 0, el clima cambiará. La variable se reestablecerá a un valor aleatorio.
	
	public Tiempo() {
		this.minuto = 00;
		this.hora = 00;
		this.dia = 1;
		this.mes = 1;
		this.anyo = 2018;
		climas = new Clima[6];
		climas[0] = new Clima("soleado", "imagenes/clima/dia-soleado.png", 0, 26, 25);
		climas[1] = new Clima("nublado", "imagenes/clima/nublado.png", 0, 12, 30);
		climas[2] = new Clima("nevando", "imagenes/clima/nevando.png", 1, 0, 25);
		climas[3] = new Clima("llovizna", "imagenes/clima/llovizna.png", 1, 12, 10);
		climas[4] = new Clima("lluvia", "imagenes/clima/dia-lluvioso.png", 2, 6, 50);
		climas[5] = new Clima("tormenta", "imagenes/clima/tormenta.png", 3, 13, 60);
	}
	
	
	public void Step() {	//Se ejecuta por cada ciclo de reloj.
		minuto += 4;	//Cada ciclo de reloj, será 22 minutos.
		
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
		Climawindow.lblFecha.setText(dateToString());
		CheckTicks();
	}
	
	private void CheckTicks() {
		System.out.println(ticksToNextEvent);
		ticksToNextEvent--;
		if(ticksToNextEvent <= 0) {
			ticksToNextEvent = (int)(Math.random()*160-60)+60;
		}
	}

	public String dateToString() {
		String minToReturn = minuto < 10 ? "0"+minuto : minuto+"";
		String horToReturn = hora < 10 ? "0"+hora : hora+"";
		String diaToReturn = dia < 10 ? "0"+dia: dia+"";
		String mesToReturn = mes< 10 ? "0"+mes: mes+"";
		String anyoToReturn = anyo< 10 ? "0"+anyo : anyo+"";
		
		return diaToReturn + "/" + mesToReturn + "/" + anyoToReturn + " - " + horToReturn + ":" + minToReturn;
	}
}