package sv.edu.udb.hibernatecrud;

import jakarta.persistence.*;

@Entity
public class Productos {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	Long producto_id;

	@Column(name = "categoria_id", insertable = false, updatable = false) // Evita la duplicación de la columna
	Long categoria_id;

	@Column
	String producto;

	@Column
	String descripcion_producto;

	@Column
	String estado_producto;

	@ManyToOne
	@JoinColumn(name = "categoria_id")
	private Categorias categoria;

	public Productos() {
	}

	public Productos(Long producto_id, Long categoria_id, String producto, String descripcion_producto, String estado_producto, Categorias categoria) {
		this.producto_id = producto_id;
		this.categoria_id = categoria_id;
		this.producto = producto;
		this.descripcion_producto = descripcion_producto;
		this.estado_producto = estado_producto;
		this.categoria = categoria;
	}

	public Long getProducto_id() {
		return producto_id;
	}

	public void setProducto_id(Long producto_id) {
		this.producto_id = producto_id;
	}

	public Long getCategoria_id() {
		return categoria_id;
	}

	public void setCategoria_id(Long categoria_id) {
		this.categoria_id = categoria_id;
	}

	public String getProducto() {
		return producto;
	}

	public void setProducto(String producto) {
		this.producto = producto;
	}

	public String getDescripcion_producto() {
		return descripcion_producto;
	}

	public void setDescripcion_producto(String descripcion_producto) {
		this.descripcion_producto = descripcion_producto;
	}

	public String getEstado_producto() {
		return estado_producto;
	}

	public void setEstado_producto(String estado_producto) {
		this.estado_producto = estado_producto;
	}

	public Categorias getCategoria() {
		return categoria;
	}

	public void setCategoria(Categorias categoria) {
		this.categoria = categoria;
	}
}
