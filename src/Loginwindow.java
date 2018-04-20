import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Loginwindow {

	JFrame frame;
	private JTextField textField;
	private JTextField textField_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Loginwindow window = new Loginwindow();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Loginwindow() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 208, 240);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblLogin = new JLabel("LOGIN");
		lblLogin.setHorizontalAlignment(SwingConstants.CENTER);
		lblLogin.setFont(new Font("Dialog", Font.BOLD, 21));
		lblLogin.setBounds(12, 12, 184, 25);
		frame.getContentPane().add(lblLogin);
		
		JLabel lblUsuario = new JLabel("Usuario");
		lblUsuario.setBounds(12, 49, 75, 15);
		frame.getContentPane().add(lblUsuario);
		
		textField = new JTextField();
		textField.setBounds(12, 63, 175, 31);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(12, 120, 175, 31);
		frame.getContentPane().add(textField_1);
		
		JLabel lblClave = new JLabel("Clave:");
		lblClave.setBounds(12, 106, 75, 15);
		frame.getContentPane().add(lblClave);
		
		JButton btnAcceder = new JButton("Acceder");
		btnAcceder.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Controlador.Login(textField.getText(), textField_1.getText());
			}
		});
		btnAcceder.setBounds(42, 163, 120, 25);
		frame.getContentPane().add(btnAcceder);
		
		JLabel lblElectsystemV = new JLabel("ElectSystem v0.4");
		lblElectsystemV.setHorizontalAlignment(SwingConstants.RIGHT);
		lblElectsystemV.setFont(new Font("Dialog", Font.PLAIN, 10));
		lblElectsystemV.setBounds(12, 197, 184, 15);
		frame.getContentPane().add(lblElectsystemV);
	}
}
