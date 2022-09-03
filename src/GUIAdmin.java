import java.util.LinkedList;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
 
public class GUIAdmin extends JFrame{
	private JTextField tfNombre;
	private JTextField tfApellido;
	private JTextField tfDocumento;
	private JTextField tfNombre2;
	private JTextField tfApellido2;
	private JTextField tfFechaNac; 
	private JTextField tfEmail;
	private JTextField tfClave;
	private JTextField tfIdRol;
	private JTextField tfId;
	private JTextField tfNombreRol;
	private JTextField tfDescRol;
	private JTextField tfId2;
	private JTextField tfIdFunc;
	private JTextField tfNombreFunc;
	private JTextField tfDescFunc;
 
    public GUIAdmin(){
 
        //Parametros asociados a la ventana
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 654, 391);
        setResizable(false);
        setVisible(true);
        setTitle("Ejemplo JTabbedPane");
 
        //Creamos el conjunto de pestañas
        JTabbedPane pestañas=new JTabbedPane();
 
        //Creamos el panel y lo añadimos a las pestañas
        JPanel panel1=new JPanel();
 
        //Añadimos un nombre de la pestaña y el panel
        pestañas.addTab("Altas", panel1);
        panel1.setLayout(null);
        
        tfNombre = new JTextField();
        tfNombre.setBounds(59, 33, 86, 28);
        panel1.add(tfNombre);
        tfNombre.setColumns(10);
        
        tfApellido = new JTextField();
        tfApellido.setBounds(248, 33, 86, 28);
        panel1.add(tfApellido);
        tfApellido.setColumns(10);
        
        tfDocumento = new JTextField();
        tfDocumento.setBounds(437, 33, 86, 28);
        panel1.add(tfDocumento);
        tfDocumento.setColumns(10);
        
        tfNombre2 = new JTextField();
        tfNombre2.setColumns(10);
        tfNombre2.setBounds(59, 111, 86, 28);
        panel1.add(tfNombre2);
        
        tfApellido2 = new JTextField();
        tfApellido2.setColumns(10);
        tfApellido2.setBounds(248, 111, 86, 28);
        panel1.add(tfApellido2);
        
        tfFechaNac = new JTextField();
        tfFechaNac.setColumns(10);
        tfFechaNac.setBounds(437, 115, 86, 28);
        panel1.add(tfFechaNac);
        
        tfEmail = new JTextField();
        tfEmail.setColumns(10);
        tfEmail.setBounds(59, 189, 86, 28);
        panel1.add(tfEmail);
        
        tfClave = new JTextField();
        tfClave.setColumns(10);
        tfClave.setBounds(248, 193, 86, 28);
        panel1.add(tfClave);
        
        tfIdRol = new JTextField();
        tfIdRol.setColumns(10);
        tfIdRol.setBounds(437, 189, 86, 28);
        panel1.add(tfIdRol);
        
        JLabel lblNewLabel = new JLabel("Nombre");
        lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
        lblNewLabel.setBounds(75, 17, 59, 15);
        panel1.add(lblNewLabel);
        
        JLabel lblApellido = new JLabel("Apellido");
        lblApellido.setFont(new Font("Tahoma", Font.PLAIN, 15));
        lblApellido.setBounds(264, 17, 59, 15);
        panel1.add(lblApellido);
        
        JLabel lblDocumento = new JLabel("Documento");
        lblDocumento.setFont(new Font("Tahoma", Font.PLAIN, 15));
        lblDocumento.setBounds(441, 17, 75, 15);
        panel1.add(lblDocumento);
        
        JLabel lblNombre_1 = new JLabel("Nombre2");
        lblNombre_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
        lblNombre_1.setBounds(72, 94, 69, 15);
        panel1.add(lblNombre_1);
        
        JLabel lblNombre = new JLabel("Apellido2");
        lblNombre.setFont(new Font("Tahoma", Font.PLAIN, 15));
        lblNombre.setBounds(258, 95, 69, 15);
        panel1.add(lblNombre);
        
        JLabel lblNombre_1_1 = new JLabel("Email");
        lblNombre_1_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
        lblNombre_1_1.setBounds(68, 173, 69, 15);
        panel1.add(lblNombre_1_1);
        
        JLabel lblNombre_1_2 = new JLabel("Clave");
        lblNombre_1_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
        lblNombre_1_2.setBounds(255, 175, 69, 15);
        panel1.add(lblNombre_1_2);
        
        JLabel lblNombre_1_3 = new JLabel("ID Rol");
        lblNombre_1_3.setFont(new Font("Tahoma", Font.PLAIN, 15));
        lblNombre_1_3.setBounds(447, 173, 69, 15);
        panel1.add(lblNombre_1_3);
        
        JLabel lblNombre_1_4 = new JLabel("Fecha Nac");
        lblNombre_1_4.setFont(new Font("Tahoma", Font.PLAIN, 15));
        lblNombre_1_4.setBounds(446, 97, 69, 15);
        panel1.add(lblNombre_1_4);
        
