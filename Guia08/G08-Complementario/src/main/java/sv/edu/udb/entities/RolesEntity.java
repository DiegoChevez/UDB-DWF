package sv.edu.udb.entities;

import jakarta.persistence.*;

import java.util.Collection;

@Entity
@Table(name = "roles", schema = "saravias_rentacar", catalog = "")
public class RolesEntity {
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	@Column(name = "rol_id", nullable = false)
	private int rolId;
	@Basic
	@Column(name = "rol", nullable = false, length = 25)
	private String rol;
	@Basic
	@Column(name = "descripcion", nullable = false, length = 255)
	private String descripcion;
	@OneToMany(mappedBy = "rolesByRolId")
	private Collection<UsuariosEntity> usuariosByRolId;

	public int getRolId() {
		return rolId;
	}

	public void setRolId(int rolId) {
		this.rolId = rolId;
	}

	public String getRol() {
		return rol;
	}

	public void setRol(String rol) {
		this.rol = rol;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}

		RolesEntity that = (RolesEntity) o;

		if (rolId != that.rolId) {
			return false;
		}
		if (rol != null ? !rol.equals(that.rol) : that.rol != null) {
			return false;
		}
		if (descripcion != null ? !descripcion.equals(that.descripcion) : that.descripcion != null) {
			return false;
		}

		return true;
	}

	@Override
	public int hashCode() {
		int result = rolId;
		result = 31 * result + (rol != null ? rol.hashCode() : 0);
		result = 31 * result + (descripcion != null ? descripcion.hashCode() : 0);
		return result;
	}

	public Collection<UsuariosEntity> getUsuariosByRolId() {
		return usuariosByRolId;
	}

	public void setUsuariosByRolId(Collection<UsuariosEntity> usuariosByRolId) {
		this.usuariosByRolId = usuariosByRolId;
	}
}
