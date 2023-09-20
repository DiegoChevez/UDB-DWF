package sv.edu.udb.hibernatecrud;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class Test2 {
	public static void main(String[] args) {
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();

		// Actualizar una categoría
		actualizarCategoria(session, 7L, "Mecanica", "Articulos para el uso mecanico y domesc", "activo");

		// Actualizar un producto
		actualizarProducto(session, 12L, "Kit de Desarmadores", "20 desarmadores de puntas distintas", "activo");

		transaction.commit();
		session.close();
		sessionFactory.close();
	}

	public static void actualizarCategoria(Session session, Long categoriaId, String nuevaCategoria, String nuevaDescripcion, String nuevoEstado) {
		Categorias categoria = session.get(Categorias.class, categoriaId);
		if (categoria != null) {
			categoria.setCategoria(nuevaCategoria);
			categoria.setDescripcion_categoria(nuevaDescripcion);
			categoria.setEstado_categoria(nuevoEstado);
			session.update(categoria);
		}
	}

	public static void actualizarProducto(Session session, Long productoId, String nuevoProducto, String nuevaDescripcion, String nuevoEstado) {
		Productos producto = session.get(Productos.class, productoId);
		if (producto != null) {
			producto.setProducto(nuevoProducto);
			producto.setDescripcion_producto(nuevaDescripcion);
			producto.setEstado_producto(nuevoEstado);
			session.update(producto);
		}
	}
}
