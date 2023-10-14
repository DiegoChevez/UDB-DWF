package sv.edu.udb.www.primefaces.entities;

import jakarta.persistence.*;

import java.util.Collection;

@Entity
@Table(name = "empleado", schema = "poo2_capacitaciones", catalog = "")
public class EmpleadoEntity {
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	@Column(name = "id_empleado", nullable = false)
	private int idEmpleado;
	@Basic
	@Column(name = "cod_empleado", nullable = true, length = 20)
	private String codEmpleado;
	@Basic
	@Column(name = "nombre", nullable = true, length = 50)
	private String nombre;
	@Basic
	@Column(name = "apellido", nullable = true, length = 50)
	private String apellido;
	@Basic
	@Column(name = "telefono", nullable = true, length = 9)
	private String telefono;
	@OneToMany(mappedBy = "empleadoByIdEmpleado")
	private Collection<CapacitacionEmpleadoEntity> capacitacionEmpleadosByIdEmpleado;

	public int getIdEmpleado() {
		return idEmpleado;
	}

	public void setIdEmpleado(int idEmpleado) {
		this.idEmpleado = idEmpleado;
	}

	public String getCodEmpleado() {
		return codEmpleado;
	}

	public void setCodEmpleado(String codEmpleado) {
		this.codEmpleado = codEmpleado;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}

		EmpleadoEntity that = (EmpleadoEntity) o;

		if (idEmpleado != that.idEmpleado) {
			return false;
		}
		if (codEmpleado != null ? !codEmpleado.equals(that.codEmpleado) : that.codEmpleado != null) {
			return false;
		}
		if (nombre != null ? !nombre.equals(that.nombre) : that.nombre != null) {
			return false;
		}
		if (apellido != null ? !apellido.equals(that.apellido) : that.apellido != null) {
			return false;
		}
		if (telefono != null ? !telefono.equals(that.telefono) : that.telefono != null) {
			return false;
		}

		return true;
	}

	@Override
	public int hashCode() {
		int result = idEmpleado;
		result = 31 * result + (codEmpleado != null ? codEmpleado.hashCode() : 0);
		result = 31 * result + (nombre != null ? nombre.hashCode() : 0);
		result = 31 * result + (apellido != null ? apellido.hashCode() : 0);
		result = 31 * result + (telefono != null ? telefono.hashCode() : 0);
		return result;
	}

	public Collection<CapacitacionEmpleadoEntity> getCapacitacionEmpleadosByIdEmpleado() {
		return capacitacionEmpleadosByIdEmpleado;
	}

	public void setCapacitacionEmpleadosByIdEmpleado(Collection<CapacitacionEmpleadoEntity> capacitacionEmpleadosByIdEmpleado) {
		this.capacitacionEmpleadosByIdEmpleado = capacitacionEmpleadosByIdEmpleado;
	}
}
