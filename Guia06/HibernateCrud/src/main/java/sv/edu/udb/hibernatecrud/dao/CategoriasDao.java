package sv.edu.udb.hibernatecrud.dao;

import sv.edu.udb.hibernatecrud.Categorias;
import sv.edu.udb.hibernatecrud.HibernateUtil;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.List;

public class CategoriasDao {
	public void addCategoria(Categorias categoria) {
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		Session session = sessionFactory.openSession();
		Transaction transaction = null;

		try {
			transaction = session.beginTransaction();
			session.save(categoria);
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

	public void deleteCategoria(Long categoriaId) {
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		Session session = sessionFactory.openSession();
		Transaction transaction = null;

		try {
			transaction = session.beginTransaction();
			Categorias categoria = session.get(Categorias.class, categoriaId);
			session.delete(categoria);
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

	public void updateCategoria(Categorias categoria) {
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		Session session = sessionFactory.openSession();
		Transaction transaction = null;

		try {
			transaction = session.beginTransaction();
			session.update(categoria);
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

	public Categorias getCategoriaById(Long categoriaId) {
		Categorias categoria = null;
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		Session session = sessionFactory.openSession();

		try {
			categoria = session.get(Categorias.class, categoriaId);
		} catch (HibernateException e) {
			e.printStackTrace();
		} finally {
			session.close();
		}

		return categoria;
	}

	public List<Categorias> getAllCategorias() {
		List<Categorias> categorias = null;
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		Session session = sessionFactory.openSession();

		try {
			Query<Categorias> query = session.createQuery("FROM Categorias", Categorias.class);
			categorias = query.list();
		} catch (HibernateException e) {
			e.printStackTrace();
		} finally {
			session.close();
		}

		return categorias;
	}
}
