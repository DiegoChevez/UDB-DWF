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


	public List<PropietarioEntity> getListaPropietarios() {
		return propietarioModel.listarPropietarios();
	}

}

