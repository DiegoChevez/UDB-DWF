package sv.edu.udb.demo_jsf.managedbeans;


import jakarta.faces.bean.ManagedBean;
import jakarta.faces.bean.SessionScoped;
import sv.edu.udb.demo_jsf.entities.PropietarioEntity;
import sv.edu.udb.demo_jsf.entities.UsuariosEntity;
import sv.edu.udb.demo_jsf.models.PropietarioModel;
import sv.edu.udb.demo_jsf.models.UsuarioModel;
import sv.edu.udb.demo_jsf.utils.JsfUtil;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Random;
import java.util.logging.Logger;

@ManagedBean
@SessionScoped
public class UsuariosBean {
	Logger logger = Logger.getLogger(UsuariosBean.class.getName());


	UsuarioModel usuarioModel = new UsuarioModel();
	private UsuariosEntity usuario;


	PropietarioModel propietarioModel = new PropietarioModel();
	private PropietarioEntity propietario;



	public UsuariosBean() {
		usuario = new UsuariosEntity();
		propietario = new PropietarioEntity();
	}
	public UsuariosEntity getUsuario() {
		return usuario;
	}
	public void setUsuario(UsuariosEntity usuario) {
		this.usuario = usuario;
	}
	public PropietarioEntity getPropietario() {
		return propietario;
	}
	public void setPropietario(PropietarioEntity propietario) {
		this.propietario = propietario;
	}

	public void limpiarBean() {
		usuario = new UsuariosEntity();
		propietario = new PropietarioEntity();
	}



	public static String generarUsuarioNombre(String nombres, String apellidos) {
		String nombre = "";
		String apellido = "";

		int indiceEspacioNombres = nombres.indexOf(" ");
		int indiceEspacioApellidos = apellidos.indexOf(" ");

		if (indiceEspacioNombres != -1) {
			nombre = nombres.substring(0, indiceEspacioNombres);
		} else {
			nombre = nombres;
		}

		if (indiceEspacioApellidos != -1) {
			apellido = apellidos.substring(0, indiceEspacioApellidos);
		} else {
			apellido = apellidos;
		}

		return nombre + apellido;
	}
	public static String generarUsuarioId(String nombres, String apellidos) {
		String inicialNombre = obtenerInicial(nombres);
		String inicialApellido = obtenerInicial(apellidos);

		return inicialNombre + inicialApellido;
	}
	private static String obtenerInicial(String cadena) {
		String[] partes = cadena.split(" ");
		if (partes.length > 0) {
			String primerParte = partes[0].trim();
			if (!primerParte.isEmpty()) {
				char inicial = Character.toUpperCase(primerParte.charAt(0));
				return String.valueOf(inicial);
			}
		}
		return "";
	}
	public String guardarUsuario() {
		// Generar un número aleatorio de 3 dígitos
		Random random = new Random();
		int nRandom = random.nextInt(900) + 100;

		// Construir el nombre de usuario y el ID de usuario
		String nombres = propietario.getNombresPropietario();
		String apellidos = propietario.getApellidosPropietario();
		String nombreUsuario = generarUsuarioNombre(nombres, apellidos) + nRandom;
		String idUsuario = generarUsuarioId(nombres, apellidos) + nRandom;
		String idPropietario = idUsuario + "P";

		usuario.setUsuarioId(idUsuario);
		usuario.setNombreUsuario(nombreUsuario);
		usuario.setRolUsuario("Propietario");
		propietario.setPropietarioId(idPropietario);

		Collection<PropietarioEntity> propietarios = new ArrayList<>();
		propietarios.add(propietario);
		usuario.setPropietariosByUsuarioId(propietarios);
		propietario.setUsuariosByCuentaUsuario(usuario);

		if (usuarioModel.insertarUsuario(usuario) == 1) {
			JsfUtil.setFlashMessage("exito", "Usuario registrado");
			if (propietarioModel.insertarPropietario(propietario) == 1) {
				JsfUtil.setFlashMessage("exito", "Usuario y propietario registrados exitosamente");
				limpiarBean();
				return "propietarios";
			} else {
				JsfUtil.setErrorMessage(null, "No se pudo insertar el propietario");
				limpiarBean();
				return "propietarios";
			}
		} else {
			JsfUtil.setErrorMessage(null, "No se pudo insertar el usuario");
			limpiarBean();
			return "propietarios";
		}
	}



	public String eliminarUsuarioYPropietario(String propietarioId) {
		PropietarioEntity propietario = propietarioModel.buscarPropietarioPorId(propietarioId);
		if(propietario != null){
			UsuariosEntity usuario =
					usuarioModel.buscarUsuarioPorId(propietario.getUsuariosByCuentaUsuario().getUsuarioId());
			if(usuario != null){
				int resultadoPropietario = propietarioModel.eliminarPropietario(propietario);
				int resultadoUsuario = usuarioModel.eliminarUsuario(usuario);

				if (resultadoPropietario == 1 && resultadoUsuario == 1) {
					JsfUtil.setFlashMessage("exito", "Propietario y Usuario eliminados con éxito");
				} else {
					JsfUtil.setErrorMessage(null, "Error al eliminar Propietario o Usuario");
				}
				limpiarBean();
				return "propietarios.xhtml";
			}
		}
		JsfUtil.setErrorMessage(null, "Propietario no encontrado");
		limpiarBean();
		return "propietarios.xhtml";
	}



	public void cargarDatosParaEdicion(String propietarioId) {
		PropietarioEntity propietario = propietarioModel.buscarPropietarioPorId(propietarioId);
		if (propietario != null) {
			this.propietario = propietario;
			UsuariosEntity usuario = propietario.getUsuariosByCuentaUsuario();
			this.usuario = usuario;
		}
	}

	public String guardarEdicionUsuarioPropietario() {
		int resultadoUsuario = usuarioModel.actualizarUsuario(usuario);
		int resultadoPropietario = propietarioModel.actualizarPropietario(propietario);

		if (resultadoUsuario == 1 && resultadoPropietario == 1) {
			JsfUtil.setFlashMessage("exito", "Usuario y propietario editados con éxito");
		} else {
			JsfUtil.setErrorMessage(null, "Error al editar Usuario o Propietario");
		}
		limpiarBean();
		return "propietarios";
	}




	public List<PropietarioEntity> getListaPropietarios() {
		return propietarioModel.listarPropietarios();
	}



	public List<UsuariosEntity> getListaUsuarios() {
		return usuarioModel.listarUsuarios();
	}

}
