package sv.edu.udb.www.primefaces.models;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import sv.edu.udb.www.primefaces.entities.EmpleadoEntity;
import jakarta.persistence.Query;
import sv.edu.udb.www.primefaces.utils.JpaUtil;
import java.util.List;
public class EmployeeModel {
	public int insertarEmpleado(EmpleadoEntity empleado) {
		EntityManager em = JpaUtil.getEntityManager();
		EntityTransaction tran = em.getTransaction();
		try {
			tran.begin();
			em.persist(empleado);
			tran.commit();
			em.close();
			return 1;
		} catch (Exception e) {
			em.close();
			return 0;
		}
	}
	public List<EmpleadoEntity> listarEmpleado() {
		EntityManager em = JpaUtil.getEntityManager();
		try {
			Query consulta = em.createQuery("Select E from EmpleadoEntity E");
			List<EmpleadoEntity> lista = consulta.getResultList();
			em.close();
			return lista;
		} catch (Exception e) {
			em.close();
			return null;
		}
	}
}
