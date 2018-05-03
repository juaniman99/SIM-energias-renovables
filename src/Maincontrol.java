//Project by Juan Torres

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Window.Type;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JSlider;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;
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
	public static JSlider sliderPower;
	public static JButton btnDetener;
	public static JButton btnArrancar;
	public JButton btnConstruir;
	public JButton btnDemoler;
	public static JLabel lblNombre;
	public static JLabel lblLocalidad;
	public static JLabel lblCapacidad;
	public static JLabel lblEstado;
	public static JLabel lblProduccion;
	public static JLabel lblProducci;
	public static JLabel lblDinero;
	public static JLabel lblReputacion;
	public static JLabel lblEnergiaDemandada;
	public static JLabel lblPoblacin;
	public static JLabel lblEficiencia;
	public JPanel panel_3;
	public JLabel lblMin;
	public JLabel lblMin_1;
	public static JSlider sliderVelSim;
	public static JButton btnPausar;
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
		frmPanelDeControl.getContentPane().setBackground(new Color(51, 51, 51));
		frmPanelDeControl.setTitle("Panel de control");
		frmPanelDeControl.setIconImage(Toolkit.getDefaultToolkit().getImage("images/molino_off.png"));
		frmPanelDeControl.setResizable(false);
		frmPanelDeControl.setBounds(550, 100, 793, 460);
		frmPanelDeControl.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmPanelDeControl.getContentPane().setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setOpaque(false);
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
		panel.setForeground(new Color(204, 204, 204));
		panel.setBorder(new TitledBorder(new LineBorder(new Color(184, 207, 229)), "Informaci\u00F3n", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(204, 204, 204)));
		panel.setToolTipText("Informacion");
		panel.setBounds(288, 13, 239, 125);
		panel.setOpaque(false);
		
		frmPanelDeControl.getContentPane().add(panel);
		panel.setLayout(null);
		
		 lblNombre = new JLabel("Nombre: ");
		 lblNombre.setForeground(new Color(255, 255, 255));
		lblNombre.setBounds(12, 23, 215, 15);
		panel.add(lblNombre);
		
		lblCapacidad = new JLabel("Produccion MAX:");
		lblCapacidad.setForeground(new Color(255, 255, 255));
		lblCapacidad.setBounds(12, 62, 215, 15);
		panel.add(lblCapacidad);
		
		lblLocalidad = new JLabel("Localizacion:");
		lblLocalidad.setForeground(new Color(255, 255, 255));
		lblLocalidad.setBounds(12, 41, 215, 15);
		panel.add(lblLocalidad);
		
		lblEstado = new JLabel("Estado:");
		lblEstado.setForeground(new Color(255, 255, 255));
		lblEstado.setBounds(12, 98, 215, 15);
		panel.add(lblEstado);
		
		lblProduccion = new JLabel("Produccion:");
		lblProduccion.setForeground(new Color(255, 255, 255));
		lblProduccion.setBounds(12, 78, 215, 15);
		panel.add(lblProduccion);
		
		btnArrancar = new JButton("ARRANCAR");
		btnArrancar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Controlador.apagarOEncenderCentral(true);
			}
		});
		btnArrancar.setBounds(288, 174, 112, 60);
		frmPanelDeControl.getContentPane().add(btnArrancar);
		
		btnDetener = new JButton("DETENER");
		btnDetener.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Controlador.apagarOEncenderCentral(false);
			}
		});
		btnDetener.setBounds(412, 174, 115, 60);
		frmPanelDeControl.getContentPane().add(btnDetener);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(204, 204, 204, 40));
		panel_1.setBounds(288, 301, 239, 48);
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
		
		sliderPower = new JSlider();
		sliderPower.setBackground(new Color(51, 153, 153));
		sliderPower.setMinimum(1);
		sliderPower.setOpaque(true);
		sliderPower.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent arg0) {
				Controlador.SetCentralTrotle(sliderPower.getValue());
				label_2.setText(sliderPower.getValue() + "%");
			}
		});
		sliderPower.setBounds(25, 12, 167, 16);
		panel_1.add(sliderPower);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBorder(new TitledBorder(new LineBorder(new Color(0, 0, 255), 1, true), "INFORMACI\u00D3N GLOBAL", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_2.setBounds(544, 138, 233, 194);
		frmPanelDeControl.getContentPane().add(panel_2);
		panel_2.setLayout(null);
		
		lblEficiencia = new JLabel("Eficiencia media:");
		lblEficiencia.setEnabled(false);
		lblEficiencia.setFont(new Font("Dialog", Font.BOLD, 12));
		lblEficiencia.setBounds(12, 171, 196, 15);
		panel_2.add(lblEficiencia);
		
		lblProducci = new JLabel("Produccion:");
		lblProducci.setFont(new Font("Dialog", Font.BOLD, 14));
		lblProducci.setBounds(12, 112, 209, 20);
		panel_2.add(lblProducci);
		
		lblPoblacin = new JLabel("Población: ");
		lblPoblacin.setBounds(12, 144, 209, 15);
		panel_2.add(lblPoblacin);
		
		lblEnergiaDemandada = new JLabel("Demandada:");
		lblEnergiaDemandada.setBounds(12, 89, 209, 15);
		panel_2.add(lblEnergiaDemandada);
		
		btnConstruir = new JButton("Construir");
		btnConstruir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Controlador.AnadirPlanta();
			}
		});
		btnConstruir.setBounds(12, 390, 128, 30);
		frmPanelDeControl.getContentPane().add(btnConstruir);
		
		btnDemoler = new JButton("Demoler");
		btnDemoler.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Controlador.DemolerPlanta();
			}
		});
		btnDemoler.setBounds(148, 390, 128, 30);
		frmPanelDeControl.getContentPane().add(btnDemoler);
		
		JLabel lblCentralheader = new JLabel("CentralHeader");
		lblCentralheader.setBounds(580, 0, 160, 170);
		lblCentralheader.setIcon( new ImageIcon(new ImageIcon("images/molino_header.png").getImage().getScaledInstance(160, 170, Image.SCALE_DEFAULT)));
		frmPanelDeControl.getContentPane().add(lblCentralheader);
		
		JLabel lblNewLabel = new JLabel("DINERO");
		lblNewLabel.setFont(new Font("Dialog", Font.BOLD, 10));
		lblNewLabel.setBounds(294, 384, 75, 15);
		frmPanelDeControl.getContentPane().add(lblNewLabel);
		
		lblDinero = new JLabel("1000\u20AC");
		lblDinero.setFont(new Font("Dialog", Font.BOLD, 24));
		lblDinero.setBounds(304, 399, 140, 21);
		frmPanelDeControl.getContentPane().add(lblDinero);
		
		panel_3 = new JPanel();
		panel_3.setBorder(new TitledBorder(null, "Velocidad simulacion", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_3.setLayout(null);
		panel_3.setBounds(538, 345, 239, 75);
		frmPanelDeControl.getContentPane().add(panel_3);
		
		lblMin = new JLabel("max");
		lblMin.setBounds(10, 22, 38, 15);
		panel_3.add(lblMin);
		
		lblMin_1 = new JLabel("min");
		lblMin_1.setBounds(202, 22, 27, 15);
		panel_3.add(lblMin_1);
		
		sliderVelSim = new JSlider();
		sliderVelSim.setValue(80);
		sliderVelSim.setMaximum(240);
		sliderVelSim.setMinimum(10);
		sliderVelSim.setBounds(41, 21, 161, 16);
		sliderVelSim.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent arg0) {
				Controlador.changueSimulationSpeed(sliderVelSim.getValue());
			}
		});
		panel_3.add(sliderVelSim);
		
		btnPausar = new JButton("Pausar");
		btnPausar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Controlador.playStopTimer();
			}
		});
		btnPausar.setBounds(65, 41, 89, 23);
		panel_3.add(btnPausar);
		
		JLabel label_rep = new JLabel("REPUTACION");
		label_rep.setFont(new Font("Dialog", Font.BOLD, 10));
		label_rep.setBounds(422, 384, 90, 15);
		frmPanelDeControl.getContentPane().add(label_rep);
		
		lblReputacion = new JLabel("0.00");
		lblReputacion.setFont(new Font("Dialog", Font.BOLD, 24));
		lblReputacion.setBounds(435, 399, 105, 21);
		frmPanelDeControl.getContentPane().add(lblReputacion);
		

		
		JLabel bgMainControl = new JLabel("");
		bgMainControl.setBounds(0, 0, 793, 460);
		ImageIcon bgImage = new ImageIcon(new ImageIcon("images/bg.png").getImage().getScaledInstance(793, 460, Image.SCALE_DEFAULT));
		bgMainControl.setIcon(bgImage);
		frmPanelDeControl.getContentPane().add(bgMainControl);
	
	}
}
