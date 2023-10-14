package sv.edu.udb.demo_jsf.model;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Query;
import sv.edu.udb.demo_jsf.entities.PublicacionesEntity;
import sv.edu.udb.demo_jsf.utils.JpaUtil;
import java.util.List;

public class PublicacionesModel {
	public int insertarPublicacion(PublicacionesEntity publicacion) {
		EntityManager em = JpaUtil.getEntityManager();
		EntityTransaction tran = em.getTransaction();
		try {
			tran.begin();
			em.persist(publicacion);
			tran.commit();
			em.close();
			return 1;
		} catch (Exception e) {
			em.close();
			return 0;
		}
	}

	public List<PublicacionesEntity> listarPublicaciones() {
		EntityManager em = JpaUtil.getEntityManager();
		try {
			Query consulta = em.createQuery("SELECT P FROM PublicacionesEntity P");
			List<PublicacionesEntity> lista = consulta.getResultList();
			em.close();
			return lista;
		} catch (Exception e) {
			em.close();
			return null;
		}
	}

	public PublicacionesEntity buscarPublicacionPorId(Long id) {
		EntityManager em = JpaUtil.getEntityManager();
		try {
			PublicacionesEntity publicacion = em.find(PublicacionesEntity.class, id);
			em.close();
			return publicacion;
		} catch (Exception e) {
			em.close();
			return null;
		}
	}

	public int actualizarPublicacion(PublicacionesEntity publicacion) {
		EntityManager em = JpaUtil.getEntityManager();
		EntityTransaction tran = em.getTransaction();
		try {
			tran.begin();
			em.merge(publicacion);
			tran.commit();
			em.close();
			return 1;
		} catch (Exception e) {
			em.close();
			return 0;
		}
	}

	public int eliminarPublicacion(Long id) {
		EntityManager em = JpaUtil.getEntityManager();
		EntityTransaction tran = em.getTransaction();
		try {
			tran.begin();
			PublicacionesEntity publicacion = em.find(PublicacionesEntity.class, id);
			if (publicacion != null) {
				em.remove(publicacion);
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
