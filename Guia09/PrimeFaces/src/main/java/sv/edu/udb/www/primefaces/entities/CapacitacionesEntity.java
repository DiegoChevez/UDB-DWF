package sv.edu.udb.www.primefaces.entities;

import jakarta.persistence.*;

import java.util.Collection;
import java.util.Date;

@Entity
@Table(name = "capacitaciones", schema = "poo2_capacitaciones", catalog = "")
public class CapacitacionesEntity {
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	@Column(name = "id_capacitacion", nullable = false)
	private int idCapacitacion;
	@Basic
	@Column(name = "descripcion", nullable = true, length = 400)
	private String descripcion;
	@Basic
	@Column(name = "fecha", nullable = true)
	private Date fecha;
	@OneToMany(mappedBy = "capacitacionesByIdCapacitacion")
	private Collection<CapacitacionEmpleadoEntity> capacitacionEmpleadosByIdCapacitacion;
	@ManyToOne
	@JoinColumn(name = "id_categoria", referencedColumnName = "id_categoria")
	private CategoriasEntity categoriasByIdCategoria;

	public int getIdCapacitacion() {
		return idCapacitacion;
	}

	public void setIdCapacitacion(int idCapacitacion) {
		this.idCapacitacion = idCapacitacion;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}

		CapacitacionesEntity that = (CapacitacionesEntity) o;

		if (idCapacitacion != that.idCapacitacion) {
			return false;
		}
		if (descripcion != null ? !descripcion.equals(that.descripcion) : that.descripcion != null) {
			return false;
		}
		if (fecha != null ? !fecha.equals(that.fecha) : that.fecha != null) {
			return false;
		}

		return true;
	}

	@Override
	public int hashCode() {
		int result = idCapacitacion;
		result = 31 * result + (descripcion != null ? descripcion.hashCode() : 0);
		result = 31 * result + (fecha != null ? fecha.hashCode() : 0);
		return result;
	}

	public Collection<CapacitacionEmpleadoEntity> getCapacitacionEmpleadosByIdCapacitacion() {
		return capacitacionEmpleadosByIdCapacitacion;
	}

	public void setCapacitacionEmpleadosByIdCapacitacion(Collection<CapacitacionEmpleadoEntity> capacitacionEmpleadosByIdCapacitacion) {
		this.capacitacionEmpleadosByIdCapacitacion = capacitacionEmpleadosByIdCapacitacion;
	}

	public CategoriasEntity getCategoriasByIdCategoria() {
		return categoriasByIdCategoria;
	}

	public void setCategoriasByIdCategoria(CategoriasEntity catFormulario) {
	}
}
