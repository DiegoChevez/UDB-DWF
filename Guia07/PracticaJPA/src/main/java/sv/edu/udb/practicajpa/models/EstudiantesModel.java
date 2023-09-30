package sv.edu.udb.practicajpa.models;

import sv.edu.udb.practicajpa.utils.JpaUtil;
import java.util.List;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Query;
import sv.edu.udb.practicajpa.entities.EstudiantesEntity;
public class EstudiantesModel {
	public List<EstudiantesEntity> listarEstudiante() {
		EntityManager em = JpaUtil.getEntityManager();
		try {
			Query consulta = em.createNamedQuery("EstudiantesEntity.findAll");
			List<EstudiantesEntity> lista = consulta.getResultList();
			em.close();
			return lista;
		} catch (Exception e) {
			em.close();
			return null;
		}
	}
	public EstudiantesEntity obtenerEstudiante(String carnet) {
		EntityManager em = JpaUtil.getEntityManager();
		try {
			EstudiantesEntity estudiante = em.find(EstudiantesEntity.class, carnet);
			em.close();
			return estudiante;
		} catch (Exception e) {
			em.close();
			return null;
		}
	}
	public int insertarEstudiante(EstudiantesEntity estudiante) {
		EntityManager em = JpaUtil.getEntityManager();
		EntityTransaction tran = em.getTransaction();
		try {
			tran.begin();
			em.persist(estudiante);
			tran.commit();
			em.close();
			return 1;
		} catch (Exception e) {
			em.close();
			return 0;
		}
	}
	public int modificarEstudiante(EstudiantesEntity estudiante) {
		EntityManager em = JpaUtil.getEntityManager();
		EntityTransaction tran = em.getTransaction();
		try {
			tran.begin();
			em.merge(estudiante);
			tran.commit();
			em.close();
			return 1;
		} catch (Exception e) {
			em.close();
			return 0;
		}
	}
	public int eliminarEstudiante(String carnet) {
		EntityManager em = JpaUtil.getEntityManager();
		int filasBorradas = 0;
		try {
			EstudiantesEntity est = em.find(EstudiantesEntity.class, carnet);
			if (est != null) {
				EntityTransaction tran = em.getTransaction();
				tran.begin();
				em.remove(est);
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
