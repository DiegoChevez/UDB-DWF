package sv.edu.udb.hibernatecrud.managedbean;

import jakarta.faces.application.FacesMessage;
import jakarta.faces.bean.ManagedBean;
import jakarta.faces.bean.SessionScoped;
import jakarta.faces.context.FacesContext;
import sv.edu.udb.hibernatecrud.Categorias;
import sv.edu.udb.hibernatecrud.dao.CategoriasDao;

import java.util.List;
import java.util.logging.Logger;

@ManagedBean
@SessionScoped
public class CategoriasBean {
	private static final Logger logger = Logger.getLogger(CategoriasBean.class.getName());

	private Long categoria_id;
	private String categoria;
	private String descripcion_categoria;
	private String estado_categoria;

	public CategoriasBean() {
	}

	public void addCategoria() {
		try {
			CategoriasDao categoriaDao = new CategoriasDao();
			Categorias categoria = new Categorias(categoria_id, this.categoria, descripcion_categoria, estado_categoria);
			categoriaDao.addCategoria(categoria);

			logger.info("Categoría agregada correctamente");
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Éxito", "Categoría agregada correctamente"));

		} catch (Exception e) {
			logger.severe("Error al agregar categoría: " + e.getMessage());

			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", "Error al agregar categoría: " + e.getMessage()));
		}
	}

	public void returnCategoriaId(Long categoriaId) {
		if (categoriaId != null) {
			logger.info("Consultando categoría con ID: " + categoriaId);

			CategoriasDao categoriaDao = new CategoriasDao();
			Categorias categoria = categoriaDao.getCategoriaById(categoriaId);

			if (categoria != null) {
				this.categoria_id = categoria.getCategoria_id();
				this.categoria = categoria.getCategoria();
				this.descripcion_categoria = categoria.getDescripcion_categoria();
				this.estado_categoria = categoria.getEstado_categoria();

				logger.info("Categoría encontrada con ID: " + categoriaId);
			} else {
				this.categoria_id = null;
				this.categoria = "";
				this.descripcion_categoria = "";
				this.estado_categoria = "";

				logger.warning("No se encontró la categoría con ID: " + categoriaId);
			}
		}
	}

	public String deleteCategoria(Long categoriaId) {
		try {
			CategoriasDao categoriaDao = new CategoriasDao();
			Categorias categoria = categoriaDao.getCategoriaById(categoriaId);

			if (categoria != null) {
				categoriaDao.deleteCategoria(categoriaId);
				this.categoria_id = null;
				this.categoria = "";
				this.descripcion_categoria = "";
				this.estado_categoria = "";

				logger.info("Categoría eliminada correctamente");

				FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Éxito", "Categoría eliminada correctamente"));
			} else {
				logger.warning("No se encontró la categoría con ID: " + categoriaId);

				FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Advertencia", "No se encontró la categoría con ID: " + categoriaId));
			}

		} catch (Exception e) {
			logger.severe("Error al eliminar categoría: " + e.getMessage());

			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", "Error al eliminar categoría: " + e.getMessage()));
		}

		return "Categorias";
	}

	public String updateCategoria(Long categoriaId) {
		try {
			CategoriasDao categoriaDao = new CategoriasDao();
			Categorias existingCategoria = categoriaDao.getCategoriaById(categoriaId);

			if (existingCategoria != null) {
				Categorias categoria = new Categorias(categoriaId, this.categoria, descripcion_categoria, estado_categoria);
				categoriaDao.updateCategoria(categoria);
				this.categoria_id = categoria.getCategoria_id();
				this.categoria = categoria.getCategoria();
				this.descripcion_categoria = categoria.getDescripcion_categoria();
				this.estado_categoria = categoria.getEstado_categoria();

				logger.info("Categoría actualizada correctamente");

				FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Éxito", "Categoría actualizada correctamente"));
			} else {
				logger.warning("No se encontró la categoría con ID: " + categoriaId);
				this.categoria_id = null;
				this.categoria = "";
				this.descripcion_categoria = "";
				this.estado_categoria = "";

				FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Advertencia", "No se encontró la categoría con ID: " + categoriaId));
			}

		} catch (Exception e) {
			logger.severe("Error al actualizar categoría: " + e.getMessage());

			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", "Error al actualizar categoría: " + e.getMessage()));
		}

		return "Categorias";
	}

	public void activarCategoria(Long categoriaId) {
		CategoriasDao categoriaDao = new CategoriasDao();
		Categorias categoria = categoriaDao.getCategoriaById(categoriaId);

		if (categoria != null) {
			categoria.setEstado_categoria("activo");
			categoriaDao.updateCategoria(categoria);
		}
	}

	public void desactivarCategoria(Long categoriaId) {
		CategoriasDao categoriaDao = new CategoriasDao();
		Categorias categoria = categoriaDao.getCategoriaById(categoriaId);

		if (categoria != null) {
			categoria.setEstado_categoria("inactivo");
			categoriaDao.updateCategoria(categoria);
		}
	}

	public List<Categorias> getCategorias() {
		CategoriasDao categoriaDao = new CategoriasDao();
		return categoriaDao.getAllCategorias();
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
