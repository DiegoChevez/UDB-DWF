package sv.edu.udb.hibernatecrud.managedbean;

import org.hibernate.Hibernate;
import sv.edu.udb.hibernatecrud.dao.CategoriasDao;
import sv.edu.udb.hibernatecrud.dao.ProductosDao;
import sv.edu.udb.hibernatecrud.Productos;
import sv.edu.udb.hibernatecrud.Categorias;
import jakarta.faces.application.FacesMessage;
import jakarta.faces.bean.ManagedBean;
import jakarta.faces.bean.SessionScoped;
import jakarta.faces.context.FacesContext;

import java.util.List;
import java.util.logging.Logger;

@ManagedBean
@SessionScoped
public class ProductosBean {
	private static final Logger logger = Logger.getLogger(CategoriasBean.class.getName());
	private Long producto_id;
	private Long categoria_id;
	private String producto;
	private String descripcion_producto;
	private String estado_producto;
	private List<Categorias> categorias;

	public ProductosBean() {
		cargarCategorias();
	}

	public void cargarCategorias() {
		try {
			CategoriasDao categoriaDao = new CategoriasDao();
			categorias = categoriaDao.getAllCategorias();
		} catch (Exception e) {
			logger.severe("Error al cargar categorías: " + e.getMessage());
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error",
					"Error al cargar categorías: " + e.getMessage()));
		}
	}

	public void addProducto() {
		try{
			ProductosDao productoDao = new ProductosDao();
			Categorias categoria = new Categorias();
			Productos producto = new Productos(producto_id, categoria_id, this.producto, descripcion_producto, estado_producto, categoria);
			productoDao.addProducto(producto);

			logger.info("Producto agregado correctamente");
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Éxito",
					"Producto" +
							" agregado correctamente"));
		}catch (Exception e){
			logger.severe("Error al agregar producto: " + e.getMessage());

			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error",
					"Error al agregar producto: " + e.getMessage()));
		}
	}

	public void returnProductoId(Long productoId) {
		if (productoId != null) {
			logger.info("Consultando producto con ID: " + productoId);
			ProductosDao productoDao = new ProductosDao();
			Productos producto = productoDao.getProductoById(productoId);

			if (producto != null) {
				this.producto_id = producto.getProducto_id();
				this.categoria_id = producto.getCategoria_id();
				this.producto = producto.getProducto();
				this.descripcion_producto = producto.getDescripcion_producto();
				this.estado_producto = producto.getEstado_producto();

				logger.info("Producto encontrado con ID: " + productoId);
			} else {
				this.producto_id = null;
				this.categoria_id = null;
				this.producto = "";
				this.descripcion_producto = "";
				this.estado_producto = "";
				logger.warning("No se encontró el producto con ID: " + productoId);
			}
		}
	}



	public String deleteProducto( Long productoId) {
		try {
			ProductosDao productoDao = new ProductosDao();
			Productos producto = productoDao.getProductoById(productoId);

			if (producto != null) {
				productoDao.deleteProducto(productoId);
				this.producto_id = null;
				this.categoria_id = null;
				this.producto = "";
				this.descripcion_producto = "";
				this.estado_producto = "";
				logger.info("Producto eliminado correctamente");
				FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,
						"Éxito", "Producto eliminado correctamente"));
			} else {
				logger.warning("No se encontró el producto con ID: " + productoId);
				FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN,
						"Advertencia", "No se encontró el producto con ID: " + productoId));
			}
		}catch (Exception e){
			logger.severe("Error al eliminar producto: " + e.getMessage());
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error",
					"Error al eliminar producto: " + e.getMessage()));
		}
		return "Productos";
	}

	public String updateProducto(Long productoId) {
		try {

			ProductosDao productoDao = new ProductosDao();
			Productos productoActual = productoDao.getProductoById(productoId);

			if (productoActual != null) {
				// Actualiza las propiedades del producto existente con los valores del bean
				productoActual.setProducto(this.producto);
				productoActual.setDescripcion_producto(this.descripcion_producto);
				productoActual.setEstado_producto(this.estado_producto);
				productoActual.setCategoria_id(this.categoria_id);

				productoDao.updateProducto(productoActual);
				logger.info("Producto actualizado correctamente");

				FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,
						"Éxito", "Producto actualizado correctamente"));
			} else {
				this.producto_id = null;
				this.categoria_id = null;
				this.producto = "";
				this.descripcion_producto = "";
				this.estado_producto = "";
				logger.warning("No se encontró el producto con ID: " + productoId);
				FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN,
						"Advertencia", "No se encontró el producto con ID: " + productoId));
			}
		} catch (Exception e) {
			logger.severe("Error al actualizar producto: " + e.getMessage());

			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error",
					"Error al actualizar producto: " + e.getMessage()));
		}
		return "Productos";
	}


	public void activarProducto(Long productoId) {
		ProductosDao productoDao = new ProductosDao();
		Productos producto = productoDao.getProductoById(productoId);

		if (producto != null) {
			producto.setEstado_producto("activo");
			productoDao.updateProducto(producto);
		}
	}

	public void desactivarProducto(Long productoId) {
		ProductosDao productoDao = new ProductosDao();
		Productos producto = productoDao.getProductoById(productoId);

		if (producto != null) {
			producto.setEstado_producto("inactivo");
			productoDao.updateProducto(producto);
		}
	}

	public List<Productos> getProductos() {
		ProductosDao productoDao = new ProductosDao();
		return productoDao.getAllProductos();
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

	public List<Categorias> getCategorias() {
		return categorias;
	}
}

