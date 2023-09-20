package sv.edu.udb.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class Test {
	public static void main(String[] args) { //clase main de ejecucion java
		SessionFactory sesFact = HibernateUtil.getSessionFactory();
		Session ses = sesFact.openSession();
		Transaction tra = ses.beginTransaction();
		Datosempleados datos = new Datosempleados();
		datos.setId(1);
		datos.setNombres("Laura Carolina");
		datos.setApellidos("Ramirez");
		datos.setEdad(23);
		datos.setTelefono("22202222");
		datos.setDireccion("Mi casa2");
		ses.update(datos);
		tra.commit();
	}
}
