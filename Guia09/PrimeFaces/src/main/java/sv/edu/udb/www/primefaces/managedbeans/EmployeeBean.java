package sv.edu.udb.www.primefaces.managedbeans;

import jakarta.faces.bean.RequestScoped;
import jakarta.faces.bean.ManagedBean;
import sv.edu.udb.www.primefaces.entities.EmpleadoEntity;
import sv.edu.udb.www.primefaces.models.EmployeeModel;
import sv.edu.udb.www.primefaces.utils.JsfUtil;
import java.util.List;
@ManagedBean
@RequestScoped
public class EmployeeBean {
	private EmpleadoEntity employee;
	EmployeeModel modelo = new EmployeeModel();
	private List<EmpleadoEntity> listaEmpleados;
	public EmployeeBean() {
		employee = new EmpleadoEntity();
	}
	//Guardar un empleado en la base de datos
	public String guardarEmpleado(){
//INDICAR EL JSFIntroPU donde se ubica UnsupportedElement JsfUtil;
		if (modelo.insertarEmpleado(employee) != 1) {
			JsfUtil.setErrorMessage(null, "Error: no se pudo insertar al empleado");
		} else {
			JsfUtil.setFlashMessage("exito", "Empleado registrada exitosamente");
//Forzando la redirección en el cliente
		}
		return "employee";
	}
	public List<EmpleadoEntity> getListaEmpleados() {
		return modelo.listarEmpleado();
	}


	public EmpleadoEntity getEmployee() {
		return employee;
	}

	public void setEmployee(EmpleadoEntity employee) {
		this.employee = employee;
	}

	public EmployeeModel getModelo() {
		return modelo;
	}

	public void setModelo(EmployeeModel modelo) {
		this.modelo = modelo;
	}

	public void setListaEmpleados(List<EmpleadoEntity> listaEmpleados) {
		this.listaEmpleados = listaEmpleados;
	}
}