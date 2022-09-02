import java.util.LinkedList;

public class Rol {
	
	private int id;
	private String nombre;
	private String desc;
	private LinkedList<Funcionalidad> listaFuncionalidades;
	
	public Rol(int id, String nombre, String desc, LinkedList<Funcionalidad> listaFuncionalidades) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.desc = desc;
		this.listaFuncionalidades = listaFuncionalidades;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getDesc() {
		return desc;
	}
	public void setDesc(String desc) {
		this.desc = desc;
	}
	public LinkedList<Funcionalidad> getListaFuncionalidades() {
		return listaFuncionalidades;
	}
	public void setListaFuncionalidades(LinkedList<Funcionalidad> listaFuncionalidades) {
		this.listaFuncionalidades = listaFuncionalidades;
	}
	@Override
	public String toString() {
		return "Rol [id=" + id + ", nombre=" + nombre + ", desc=" + desc + ", listaFuncionalidades="
				+ listaFuncionalidades + "]";
	}
	
	
}
