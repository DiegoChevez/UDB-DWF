package sv.edu.udb.www.primefaces.managedbeans;

import jakarta.faces.bean.ManagedBean;
import jakarta.faces.bean.RequestScoped;
import sv.edu.udb.www.primefaces.entities.CapacitacionEmpleadoEntity;
import sv.edu.udb.www.primefaces.models.TrainingEmployeeModel;
import sv.edu.udb.www.primefaces.utils.JsfUtil;
import java.util.List;
@ManagedBean
@RequestScoped
public class TrainingEmployeeBean {
	/**
	 * Creates a new instance of TrainingEmployee
	 */
	TrainingEmployeeModel modelo = new TrainingEmployeeModel();
	private int idCapacitacion;
	private int[] empleadosSeleccionados;

	public TrainingEmployeeBean() {
	}
	public List<CapacitacionEmpleadoEntity> listaEmpleadosCapacitados(){
		return modelo.listarEmpleadosCapacitados();
	}
	public String guardarEmpleados(){
		if (modelo.insertarEmpleadoCapacitado(empleadosSeleccionados,idCapacitacion) != 1) {
			JsfUtil.setErrorMessage(null, "Uno o mas empleados ya tienen una capacitación asignada");
		} else {
			JsfUtil.setFlashMessage("exito", "Empleados asignados a Capacitación con exito");
//Forzando la redirección en el cliente
		}
		return "trainingemployee";
	}

	public TrainingEmployeeModel getModelo() {
		return modelo;
	}

	public void setModelo(TrainingEmployeeModel modelo) {
		this.modelo = modelo;
	}

	public int getIdCapacitacion() {
		return idCapacitacion;
	}

	public void setIdCapacitacion(int idCapacitacion) {
		this.idCapacitacion = idCapacitacion;
	}

	public int[] getEmpleadosSeleccionados() {
		return empleadosSeleccionados;
	}

	public void setEmpleadosSeleccionados(int[] empleadosSeleccionados) {
		this.empleadosSeleccionados = empleadosSeleccionados;
	}
}