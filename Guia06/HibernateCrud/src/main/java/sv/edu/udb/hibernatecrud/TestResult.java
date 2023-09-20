package sv.edu.udb.hibernatecrud;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.List;

public class TestResult {
	public static void main(String[] args) {
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		Session session = sessionFactory.openSession();

		mostrarProductos(session);
		mostrarCategorias(session);

		session.close();
		sessionFactory.close();
	}

	public static void mostrarProductos(Session session) {
		List<Productos> listaProductos = session.createQuery("from Productos")
												.list();
		System.out.println("Productos:");
		for (Productos producto : listaProductos) {
			System.out.println("ID: " + producto.getProducto_id() + ", Producto: " + producto.getProducto() + ", Descripción: " + producto.getDescripcion_producto() + ", Estado: " + producto.getEstado_producto() + ", Categoría: " + producto.getCategoria()
																																																												.getCategoria());
		}
	}

	public static void mostrarCategorias(Session session) {
		List<Categorias> listaCategorias = session.createQuery("from Categorias")
												  .list();
		System.out.println("\nCategorías:");
		for (Categorias categoria : listaCategorias) {
			System.out.println("ID: " + categoria.getCategoria_id() + ", Categoría: " + categoria.getCategoria() + ", Descripción: " + categoria.getDescripcion_categoria() + ", Estado: " + categoria.getEstado_categoria());
		}
	}
}
