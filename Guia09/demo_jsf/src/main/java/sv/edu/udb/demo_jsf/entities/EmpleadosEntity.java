package sv.edu.udb.demo_jsf.entities;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "empleados", schema = "saravias_rentacar", catalog = "")
public class EmpleadosEntity {
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	@Column(name = "empleado_id", nullable = false, length = 5)
	private String empleadoId;
	@Basic
	@Column(name = "nombres_empleado", nullable = true, length = 100)
	private String nombresEmpleado;
	@Basic
	@Column(name = "apellidos_empleado", nullable = true, length = 100)
	private String apellidosEmpleado;
	@Basic
	@Column(name = "telefono_empleado", nullable = true, length = 9)
	private String telefonoEmpleado;
	@Basic
	@Column(name = "estado_empleado", nullable = true)
	private Object estadoEmpleado;
	@ManyToOne
	@JoinColumn(name = "empleado_user", referencedColumnName = "usuario_id")
	private UsuariosEntity usuariosByEmpleadoUser;

	public String getEmpleadoId() {
		return empleadoId;
	}

	public void setEmpleadoId(String empleadoId) {
		this.empleadoId = empleadoId;
	}

	public String getNombresEmpleado() {
		return nombresEmpleado;
	}

	public void setNombresEmpleado(String nombresEmpleado) {
		this.nombresEmpleado = nombresEmpleado;
	}

	public String getApellidosEmpleado() {
		return apellidosEmpleado;
	}

	public void setApellidosEmpleado(String apellidosEmpleado) {
		this.apellidosEmpleado = apellidosEmpleado;
	}

	public String getTelefonoEmpleado() {
		return telefonoEmpleado;
	}

	public void setTelefonoEmpleado(String telefonoEmpleado) {
		this.telefonoEmpleado = telefonoEmpleado;
	}

	public Object getEstadoEmpleado() {
		return estadoEmpleado;
	}

	public void setEstadoEmpleado(Object estadoEmpleado) {
		this.estadoEmpleado = estadoEmpleado;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		EmpleadosEntity that = (EmpleadosEntity) o;
		return Objects.equals(empleadoId, that.empleadoId) && Objects.equals(nombresEmpleado, that.nombresEmpleado) && Objects.equals(apellidosEmpleado, that.apellidosEmpleado) && Objects.equals(telefonoEmpleado, that.telefonoEmpleado) && Objects.equals(estadoEmpleado, that.estadoEmpleado);
	}

	@Override
	public int hashCode() {
		return Objects.hash(empleadoId, nombresEmpleado, apellidosEmpleado, telefonoEmpleado, estadoEmpleado);
	}

	public UsuariosEntity getUsuariosByEmpleadoUser() {
		return usuariosByEmpleadoUser;
	}

	public void setUsuariosByEmpleadoUser(UsuariosEntity usuariosByEmpleadoUser) {
		this.usuariosByEmpleadoUser = usuariosByEmpleadoUser;
	}
}
