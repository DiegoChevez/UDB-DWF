package sv.edu.udb.demo_jsf.managedbeans;
import sv.edu.udb.demo_jsf.model.PublicacionesModel;
import sv.edu.udb.demo_jsf.entities.PublicacionesEntity;

import java.util.List;

public class PublicacionBean {
	private PublicacionesModel publicacionModel = new PublicacionesModel();
	private PublicacionesEntity publicacion = new PublicacionesEntity();

	public String insertarPublicacion() {
		int result = publicacionModel.insertarPublicacion(publicacion);
		if (result == 1) {
			// Éxito, redirige a alguna página de éxito
			return "exito";
		} else {
			// Error, maneja el error o redirige a una página de error
			return "error";
		}
	}

	public List<PublicacionesEntity> listarPublicaciones() {
		return publicacionModel.listarPublicaciones();
	}

	public String editarPublicacion(Long id) {
		publicacion = publicacionModel.buscarPublicacionPorId(id);
		return "editar"; // Redirige a la página de edición
	}

	public String actualizarPublicacion() {
		int result = publicacionModel.actualizarPublicacion(publicacion);
		if (result == 1) {
			// Éxito, redirige a alguna página de éxito
			return "exito";
		} else {
			// Error, maneja el error o redirige a una página de error
			return "error";
		}
	}

	public String eliminarPublicacion(Long id) {
		int result = publicacionModel.eliminarPublicacion(id);
		if (result == 1) {
			// Éxito, redirige a alguna página de éxito
			return "exito";
		} else {
			// Error, maneja el error o redirige a una página de error
			return "error";
		}
	}


	public PublicacionesModel getPublicacionModel() {
		return publicacionModel;
	}

	public void setPublicacionModel(PublicacionesModel publicacionModel) {
		this.publicacionModel = publicacionModel;
	}

	public PublicacionesEntity getPublicacion() {
		return publicacion;
	}

	public void setPublicacion(PublicacionesEntity publicacion) {
		this.publicacion = publicacion;
	}
}
