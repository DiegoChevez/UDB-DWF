package sv.edu.udb.demo_jsf.managedbeans;

import jakarta.faces.bean.ManagedBean;
import jakarta.faces.bean.RequestScoped;
import sv.edu.udb.demo_jsf.entities.PropietarioEntity;
import sv.edu.udb.demo_jsf.entities.UsuariosEntity;
import sv.edu.udb.demo_jsf.models.PropietarioModel;
import sv.edu.udb.demo_jsf.models.UsuarioModel;
import sv.edu.udb.demo_jsf.utils.JsfUtil;

import java.util.Arrays;
import java.util.Collection;
import java.util.logging.Logger;
import java.util.ArrayList;

import java.util.Random;

@ManagedBean
@RequestScoped
public class UsuarioBean {
	Logger logger = Logger.getLogger(UsuarioBean.class.getName());
	UsuarioModel usuarioModel = new UsuarioModel();
	private UsuariosEntity usuario;
	PropietarioModel propietarioModel = new PropietarioModel();
	private PropietarioEntity propietario;

	public UsuarioBean() {
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

		// Configurar los valores en el usuario y el propietario
		usuario.setUsuarioId(idUsuario);
		usuario.setNombreUsuario(nombreUsuario);
		usuario.setRolUsuario("Propietario");
		propietario.setPropietarioId(idPropietario);

		// Crear una colección y agregar el propietario
		Collection<PropietarioEntity> propietarios = new ArrayList<>();
		propietarios.add(propietario);

		// Establecer la colección en el usuario
		usuario.setPropietariosByUsuarioId(propietarios);

		// Establecer la relación inversa en el propietario
		propietario.setUsuariosByCuentaUsuario(usuario);

		String msj = "-- Datos del Usuario --\n " +
				"Usuario ID: " + usuario.getUsuarioId() + " \n " +
				"Nombre : " + usuario.getNombreUsuario() + " \n " +
				"Correo : " + usuario.getCorreoUsuario() + " \n " +
				"Contraseña : " + usuario.getContrasenaUsuario() + " \n " +
				"Rol : " + usuario.getRolUsuario() + " \n " +
				"Estado : " + usuario.getEstadoUsuario() + " \n " +
				"Propietario IDs : ";

		// Obtén las IDs de los propietarios y agrégalas al mensaje
		for (PropietarioEntity propietario : usuario.getPropietariosByUsuarioId()) {
			msj += propietario.getPropietarioId() + ", ";
		}

		// Elimina la coma extra al final si es necesario
		if (!usuario.getPropietariosByUsuarioId().isEmpty()) {
			msj = msj.substring(0, msj.length() - 2); // Elimina la última coma y el espacio
		}

		msj += " \n ";

		String msj2 = "--Datos del Propietario-- \n" +
				"Propietario ID : " + propietario.getPropietarioId() + "\n" +
				"Nombres : " + propietario.getNombresPropietario() + "\n" +
				"Apellidos : " + propietario.getApellidosPropietario() + "\n" +
				"Telefono : " + propietario.getTelefonoPropietario() + "\n" +
				"Estado : " + propietario.getEstadoPropietario() + "\n" +
				"PropietarioUsuario ID : " + propietario.getUsuariosByCuentaUsuario().getUsuarioId() + " \n ";

		logger.info(msj);
		logger.info(msj2);

		// Continuar con la lógica de inserción de usuario y propietario

		if (usuarioModel.insertarUsuario(usuario) == 1) {
			JsfUtil.setFlashMessage("exito", "Usuario registrado");
			if (propietarioModel.insertarPropietario(propietario) == 1) {
				JsfUtil.setFlashMessage("exito", "Usuario y propietario registrados exitosamente");
				return "propietarios.xhtml";
			} else {
				JsfUtil.setErrorMessage(null, "No se pudo insertar el propietario");
				return "propietarios.xhtml";
			}
		} else {
			JsfUtil.setErrorMessage(null, "No se pudo insertar el usuario");
			return "propietarios.xhtml";
		}
	}



	public String buscarUsuarioPorId(String usuarioId) {
		UsuariosEntity usuario = usuarioModel.buscarUsuarioPorId(usuarioId);
		if (usuario != null) {
			this.usuario = usuario;
			return "editar"; // Página de edición
		} else {
			JsfUtil.setErrorMessage(null, "Usuario no encontrado");
			return null;
		}
	}


}
