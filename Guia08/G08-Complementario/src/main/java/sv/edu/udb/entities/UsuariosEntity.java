package sv.edu.udb.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "usuarios", schema = "saravias_rentacar", catalog = "")
public class UsuariosEntity {
<<<<<<< HEAD
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "usuario_id", nullable = false)
    private int usuarioId;
    @Basic
    @Column(name = "usuario", nullable = false, length = 50)
    private String usuario;
    @Basic
    @Column(name = "correo", nullable = false, length = 50)
    private String correo;
    @Basic
    @Column(name = "contrasena", nullable = false, length = 50)
    private String contrasena;
    @Basic
    @Column(name = "rol_id", nullable = false)
    private Integer rolId;
=======
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	@Column(name = "usuario_id", nullable = false)
	private int usuarioId;
	@Basic
	@Column(name = "usuario", nullable = false, length = 25)
	private String usuario;
	@Basic
	@Column(name = "correo", nullable = false, length = 100)
	private String correo;
	@Basic
	@Column(name = "contrasena", nullable = false, length = -1)
	private String contrasena;
	@Basic
	@Column(name = "rol_id", nullable = false)
	private Integer rolId;
>>>>>>> c6292a9dc63c1fe6ed96c58667968e765740f9b1

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

<<<<<<< HEAD
    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    public Integer getRolId() {
        return rolId;
    }
=======
	public String getContrasena() {
		return contrasena;
	}
>>>>>>> c6292a9dc63c1fe6ed96c58667968e765740f9b1

    public void setRolId(Integer rolId) {
        this.rolId = rolId;
    }

<<<<<<< HEAD
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
=======
	public Integer getRolId() {
		return rolId;
	}

	public void setRolId(Integer rolId) {
		this.rolId = rolId;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
>>>>>>> c6292a9dc63c1fe6ed96c58667968e765740f9b1

        UsuariosEntity that = (UsuariosEntity) o;

<<<<<<< HEAD
        if (usuarioId != that.usuarioId) return false;
        if (rolId != that.rolId) return false;
        if (usuario != null ? !usuario.equals(that.usuario) : that.usuario != null) return false;
        if (correo != null ? !correo.equals(that.correo) : that.correo != null) return false;
        if (contrasena != null ? !contrasena.equals(that.contrasena) : that.contrasena != null) return false;
=======
		if (usuarioId != that.usuarioId) {
			return false;
		}
		if (rolId != that.rolId) {
			return false;
		}
		if (usuario != null ? !usuario.equals(that.usuario) : that.usuario != null) {
			return false;
		}
		if (correo != null ? !correo.equals(that.correo) : that.correo != null) {
			return false;
		}
		if (contrasena != null ? !contrasena.equals(that.contrasena) : that.contrasena != null) {
			return false;
		}
>>>>>>> c6292a9dc63c1fe6ed96c58667968e765740f9b1

        return true;
    }

<<<<<<< HEAD
    @Override
    public int hashCode() {
        int result = usuarioId;
        result = 31 * result + (usuario != null ? usuario.hashCode() : 0);
        result = 31 * result + (correo != null ? correo.hashCode() : 0);
        result = 31 * result + (contrasena != null ? contrasena.hashCode() : 0);
        result = 31 * result + rolId;
        return result;
    }
=======
	@Override
	public int hashCode() {
		int result = usuarioId;
		result = 31 * result + (usuario != null ? usuario.hashCode() : 0);
		result = 31 * result + (correo != null ? correo.hashCode() : 0);
		result = 31 * result + (contrasena != null ? contrasena.hashCode() : 0);
		result = 31 * result + rolId;
		return result;
	}
>>>>>>> c6292a9dc63c1fe6ed96c58667968e765740f9b1
}
