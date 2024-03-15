package az.developia.libraryelchinemirov.entity;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import io.swagger.annotations.ApiModelProperty;

@Entity
@Table(name = "books")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler", "librarian"})
public class BookEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "book_id")
	private Long id;													
	@NotEmpty(message = "Bos qoymaq olmaz")
	@Size(min = 2, message = "Minimum 2 simvol yazmaq lazimdir")
	@Size(max = 40, message = "Maksimum 40 simvol yazmaq lazimdir")
	@Column(columnDefinition = "VARCHAR(30)")
	private String name;

	@Min(value = 0, message = "Minimum 0 yazmaq olar")
	@Max(value = 10000, message = "Maksimum 10000 yazmaq olar")
	@NotNull(message = "Bos qoymaq olmaz")
	private Double price;

	@JsonFormat(pattern = "yyyy-MM-dd")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@Column(name = "publication_date")
	private LocalDate publicationDate;
	
	@ManyToOne(fetch = FetchType.LAZY) 
	@JoinColumn(name = "librarian_id")
	@ApiModelProperty(hidden = true)
	private LibrarianEntity librarian;

	@Column(name = "available_for_borrowing")
	private boolean availableForBorrowing;

	@OneToMany(mappedBy = "book")
	@JsonIgnore
	private List<Borrowed> takenBooks;
																																												


	
	@ApiModelProperty(hidden = true)
	@Column(name = "take_date")	
	private LocalDateTime takeDate;

	@ApiModelProperty(hidden = true)
	@Column(name = "return_date")	
	private LocalDateTime returnDate;

	public LocalDateTime getTakeDate() {
		return takeDate;
	}

	public void setTakeDate(LocalDateTime takeDate) {
		this.takeDate = takeDate;
	}

	

	public LocalDateTime getReturnDate() {
		return returnDate;
	}

	public void setReturnDate(LocalDateTime returnDate) {
		this.returnDate = returnDate;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public boolean isAvailableForBorrowing() {
		return availableForBorrowing;
	}

	public void setAvailableForBorrowing(boolean availableForBorrowing) {
		this.availableForBorrowing = availableForBorrowing;
	}

	public List<Borrowed> getTakenBooks() {
		return takenBooks;
	}

	public void setTakenBooks(List<Borrowed> takenBooks) {
		this.takenBooks = takenBooks;
	}

	public LibrarianEntity getLibrarian() {
		return librarian;
	}

	public void setLibrarian(LibrarianEntity librarian) {
		this.librarian = librarian;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public LocalDate getPublicationDate() {
		return publicationDate;
	}

	public void setPublicationDate(LocalDate publicationDate) {
		this.publicationDate = publicationDate;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	
}
	
