package sv.edu.udb.hibernatecrud;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class Test {
	public static void main(String[] args) {
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		Session session = sessionFactory.openSession();

		agregarCategoria(session);
		agregarProducto(session);

		session.close();
		sessionFactory.close();
	}

	public static void agregarCategoria(Session session) {
		Transaction transaction = session.beginTransaction();
		Categorias categoria = new Categorias();
		categoria.setCategoria("Herramientas");
		categoria.setDescripcion_categoria("Articulos para el uso mecanico");
		categoria.setEstado_categoria("activo");
		session.save(categoria);
		transaction.commit();
	}

	public static void agregarProducto(Session session) {
		Transaction transaction = session.beginTransaction();
		Productos producto = new Productos();
		producto.setProducto("Kit de Desarmador");
		producto.setDescripcion_producto("14 desarmadores de puntas distintas");
		producto.setEstado_producto("activo");

		Categorias categoria = (Categorias) session.createQuery("from Categorias where categoria = :categoria")
												   .setParameter("categoria", "Herramientas")
												   .uniqueResult();

		producto.setCategoria(categoria);

		session.save(producto);
		transaction.commit();
	}
}
