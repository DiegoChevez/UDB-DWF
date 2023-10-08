package sv.edu.udb.models;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Query;
import sv.edu.udb.utils.JpaUtil;
import sv.edu.udb.entities.UsuariosEntity;
import java.util.List;
public class UsuarioModel {
	public List<UsuariosEntity> listarUsuarios() {
		EntityManager em = JpaUtil.getEntityManager();
		try {
			Query consulta = em.createQuery("Select E from UsuariosEntity E");
			List<UsuariosEntity> lista = consulta.getResultList();
			em.close();
			return lista;
		} catch (Exception e) {
			em.close();
			return null;
		}
	}
	public UsuariosEntity obtenerUsuario(int id) {
		EntityManager em = JpaUtil.getEntityManager();
		try {
			UsuariosEntity usuario = em.find(UsuariosEntity.class, id);
			em.close();
			return usuario;
		} catch (Exception e) {
			em.close();
			return null;
		}
	}
	public int insertarUsuario(UsuariosEntity usuario) {
		EntityManager em = JpaUtil.getEntityManager();
		EntityTransaction tran = em.getTransaction();
		try {
			tran.begin();
			em.persist(usuario);
			tran.commit();
			em.close();
			return 1;
		} catch (Exception e) {
			em.close();
			return 0;
		}
	}
	public int modificarUsuario(UsuariosEntity usuario) {
		EntityManager em = JpaUtil.getEntityManager();
		EntityTransaction tran = em.getTransaction();
		try {
			tran.begin();
			em.merge(usuario);
			tran.commit();
			em.close();
			return 1;
		} catch (Exception e) {
			em.close();
			return 0;
		}
	}
	public int eliminarUsuario(int id) {
		EntityManager em = JpaUtil.getEntityManager();
		int filasBorradas = 0;
		try {
			UsuariosEntity ent = em.find(UsuariosEntity.class, id);
			if (ent != null) {
				EntityTransaction tran = em.getTransaction();
				tran.begin();
				em.remove(ent);
				tran.commit();

				filasBorradas = 1;
			}
			em.close();
			return filasBorradas;
		} catch (Exception e) {
			em.close();
			return 0;
		}
	}
}