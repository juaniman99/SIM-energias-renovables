import java.awt.EventQueue;

import javax.swing.JFrame;

public class Climawindow {

	JFrame frmClima;

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
		frmClima.setBounds(100, 100, 450, 300);
		frmClima.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

}
