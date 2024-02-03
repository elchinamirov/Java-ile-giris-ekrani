package az.developia.restaurantelchinemirov.handler;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import az.developia.restaurantelchinemirov.exception.OurRuntimeException;
import az.developia.restaurantelchinemirov.response.ErrorResponse;

@RestControllerAdvice
public class MyAdvice {

	@ExceptionHandler
	@ResponseStatus(code = HttpStatus.BAD_REQUEST)
	public ErrorResponse handleOurRuntimeException(OurRuntimeException e) {
		
		ErrorResponse resp=new ErrorResponse();
		resp.setMessage(e.getMessage());
		resp.setInternalMessage("developer gorecek");
		
		return resp;
}

}
//best p korlanib
// validation