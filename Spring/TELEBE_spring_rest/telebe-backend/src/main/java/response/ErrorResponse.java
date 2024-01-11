package response;

import java.time.LocalDateTime;
import java.util.List;

public class ErrorResponse {
private String message;
private String internalMessage;
private String type;
private String path;
private LocalDateTime timestamp;
private Integer status;
private List<FieldErrorMessage> validations;



public String getMessage() {
	return message;
}
public void setMessage(String message) {
	this.message = message;
}
public String getInternalMessage() {
	return internalMessage;
}
public void setInternalMessage(String internalMessage) {
	this.internalMessage = internalMessage;
}
public String getType() {
	return type;
}
public void setType(String type) {
	this.type = type;
}
public String getPath() {
	return path;
}
public void setPath(String path) {
	this.path = path;
}
public LocalDateTime getTimestamp() {
	return timestamp;
}
public void setTimestamp(LocalDateTime timestamp) {
	this.timestamp = timestamp;
}
public Integer getStatus() {
	return status;
}
public void setStatus(Integer status) {
	this.status = status;
}
public List<FieldErrorMessage> getValidations() {
	return validations;
}
public void setValidations(List<FieldErrorMessage> validations) {
	this.validations = validations;
}


}


