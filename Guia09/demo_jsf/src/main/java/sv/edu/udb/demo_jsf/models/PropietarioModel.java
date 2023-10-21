package sv.edu.udb.demo_jsf.models;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Query;
import sv.edu.udb.demo_jsf.entities.PropietarioEntity;
import sv.edu.udb.demo_jsf.utils.JpaUtil;
import java.util.List;
import java.util.logging.Logger;

public class PropietarioModel {

	public int insertarPropietario(PropietarioEntity propietario) {
		Logger logger = Logger.getLogger(PropietarioModel.class.getName());
		EntityManager em = JpaUtil.getEntityManager();
		EntityTransaction tran = em.getTransaction();
		logger.info("Propietario Model");
		logger.info(propietario.toString());
		try {
			tran.begin();
			em.persist(propietario);
			tran.commit();
			em.close();
			return 1;
		} catch (Exception e) {
			em.close();
			return 0;
		}
	}



	public int eliminarPropietario(PropietarioEntity propietario) {
		EntityManager em = JpaUtil.getEntityManager();
		EntityTransaction tran = em.getTransaction();

		try {
			tran.begin();
			propietario = em.find(PropietarioEntity.class, propietario.getPropietarioId());
			em.remove(propietario);
			tran.commit();
			em.close();
			return 1;
		} catch (Exception e) {
			if (tran.isActive()) {
				tran.rollback();
			}
			em.close();
			return 0;
		}
	}


	public int actualizarPropietario(PropietarioEntity propietario) {
		EntityManager em = JpaUtil.getEntityManager();
		EntityTransaction tran = em.getTransaction();

		try {
			tran.begin();
			PropietarioEntity updatedPropietario = em.merge(propietario);
			tran.commit();
			em.close();
			return 1;
		} catch (Exception e) {
			if (tran.isActive()) {
				tran.rollback();
			}
			em.close();
			return 0;
		}
	}




	public List<PropietarioEntity> listarPropietarios() {
		EntityManager em = JpaUtil.getEntityManager();
		try {
			Query consulta = em.createQuery("Select P from PropietarioEntity P");
			List<PropietarioEntity> lista = consulta.getResultList();
			em.close();
			return lista;
		} catch (Exception e) {
			em.close();
			return null;
		}
	}



	public PropietarioEntity buscarPropietarioPorId(String propietarioId) {
		EntityManager em = JpaUtil.getEntityManager();
		try {
			PropietarioEntity propietario = em.find(PropietarioEntity.class, propietarioId);
			em.close();
			return propietario;
		} catch (Exception e) {
			em.close();
			return null;
		}
	}

}
