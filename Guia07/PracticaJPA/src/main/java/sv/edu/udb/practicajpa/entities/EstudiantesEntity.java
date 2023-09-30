package sv.edu.udb.practicajpa.entities;

import jakarta.persistence.*;

import java.math.BigDecimal;

@Entity
@Table(name = "estudiantes", schema = "registro_estudiantes", catalog = "")
@NamedQueries({
		@NamedQuery(name = "EstudiantesEntity.findAll", query = "SELECT e FROM EstudiantesEntity e"),
		@NamedQuery(name = "EstudiantesEntity.findByCarnet", query = "SELECT e FROM EstudiantesEntity e WHERE e.carnet = :carnet"),
		@NamedQuery(name = "EstudiantesEntity.findByNombres", query = "SELECT e FROM EstudiantesEntity e WHERE e.nombres = :nombres"),
		@NamedQuery(name = "EstudiantesEntity.findByApellidos", query = "SELECT e FROM EstudiantesEntity e WHERE e.apellidos = :apellidos"),
		@NamedQuery(name = "EstudiantesEntity.findByEdad", query = "SELECT e FROM EstudiantesEntity e WHERE e.edad = :edad"),
		@NamedQuery(name = "EstudiantesEntity.findByCum", query = "SELECT e FROM EstudiantesEntity e WHERE e.cum = :cum"),
		@NamedQuery(name = "EstudiantesEntity.findByGenero", query = "SELECT e FROM EstudiantesEntity e WHERE e.genero = :genero"),
		@NamedQuery(name = "EstudiantesEntity.findByCarrera", query = "SELECT e FROM EstudiantesEntity e WHERE e.carrera = :carrera")
})
public class EstudiantesEntity {
	@Id
	@Column(name = "carnet")
	private String carnet;
	@Basic
	@Column(name = "nombres")
	private String nombres;
	@Basic
	@Column(name = "apellidos")
	private String apellidos;
	@Basic
	@Column(name = "edad")
	private int edad;
	@Basic
	@Column(name = "cum")
	private BigDecimal cum;
	@Basic
	@Column(name = "genero")
	private String genero;
	@Basic
	@Column(name = "carrera")
	private String carrera;
	public String getCarnet() {
		return carnet;
	}
	public void setCarnet(String carnet) {
		this.carnet = carnet;
	}
	public String getNombres() {
		return nombres;
	}
	public void setNombres(String nombres) {
		this.nombres = nombres;
	}
	public String getApellidos() {
		return apellidos;
	}
	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}
	public int getEdad() {
		return edad;
	}
	public void setEdad(int edad) {
		this.edad = edad;
	}
	public BigDecimal getCum() {
		return cum;
	}
	public void setCum(BigDecimal cum) {
		this.cum = cum;
	}
	public String getGenero() {
		return genero;
	}
	public void setGenero(String genero) {
		this.genero = genero;
	}
	public String getCarrera() {
		return carrera;
	}
	public void setCarrera(String carrera) {
		this.carrera = carrera;
	}
	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		EstudiantesEntity that = (EstudiantesEntity) o;
		if (edad != that.edad) return false;
		if (carnet != null ? !carnet.equals(that.carnet) : that.carnet !=
				null) return false;
		if (nombres != null ? !nombres.equals(that.nombres) : that.nombres !=
				null) return false;
		if (apellidos != null ? !apellidos.equals(that.apellidos) :
				that.apellidos != null) return false;
		if (cum != null ? !cum.equals(that.cum) : that.cum != null) return
				false;
		if (genero != null ? !genero.equals(that.genero) : that.genero !=
				null) return false;
		if (carrera != null ? !carrera.equals(that.carrera) : that.carrera !=
				null) return false;
		return true;
	}
	@Override
	public int hashCode() {
		int result = carnet != null ? carnet.hashCode() : 0;
		result = 31 * result + (nombres != null ? nombres.hashCode() : 0);
		result = 31 * result + (apellidos != null ? apellidos.hashCode() :
				0);
		result = 31 * result + edad;
		result = 31 * result + (cum != null ? cum.hashCode() : 0);
		result = 31 * result + (genero != null ? genero.hashCode() : 0);
		result = 31 * result + (carrera != null ? carrera.hashCode() : 0);
		return result;
	}
}