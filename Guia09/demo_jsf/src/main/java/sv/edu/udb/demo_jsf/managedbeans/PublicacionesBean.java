package sv.edu.udb.demo_jsf.managedbeans;

import jakarta.faces.bean.ManagedBean;
import jakarta.faces.bean.RequestScoped;
import sv.edu.udb.demo_jsf.entities.PublicacionesEntity;
import sv.edu.udb.demo_jsf.models.PublicacionesModel;
import sv.edu.udb.demo_jsf.utils.JsfUtil;

import java.util.List;

@ManagedBean
@RequestScoped
public class PublicacionesBean {
	private PublicacionesEntity publicacion = new PublicacionesEntity();
	private PublicacionesModel publicacionModel = new PublicacionesModel();

	public PublicacionesEntity getPublicacion() {
		return publicacion;
	}

	public void setPublicacion(PublicacionesEntity publicacion) {
		this.publicacion = publicacion;
	}

	public String guardarPublicacion() {
		if (publicacionModel.insertarPublicacion(publicacion) == 1) {
			JsfUtil.setFlashMessage("exito", "Publicación registrada exitosamente");
			return "index";
		} else {
			JsfUtil.setErrorMessage(null, "Error: no se pudo insertar la publicación");
			return null;
		}
	}

	public List<PublicacionesEntity> getListaPublicaciones() {
		return publicacionModel.listarPublicaciones();
	}

	public String buscarPublicacionPorId(Long id) {
		PublicacionesEntity publicacion = publicacionModel.buscarPublicacionPorId(id);
		if (publicacion != null) {
			this.publicacion = publicacion;
			return "detalle"; // Página de detalle
		} else {
			JsfUtil.setErrorMessage(null, "Publicación no encontrada");
			return null;
		}
	}

	public String editarPublicacion(Long id) {
		PublicacionesEntity publicacion = publicacionModel.buscarPublicacionPorId(id);
		if (publicacion != null) {
			this.publicacion = publicacion;
			return "editar"; // Página de edición de publicación
		} else {
			JsfUtil.setErrorMessage(null, "Publicación no encontrada");
			return null;
		}
	}

	public String guardarCambios() {
		if (publicacionModel.actualizarPublicacion(publicacion) == 1) {
			JsfUtil.setFlashMessage("exito", "Cambios guardados exitosamente");
			return "index"; // Redirigir a la página principal
		} else {
			JsfUtil.setErrorMessage(null, "Error: no se pudieron guardar los cambios");
			return null;
		}
	}

	public String eliminarPublicacion(Long id) {
		if (publicacionModel.eliminarPublicacion(id) == 1) {
			JsfUtil.setFlashMessage("exito", "Publicación eliminada exitosamente");
			return "index"; // Redirigir a la página principal
		} else {
			JsfUtil.setErrorMessage(null, "Error: no se pudo eliminar la publicación");
			return null;
		}
	}
}
