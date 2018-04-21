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
import javax.swing.JPanel;

public class Mapwindow {

	static JFrame frmMapa;
	public JPanel panel;
	static JPanel panel_1;

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
		
		panel_1 = new JPanel();
		panel_1.setLayout(null);
		panel_1.setOpaque(false);
		panel_1.setBounds(0, 0, 529, 333);
		frmMapa.getContentPane().add(panel_1);
		///////////////////////////////////////////////////////////
		
		/*JLabel lblpanel1 = new JLabel();
		lblpanel1.setBounds(178, 194, 70, 70);
		panel_1.add(lblpanel1);
		lblpanel1.setIcon(panelOn);
		
		JLabel lblmolino1 = new JLabel();
		lblmolino1.setBounds(276, 33, 70, 70);
		panel_1.add(lblmolino1);
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
		lblmolino1.setIcon(molinoOn);
		
		JLabel lblpanel2 = new JLabel();
		lblpanel2.setBounds(79, 135, 70, 70);
		panel_1.add(lblpanel2);
		lblpanel2.setIcon(panelOn);
		
		JLabel lblmolino2 = new JLabel();
		lblmolino2.setBounds(258, 147, 70, 70);
		panel_1.add(lblmolino2);
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
		*/
		panel = new JPanel();
		panel.setBounds(0, 0, 529, 333);
		frmMapa.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblMap = new JLabel("map");
		lblMap.setBounds(0, 0, 519, 333);
		panel.add(lblMap);
		lblMap.setIcon(imageIcon);
	}
}
