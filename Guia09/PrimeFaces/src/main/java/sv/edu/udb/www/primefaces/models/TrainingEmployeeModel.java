package sv.edu.udb.www.primefaces.models;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Query;
import sv.edu.udb.www.primefaces.entities.CapacitacionEmpleadoEntity;
import sv.edu.udb.www.primefaces.entities.CapacitacionesEntity;
import sv.edu.udb.www.primefaces.entities.EmpleadoEntity;
import sv.edu.udb.www.primefaces.utils.JpaUtil;
import java.util.Date;
import java.util.List;
public class TrainingEmployeeModel {
	public List<CapacitacionEmpleadoEntity> listarEmpleadosCapacitados() {
//Obtengo una instancia de EntityManager
		EntityManager em = JpaUtil.getEntityManager();
		try {
			Query query = em.createQuery("select CE from CapacitacionEmpleadoEntity CE");
			List<CapacitacionEmpleadoEntity> lista = query.getResultList();
			em.close();// Cerrando el EntityManager
			return lista;
		} catch (Exception e) {
			em.close();
			return null;
		}

	}
	public int insertarEmpleadoCapacitado(int[] empleadosSeleccionados, int
			idCapacitacion){
		EntityManager em = JpaUtil.getEntityManager();
		EntityTransaction tran = em.getTransaction();
		try {
			for(int tmpEmpleados : empleadosSeleccionados){
				Query query = em.createQuery("Select CP from CapacitacionEmpleadoEntity CP "
								+ " where CP.empleadoByIdEmpleado.idEmpleado = :idEmpleado "
								+ "and CP.capacitacionesByIdCapacitacion.idCapacitacion =:idCapacitacion");
				query.setParameter("idEmpleado", tmpEmpleados);
				query.setParameter("idCapacitacion", idCapacitacion);
				EmpleadoEntity tmpEmpleadoEntity = em.find(EmpleadoEntity.class, tmpEmpleados);
				CapacitacionesEntity tmpCapacitacion = em.find(CapacitacionesEntity.class, idCapacitacion);
				tran.begin();
				if(query.getResultList().isEmpty()){
					CapacitacionEmpleadoEntity capacitacionEmpleadoEntity = new
							CapacitacionEmpleadoEntity();
					capacitacionEmpleadoEntity.setEmpleadoByIdEmpleado(tmpEmpleadoEntity);
					capacitacionEmpleadoEntity.setCapacitacionesByIdCapacitacion(tmpCapacitacion);
					capacitacionEmpleadoEntity.setFechaInscripcion(new Date());
					em.persist(capacitacionEmpleadoEntity);
				}
				em.getTransaction().commit();
			}
			em.close();
			return 1;
		} catch (Exception e) {
			em.close();
			return 0;
		}
	}
}
