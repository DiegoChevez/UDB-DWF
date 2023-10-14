package sv.edu.udb.www.primefaces.managedbeans;

import jakarta.faces.bean.ManagedBean;
import jakarta.faces.bean.RequestScoped;
import sv.edu.udb.www.primefaces.entities.CapacitacionesEntity;
import sv.edu.udb.www.primefaces.entities.CategoriasEntity;
import sv.edu.udb.www.primefaces.models.TrainingModel;
import sv.edu.udb.www.primefaces.utils.JsfUtil;
import java.util.List;
@ManagedBean
@RequestScoped
public class TrainingBean {
	TrainingModel modelo = new TrainingModel();
	private CapacitacionesEntity capacitacion;
	private List<CapacitacionesEntity> listaCapacitaciones;
	private int idCategoriaForm;
	public TrainingBean() {

		capacitacion =new CapacitacionesEntity();
	}
	public List<CategoriasEntity> getListaCategorias(){
		return modelo.listarCategorias();
	}
	public List<CapacitacionesEntity> getListaCapacitaciones(){
		return modelo.listarCapacitaciones();
	}
	public String guardarCapacitacion(){
		if (modelo.insertarCapacitacion(capacitacion,idCategoriaForm) != 1) {
			JsfUtil.setErrorMessage(null, "Ya se registró una capacitación similar");
		} else {
			JsfUtil.setFlashMessage("exito", "Capacitación registrada exitosamente");
//Forzando la redirección en el cliente
		}
		return "index";
	}

	public TrainingModel getModelo() {
		return modelo;
	}

	public void setModelo(TrainingModel modelo) {
		this.modelo = modelo;
	}

	public CapacitacionesEntity getCapacitacion() {
		return capacitacion;
	}

	public void setCapacitacion(CapacitacionesEntity capacitacion) {
		this.capacitacion = capacitacion;
	}

	public void setListaCapacitaciones(List<CapacitacionesEntity> listaCapacitaciones) {
		this.listaCapacitaciones = listaCapacitaciones;
	}

	public int getIdCategoriaForm() {
		return idCategoriaForm;
	}

	public void setIdCategoriaForm(int idCategoriaForm) {
		this.idCategoriaForm = idCategoriaForm;
	}
}