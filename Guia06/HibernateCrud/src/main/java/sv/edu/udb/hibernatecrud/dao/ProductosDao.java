package sv.edu.udb.hibernatecrud.dao;

import sv.edu.udb.hibernatecrud.Productos;
import sv.edu.udb.hibernatecrud.HibernateUtil;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import sv.edu.udb.hibernatecrud.managedbean.CategoriasBean;

import java.util.List;
import java.util.logging.Logger;

public class ProductosDao {
	private static final Logger logger = Logger.getLogger(CategoriasBean.class.getName());
	public void addProducto(Productos producto) {
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		Session session = sessionFactory.openSession();
		Transaction transaction = null;

		try {
			transaction = session.beginTransaction();
			session.save(producto);
			session.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
			if (transaction != null) {
				transaction.rollback();
			}
		} finally {
			session.close();
		}
	}

	public void deleteProducto(Long productoId) {
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		Session session = sessionFactory.openSession();
		Transaction transaction = null;

		try {
			transaction = session.beginTransaction();
			Productos producto = session.get(Productos.class, productoId);
			session.delete(producto);
			session.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
			if (transaction != null) {
				transaction.rollback();
			}
		} finally {
			session.close();
		}
	}

	public void updateProducto(Productos producto) {
		logger.info("nuevo producto: " + producto.getEstado_producto());
		logger.info("nuevo producto: " + producto.getCategoria_id());
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		Session session = sessionFactory.openSession();
		Transaction transaction = null;

		try {
			transaction = session.beginTransaction();
			session.update(producto);
			session.getTransaction().commit();
			logger.info("Si se actualiza");
		} catch (Exception e) {
			e.printStackTrace();
			if (transaction != null) {
				transaction.rollback();
				logger.info("Problema");
			}
		} finally {
			session.close();
		}
	}

	public Productos getProductoById(Long productoId) {
		Productos producto = null;
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		Session session = sessionFactory.openSession();

		try {
			producto = session.get(Productos.class, productoId);
		} catch (HibernateException e) {
			e.printStackTrace();
		} finally {
			session.close();
		}

		return producto;
	}

	public List<Productos> getAllProductos() {
		List<Productos> productos = null;
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		Session session = sessionFactory.openSession();

		try {
			Query<Productos> query = session.createQuery("FROM Productos", Productos.class);
			productos = query.list();
		} catch (HibernateException e) {
			e.printStackTrace();
		} finally {
			session.close();
		}

		return productos;
	}
}
