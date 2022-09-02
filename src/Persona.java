
public class Persona {
	
		private String documento;
		private String apellido1;
		private String apellido2;
		private String nombre1;
		private String nombre2;
		private String email;
		private String clave;
		private String fech_nac;
		private int id_rol;
		private Rol rol;
		
		public Persona(String documento, String apellido1, String apellido2, String nombre1, String nombre2,
				String email, String clave, String fech_nac,Rol rol) {
			super();
			this.documento = documento;
			this.apellido1 = apellido1;
			this.apellido2 = apellido2;
			this.nombre1 = nombre1;
			this.nombre2 = nombre2;
			this.email = email;
			this.clave = clave;
			this.fech_nac = fech_nac;
			this.rol = rol;
		}
		public Persona(String documento, String apellido1, String apellido2, String nombre1, String nombre2,
				String email, String clave, String fech_nac,int id_rol) {
			super();
			this.documento = documento;
			this.apellido1 = apellido1;
			this.apellido2 = apellido2;
			this.nombre1 = nombre1;
			this.nombre2 = nombre2;
			this.email = email;
			this.clave = clave;
			this.fech_nac = fech_nac;
			this.id_rol = id_rol;
		}
		public Rol getRol() {
			return rol;
		}
		public void setRol(Rol rol) {
			this.rol = rol;
		}
		public String getDocumento() {
			return documento;
		}
		public void setDocumento(String documento) {
			this.documento = documento;
		}
		public String getApellido1() {
			return apellido1;
		}
		public void setApellido1(String apellido1) {
			this.apellido1 = apellido1;
		}
		public String getApellido2() {
			return apellido2;
		}
		public void setApellido2(String apellido2) {
			this.apellido2 = apellido2;
		}
		public String getNombre1() {
			return nombre1;
		}
		public void setNombre1(String nombre1) {
			this.nombre1 = nombre1;
		}
		public String getNombre2() {
			return nombre2;
		}
		public void setNombre2(String nombre2) {
			this.nombre2 = nombre2;
		}
		public String getEmail() {
			return email;
		}
		public void setEmail(String email) {
			this.email = email;
		}
		public String getClave() {
			return clave;
		}
		public void setClave(String clave) {
			this.clave = clave;
		}
		public String getFech_nac() {
			return fech_nac;
		}
		public void setFech_nac(String fech_nac) {
			this.fech_nac = fech_nac;
		}
		
		public int getId_rol() {
			return id_rol;
		}
		public void setId_rol(int id_rol) {
			this.id_rol = id_rol;
		}
		@Override
		public String toString() {
			return "Persona [documento=" + documento + ", apellido1=" + apellido1 + ", apellido2=" + apellido2
					+ ", nombre1=" + nombre1 + ", nombre2=" + nombre2 + ", email=" + email + ", clave=" + clave
					+ ", fech_nac=" + fech_nac + "]";
		}
}
