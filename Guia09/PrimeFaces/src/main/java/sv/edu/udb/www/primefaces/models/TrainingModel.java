package sv.edu.udb.www.primefaces.models;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Query;

import sv.edu.udb.www.primefaces.utils.JpaUtil;
import sv.edu.udb.www.primefaces.entities.CategoriasEntity;
import sv.edu.udb.www.primefaces.entities.CapacitacionesEntity;
import java.util.List;
public class TrainingModel {
	public List<CategoriasEntity> listarCategorias() {
//Obtengo una instancia de EntityManager
		EntityManager em = JpaUtil.getEntityManager();
		try {
			Query consulta = em.createQuery("Select C From CategoriasEntity C");
			List<CategoriasEntity> lista = consulta.getResultList();
			em.close();// Cerrando el EntityManager
			return lista;
		} catch (Exception e) {
			em.close();
			return null;
		}
	}
	public List<CapacitacionesEntity> listarCapacitaciones() {
//Obtengo una instancia de EntityManager
		EntityManager em = JpaUtil.getEntityManager();
		try {
			Query consulta = em.createQuery("Select CS From CapacitacionesEntity CS");
			List<CapacitacionesEntity> lista = consulta.getResultList();
			em.close();// Cerrando el EntityManager
			return lista;
		} catch (Exception e) {
			em.close();
			return null;
		}
	}
	public int insertarCapacitacion(CapacitacionesEntity capacitacion, int idCategoriaForm)
	{
		EntityManager em = JpaUtil.getEntityManager();
		EntityTransaction tran = em.getTransaction();
		try {
			CategoriasEntity catFormulario = em.find(CategoriasEntity.class,
					idCategoriaForm);

			capacitacion.setCategoriasByIdCategoria(catFormulario);
			tran.begin();
			em.persist(capacitacion);
			tran.commit();//Confirmando la transacción
			em.close();
			return 1;
		} catch (Exception e) {
			em.close();
			return 0;
		}
	}
}