package mx.any.example.rest.spring.dto;

public class UserDto {

	private int id; 
	private String nombre;
	private String apellido;
	private String email; 
	private String password; 
	
	public UserDto(){
		this.id = 0; 
		this.apellido ="";
		this.email ="";
		this.nombre ="";
		this.password ="";
	}
	
	@Override
	public String toString(){
		return "id:" + this.id + "\n" +
			  "nm:" + this.nombre + "\n"+
			  "ap:" + this.apellido + "\n"+
			  "em:" + this.email + "\n" +
			  "ps:" + this.password; 
	}

	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * @return the nombre
	 */
	public String getNombre() {
		return nombre;
	}

	/**
	 * @param nombre the nombre to set
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	/**
	 * @return the apellido
	 */
	public String getApellido() {
		return apellido;
	}

	/**
	 * @param apellido the apellido to set
	 */
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}
	
}
