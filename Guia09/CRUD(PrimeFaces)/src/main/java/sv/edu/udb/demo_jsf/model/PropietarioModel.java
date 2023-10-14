package sv.edu.udb.demo_jsf.model;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Query;
import sv.edu.udb.demo_jsf.entities.PropietarioEntity;
import sv.edu.udb.demo_jsf.utils.JpaUtil;
import java.util.List;

public class PropietarioModel {
	public int insertarPropietario(PropietarioEntity propietario) {
		EntityManager em = JpaUtil.getEntityManager();
		EntityTransaction tran = em.getTransaction();
		try {
			tran.begin(); // Iniciando transacción
			em.persist(propietario); // Guardando el objeto en la BD
			tran.commit(); // Confirmando la transacción
			em.close();
			return 1;
		} catch (Exception e) {
			em.close();
			return 0;
		}
	}
	public List<PropietarioEntity> listarPropietarios() {
		// Obtengo una instancia de EntityManager
		EntityManager em = JpaUtil.getEntityManager();
		try {
			Query consulta = em.createQuery("Select P from PropietarioEntity P");
			List<PropietarioEntity> lista = consulta.getResultList();
			em.close(); // Cerrando el EntityManager
			return lista;
		} catch (Exception e) {
			em.close();
			return null;
		}
	}

	public PropietarioEntity buscarPropietarioPorId(Long id) {
		EntityManager em = JpaUtil.getEntityManager();
		try {
			PropietarioEntity propietario = em.find(PropietarioEntity.class, id);
			em.close();
			return propietario;
		} catch (Exception e) {
			em.close();
			return null;
		}
	}

	public int actualizarPropietario(PropietarioEntity propietario) {
		EntityManager em = JpaUtil.getEntityManager();
		EntityTransaction tran = em.getTransaction();
		try {
			tran.begin();
			em.merge(propietario);
			tran.commit();
			em.close();
			return 1;
		} catch (Exception e) {
			em.close();
			return 0;
		}
	}

	public int eliminarPropietario(Long id) {
		EntityManager em = JpaUtil.getEntityManager();
		EntityTransaction tran = em.getTransaction();
		try {
			tran.begin();
			PropietarioEntity propietario = em.find(PropietarioEntity.class, id);
			if (propietario != null) {
				em.remove(propietario);
				tran.commit();
				em.close();
				return 1;
			} else {
				em.close();
				return 0;
			}
		} catch (Exception e) {
			em.close();
			return 0;
		}
	}
}
