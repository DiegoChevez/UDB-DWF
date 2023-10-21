package sv.edu.udb.demo_jsf.entities;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "usuarios", schema = "saraviasbd")
public class UsuariosEntity implements Serializable {
	@Id
	@Column(name = "usuario_id", nullable = false, length = 5)
	private String usuarioId;
	@Basic
	@Column(name = "nombre_usuario", nullable = false, length = 100)
	private String nombreUsuario;
	@Basic
	@Column(name = "correo_usuario", nullable = false, length = 100)
	private String correoUsuario;
	@Basic
	@Column(name = "contrasena_usuario", nullable = false, length = 255)
	private String contrasenaUsuario;
	@Basic
	@Column(name = "rol_usuario", nullable = false)
	private String rolUsuario;
	@Basic
	@Column(name = "estado_usuario", nullable = false)
	private String estadoUsuario;
	@OneToMany(mappedBy = "usuariosByCuentaUsuario", cascade = CascadeType.ALL)
	private Collection<PropietarioEntity> propietariosByUsuarioId;

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

	public String getRolUsuario() {
		return rolUsuario;
	}

	public void setRolUsuario(String rolUsuario) {
		this.rolUsuario = rolUsuario;
	}

	public String getEstadoUsuario() {
		return estadoUsuario;
	}

	public void setEstadoUsuario(String estadoUsuario) {
		this.estadoUsuario = estadoUsuario;
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
		return Objects.equals(usuarioId, that.usuarioId) && Objects.equals(nombreUsuario, that.nombreUsuario) && Objects.equals(correoUsuario, that.correoUsuario) && Objects.equals(contrasenaUsuario, that.contrasenaUsuario) && Objects.equals(rolUsuario, that.rolUsuario) && Objects.equals(estadoUsuario, that.estadoUsuario);
	}

	@Override
	public int hashCode() {
		return Objects.hash(usuarioId, nombreUsuario, correoUsuario, contrasenaUsuario, rolUsuario, estadoUsuario);
	}

	public Collection<PropietarioEntity> getPropietariosByUsuarioId() {
		return propietariosByUsuarioId;
	}

	public void setPropietariosByUsuarioId(Collection<PropietarioEntity> propietariosByUsuarioId) {
		this.propietariosByUsuarioId = propietariosByUsuarioId;
	}
}
