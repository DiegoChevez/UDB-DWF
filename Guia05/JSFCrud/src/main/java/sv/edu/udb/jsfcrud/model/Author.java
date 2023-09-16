package sv.edu.udb.jsfcrud.model;
import java.util.Date;

public class Author {
	private int authorId;
	private String authorName;
	private Date authorBirth;
	private String authorNumber;
	private String literaryGenre;
	public Author() {
	}
	public Author(int authorId, String authorName, Date authorAge,
				  String authorNumber, String literaryGenre) {
		this.authorId = authorId;
		this.authorName = authorName;
		this.authorBirth = authorAge;
		this.authorNumber = authorNumber;
		this.literaryGenre = literaryGenre;
	}

	public int getAuthorId() {
		return authorId;
	}

	public void setAuthorId(int authorId) {
		this.authorId = authorId;
	}

	public String getAuthorName() {
		return authorName;
	}

	public void setAuthorName(String authorName) {
		this.authorName = authorName;
	}

	public Date getAuthorBirth() {
		return authorBirth;
	}

	public void setAuthorBirth(Date authorBirth) {
		this.authorBirth = authorBirth;
	}

	public String getAuthorNumber() {
		return authorNumber;
	}

	public void setAuthorNumber(String authorNumber) {
		this.authorNumber = authorNumber;
	}

	public String getLiteraryGenre() {
		return literaryGenre;
	}

	public void setLiteraryGenre(String literaryGenre) {
		this.literaryGenre = literaryGenre;
	}
}
