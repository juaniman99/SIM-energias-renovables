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
import javax.swing.event.ChangeListener;
import javax.swing.event.ChangeEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.border.LineBorder;
import java.awt.Color;

public class Maincontrol {

	public static JFrame frmPanelDeControl;
	public static JTable table;
	public static DefaultTableModel model = new DefaultTableModel();
	public static JSlider slider;
	public static JButton btnDetener;
	public static JButton btnArrancar;
	public JButton btnNewButton;
	public JButton btnDemoler;
	public static JLabel lblNombre;
	public static JLabel lblLocalidad;
	public static JLabel lblCapacidad;
	public static JLabel lblEstado;
	public static JLabel lblProduccion;
	public static JLabel lblProducci;

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
		
		model.addColumn("Id");
		model.addColumn("Nombre");
        model.addColumn("Tipo");
        model.addColumn("Produccion");
        model.addColumn("potencia");	//Porcentaje potencia.
		table = new JTable(model);
		table.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent arg0) {
				Controlador.TableSelectionChangued(Integer.parseInt(table.getValueAt(table.getSelectedRow(), 0).toString()));
			}
		});
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				Controlador.TableSelectionChangued(Integer.parseInt(table.getValueAt(table.getSelectedRow(), 0).toString()));
			}
		});
		scrollPane.setViewportView(table);
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "Informaci\u00F3n", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setToolTipText("Informacion");
		panel.setBounds(300, 13, 216, 125);
		frmPanelDeControl.getContentPane().add(panel);
		panel.setLayout(null);
		
		 lblNombre = new JLabel("Nombre: ");
		lblNombre.setBounds(12, 23, 192, 15);
		panel.add(lblNombre);
		
		lblCapacidad = new JLabel("Produccion MAX:");
		lblCapacidad.setBounds(12, 62, 192, 15);
		panel.add(lblCapacidad);
		
		lblLocalidad = new JLabel("Localizacion:");
		lblLocalidad.setBounds(12, 41, 192, 15);
		panel.add(lblLocalidad);
		
		lblEstado = new JLabel("Estado:");
		lblEstado.setBounds(12, 98, 192, 15);
		panel.add(lblEstado);
		
		lblProduccion = new JLabel("Produccion:");
		lblProduccion.setBounds(12, 78, 192, 15);
		panel.add(lblProduccion);
		
		btnArrancar = new JButton("ARRANCAR");
		btnArrancar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Controlador.apagarOEncenderCentral(true);
			}
		});
		btnArrancar.setBounds(300, 174, 95, 60);
		frmPanelDeControl.getContentPane().add(btnArrancar);
		
		btnDetener = new JButton("DETENER");
		btnDetener.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Controlador.apagarOEncenderCentral(false);
			}
		});
		btnDetener.setBounds(405, 174, 95, 60);
		frmPanelDeControl.getContentPane().add(btnDetener);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(305, 372, 239, 48);
		frmPanelDeControl.getContentPane().add(panel_1);
		panel_1.setLayout(null);
		
		
		JLabel label = new JLabel("1%");
		label.setBounds(0, 13, 27, 15);
		panel_1.add(label);
		
		JLabel label_1 = new JLabel("100%");
		label_1.setBounds(192, 13, 47, 15);
		panel_1.add(label_1);
		
		JLabel label_2 = new JLabel("50%");
		label_2.setBounds(97, 33, 75, 15);
		panel_1.add(label_2);
		
		slider = new JSlider();
		slider.setMinimum(1);
		slider.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent arg0) {
				Controlador.SetCentralTrotle(slider.getValue());
				label_2.setText(slider.getValue() + "%");
			}
		});
		slider.setBounds(25, 12, 167, 16);
		panel_1.add(slider);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBorder(new TitledBorder(new LineBorder(new Color(0, 0, 255), 1, true), "INFORMACI\u00D3N GLOBAL", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_2.setBounds(548, 252, 233, 168);
		frmPanelDeControl.getContentPane().add(panel_2);
		panel_2.setLayout(null);
		
		JLabel lblEficiencia = new JLabel("Eficiencia media:");
		lblEficiencia.setFont(new Font("Dialog", Font.BOLD, 12));
		lblEficiencia.setBounds(12, 129, 196, 15);
		panel_2.add(lblEficiencia);
		
		lblProducci = new JLabel("Produccion:");
		lblProducci.setFont(new Font("Dialog", Font.BOLD, 14));
		lblProducci.setBounds(12, 109, 209, 20);
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
