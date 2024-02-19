package az.developia.bookshopping.model;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

public class User {

	@NotEmpty(message="Boş qoymaq olmaz")
	@Size(min=1 , message = "İstifadəçi adı ən azı 1 simvol olmalıdır")
	@Size(max=50, message = "İstifadəçi adı ən çox 50 simvol olmalıdır")
	private String username;
	
	@NotEmpty(message="Boş qoymaq olmaz")
	@Size(min=1 , message = "Şifrə ən azı 1 simvol olmalıdır")
	@Size(max=50, message = "Şifrə ən çox 50 simvol olmalıdır")
	private String password;
	
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	@Override
	public String toString() {
		return "User [username=" + username + ", password=" + password + "]";
	}
	

	
}
