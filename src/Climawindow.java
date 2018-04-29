//Project by Juan Torres G�mez

//	Los elementos mostrados son controlados por la Clase Tiempo.

import java.awt.EventQueue;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import java.awt.Font;

public class Climawindow {

	JFrame frmClima;
	public static JLabel lbliconoClimatologico;
	public JPanel panel;
	public JLabel lblVientokmh;
	public static JLabel lblFecha;
	public JLabel lblSol;
	public JLabel lblLluvia;
	public static JLabel label;
	public JLabel lblTemperatura;
	public static JLabel lblc;
	public static JLabel lblkmh;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Climawindow window = new Climawindow();
					window.frmClima.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Climawindow() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmClima = new JFrame();
		frmClima.setTitle("Info clima");
		frmClima.setResizable(false);
		frmClima.setBounds(100, 450, 423, 224);
		frmClima.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmClima.getContentPane().setLayout(null);
		
		lbliconoClimatologico = new JLabel("");
		lbliconoClimatologico.setBounds(20, 21, 150, 150);
		frmClima.getContentPane().add(lbliconoClimatologico);
		ImageIcon imageIcon = new ImageIcon(new ImageIcon("images/clima/dia-lluvioso.png").getImage().getScaledInstance(129, 129, Image.SCALE_DEFAULT));
		lbliconoClimatologico.setIcon(imageIcon);
		
		panel = new JPanel();
		panel.setBounds(180, 11, 227, 150);
		frmClima.getContentPane().add(panel);
		panel.setLayout(null);
		
		lblVientokmh = new JLabel("Viento:");
		lblVientokmh.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblVientokmh.setBounds(10, 11, 148, 34);
		panel.add(lblVientokmh);
		
		lblSol = new JLabel("Sol:");
		lblSol.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblSol.setBounds(10, 48, 148, 34);
		panel.add(lblSol);
		
		lblLluvia = new JLabel("Lluvia:");
		lblLluvia.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblLluvia.setBounds(10, 84, 148, 34);
		panel.add(lblLluvia);
		
		label = new JLabel("0%");
		label.setHorizontalAlignment(SwingConstants.RIGHT);
		label.setFont(new Font("Tahoma", Font.PLAIN, 18));
		label.setBounds(168, 48, 49, 22);
		panel.add(label);
		
		lblTemperatura = new JLabel("Temperatura:");
		lblTemperatura.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblTemperatura.setBounds(10, 116, 148, 34);
		panel.add(lblTemperatura);
		
		lblc = new JLabel("0.00\u00BAc");
		lblc.setHorizontalAlignment(SwingConstants.RIGHT);
		lblc.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblc.setBounds(144, 123, 73, 22);
		panel.add(lblc);
		
		lblkmh = new JLabel("0km/h");
		lblkmh.setHorizontalAlignment(SwingConstants.RIGHT);
		lblkmh.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblkmh.setBounds(144, 15, 73, 22);
		panel.add(lblkmh);
		
		lblFecha = new JLabel("fecha");
		lblFecha.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblFecha.setHorizontalAlignment(SwingConstants.CENTER);
		lblFecha.setBounds(104, 172, 150, 23);
		frmClima.getContentPane().add(lblFecha);
	}
}