        JButton btnCrearPersona = new JButton("Crear Persona");
        btnCrearPersona.setFont(new Font("Tahoma", Font.PLAIN, 15));
        btnCrearPersona.setBounds(227, 249, 132, 34);
        panel1.add(btnCrearPersona);
 
        //Realizamos lo mismo con el resto
        JPanel panel2=new JPanel();
        pestañas.addTab("Modificaciones", panel2);
 
        //Componentes del panel2
        JLabel et_p2=new JLabel("Estas en el panel 2");
        panel2.add(et_p2);
 
        JPanel panel3=new JPanel();
 
        //Componentes del panel3
        JLabel et_p3=new JLabel("Estas en el panel 3");
        panel3.add(et_p3);
 
        pestañas.addTab("Bajas", panel3);
 
        JPanel panel4=new JPanel();
 
        //Componentes del panel4
        
        JTable et_p4= tabListarPersonas();
        panel4.add(new JScrollPane(et_p4));
 
        pestañas.addTab("Listado", panel4);
        
        //Realizamos lo mismo con el resto
        JPanel panel5=new JPanel();
        pestañas.addTab("Roles", panel5);
        
        JPanel panel6=new JPanel();
        pestañas.addTab("Funcionalidades", panel6);
        panel6.setLayout(null);
        
        JLabel lblNewLabel_1_1_2 = new JLabel("ID");
        lblNewLabel_1_1_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
        lblNewLabel_1_1_2.setBounds(30, 30, 28, 15);
        panel6.add(lblNewLabel_1_1_2);
        
        tfIdFunc = new JTextField();
        tfIdFunc.setColumns(10);
        tfIdFunc.setBounds(68, 25, 86, 28);
        panel6.add(tfIdFunc);
        
        tfNombreFunc = new JTextField();
        tfNombreFunc.setColumns(10);
        tfNombreFunc.setBounds(248, 25, 86, 28);
        panel6.add(tfNombreFunc);
        
        JLabel lblNewLabel_1_3 = new JLabel("Nombre");
        lblNewLabel_1_3.setFont(new Font("Tahoma", Font.PLAIN, 15));
        lblNewLabel_1_3.setBounds(179, 30, 59, 15);
        panel6.add(lblNewLabel_1_3);
        
        JLabel lblNewLabel_1_2_1 = new JLabel("Desc");
        lblNewLabel_1_2_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
        lblNewLabel_1_2_1.setBounds(355, 32, 59, 15);
        panel6.add(lblNewLabel_1_2_1);
        
        tfDescFunc = new JTextField();
        tfDescFunc.setColumns(10);
        tfDescFunc.setBounds(423, 25, 130, 28);
        panel6.add(tfDescFunc);
        
        JButton btnModificar_1 = new JButton("Modificar");
        btnModificar_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
        btnModificar_1.setBounds(30, 83, 132, 34);
        panel6.add(btnModificar_1);
        
        JButton btnCrear_1 = new JButton("Crear");
        btnCrear_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
        btnCrear_1.setBounds(230, 83, 132, 34);
        panel6.add(btnCrear_1);
        
        JButton btnBuscarPorId_1 = new JButton("Buscar por ID");
        btnBuscarPorId_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
        btnBuscarPorId_1.setBounds(432, 83, 132, 34);
        panel6.add(btnBuscarPorId_1);
        
        
        panel5.setLayout(null);
        
        tfId = new JTextField();
        tfId.setColumns(10);
        tfId.setBounds(64, 29, 86, 28);
        panel5.add(tfId);
        
        tfNombreRol = new JTextField();
        tfNombreRol.setColumns(10);
        tfNombreRol.setBounds(244, 29, 86, 28);
        panel5.add(tfNombreRol);
        
        tfDescRol = new JTextField();
        tfDescRol.setColumns(10);
        tfDescRol.setBounds(419, 29, 130, 28);
        panel5.add(tfDescRol);
        
        JLabel lblNewLabel_1 = new JLabel("Nombre");
        lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
        lblNewLabel_1.setBounds(175, 34, 59, 15);
        panel5.add(lblNewLabel_1);
        
        JLabel lblNewLabel_1_1 = new JLabel("ID");
        lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
        lblNewLabel_1_1.setBounds(26, 34, 28, 15);
        panel5.add(lblNewLabel_1_1);
        
        JLabel lblNewLabel_1_2 = new JLabel("Desc");
        lblNewLabel_1_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
        lblNewLabel_1_2.setBounds(351, 36, 59, 15);
        panel5.add(lblNewLabel_1_2);
        
        JButton btnModificarRol = new JButton("Modificar");
        btnModificarRol.setFont(new Font("Tahoma", Font.PLAIN, 15));
        btnModificarRol.setBounds(26, 87, 132, 34);
        panel5.add(btnModificarRol);
        
        JButton btnCrearRol = new JButton("Crear");
        btnCrearRol.setFont(new Font("Tahoma", Font.PLAIN, 15));
        btnCrearRol.setBounds(226, 87, 132, 34);
        panel5.add(btnCrearRol);
        
