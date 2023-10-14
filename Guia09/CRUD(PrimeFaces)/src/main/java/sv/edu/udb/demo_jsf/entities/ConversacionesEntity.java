package sv.edu.udb.demo_jsf.entities;

import jakarta.persistence.*;

import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "conversaciones", schema = "saravias_rentacar", catalog = "")
public class ConversacionesEntity {
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	@Column(name = "conversacion_id", nullable = false, length = 10)
	private String conversacionId;
	@ManyToOne
	@JoinColumn(name = "empleado_id", referencedColumnName = "usuario_id")
	private UsuariosEntity usuariosByEmpleadoId;
	@ManyToOne
	@JoinColumn(name = "usuario_id", referencedColumnName = "usuario_id")
	private UsuariosEntity usuariosByUsuarioId;
	@OneToMany(mappedBy = "conversacionesByConversacionId")
	private Collection<MensajesEntity> mensajesByConversacionId;

	public String getConversacionId() {
		return conversacionId;
	}

	public void setConversacionId(String conversacionId) {
		this.conversacionId = conversacionId;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		ConversacionesEntity that = (ConversacionesEntity) o;
		return Objects.equals(conversacionId, that.conversacionId);
	}

	@Override
	public int hashCode() {
		return Objects.hash(conversacionId);
	}

	public UsuariosEntity getUsuariosByEmpleadoId() {
		return usuariosByEmpleadoId;
	}

	public void setUsuariosByEmpleadoId(UsuariosEntity usuariosByEmpleadoId) {
		this.usuariosByEmpleadoId = usuariosByEmpleadoId;
	}

	public UsuariosEntity getUsuariosByUsuarioId() {
		return usuariosByUsuarioId;
	}

	public void setUsuariosByUsuarioId(UsuariosEntity usuariosByUsuarioId) {
		this.usuariosByUsuarioId = usuariosByUsuarioId;
	}

	public Collection<MensajesEntity> getMensajesByConversacionId() {
		return mensajesByConversacionId;
	}

	public void setMensajesByConversacionId(Collection<MensajesEntity> mensajesByConversacionId) {
		this.mensajesByConversacionId = mensajesByConversacionId;
	}
}
