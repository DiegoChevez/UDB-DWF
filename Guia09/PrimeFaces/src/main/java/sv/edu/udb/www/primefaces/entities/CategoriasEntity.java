package sv.edu.udb.www.primefaces.entities;

import jakarta.persistence.*;

import java.util.Collection;

@Entity
@Table(name = "categorias", schema = "poo2_capacitaciones", catalog = "")
public class CategoriasEntity {
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	@Column(name = "id_categoria", nullable = false)
	private int idCategoria;
	@Basic
	@Column(name = "descripcion", nullable = true, length = 100)
	private String descripcion;
	@OneToMany(mappedBy = "categoriasByIdCategoria")
	private Collection<CapacitacionesEntity> capacitacionesByIdCategoria;

	public int getIdCategoria() {
		return idCategoria;
	}

	public void setIdCategoria(int idCategoria) {
		this.idCategoria = idCategoria;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}

		CategoriasEntity that = (CategoriasEntity) o;

		if (idCategoria != that.idCategoria) {
			return false;
		}
		if (descripcion != null ? !descripcion.equals(that.descripcion) : that.descripcion != null) {
			return false;
		}

		return true;
	}

	@Override
	public int hashCode() {
		int result = idCategoria;
		result = 31 * result + (descripcion != null ? descripcion.hashCode() : 0);
		return result;
	}

	public Collection<CapacitacionesEntity> getCapacitacionesByIdCategoria() {
		return capacitacionesByIdCategoria;
	}

	public void setCapacitacionesByIdCategoria(Collection<CapacitacionesEntity> capacitacionesByIdCategoria) {
		this.capacitacionesByIdCategoria = capacitacionesByIdCategoria;
	}
}
