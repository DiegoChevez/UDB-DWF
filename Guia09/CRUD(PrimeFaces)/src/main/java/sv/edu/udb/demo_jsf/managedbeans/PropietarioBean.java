package sv.edu.udb.demo_jsf.managedbeans;
import sv.edu.udb.demo_jsf.model.PropietarioModel;
import sv.edu.udb.demo_jsf.entities.PropietarioEntity;

import java.util.List;

public class PropietarioBean {
	private PropietarioModel propietarioModel = new PropietarioModel();
	private PropietarioEntity propietario = new PropietarioEntity();

	public String insertarPropietario() {
		int result = propietarioModel.insertarPropietario(propietario);
		if (result == 1) {
			// Éxito, redirige a alguna página de éxito
			return "exito";
		} else {
			// Error, maneja el error o redirige a una página de error
			return "error";
		}
	}

	public List<PropietarioEntity> listarPropietarios() {
		return propietarioModel.listarPropietarios();
	}

	public String editarPropietario(Long id) {
		propietario = propietarioModel.buscarPropietarioPorId(id);
		return "editar"; // Redirige a la página de edición
	}

	public String actualizarPropietario() {
		int result = propietarioModel.actualizarPropietario(propietario);
		if (result == 1) {
			// Éxito, redirige a alguna página de éxito
			return "exito";
		} else {
			// Error, maneja el error o redirige a una página de error
			return "error";
		}
	}

	public String eliminarPropietario(Long id) {
		int result = propietarioModel.eliminarPropietario(id);
		if (result == 1) {
			// Éxito, redirige a alguna página de éxito
			return "exito";
		} else {
			// Error, maneja el error o redirige a una página de error
			return "error";
		}
	}


	public PropietarioModel getPropietarioModel() {
		return propietarioModel;
	}

	public void setPropietarioModel(PropietarioModel propietarioModel) {
		this.propietarioModel = propietarioModel;
	}

	public PropietarioEntity getPropietario() {
		return propietario;
	}

	public void setPropietario(PropietarioEntity propietario) {
		this.propietario = propietario;
	}
}
