package az.developia.bookshopping.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
public class Book {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@NotEmpty(message="Boş qoymaq olmaz")
	@Size(min=2 , message = "Ən azı 2 simvol yazmaq lazımdır")
	@Size(max=50, message = "Ən çoxu 50 simvol yazmaq lazımdır")
	@Column(columnDefinition = "VARCHAR(50)")
	private String name;
	
	@Column(columnDefinition = "VARCHAR(300)")
	@Size(max=300,message ="Ən çoxu 300 simvol yazmaq lazımdır")
	private String description;
	
	@Min(value = 0,message = "Ən azı 0 yazmaq olar")
	@Max(value = 1000,message = "Ən çoxu 1000 yazmaq olar")
	@NotNull(message = "Boş qoymaq olmaz")
	private Double price;
	
	@Column(columnDefinition = "VARCHAR(50)")
	@Size(min=2 , message = "Ən azı 2 simvol yazmaq lazımdır")
	@Size(max=50, message = "Ən çoxu 50 simvol yazmaq lazımdır")
	private String author;
	
	@Min(value = 0,message = "Ən azı 0 yazmaq olar")
	@Max(value = 100000,message = "Ən çoxu 100000 yazmaq olar")
	private Integer pageCount;
	
	private String image;
	
	private String username;


	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public Integer getPageCount() {
		return pageCount;
	}
	public void setPageCount(Integer pageCount) {
		this.pageCount = pageCount;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	
	
}
