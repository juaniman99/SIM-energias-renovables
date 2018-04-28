import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;

public class WindowConstruir {

	public static JFrame frmNuevaConstruccion;
	public JLabel lblNuevaConstruccin;
	public JComboBox comboBox;
	public JButton btnNewButton;
	public JButton btnCancelar;
	public JLabel lblTipo;
	public JLabel lblProduccion;
	public JComboBox comboBox_1;
	public JLabel lblNombre;
	public JTextField textField;
	public JTextField textField_1;
	public JTextField textField_2;
	public JLabel lblX;
	public JLabel lblY;
	public JPanel panel;
	public JLabel lblDescripcion;
	public JLabel lblPosicion;
	public JLabel lblCoste;
	

	public static void main(String[] args) {
		System.out.println("HOLAJ");
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					WindowConstruir window = new WindowConstruir();
					window.frmNuevaConstruccion.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public WindowConstruir() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmNuevaConstruccion = new JFrame();
		frmNuevaConstruccion.setAlwaysOnTop(true);
		frmNuevaConstruccion.setResizable(false);
		frmNuevaConstruccion.setTitle("Nueva construccion");
		frmNuevaConstruccion.setBounds(100, 100, 431, 275);
		frmNuevaConstruccion.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmNuevaConstruccion.getContentPane().setLayout(null);
		
		lblNuevaConstruccin = new JLabel("Nueva construcci\u00F3n");
		lblNuevaConstruccin.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 16));
		lblNuevaConstruccin.setBounds(4, 11, 165, 32);
		frmNuevaConstruccion.getContentPane().add(lblNuevaConstruccin);
		
		comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Solar", "Eolica"}));
		comboBox.setSelectedIndex(1);
		comboBox.setBounds(83, 77, 86, 20);
		frmNuevaConstruccion.getContentPane().add(comboBox);
		
		btnNewButton = new JButton("Construir!");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Controlador.ConstruirPlanta(String.valueOf(comboBox.getSelectedItem()), textField.getText(), Integer.parseInt(textField_1.getText()), Integer.parseInt(textField_2.getText()), String.valueOf(comboBox_1.getSelectedItem()));	//el 10 hay que modificarlo
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 17));
		btnNewButton.setBounds(268, 115, 147, 49);
		frmNuevaConstruccion.getContentPane().add(btnNewButton);
		
		btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				frmNuevaConstruccion.setVisible(false);
			}
		});
		btnCancelar.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnCancelar.setBounds(184, 132, 86, 32);
		frmNuevaConstruccion.getContentPane().add(btnCancelar);
		
		lblTipo = new JLabel("Tipo:");
		lblTipo.setBounds(10, 80, 46, 14);
		frmNuevaConstruccion.getContentPane().add(lblTipo);
		
		lblProduccion = new JLabel("Produccion:");
		lblProduccion.setBounds(10, 103, 63, 14);
		frmNuevaConstruccion.getContentPane().add(lblProduccion);
		
		comboBox_1 = new JComboBox();
		comboBox_1.setModel(new DefaultComboBoxModel(new String[] {"XS", "S", "M", "L", "XL"}));
		comboBox_1.setSelectedIndex(1);
		comboBox_1.setBounds(83, 100, 86, 20);
		frmNuevaConstruccion.getContentPane().add(comboBox_1);
		
		lblNombre = new JLabel("Nombre: ");
		lblNombre.setBounds(10, 54, 46, 14);
		frmNuevaConstruccion.getContentPane().add(lblNombre);
		
		textField = new JTextField();
		textField.setBounds(83, 51, 86, 20);
		frmNuevaConstruccion.getContentPane().add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setText("150");
		textField_1.setBounds(306, 30, 46, 20);
		frmNuevaConstruccion.getContentPane().add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setText("125");
		textField_2.setColumns(10);
		textField_2.setBounds(358, 30, 46, 20);
		frmNuevaConstruccion.getContentPane().add(textField_2);
		
		lblX = new JLabel("X");
		lblX.setHorizontalAlignment(SwingConstants.CENTER);
		lblX.setBounds(306, 11, 46, 14);
		frmNuevaConstruccion.getContentPane().add(lblX);
		
		lblY = new JLabel("Y");
		lblY.setHorizontalAlignment(SwingConstants.CENTER);
		lblY.setBounds(358, 11, 46, 14);
		frmNuevaConstruccion.getContentPane().add(lblY);
		
		panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "Descripcion", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setBounds(10, 165, 405, 79);
		frmNuevaConstruccion.getContentPane().add(panel);
		panel.setLayout(null);
		
		lblDescripcion = new JLabel("descripcion");
		lblDescripcion.setVerticalAlignment(SwingConstants.TOP);
		lblDescripcion.setBounds(10, 23, 385, 45);
		panel.add(lblDescripcion);
		
		lblPosicion = new JLabel("Posicion:");
		lblPosicion.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblPosicion.setBounds(224, 31, 72, 17);
		frmNuevaConstruccion.getContentPane().add(lblPosicion);
		
		lblCoste = new JLabel("Coste: 0\u20AC");
		lblCoste.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblCoste.setBounds(268, 80, 114, 24);
		frmNuevaConstruccion.getContentPane().add(lblCoste);
	}
}
