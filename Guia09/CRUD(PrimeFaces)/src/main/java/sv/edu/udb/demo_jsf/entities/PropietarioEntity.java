package sv.edu.udb.demo_jsf.entities;

import jakarta.persistence.*;

import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "propietario", schema = "saravias_rentacar", catalog = "")
public class PropietarioEntity {
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	@Column(name = "propietario_id", nullable = false, length = 5)
	private String propietarioId;
	@Basic
	@Column(name = "nombres_propietario", nullable = true, length = 100)
	private String nombresPropietario;
	@Basic
	@Column(name = "apellidos_propietario", nullable = true, length = 100)
	private String apellidosPropietario;
	@Basic
	@Column(name = "telefono_propietario", nullable = true, length = 9)
	private String telefonoPropietario;
	@Basic
	@Column(name = "estado_propietario", nullable = true)
	private Object estadoPropietario;
	@ManyToOne
	@JoinColumn(name = "propietario_user", referencedColumnName = "usuario_id")
	private UsuariosEntity usuariosByPropietarioUser;
	@OneToMany(mappedBy = "propietarioByPropietarioPublicacion")
	private Collection<PublicacionesEntity> publicacionesByPropietarioId;

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

	public Object getEstadoPropietario() {
		return estadoPropietario;
	}

	public void setEstadoPropietario(Object estadoPropietario) {
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

	public UsuariosEntity getUsuariosByPropietarioUser() {
		return usuariosByPropietarioUser;
	}

	public void setUsuariosByPropietarioUser(UsuariosEntity usuariosByPropietarioUser) {
		this.usuariosByPropietarioUser = usuariosByPropietarioUser;
	}

	public Collection<PublicacionesEntity> getPublicacionesByPropietarioId() {
		return publicacionesByPropietarioId;
	}

	public void setPublicacionesByPropietarioId(Collection<PublicacionesEntity> publicacionesByPropietarioId) {
		this.publicacionesByPropietarioId = publicacionesByPropietarioId;
	}
}
