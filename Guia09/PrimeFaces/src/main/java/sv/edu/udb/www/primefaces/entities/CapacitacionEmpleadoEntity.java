package sv.edu.udb.www.primefaces.entities;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "capacitacion_empleado", schema = "poo2_capacitaciones", catalog = "")
public class CapacitacionEmpleadoEntity {
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	@Column(name = "id_capacitacion_empleado", nullable = false)
	private int idCapacitacionEmpleado;
	@Basic
	@Column(name = "fecha_inscripcion", nullable = true)
	private Date fechaInscripcion;
	@ManyToOne
	@JoinColumn(name = "id_capacitacion", referencedColumnName = "id_capacitacion")
	private CapacitacionesEntity capacitacionesByIdCapacitacion;
	@ManyToOne
	@JoinColumn(name = "id_empleado", referencedColumnName = "id_empleado")
	private EmpleadoEntity empleadoByIdEmpleado;

	public int getIdCapacitacionEmpleado() {
		return idCapacitacionEmpleado;
	}

	public void setIdCapacitacionEmpleado(int idCapacitacionEmpleado) {
		this.idCapacitacionEmpleado = idCapacitacionEmpleado;
	}

	public Date getFechaInscripcion() {
		return fechaInscripcion;
	}

	public void setFechaInscripcion(Date fechaInscripcion) {
		this.fechaInscripcion = fechaInscripcion;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}

		CapacitacionEmpleadoEntity that = (CapacitacionEmpleadoEntity) o;

		if (idCapacitacionEmpleado != that.idCapacitacionEmpleado) {
			return false;
		}
		if (fechaInscripcion != null ? !fechaInscripcion.equals(that.fechaInscripcion) : that.fechaInscripcion != null) {
			return false;
		}

		return true;
	}

	@Override
	public int hashCode() {
		int result = idCapacitacionEmpleado;
		result = 31 * result + (fechaInscripcion != null ? fechaInscripcion.hashCode() : 0);
		return result;
	}

	public CapacitacionesEntity getCapacitacionesByIdCapacitacion() {
		return capacitacionesByIdCapacitacion;
	}

	public void setCapacitacionesByIdCapacitacion(CapacitacionesEntity capacitacionesByIdCapacitacion) {
		this.capacitacionesByIdCapacitacion = capacitacionesByIdCapacitacion;
	}

	public EmpleadoEntity getEmpleadoByIdEmpleado() {
		return empleadoByIdEmpleado;
	}

	public void setEmpleadoByIdEmpleado(EmpleadoEntity empleadoByIdEmpleado) {
		this.empleadoByIdEmpleado = empleadoByIdEmpleado;
	}
}
