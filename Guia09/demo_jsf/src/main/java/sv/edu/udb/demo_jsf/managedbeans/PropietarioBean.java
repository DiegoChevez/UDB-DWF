package sv.edu.udb.demo_jsf.managedbeans;

import jakarta.faces.bean.ManagedBean;
import jakarta.faces.bean.RequestScoped;
import sv.edu.udb.demo_jsf.entities.PropietarioEntity;
import sv.edu.udb.demo_jsf.models.PropietarioModel;
import sv.edu.udb.demo_jsf.utils.JsfUtil;

import java.util.List;

@ManagedBean
@RequestScoped
public class PropietarioBean {
	private PropietarioEntity propietario = new PropietarioEntity();
	private PropietarioModel propietarioModel = new PropietarioModel();

	public PropietarioEntity getPropietario() {
		return propietario;
	}

	public void setPropietario(PropietarioEntity propietario) {
		this.propietario = propietario;
	}

	public String guardarPropietario() {
		if (propietarioModel.insertarPropietario(propietario) == 1) {
			JsfUtil.setFlashMessage("exito", "Propietario registrado exitosamente");
			return "index";
		} else {
			JsfUtil.setErrorMessage(null, "Error: no se pudo insertar al propietario");
			return null;
		}
	}

	public List<PropietarioEntity> getListaPropietarios() {
		return propietarioModel.listarPropietarios();
	}

	public String eliminarPropietario(Long id) {
		if (propietarioModel.eliminarPropietario(id) == 1) {
			JsfUtil.setFlashMessage("exito", "Propietario eliminado exitosamente");
			return "index";
		} else {
			JsfUtil.setErrorMessage(null, "Error: no se pudo eliminar al propietario");
			return null;
		}
	}

	public String editarPropietario(Long id) {
		PropietarioEntity propietario = propietarioModel.buscarPropietarioPorId(id);
		if (propietario != null) {
			this.propietario = propietario;
			return "editar"; // Página de edición
		} else {
			JsfUtil.setErrorMessage(null, "Propietario no encontrado");
			return null;
		}
	}

	public String guardarCambios() {
		if (propietarioModel.actualizarPropietario(propietario) == 1) {
			JsfUtil.setFlashMessage("exito", "Cambios guardados exitosamente");
			return "index";
		} else {
			JsfUtil.setErrorMessage(null, "Error: no se pudieron guardar los cambios");
			return null;
		}
	}
}

