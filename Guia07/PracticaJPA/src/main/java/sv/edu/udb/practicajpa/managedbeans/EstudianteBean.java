package sv.edu.udb.practicajpa.managedbeans;

import jakarta.faces.bean.ManagedBean;
import jakarta.faces.bean.RequestScoped;
import sv.edu.udb.practicajpa.entities.EstudiantesEntity;
import sv.edu.udb.practicajpa.models.EstudiantesModel;
import sv.edu.udb.practicajpa.utils.JsfUtil;
import java.util.List;
@ManagedBean
@RequestScoped
public class EstudianteBean {
	EstudiantesModel modelo = new EstudiantesModel();
	private EstudiantesEntity estudiante;

	private List<EstudiantesEntity> listaEstudiantes;
	public EstudianteBean() {
		estudiante = new EstudiantesEntity();
	}
	public EstudiantesEntity getEstudiante() {
		return estudiante;
	}
	public void setEstudiante(EstudiantesEntity estudiante) {
		this.estudiante = estudiante;
	}
	public List<EstudiantesEntity> getListaEstudiantes() {
		return modelo.listarEstudiante();
	}
	public String guardarEstudiante() {
		if (modelo.insertarEstudiante(estudiante) != 1) {
			JsfUtil.setFlashMessage("exito", "Alumno ha sido modificado");
			modelo.modificarEstudiante(estudiante);
			return null;
		} else {
			JsfUtil.setFlashMessage("exito", "Alumno registrado exitosamente");
			return "registroEstudiantes?faces-redirect=true";
		}
	}

	public String eliminarEstudiante() {
		String carnet= JsfUtil.getRequest().getParameter("carnet");
		if (modelo.eliminarEstudiante(carnet) > 0) {
			JsfUtil.setFlashMessage("exito", "Estudiante eliminado exitosamente" );
		}
		else{
			JsfUtil.setErrorMessage(null, "No se pudo borrar a este alumno");
		}
		return "registroEstudiantes?faces-redirect=true";
	}

	public String obtenerEstudiante(){
		String carnet= JsfUtil.getRequest().getParameter("carnet");
		if (modelo.obtenerEstudiante(carnet) != null) {
			estudiante = modelo.obtenerEstudiante(carnet);
			return null;
		}
		else{
			JsfUtil.setErrorMessage(null, "No se pudo obtener a este alumno");
			return null;
		}
	}
}
