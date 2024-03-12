package az.developia.libraryelchinemirov.entity;

import java.awt.print.Book;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

	@Entity
	@Table(name = "borrowed_books")
	public class Borrowed {

		    @Id
		    @GeneratedValue(strategy = GenerationType.IDENTITY)
		    private Integer id;

		    @ManyToOne
		    @JoinColumn(name = "student_id", referencedColumnName = "id")
		    private StudentEntity student;

		    @ManyToOne
		    @JoinColumn(name = "book_id", referencedColumnName = "book_id")
		    private Book book;

			public Integer getId() {
				return id;
			}

			public void setId(Integer id) {
				this.id = id;
			}

			public StudentEntity getStudent() {
				return student;
			}

			public void setStudent(StudentEntity student) {
				this.student = student;
			}

			public Book getBook() {
				return book;
			}

			public void setBook(Book book) {
				this.book = book;
			}

}
