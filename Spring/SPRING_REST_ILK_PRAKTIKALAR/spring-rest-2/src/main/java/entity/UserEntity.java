package entity;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;


@Entity
@Table(name = "users")
public class UserEntity {

	@Id
	
	@NotNull
	@NotEmpty
	@Size(min=1,max=100)
	private String username;
	
	@NotNull
	@NotEmpty
	@Size(min=1,max=100)
	
	private String password;
	
	private Boolean enabled;
	private String type;
	
	
public String getType() {
	return type;
	}

public void setType(String type) {
	this.type = type;
}
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
public Boolean getEnabled() {
	return enabled;
}
public void setEnabled(Boolean enabled) {
	this.enabled = enabled;
}
 

}
