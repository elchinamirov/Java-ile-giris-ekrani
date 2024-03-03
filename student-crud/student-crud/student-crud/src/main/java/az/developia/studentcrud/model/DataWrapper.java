package az.developia.studentcrud.model;

import java.util.List;
public class DataWrapper {
private List<az.developia.studentcrud.model.ErrorResponse> validations;

public List<az.developia.studentcrud.model.ErrorResponse> getValidations() {
	return validations;
}

public void setValidations(List<az.developia.studentcrud.model.ErrorResponse> validations) {
	this.validations = validations;
}



}
