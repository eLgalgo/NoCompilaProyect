
public class Funcionalidad {
	private String nombre;
	private String desc;
	private int id;
	
	public Funcionalidad(int id,String nombre, String desc) {
		super();
		this.nombre = nombre;
		this.desc = desc;
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
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	@Override
	public String toString() {
		return "Funcionalidades [nombre=" + nombre + ", desc=" + desc + ", id=" + id + "]";
	}
	
}
