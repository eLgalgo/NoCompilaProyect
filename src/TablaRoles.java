

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

public class TablaRoles extends JFrame {

	 private JTable tabla = null;
	 DefaultTableModel modelo = null;
	 JScrollPane desplazamiento = null;

	/**
	 * Launch the application.
	 */

	/**
	 * Create the frame.
	 */
	public TablaRoles(LinkedList<Rol> list) {
		crearTablaPersona();
       // Agregamos datos
       this.agregarDatosLista(modelo, list);
       // Agregando elementos a la ventana
       this.getContentPane().add(desplazamiento, BorderLayout.NORTH);
       this.pack();
	}
	private void crearTablaPersona() {
		setResizable(false);
		String[] columnas = {"ID_ROL", "NOMBRE", "DESC"};
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
	private void agregarDatosLista(DefaultTableModel modelo, LinkedList<Rol> list) {
       // Borramos todas las filas en la tabla
       modelo.setRowCount(0);
       
       // Creamos los datos de una fila de la tabla
       Object[] datosFila = {"", "", ""};
       
       // Agregamos MUCHOS mas datos
       for (Rol p : list) {
           datosFila[0] = p.getId();
           datosFila[1] = p.getNombre();
           datosFila[2] = p.getDesc();
           
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
