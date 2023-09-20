package sv.edu.udb.hibernatecrud;

import jakarta.persistence.*;

@Entity
public class Categorias {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	Long categoria_id;

	@Column
	String categoria;

	@Column
	String descripcion_categoria;

	@Column
	String estado_categoria;

	public Categorias() {

	}

	public Categorias(Long categoria_id, String categoria, String descripcion_categoria, String estado_categoria) {
		this.categoria_id = categoria_id;
		this.categoria = categoria;
		this.descripcion_categoria = descripcion_categoria;
		this.estado_categoria = estado_categoria;
	}

	public Long getCategoria_id() {
		return categoria_id;
	}

	public void setCategoria_id(Long categoria_id) {
		this.categoria_id = categoria_id;
	}

	public String getCategoria() {
		return categoria;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}

	public String getDescripcion_categoria() {
		return descripcion_categoria;
	}

	public void setDescripcion_categoria(String descripcion_categoria) {
		this.descripcion_categoria = descripcion_categoria;
	}

	public String getEstado_categoria() {
		return estado_categoria;
	}

	public void setEstado_categoria(String estado_categoria) {
		this.estado_categoria = estado_categoria;
	}
}
