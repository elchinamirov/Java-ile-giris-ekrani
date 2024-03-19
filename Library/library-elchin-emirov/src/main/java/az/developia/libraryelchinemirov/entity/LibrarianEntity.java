package az.developia.libraryelchinemirov.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "librarians")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler", "books"})
public class LibrarianEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="librarian_id")
    private Long LibrarianId;

    @Column(name = "username", unique = true)
    private String username;

    @Column(name = "password")
    private String password;

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public Long getLibrarianId() {
		return LibrarianId;
	}

	public void setLibrarianId(Long librarianId) {
		LibrarianId = librarianId;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	

}
