import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class Mapwindow {

	JFrame frmMapa;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Mapwindow window = new Mapwindow();
					window.frmMapa.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Mapwindow() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmMapa = new JFrame();
		frmMapa.setTitle("Mapa");
		frmMapa.setResizable(false);
		frmMapa.setBounds(100, 100, 529, 361);
		frmMapa.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmMapa.getContentPane().setLayout(null);
		
		JLabel lblMap = new JLabel("map");
		lblMap.setBounds(0, 0, 529, 333);
		frmMapa.getContentPane().add(lblMap);
	}
}
