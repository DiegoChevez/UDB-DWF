package sv.edu.udb.demo_jsf.entities;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "cliente", schema = "saravias_rentacar", catalog = "")
public class ClienteEntity {
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	@Column(name = "cliente_id", nullable = false, length = 5)
	private String clienteId;
	@Basic
	@Column(name = "nombres_cliente", nullable = true, length = 100)
	private String nombresCliente;
	@Basic
	@Column(name = "apellidos_cliente", nullable = true, length = 100)
	private String apellidosCliente;
	@Basic
	@Column(name = "telefono_cliente", nullable = true, length = 9)
	private String telefonoCliente;
	@Basic
	@Column(name = "estado_cliente", nullable = true)
	private Object estadoCliente;
	@ManyToOne
	@JoinColumn(name = "cliente_user", referencedColumnName = "usuario_id")
	private UsuariosEntity usuariosByClienteUser;

	public String getClienteId() {
		return clienteId;
	}

	public void setClienteId(String clienteId) {
		this.clienteId = clienteId;
	}

	public String getNombresCliente() {
		return nombresCliente;
	}

	public void setNombresCliente(String nombresCliente) {
		this.nombresCliente = nombresCliente;
	}

	public String getApellidosCliente() {
		return apellidosCliente;
	}

	public void setApellidosCliente(String apellidosCliente) {
		this.apellidosCliente = apellidosCliente;
	}

	public String getTelefonoCliente() {
		return telefonoCliente;
	}

	public void setTelefonoCliente(String telefonoCliente) {
		this.telefonoCliente = telefonoCliente;
	}

	public Object getEstadoCliente() {
		return estadoCliente;
	}

	public void setEstadoCliente(Object estadoCliente) {
		this.estadoCliente = estadoCliente;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		ClienteEntity that = (ClienteEntity) o;
		return Objects.equals(clienteId, that.clienteId) && Objects.equals(nombresCliente, that.nombresCliente) && Objects.equals(apellidosCliente, that.apellidosCliente) && Objects.equals(telefonoCliente, that.telefonoCliente) && Objects.equals(estadoCliente, that.estadoCliente);
	}

	@Override
	public int hashCode() {
		return Objects.hash(clienteId, nombresCliente, apellidosCliente, telefonoCliente, estadoCliente);
	}

	public UsuariosEntity getUsuariosByClienteUser() {
		return usuariosByClienteUser;
	}

	public void setUsuariosByClienteUser(UsuariosEntity usuariosByClienteUser) {
		this.usuariosByClienteUser = usuariosByClienteUser;
	}
}
