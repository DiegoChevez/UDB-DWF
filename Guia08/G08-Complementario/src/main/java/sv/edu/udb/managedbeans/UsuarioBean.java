package sv.edu.udb.managedbeans;

import jakarta.faces.application.FacesMessage;
import jakarta.faces.bean.ManagedBean;
import jakarta.faces.bean.RequestScoped;
import jakarta.faces.context.FacesContext;
import sv.edu.udb.models.UsuarioModel;
import sv.edu.udb.utils.JsfUtil;
import sv.edu.udb.entities.UsuariosEntity;
import java.util.List;

@ManagedBean
@RequestScoped
public class UsuarioBean {

	private UsuariosEntity usuario;
	private UsuarioModel modelo = new UsuarioModel();

	public UsuarioBean() {
		usuario = new UsuariosEntity();
	}

	public List<UsuariosEntity> getUsuarios() {
		return modelo.listarUsuarios();
	}

	public String guardarUsuario() {
		if (modelo.insertarUsuario(usuario) != 1) {
			JsfUtil.setErrorMessage(null, "Error no se pudo agregar el usuario");
			return "index";
		} else {
			JsfUtil.setFlashMessage("Exito", "Entrada registrada exitosamente");
			return "index";
		}
	}

	public String eliminarUsuario(int usuario_id) {
		if(modelo.eliminarUsuario(usuario_id) != 1){
			JsfUtil.setErrorMessage(null, "Error: no se pudo eliminar el usuario");

		}else{
			JsfUtil.setFlashMessage("exito", "Se ha eliminado el usuario");
		}
		return "";
	}

	public String editarUsuario(UsuariosEntity usuarioEditar){
		usuario = usuarioEditar;
		return "formEditar";
	}

	public String modificarUsuario(){
		if(modelo.modificarUsuario(usuario)!=1){
			JsfUtil.setErrorMessage(null, "Error: no se pudo modificar el usuario");

		}else{
			JsfUtil.setFlashMessage("exito", "Usuario modificado exitosamente");
		}
		return "index";
	}

	public String registrarUsuario(){
		modelo.insertarUsuario(usuario);
		FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Agregado", "Entrada Agregada");
		FacesContext.getCurrentInstance().addMessage(null, message);
		usuario.setUsuario(null);
		usuario.setCorreo(null);
		usuario.setContrasena(null);
		usuario.setRolId(null);
		return "listado";
	}


	public UsuariosEntity getUsuario() {
		return usuario;
	}

	public void setUsuario(UsuariosEntity usuario) {
		this.usuario = usuario;
	}

	public UsuarioModel getModelo() {
		return modelo;
	}

	public void setModelo(UsuarioModel modelo) {
		this.modelo = modelo;
	}
}