        JButton btnBuscarPorIdRol = new JButton("Buscar por ID");
        btnBuscarPorIdRol.setFont(new Font("Tahoma", Font.PLAIN, 15));
        btnBuscarPorIdRol.setBounds(428, 87, 132, 34);
        panel5.add(btnBuscarPorIdRol);
        
        JComboBox cbFuncionalidades = new JComboBox();
        cbFuncionalidades.setBounds(217, 163, 124, 28);
        
        LinkedList<Funcionalidad> listaFunc = DAOFuncionalidad.selectAll();
        
        for(Funcionalidad f :listaFunc) {
        	cbFuncionalidades.addItem(f.getNombre());
        }
        panel5.add(cbFuncionalidades);
        
        JButton btnAgregarFunc = new JButton("Agregar Func");
        btnAgregarFunc.setFont(new Font("Tahoma", Font.PLAIN, 15));
        btnAgregarFunc.setBounds(428, 163, 132, 28);
        panel5.add(btnAgregarFunc);
        
        tfId2 = new JTextField();
        tfId2.setColumns(10);
        tfId2.setBounds(64, 163, 86, 28);
        panel5.add(tfId2);
        
        JLabel lblNewLabel_1_1_1 = new JLabel("ID");
        lblNewLabel_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
        lblNewLabel_1_1_1.setBounds(26, 168, 28, 15);
        panel5.add(lblNewLabel_1_1_1);
        
        getContentPane().add(pestañas);
        this.setLocationRelativeTo(null);
        //Botones
        	//Funcionalidades
        btnModificar_1.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		Funcionalidad f = new Funcionalidad(
        				Integer.parseInt(tfIdFunc.getText()),
        				tfNombreFunc.getText(),
        				tfDescFunc.getText());
        		if(DAOFuncionalidad.updateFunc(f)) {
        			JOptionPane.showMessageDialog(null, "Actualizado con exito");
        		}else {
        			JOptionPane.showMessageDialog(null, "Ha ocurrido un error");
        		}
        	}
        });
        btnBuscarPorId_1.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		int idABuscar = Integer.parseInt(tfIdFunc.getText());
        		Funcionalidad f = DAOFuncionalidad.buscarFuncById(idABuscar);
        		tfIdFunc.setText(String.valueOf(f.getId()));
        		tfDescFunc.setText(f.getDesc());
        		tfNombreFunc.setText(f.getNombre());
        	}
        });
        btnCrear_1.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		Funcionalidad f = new Funcionalidad(Integer.parseInt(tfIdFunc.getText()) , tfNombreFunc.getText(), tfDescFunc.getText());
        		if(DAOFuncionalidad.insertFunc(f))
        		{
					JOptionPane.showInternalMessageDialog(null, "Funcionalidad agregada!");
				}else {
					JOptionPane.showMessageDialog(null, "Error al intentar crear funcionalidad");
				}
        	}
        });
        	//Roles
        btnAgregarFunc.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		int id = Integer.parseInt(tfId2.getText());
        		
        		if(DAORolFunc.agregarFuncARol(id,cbFuncionalidades.getSelectedItem().toString())) {
        			JOptionPane.showMessageDialog(null, "Agregada con exito");
        		}else {
        			JOptionPane.showMessageDialog(null, "Agregada con desexito");
        		}
        		
        	}
        });
        btnCrearRol.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		Rol f = new Rol(
        				Integer.parseInt(tfId.getText()),
        				tfNombreRol.getText(),
        				tfDescRol.getText(),
        				null);
        		if(DAORol.insertRol(f)) {
        			JOptionPane.showMessageDialog(null, "Actualizado con exito");
        		}else {
        			JOptionPane.showMessageDialog(null, "Ha ocurrido un error");
        		}
        	}
        });
        btnModificarRol.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		if(DAORol.updateRol(tfNombreRol.getText(), tfDescRol.getText(),Integer.parseInt(tfId.getText()))) {
        			JOptionPane.showMessageDialog(null, "Actualizado con exito");
        		}else {
        			JOptionPane.showMessageDialog(null, "Ha ocurrido un error");
        		}
        	}
        });
        btnBuscarPorIdRol.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		int idABuscar = Integer.parseInt(tfId.getText());
        		Rol r = DAORol.buscarRolById(idABuscar);
        		tfId.setText(String.valueOf(r.getId()));
        		tfDescRol.setText(r.getDesc());
        		tfNombreRol.setText(r.getNombre());
        	}
        });
        btnCrearPersona.addActionListener(new ActionListener() {
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
	public JTable tabListarPersonas() {
		LinkedList<Persona> personas = DAOPersona.selectAll();
		Tabla tb = new Tabla(personas);
		tb.getTabla().setFillsViewportHeight(false);
		tb.getTabla().setFillsViewportHeight(false);
		tb.getTabla().setFillsViewportHeight(false);
		tb.getTabla().setFillsViewportHeight(false);
		tb.getTabla().setFillsViewportHeight(false);
		tb.getTabla().setFillsViewportHeight(false);
		
		return tb.getTabla();
	}
}
