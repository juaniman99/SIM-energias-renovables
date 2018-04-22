import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Window.Type;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JSlider;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Maincontrol {

	private JFrame frmPanelDeControl;
	public static JTable table;
	public static DefaultTableModel model = new DefaultTableModel();
	public JButton btnNewButton;
	public JButton btnDemoler;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Maincontrol window = new Maincontrol();
					window.frmPanelDeControl.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Maincontrol() {
		initialize();
		Controlador.Iniciar();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmPanelDeControl = new JFrame();
		frmPanelDeControl.setTitle("Panel de control");
		frmPanelDeControl.setResizable(false);
		frmPanelDeControl.setBounds(100, 100, 793, 460);
		frmPanelDeControl.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmPanelDeControl.getContentPane().setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(12, 12, 264, 367);
		frmPanelDeControl.getContentPane().add(scrollPane);
		
		model.addColumn("Nombre");
        model.addColumn("Tipo");
        model.addColumn("Produccion");
        model.addColumn("potencia");	//Porcentaje potencia.
		table = new JTable(model);
		scrollPane.setViewportView(table);
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "Informaci\u00F3n", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setToolTipText("Informacion");
		panel.setBounds(288, 12, 216, 109);
		frmPanelDeControl.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblNombre = new JLabel("Nombre: ");
		lblNombre.setBounds(12, 23, 192, 15);
		panel.add(lblNombre);
		
		JLabel lblCapacidad = new JLabel("Capacidad:");
		lblCapacidad.setBounds(12, 62, 192, 15);
		panel.add(lblCapacidad);
		
		JLabel lblLocalidad = new JLabel("Localidad:");
		lblLocalidad.setBounds(12, 41, 192, 15);
		panel.add(lblLocalidad);
		
		JLabel lblEstado = new JLabel("Estado:");
		lblEstado.setBounds(12, 82, 192, 15);
		panel.add(lblEstado);
		
		JButton btnArrancar = new JButton("ARRANCAR");
		btnArrancar.setBounds(305, 174, 120, 60);
		frmPanelDeControl.getContentPane().add(btnArrancar);
		
		JButton btnDetener = new JButton("DETENER");
		btnDetener.setBounds(437, 174, 120, 60);
		frmPanelDeControl.getContentPane().add(btnDetener);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(305, 372, 257, 48);
		frmPanelDeControl.getContentPane().add(panel_1);
		panel_1.setLayout(null);
		
		JSlider slider = new JSlider();
		slider.setBounds(25, 12, 186, 16);
		panel_1.add(slider);
		
		JLabel label = new JLabel("0%");
		label.setBounds(0, 13, 27, 15);
		panel_1.add(label);
		
		JLabel label_1 = new JLabel("100%");
		label_1.setBounds(210, 13, 47, 15);
		panel_1.add(label_1);
		
		JLabel label_2 = new JLabel("50%");
		label_2.setBounds(97, 33, 75, 15);
		panel_1.add(label_2);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBounds(574, 252, 207, 168);
		frmPanelDeControl.getContentPane().add(panel_2);
		panel_2.setLayout(null);
		
		JLabel lblEficiencia = new JLabel("Eficiencia:");
		lblEficiencia.setFont(new Font("Dialog", Font.BOLD, 16));
		lblEficiencia.setBounds(0, 141, 195, 15);
		panel_2.add(lblEficiencia);
		
		JLabel lblProducci = new JLabel("Produccion:");
		lblProducci.setFont(new Font("Dialog", Font.BOLD, 16));
		lblProducci.setBounds(0, 114, 195, 15);
		panel_2.add(lblProducci);
		
		btnNewButton = new JButton("Construir");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Controlador.AnadirPlanta();
			}
		});
		btnNewButton.setBounds(12, 390, 128, 30);
		frmPanelDeControl.getContentPane().add(btnNewButton);
		
		btnDemoler = new JButton("Demoler");
		btnDemoler.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Controlador.DemolerPlanta();
			}
		});
		btnDemoler.setBounds(148, 390, 128, 30);
		frmPanelDeControl.getContentPane().add(btnDemoler);
	}
}
