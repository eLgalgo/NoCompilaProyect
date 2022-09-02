

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.util.LinkedList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JList;
import javax.swing.JTable;

public class Tabla extends JFrame {

	 private JTable tabla = null;
	 DefaultTableModel modelo = null;
	 JScrollPane desplazamiento = null;

	/**
	 * Launch the application.
	 */

	/**
	 * Create the frame.
	 */
	public Tabla(LinkedList<Persona> list) {
		crearTablaPersona();
        // Agregamos datos
        this.agregarDatosLista(modelo, list);
        // Agregando elementos a la ventana
        this.getContentPane().add(desplazamiento, BorderLayout.NORTH);
        this.pack();
	}
	private void crearTablaPersona() {
		setResizable(false);
		String[] columnas = {"Documento", "Nombre1", "Nombre2", "Apellido1","Apellido2", "Email","Fecha Nacimiento", "ID de Rol"};
        tabla = new JTable();
        modelo = new DefaultTableModel();
        desplazamiento = new JScrollPane(tabla);       

        // Parametros de la ventana
        this.setTitle("JTable");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        getContentPane().setLayout(new BorderLayout());

        // Modelo de la tabla
        modelo.setColumnIdentifiers(columnas);

        // Barras de desplazamiento
        desplazamiento.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        desplazamiento.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);

        // Propiedades de la tabla
        tabla.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
        tabla.setFillsViewportHeight(false);

        tabla.setModel(modelo);
	}
	private void agregarDatosLista(DefaultTableModel modelo, LinkedList<Persona> list) {
        // Borramos todas las filas en la tabla
        modelo.setRowCount(0);
        
        // Creamos los datos de una fila de la tabla
        Object[] datosFila = {"", "", "", "","","","",""};
        
        // Agregamos MUCHOS mas datos
        for (Persona p : list) {
            datosFila[0] = p.getDocumento();
            datosFila[1] = p.getNombre1();
            datosFila[2] = p.getNombre2();
            datosFila[3] = p.getApellido1();
            datosFila[4] = p.getApellido2();
            datosFila[5] = p.getEmail();
            datosFila[6] = p.getFech_nac();
            datosFila[7] = p.getId_rol();
            
            modelo.addRow(datosFila);
        }
    }
	public JTable getTabla() {
		return tabla;
	}
	public void setTabla(JTable tabla) {
		this.tabla = tabla;
	}
	
}
