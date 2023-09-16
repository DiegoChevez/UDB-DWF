package sv.edu.udb.jsfcrud.managedbean;

import jakarta.faces.application.FacesMessage;
import jakarta.faces.bean.ManagedBean;
import jakarta.faces.bean.SessionScoped;
import jakarta.faces.context.FacesContext;
import sv.edu.udb.jsfcrud.model.Author;
import sv.edu.udb.jsfcrud.model.AuthorModel;
import sv.edu.udb.jsfcrud.model.LiteraryGenreModel;

import java.io.Serializable;
import java.sql.SQLException;

@ManagedBean
@SessionScoped

public class AuthorBean implements Serializable {
	private Author author;
	private AuthorModel authorModel = new AuthorModel();
	private LiteraryGenreModel literaryGenreModel = new LiteraryGenreModel();

	public AuthorBean() {
		this.author = new Author();
	}

	public void addAuthor() throws SQLException {
		authorModel.addAuthor(author);
		FacesContext.getCurrentInstance().addMessage("successMessage", new FacesMessage(FacesMessage.SEVERITY_INFO,
				"Agregado Exitosamente", "Agregado"));
		author = new Author();
	}

	public void deleteAuthor(Author author) throws SQLException {
		authorModel.delete(author);
	}

	public void countAuthor(String name) throws SQLException {
		if (authorModel.findSameNameAuhor(name) > 0) {
			FacesContext.getCurrentInstance().addMessage("errorMessage", new FacesMessage(FacesMessage.SEVERITY_INFO,
					"Este autor ya " + "existe", "Author"));
		}
	}

	public Author getAuthor() {
		return author;
	}

	public void setAuthor(Author author) {
		this.author = author;
	}

	public AuthorModel getAuthorModel() {
		return authorModel;
	}

	public void setAuthorModel(AuthorModel authorModel) {
		this.authorModel = authorModel;
	}

	public LiteraryGenreModel getLiteraryGenreModel() {
		return literaryGenreModel;
	}

	public void setLiteraryGenreModel(LiteraryGenreModel literaryGenreModel) {
		this.literaryGenreModel = literaryGenreModel;
	}
}
