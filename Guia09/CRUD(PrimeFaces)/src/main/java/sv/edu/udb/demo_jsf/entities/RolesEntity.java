package sv.edu.udb.demo_jsf.entities;

import jakarta.persistence.*;

import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "roles", schema = "saravias_rentacar", catalog = "")
public class RolesEntity {
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	@Column(name = "rol_id", nullable = false, length = 5)
	private String rolId;
	@Basic
	@Column(name = "rol", nullable = true, length = 25)
	private String rol;
	@Basic
	@Column(name = "descripcion", nullable = true, length = -1)
	private String descripcion;
	@Basic
	@Column(name = "estado", nullable = true)
	private Object estado;
	@OneToMany(mappedBy = "rolesByRolUsuario")
	private Collection<UsuariosEntity> usuariosByRolId;

	public String getRolId() {
		return rolId;
	}

	public void setRolId(String rolId) {
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

	public Object getEstado() {
		return estado;
	}

	public void setEstado(Object estado) {
		this.estado = estado;
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
		return Objects.equals(rolId, that.rolId) && Objects.equals(rol, that.rol) && Objects.equals(descripcion, that.descripcion) && Objects.equals(estado, that.estado);
	}

	@Override
	public int hashCode() {
		return Objects.hash(rolId, rol, descripcion, estado);
	}

	public Collection<UsuariosEntity> getUsuariosByRolId() {
		return usuariosByRolId;
	}

	public void setUsuariosByRolId(Collection<UsuariosEntity> usuariosByRolId) {
		this.usuariosByRolId = usuariosByRolId;
	}
}
