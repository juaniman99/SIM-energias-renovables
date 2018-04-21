import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Image;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

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
		frmMapa.setIconImage(Toolkit.getDefaultToolkit().getImage("images/molino_off.png"));
		frmMapa.setTitle("Mapa");
		frmMapa.setResizable(false);
		frmMapa.setBounds(100, 100, 529, 361);
		frmMapa.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmMapa.getContentPane().setLayout(null);
		ImageIcon imageIcon = new ImageIcon(new ImageIcon("images/mapa.png").getImage().getScaledInstance(529, 333, Image.SCALE_DEFAULT));
		
		/////////	Cargo los distintos modelos de imagenes	////////
		ImageIcon panelOn = new ImageIcon(new ImageIcon("images/panel_on.gif").getImage().getScaledInstance(70, 70, Image.SCALE_DEFAULT));
		ImageIcon molinoOn = new ImageIcon(new ImageIcon("images/molino_on.gif").getImage().getScaledInstance(70, 70, Image.SCALE_DEFAULT));
		///////////////////////////////////////////////////////////
		
		JLabel lblpanel1 = new JLabel();
		lblpanel1.setBounds(100, 100, 70, 70);
		frmMapa.getContentPane().add(lblpanel1);
		lblpanel1.setIcon(panelOn);
		lblpanel1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent arg0) {
				lblpanel1.setBorder(BorderFactory.createLineBorder(Color.black));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				lblpanel1.setBorder(null);
			}
		});
		
		JLabel lblmolino1 = new JLabel();
		lblmolino1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent arg0) {
				lblmolino1.setBorder(BorderFactory.createLineBorder(Color.black));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				lblmolino1.setBorder(null);
			}
		});
		lblmolino1.setBounds(200, 150, 70, 70);
		frmMapa.getContentPane().add(lblmolino1);
		lblmolino1.setIcon(molinoOn);
		
		JLabel lblpanel2 = new JLabel();
		lblpanel2.setBounds(200, 40, 70, 70);
		frmMapa.getContentPane().add(lblpanel2);
		lblpanel2.setIcon(panelOn);
		lblpanel2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent arg0) {
				lblpanel2.setBorder(BorderFactory.createLineBorder(Color.black));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				lblpanel2.setBorder(null);
			}
		});
		
		JLabel lblmolino2 = new JLabel();
		lblmolino2.setBounds(300, 210, 70, 70);
		frmMapa.getContentPane().add(lblmolino2);
		lblmolino2.setIcon(molinoOn);
		lblmolino2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent arg0) {
				lblmolino2.setBorder(BorderFactory.createLineBorder(Color.black));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				lblmolino2.setBorder(null);
			}
		});
		
		JLabel lblMap = new JLabel("map");
		lblMap.setBounds(0, 0, 529, 333);
		frmMapa.getContentPane().add(lblMap);
		lblMap.setIcon(imageIcon);
	}
}
