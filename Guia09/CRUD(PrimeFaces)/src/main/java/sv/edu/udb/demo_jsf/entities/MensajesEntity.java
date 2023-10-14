package sv.edu.udb.demo_jsf.entities;

import jakarta.persistence.*;

import java.time.LocalTime;
import java.util.Date;
import java.util.Objects;

@Entity
@Table(name = "mensajes", schema = "saravias_rentacar", catalog = "")
public class MensajesEntity {
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	@Column(name = "mensaje_id", nullable = false, length = 10)
	private String mensajeId;
	@Basic
	@Column(name = "mensaje", nullable = true, length = -1)
	private String mensaje;
	@Basic
	@Column(name = "fecha_mensaje", nullable = true)
	private Date fechaMensaje;
	@Basic
	@Column(name = "hora_mensaje", nullable = true)
	private LocalTime horaMensaje;
	@Basic
	@Column(name = "estado_mensaje", nullable = true)
	private Object estadoMensaje;
	@ManyToOne
	@JoinColumn(name = "conversacion_id", referencedColumnName = "conversacion_id")
	private ConversacionesEntity conversacionesByConversacionId;
	@ManyToOne
	@JoinColumn(name = "usuario_id", referencedColumnName = "usuario_id")
	private UsuariosEntity usuariosByUsuarioId;

	public String getMensajeId() {
		return mensajeId;
	}

	public void setMensajeId(String mensajeId) {
		this.mensajeId = mensajeId;
	}

	public String getMensaje() {
		return mensaje;
	}

	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}

	public Date getFechaMensaje() {
		return fechaMensaje;
	}

	public void setFechaMensaje(Date fechaMensaje) {
		this.fechaMensaje = fechaMensaje;
	}

	public LocalTime getHoraMensaje() {
		return horaMensaje;
	}

	public void setHoraMensaje(LocalTime horaMensaje) {
		this.horaMensaje = horaMensaje;
	}

	public Object getEstadoMensaje() {
		return estadoMensaje;
	}

	public void setEstadoMensaje(Object estadoMensaje) {
		this.estadoMensaje = estadoMensaje;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		MensajesEntity that = (MensajesEntity) o;
		return Objects.equals(mensajeId, that.mensajeId) && Objects.equals(mensaje, that.mensaje) && Objects.equals(fechaMensaje, that.fechaMensaje) && Objects.equals(horaMensaje, that.horaMensaje) && Objects.equals(estadoMensaje, that.estadoMensaje);
	}

	@Override
	public int hashCode() {
		return Objects.hash(mensajeId, mensaje, fechaMensaje, horaMensaje, estadoMensaje);
	}

	public ConversacionesEntity getConversacionesByConversacionId() {
		return conversacionesByConversacionId;
	}

	public void setConversacionesByConversacionId(ConversacionesEntity conversacionesByConversacionId) {
		this.conversacionesByConversacionId = conversacionesByConversacionId;
	}

	public UsuariosEntity getUsuariosByUsuarioId() {
		return usuariosByUsuarioId;
	}

	public void setUsuariosByUsuarioId(UsuariosEntity usuariosByUsuarioId) {
		this.usuariosByUsuarioId = usuariosByUsuarioId;
	}
}
