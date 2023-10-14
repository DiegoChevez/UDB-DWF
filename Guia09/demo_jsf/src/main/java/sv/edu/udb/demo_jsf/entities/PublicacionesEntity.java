package sv.edu.udb.demo_jsf.entities;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.util.Date;
import java.util.Objects;

@Entity
@Table(name = "publicaciones", schema = "saravias_rentacar", catalog = "")
public class PublicacionesEntity {
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	@Column(name = "publicacion_id", nullable = false, length = 10)
	private String publicacionId;
	@Basic
	@Column(name = "titulo_publicacion", nullable = true, length = 150)
	private String tituloPublicacion;
	@Basic
	@Column(name = "fotos_publicacion", nullable = true)
	private Long fotosPublicacion;
	@Basic
	@Column(name = "descripcion_publicacion", nullable = true, length = -1)
	private String descripcionPublicacion;
	@Basic
	@Column(name = "precio_publicacion", nullable = true, precision = 2)
	private BigDecimal precioPublicacion;
	@Basic
	@Column(name = "tipo_oferta", nullable = true)
	private Object tipoOferta;
	@Basic
	@Column(name = "fecha_publicacion_publicacion", nullable = true)
	private Date fechaPublicacionPublicacion;
	@Basic
	@Column(name = "estado_opublicacion", nullable = true)
	private Object estadoOpublicacion;
	@ManyToOne
	@JoinColumn(name = "propietario_publicacion", referencedColumnName = "propietario_id")
	private PropietarioEntity propietarioByPropietarioPublicacion;

	public String getPublicacionId() {
		return publicacionId;
	}

	public void setPublicacionId(String publicacionId) {
		this.publicacionId = publicacionId;
	}

	public String getTituloPublicacion() {
		return tituloPublicacion;
	}

	public void setTituloPublicacion(String tituloPublicacion) {
		this.tituloPublicacion = tituloPublicacion;
	}

	public Long getFotosPublicacion() {
		return fotosPublicacion;
	}

	public void setFotosPublicacion(Long fotosPublicacion) {
		this.fotosPublicacion = fotosPublicacion;
	}

	public String getDescripcionPublicacion() {
		return descripcionPublicacion;
	}

	public void setDescripcionPublicacion(String descripcionPublicacion) {
		this.descripcionPublicacion = descripcionPublicacion;
	}

	public BigDecimal getPrecioPublicacion() {
		return precioPublicacion;
	}

	public void setPrecioPublicacion(BigDecimal precioPublicacion) {
		this.precioPublicacion = precioPublicacion;
	}

	public Object getTipoOferta() {
		return tipoOferta;
	}

	public void setTipoOferta(Object tipoOferta) {
		this.tipoOferta = tipoOferta;
	}

	public Date getFechaPublicacionPublicacion() {
		return fechaPublicacionPublicacion;
	}

	public void setFechaPublicacionPublicacion(Date fechaPublicacionPublicacion) {
		this.fechaPublicacionPublicacion = fechaPublicacionPublicacion;
	}

	public Object getEstadoOpublicacion() {
		return estadoOpublicacion;
	}

	public void setEstadoOpublicacion(Object estadoOpublicacion) {
		this.estadoOpublicacion = estadoOpublicacion;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		PublicacionesEntity that = (PublicacionesEntity) o;
		return Objects.equals(publicacionId, that.publicacionId) && Objects.equals(tituloPublicacion, that.tituloPublicacion) && Objects.equals(fotosPublicacion, that.fotosPublicacion) && Objects.equals(descripcionPublicacion, that.descripcionPublicacion) && Objects.equals(precioPublicacion, that.precioPublicacion) && Objects.equals(tipoOferta, that.tipoOferta) && Objects.equals(fechaPublicacionPublicacion, that.fechaPublicacionPublicacion) && Objects.equals(estadoOpublicacion, that.estadoOpublicacion);
	}

	@Override
	public int hashCode() {
		return Objects.hash(publicacionId, tituloPublicacion, fotosPublicacion, descripcionPublicacion, precioPublicacion, tipoOferta, fechaPublicacionPublicacion, estadoOpublicacion);
	}

	public PropietarioEntity getPropietarioByPropietarioPublicacion() {
		return propietarioByPropietarioPublicacion;
	}

	public void setPropietarioByPropietarioPublicacion(PropietarioEntity propietarioByPropietarioPublicacion) {
		this.propietarioByPropietarioPublicacion = propietarioByPropietarioPublicacion;
	}
}
