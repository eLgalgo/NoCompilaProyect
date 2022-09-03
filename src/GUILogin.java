import java.awt.BorderLayout;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;

public class GUILogin extends JFrame {

	private JPanel contentPane;
	private JTextField tfEmail;
	private JPasswordField tfPass;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUILogin frame = new GUILogin();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	//AVERRRRR AHORA PUTITAS QUE CHETOOOOOOOOOO NO COMPAILA-----
	/**
	 * Create the frame.
	 */
	public GUILogin() {
		setResizable(false);
		setTitle("Login");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 354, 336);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		tfEmail = new JTextField();
		tfEmail.setBounds(68, 66, 198, 30);
		contentPane.add(tfEmail);
		tfEmail.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Email");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel.setBounds(152, 41, 45, 19);
		contentPane.add(lblNewLabel);
		
		JLabel lblClave = new JLabel("Clave");
		lblClave.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblClave.setBounds(152, 107, 45, 19);
		contentPane.add(lblClave);
		
		tfPass = new JPasswordField();
		tfPass.setBounds(68, 131, 198, 30);
		contentPane.add(tfPass);
		
		JButton btnNewButton = new JButton("Iniciar Sesion");
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnNewButton.setBounds(108, 187, 123, 30);
		contentPane.add(btnNewButton);
		
		JButton btnRegistrarse = new JButton("Registrarse");
		btnRegistrarse.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnRegistrarse.setBounds(108, 237, 123, 30);
		contentPane.add(btnRegistrarse);
		
		JLabel lblLogin_1 = new JLabel("LOGIN");
		lblLogin_1.setHorizontalAlignment(SwingConstants.LEFT);
		lblLogin_1.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblLogin_1.setBounds(10, 11, 318, 19);
		contentPane.add(lblLogin_1);
		this.setLocationRelativeTo(null);
		//Abrir conexion de la base de datos
		Connection connection = DataBaseManager.getConnection();
		//Botones
		btnRegistrarse.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				GUIRegistro ventanaRegistro = new GUIRegistro();
				ventanaRegistro.setVisible(true);
				dispose();
			}
		});
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String email = tfEmail.getText();
				String clave = tfPass.getText();
				int rol = DAOPersona.verificarLogin(email, clave);
				if(rol != -1) {
					JOptionPane.showMessageDialog(null, "¡Bienvenido Administrador!");
					GUIAdmin ventana=new GUIAdmin();
					dispose();
				}else {
					JOptionPane.showMessageDialog(null, "No estas registrado.");
				}
			}
		});
	}
}
