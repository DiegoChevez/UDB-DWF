package sv.edu.udb.demo_jsf.models;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.NoResultException;
import jakarta.persistence.Query;
import sv.edu.udb.demo_jsf.entities.PropietarioEntity;
import sv.edu.udb.demo_jsf.entities.UsuariosEntity;
import sv.edu.udb.demo_jsf.utils.JpaUtil;

import java.util.List;
import java.util.logging.Logger;

public class UsuarioModel {

	public int insertarUsuario(UsuariosEntity usuario) {
		EntityManager em = JpaUtil.getEntityManager();
		EntityTransaction tran = em.getTransaction();
		Logger logger = Logger.getLogger(UsuarioModel.class.getName());
		logger.info("Usuario Model");
		logger.info(usuario.toString());
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


	public int eliminarUsuario(UsuariosEntity usuario) {
		EntityManager em = JpaUtil.getEntityManager();
		EntityTransaction tran = em.getTransaction();

		try {
			tran.begin();
			usuario = em.find(UsuariosEntity.class, usuario.getUsuarioId());
			em.remove(usuario);
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


	public int actualizarUsuario(UsuariosEntity usuario) {
		EntityManager em = JpaUtil.getEntityManager();
		EntityTransaction tran = em.getTransaction();

		try {
			tran.begin();
			UsuariosEntity updatedUser = em.merge(usuario);
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




	public UsuariosEntity buscarUsuarioPorId(String usuarioId) {
		EntityManager em = JpaUtil.getEntityManager();
		try {
			UsuariosEntity usuario = em.find(UsuariosEntity.class, usuarioId);
			em.close();
			return usuario;
		} catch (Exception e) {
			em.close();
			return null;
		}
	}



	public List<UsuariosEntity> listarUsuarios() {
		// Obtengo una instancia de EntityManager
		EntityManager em = JpaUtil.getEntityManager();
		try {
			Query consulta = em.createQuery("Select U from UsuariosEntity U");
			List<UsuariosEntity> lista = consulta.getResultList();
			em.close(); // Cerrando el EntityManager
			return lista;
		} catch (Exception e) {
			em.close();
			return null;
		}
	}

}
