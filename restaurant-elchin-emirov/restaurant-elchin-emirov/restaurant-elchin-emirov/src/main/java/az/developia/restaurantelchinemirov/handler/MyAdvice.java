package az.developia.restaurantelchinemirov.handler;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.ResponseStatus;

import az.developia.restaurantelchinemirov.exception.OurRuntimeException;
import az.developia.restaurantelchinemirov.response.ErrorResponse;
import az.developia.restaurantelchinemirov.response.FieldErrorMessage;

@RestControllerAdvice
public class MyAdvice {

	@ExceptionHandler
	@ResponseStatus(code = HttpStatus.BAD_REQUEST)
	public ErrorResponse handleOurRuntimeException(OurRuntimeException e) {
		BindingResult br =e.getBr();
		ErrorResponse resp=new ErrorResponse();
		List<FieldErrorMessage> validations=new ArrayList<>();
		resp.setMessage(e.getMessage());
		resp.setInternalMessage("developer gorecek");
		if(br !=null) {
			List<FieldError> fieldErrors=br.getFieldErrors();
			for (int i=0; i<fieldErrors.size();i++) {
				FieldError fieldError = fieldErrors.get(i);
				FieldErrorMessage message=new FieldErrorMessage();
				message.setField(fieldError.getField());
				message.setMessage(fieldError.getDefaultMessage());
				validations.add(message);
			}
			resp.setValidations(validations);
			}
		return resp;
}

}
//best p korlanib
// validation