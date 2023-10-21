package sv.edu.udb.demo_jsf.entities;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "propietario", schema = "saraviasbd", catalog = "")
public class PropietarioEntity implements Serializable {
	@Id
	@Column(name = "propietario_id", nullable = false, length = 6)
	private String propietarioId;
	@Basic
	@Column(name = "nombres_propietario", nullable = false, length = 100)
	private String nombresPropietario;
	@Basic
	@Column(name = "apellidos_propietario", nullable = false, length = 100)
	private String apellidosPropietario;
	@Basic
	@Column(name = "telefono_propietario", nullable = false, length = 9)
	private String telefonoPropietario;
	@Basic
	@Column(name = "estado_propietario", nullable = false)
	private String estadoPropietario;
	@ManyToOne
	@JoinColumn(name = "cuenta_usuario", referencedColumnName = "usuario_id", nullable = false)
	private UsuariosEntity usuariosByCuentaUsuario;

	public String getPropietarioId() {
		return propietarioId;
	}

	public void setPropietarioId(String propietarioId) {
		this.propietarioId = propietarioId;
	}

	public String getNombresPropietario() {
		return nombresPropietario;
	}

	public void setNombresPropietario(String nombresPropietario) {
		this.nombresPropietario = nombresPropietario;
	}

	public String getApellidosPropietario() {
		return apellidosPropietario;
	}

	public void setApellidosPropietario(String apellidosPropietario) {
		this.apellidosPropietario = apellidosPropietario;
	}

	public String getTelefonoPropietario() {
		return telefonoPropietario;
	}

	public void setTelefonoPropietario(String telefonoPropietario) {
		this.telefonoPropietario = telefonoPropietario;
	}

	public String getEstadoPropietario() {
		return estadoPropietario;
	}

	public void setEstadoPropietario(String estadoPropietario) {
		this.estadoPropietario = estadoPropietario;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		PropietarioEntity that = (PropietarioEntity) o;
		return Objects.equals(propietarioId, that.propietarioId) && Objects.equals(nombresPropietario, that.nombresPropietario) && Objects.equals(apellidosPropietario, that.apellidosPropietario) && Objects.equals(telefonoPropietario, that.telefonoPropietario) && Objects.equals(estadoPropietario, that.estadoPropietario);
	}

	@Override
	public int hashCode() {
		return Objects.hash(propietarioId, nombresPropietario, apellidosPropietario, telefonoPropietario, estadoPropietario);
	}

	public UsuariosEntity getUsuariosByCuentaUsuario() {
		return usuariosByCuentaUsuario;
	}

	public void setUsuariosByCuentaUsuario(UsuariosEntity usuariosByCuentaUsuario) {
		this.usuariosByCuentaUsuario = usuariosByCuentaUsuario;
	}
}
