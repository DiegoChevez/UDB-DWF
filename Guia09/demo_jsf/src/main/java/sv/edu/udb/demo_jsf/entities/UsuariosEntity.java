package sv.edu.udb.demo_jsf.entities;

import jakarta.persistence.*;

import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "usuarios", schema = "saravias_rentacar", catalog = "")
public class UsuariosEntity {
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	@Column(name = "usuario_id", nullable = false, length = 5)
	private String usuarioId;
	@Basic
	@Column(name = "nombre_usuario", nullable = true, length = 50)
	private String nombreUsuario;
	@Basic
	@Column(name = "correo_usuario", nullable = true, length = 100)
	private String correoUsuario;
	@Basic
	@Column(name = "contrasena_usuario", nullable = true, length = -1)
	private String contrasenaUsuario;
	@Basic
	@Column(name = "verificacion_usuario", nullable = true)
	private Object verificacionUsuario;
	@Basic
	@Column(name = "estado_usuario", nullable = true, length = 50)
	private String estadoUsuario;
	@OneToMany(mappedBy = "usuariosByAdminUser")
	private Collection<AdministracionEntity> administracionsByUsuarioId;
	@OneToMany(mappedBy = "usuariosByClienteUser")
	private Collection<ClienteEntity> clientesByUsuarioId;
	@OneToMany(mappedBy = "usuariosByEmpleadoId")
	private Collection<ConversacionesEntity> conversacionesByUsuarioId;
	@OneToMany(mappedBy = "usuariosByUsuarioId")
	private Collection<ConversacionesEntity> conversacionesByUsuarioId_0;
	@OneToMany(mappedBy = "usuariosByEmpleadoUser")
	private Collection<EmpleadosEntity> empleadosByUsuarioId;
	@OneToMany(mappedBy = "usuariosByUsuarioId")
	private Collection<MensajesEntity> mensajesByUsuarioId;
	@OneToMany(mappedBy = "usuariosByPropietarioUser")
	private Collection<PropietarioEntity> propietariosByUsuarioId;
	@ManyToOne
	@JoinColumn(name = "rol_usuario", referencedColumnName = "rol_id")
	private RolesEntity rolesByRolUsuario;

	public String getUsuarioId() {
		return usuarioId;
	}

	public void setUsuarioId(String usuarioId) {
		this.usuarioId = usuarioId;
	}

	public String getNombreUsuario() {
		return nombreUsuario;
	}

	public void setNombreUsuario(String nombreUsuario) {
		this.nombreUsuario = nombreUsuario;
	}

	public String getCorreoUsuario() {
		return correoUsuario;
	}

	public void setCorreoUsuario(String correoUsuario) {
		this.correoUsuario = correoUsuario;
	}

	public String getContrasenaUsuario() {
		return contrasenaUsuario;
	}

	public void setContrasenaUsuario(String contrasenaUsuario) {
		this.contrasenaUsuario = contrasenaUsuario;
	}

	public Object getVerificacionUsuario() {
		return verificacionUsuario;
	}

	public void setVerificacionUsuario(Object verificacionUsuario) {
		this.verificacionUsuario = verificacionUsuario;
	}

	public Object getEstadoUsuario() {
		return estadoUsuario;
	}

	public void setEstadoUsuario(Object estadoUsuario) {
		this.estadoUsuario = (String) estadoUsuario;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		UsuariosEntity that = (UsuariosEntity) o;
		return Objects.equals(usuarioId, that.usuarioId) && Objects.equals(nombreUsuario, that.nombreUsuario) && Objects.equals(correoUsuario, that.correoUsuario) && Objects.equals(contrasenaUsuario, that.contrasenaUsuario) && Objects.equals(verificacionUsuario, that.verificacionUsuario) && Objects.equals(estadoUsuario, that.estadoUsuario);
	}

	@Override
	public int hashCode() {
		return Objects.hash(usuarioId, nombreUsuario, correoUsuario, contrasenaUsuario, verificacionUsuario, estadoUsuario);
	}

	public Collection<AdministracionEntity> getAdministracionsByUsuarioId() {
		return administracionsByUsuarioId;
	}

	public void setAdministracionsByUsuarioId(Collection<AdministracionEntity> administracionsByUsuarioId) {
		this.administracionsByUsuarioId = administracionsByUsuarioId;
	}

	public Collection<ClienteEntity> getClientesByUsuarioId() {
		return clientesByUsuarioId;
	}

	public void setClientesByUsuarioId(Collection<ClienteEntity> clientesByUsuarioId) {
		this.clientesByUsuarioId = clientesByUsuarioId;
	}

	public Collection<ConversacionesEntity> getConversacionesByUsuarioId() {
		return conversacionesByUsuarioId;
	}

	public void setConversacionesByUsuarioId(Collection<ConversacionesEntity> conversacionesByUsuarioId) {
		this.conversacionesByUsuarioId = conversacionesByUsuarioId;
	}

	public Collection<ConversacionesEntity> getConversacionesByUsuarioId_0() {
		return conversacionesByUsuarioId_0;
	}

	public void setConversacionesByUsuarioId_0(Collection<ConversacionesEntity> conversacionesByUsuarioId_0) {
		this.conversacionesByUsuarioId_0 = conversacionesByUsuarioId_0;
	}

	public Collection<EmpleadosEntity> getEmpleadosByUsuarioId() {
		return empleadosByUsuarioId;
	}

	public void setEmpleadosByUsuarioId(Collection<EmpleadosEntity> empleadosByUsuarioId) {
		this.empleadosByUsuarioId = empleadosByUsuarioId;
	}

	public Collection<MensajesEntity> getMensajesByUsuarioId() {
		return mensajesByUsuarioId;
	}

	public void setMensajesByUsuarioId(Collection<MensajesEntity> mensajesByUsuarioId) {
		this.mensajesByUsuarioId = mensajesByUsuarioId;
	}

	public Collection<PropietarioEntity> getPropietariosByUsuarioId() {
		return propietariosByUsuarioId;
	}

	public void setPropietariosByUsuarioId(Collection<PropietarioEntity> propietariosByUsuarioId) {
		this.propietariosByUsuarioId = propietariosByUsuarioId;
	}

	public RolesEntity getRolesByRolUsuario() {
		return rolesByRolUsuario;
	}

	public void setRolesByRolUsuario(RolesEntity rolesByRolUsuario) {
		this.rolesByRolUsuario = rolesByRolUsuario;
	}
}
