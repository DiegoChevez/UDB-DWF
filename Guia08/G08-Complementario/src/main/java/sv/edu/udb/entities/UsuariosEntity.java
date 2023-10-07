package sv.edu.udb.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "usuarios", schema = "saravias_rentacar", catalog = "")
public class UsuariosEntity {
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	@Column(name = "usuario_id", nullable = false)
	private int usuarioId;
	@Basic
	@Column(name = "usuario", nullable = true, length = 20)
	private String usuario;
	@Basic
	@Column(name = "correo", nullable = true, length = 100)
	private String correo;
	@Basic
	@Column(name = "rol_id", nullable = true)
	private Integer rolId;
	@Basic
	@Column(name = "contrasena", nullable = true, length = 20)
	private String contrasena;
	@ManyToOne
	@JoinColumn(name = "rol_id", referencedColumnName = "rol_id")
	private RolesEntity rolesByRolId;

	public int getUsuarioId() {
		return usuarioId;
	}

	public void setUsuarioId(int usuarioId) {
		this.usuarioId = usuarioId;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

	public Integer getRolId() {
		return rolId;
	}

	public void setRolId(Integer rolId) {
		this.rolId = rolId;
	}

	public String getContrasena() {
		return contrasena;
	}

	public void setContrasena(String contrasena) {
		this.contrasena = contrasena;
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

		if (usuarioId != that.usuarioId) {
			return false;
		}
		if (usuario != null ? !usuario.equals(that.usuario) : that.usuario != null) {
			return false;
		}
		if (correo != null ? !correo.equals(that.correo) : that.correo != null) {
			return false;
		}
		if (rolId != null ? !rolId.equals(that.rolId) : that.rolId != null) {
			return false;
		}
		if (contrasena != null ? !contrasena.equals(that.contrasena) : that.contrasena != null) {
			return false;
		}

		return true;
	}

	@Override
	public int hashCode() {
		int result = usuarioId;
		result = 31 * result + (usuario != null ? usuario.hashCode() : 0);
		result = 31 * result + (correo != null ? correo.hashCode() : 0);
		result = 31 * result + (rolId != null ? rolId.hashCode() : 0);
		result = 31 * result + (contrasena != null ? contrasena.hashCode() : 0);
		return result;
	}

	public RolesEntity getRolesByRolId() {
		return rolesByRolId;
	}

	public void setRolesByRolId(RolesEntity rolesByRolId) {
		this.rolesByRolId = rolesByRolId;
	}
}
