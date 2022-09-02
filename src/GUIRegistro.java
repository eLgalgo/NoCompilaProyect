import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

public class GUIRegistro extends JFrame {

	private JPanel contentPane;
	private JTextField tfNombre;
	private JTextField tfApellido;
	private JTextField tfDocumento;
	private JTextField tfNombre2;
	private JTextField tfApellido2;
	private JTextField tfFechaNac;
	private JTextField tfEmail;
	private JTextField tfClave;
	private JTextField tfIdRol;
	private JButton btnVolver;
	public GUIRegistro() {
		setResizable(false);
		setTitle("Registro");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 586, 390);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		this.setLocationRelativeTo(null);
		
		tfNombre = new JTextField();
		tfNombre.setColumns(10);
		tfNombre.setBounds(73, 57, 86, 28);
		contentPane.add(tfNombre);
		
		tfApellido = new JTextField();
		tfApellido.setColumns(10);
		tfApellido.setBounds(262, 57, 86, 28);
		contentPane.add(tfApellido);
		
		tfDocumento = new JTextField();
		tfDocumento.setColumns(10);
		tfDocumento.setBounds(451, 57, 86, 28);
		contentPane.add(tfDocumento);
		
		tfNombre2 = new JTextField();
		tfNombre2.setColumns(10);
		tfNombre2.setBounds(73, 135, 86, 28);
		contentPane.add(tfNombre2);
		
		tfApellido2 = new JTextField();
		tfApellido2.setColumns(10);
		tfApellido2.setBounds(262, 135, 86, 28);
		contentPane.add(tfApellido2);
		
		tfFechaNac = new JTextField();
		tfFechaNac.setColumns(10);
		tfFechaNac.setBounds(451, 139, 86, 28);
		contentPane.add(tfFechaNac);
		
		tfEmail = new JTextField();
		tfEmail.setColumns(10);
		tfEmail.setBounds(73, 213, 86, 28);
		contentPane.add(tfEmail);
		
		tfClave = new JTextField();
		tfClave.setColumns(10);
		tfClave.setBounds(262, 217, 86, 28);
		contentPane.add(tfClave);
		
		tfIdRol = new JTextField();
		tfIdRol.setColumns(10);
		tfIdRol.setBounds(451, 213, 86, 28);
		contentPane.add(tfIdRol);
		
		JLabel lblNewLabel = new JLabel("Nombre");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel.setBounds(89, 41, 59, 15);
		contentPane.add(lblNewLabel);
		
		JLabel lblApellido = new JLabel("Apellido");
		lblApellido.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblApellido.setBounds(278, 41, 59, 15);
		contentPane.add(lblApellido);
		
		JLabel lblDocumento = new JLabel("Documento");
		lblDocumento.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblDocumento.setBounds(455, 41, 75, 15);
		contentPane.add(lblDocumento);
		
		JLabel lblNombre_1 = new JLabel("Nombre2");
		lblNombre_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNombre_1.setBounds(86, 118, 69, 15);
		contentPane.add(lblNombre_1);
		
		JLabel lblNombre = new JLabel("Apellido2");
		lblNombre.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNombre.setBounds(272, 119, 69, 15);
		contentPane.add(lblNombre);
		
		JLabel lblNombre_1_1 = new JLabel("Email");
		lblNombre_1_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNombre_1_1.setBounds(82, 197, 69, 15);
		contentPane.add(lblNombre_1_1);
		
		JLabel lblNombre_1_2 = new JLabel("Clave");
		lblNombre_1_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNombre_1_2.setBounds(269, 199, 69, 15);
		contentPane.add(lblNombre_1_2);
		
		JLabel lblNombre_1_3 = new JLabel("ID Rol");
		lblNombre_1_3.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNombre_1_3.setBounds(461, 197, 69, 15);
		contentPane.add(lblNombre_1_3);
		
		JLabel lblNombre_1_4 = new JLabel("Fecha Nac");
		lblNombre_1_4.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNombre_1_4.setBounds(460, 121, 69, 15);
		contentPane.add(lblNombre_1_4);
		
		JButton btnRegistrarse = new JButton("Registrarse");
		btnRegistrarse.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnRegistrarse.setBounds(147, 273, 132, 34);
		contentPane.add(btnRegistrarse);
		
		btnVolver = new JButton("Volver");
		btnVolver.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnVolver.setBounds(318, 273, 132, 34);
		contentPane.add(btnVolver);
		//Botones
		btnVolver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				GUILogin ventanaLogin = new GUILogin();
				ventanaLogin.setVisible(true);
				dispose();
			}
		});
		btnRegistrarse.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		String documento = tfDocumento.getText();
        		String apellido1 = tfApellido.getText();
        		String apellido2 = tfApellido2.getText();
        		String nombre1 = tfNombre.getText();
        		String nombre2 = tfNombre.getText();
        		String email = tfEmail.getText();
        		String clave = tfClave.getText();
        		String fechaNac = tfFechaNac.getText();
        		int idRol = Integer.parseInt(tfIdRol.getText());
        		
        		Persona pAgregar = new Persona(documento, apellido1, apellido2, nombre1, nombre2, email, clave,fechaNac, idRol );
        		if(DAOPersona.insertPeople(pAgregar)) {
        			JOptionPane.showMessageDialog(null,"Persona agregada con exito.");
        		}else {
        			JOptionPane.showMessageDialog(null,"Ha ocurrido un error al insertar persona");
        		}
      
        	}
        });
	}

}
