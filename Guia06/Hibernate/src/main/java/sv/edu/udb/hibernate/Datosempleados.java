package sv.edu.udb.hibernate;

import jakarta.persistence.*;

@Entity
public class Datosempleados {

	public Datosempleados() {

	}

	public Datosempleados (String nombres, String apellidos, int edad){
		this.nombres = nombres;
		this.apellidos = apellidos;
		this.edad = edad;
	}

	public Datosempleados (String nombres, String apellidos, int edad, String telefono, String direccion){
		this.nombres = nombres;
		this.apellidos = apellidos;
		this.edad = edad;
		this.telefono = telefono;
		this.direccion = direccion;
	}

	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	@Column(name = "Id", nullable = false)
	private int id;
	@Basic
	@Column(name = "Nombres", nullable = false, length = 80)
	private String nombres;
	@Basic
	@Column(name = "Apellidos", nullable = false, length = 80)
	private String apellidos;
	@Basic
	@Column(name = "Edad", nullable = false)
	private int edad;
	@Basic
	@Column(name = "Telefono", nullable = true, length = 10)
	private String telefono;
	@Basic
	@Column(name = "Direccion", nullable = true, length = 90)
	private String direccion;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombres() {
		return nombres;
	}

	public void setNombres(String nombres) {
		this.nombres = nombres;
	}

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public int getEdad() {
		return edad;
	}

	public void setEdad(int edad) {
		this.edad = edad;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
}
