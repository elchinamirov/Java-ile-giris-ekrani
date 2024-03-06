package az.developia.libraryelchinemirov.handler;


import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import az.developia.libraryelchinemirov.exception.OurRuntimeException;
import az.developia.libraryelchinemirov.response.ErrorResponse;
import az.developia.libraryelchinemirov.response.FieldErrorMessage;

@RestControllerAdvice
public class MyAdvice {

	@ExceptionHandler
	@ResponseStatus(code = HttpStatus.BAD_REQUEST)
	public ErrorResponse handleOurRuntimeException(OurRuntimeException e) {
		BindingResult br = e.getBr();

		ErrorResponse resp = new ErrorResponse();
		List<FieldErrorMessage> validations = new ArrayList<>();

		resp.setMessage(e.getMessage());
		resp.setInternalMessage("developer gorecek");
		if (br != null) {
			List<FieldError> fieldErrors = br.getFieldErrors();

			for (int i = 0; i < fieldErrors.size(); i++) {

				FieldError fieldError = fieldErrors.get(i);
				FieldErrorMessage message = new FieldErrorMessage();
				message.setField(fieldError.getField());
				message.setMessage(fieldError.getDefaultMessage());
				validations.add(message);
			}
			resp.setValidations(validations);
		}

		return resp;
	}
	// best p korlanib
	// validation

}