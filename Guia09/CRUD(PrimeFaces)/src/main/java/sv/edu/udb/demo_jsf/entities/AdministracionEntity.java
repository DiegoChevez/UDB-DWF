package sv.edu.udb.demo_jsf.entities;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "administracion", schema = "saravias_rentacar", catalog = "")
public class AdministracionEntity {
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	@Column(name = "admin_id", nullable = false, length = 5)
	private String adminId;
	@Basic
	@Column(name = "nombres_admin", nullable = true, length = 100)
	private String nombresAdmin;
	@Basic
	@Column(name = "apellidos_admin", nullable = true, length = 100)
	private String apellidosAdmin;
	@Basic
	@Column(name = "telefono_admin", nullable = true, length = 9)
	private String telefonoAdmin;
	@Basic
	@Column(name = "estado_admin", nullable = true)
	private Object estadoAdmin;
	@ManyToOne
	@JoinColumn(name = "admin_user", referencedColumnName = "usuario_id")
	private UsuariosEntity usuariosByAdminUser;

	public String getAdminId() {
		return adminId;
	}

	public void setAdminId(String adminId) {
		this.adminId = adminId;
	}

	public String getNombresAdmin() {
		return nombresAdmin;
	}

	public void setNombresAdmin(String nombresAdmin) {
		this.nombresAdmin = nombresAdmin;
	}

	public String getApellidosAdmin() {
		return apellidosAdmin;
	}

	public void setApellidosAdmin(String apellidosAdmin) {
		this.apellidosAdmin = apellidosAdmin;
	}

	public String getTelefonoAdmin() {
		return telefonoAdmin;
	}

	public void setTelefonoAdmin(String telefonoAdmin) {
		this.telefonoAdmin = telefonoAdmin;
	}

	public Object getEstadoAdmin() {
		return estadoAdmin;
	}

	public void setEstadoAdmin(Object estadoAdmin) {
		this.estadoAdmin = estadoAdmin;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		AdministracionEntity that = (AdministracionEntity) o;
		return Objects.equals(adminId, that.adminId) && Objects.equals(nombresAdmin, that.nombresAdmin) && Objects.equals(apellidosAdmin, that.apellidosAdmin) && Objects.equals(telefonoAdmin, that.telefonoAdmin) && Objects.equals(estadoAdmin, that.estadoAdmin);
	}

	@Override
	public int hashCode() {
		return Objects.hash(adminId, nombresAdmin, apellidosAdmin, telefonoAdmin, estadoAdmin);
	}

	public UsuariosEntity getUsuariosByAdminUser() {
		return usuariosByAdminUser;
	}

	public void setUsuariosByAdminUser(UsuariosEntity usuariosByAdminUser) {
		this.usuariosByAdminUser = usuariosByAdminUser;
	}
}
