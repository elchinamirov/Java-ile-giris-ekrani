package az.developia.restaurantelchinemirov.handler;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import az.developia.restaurantelchinemirov.exception.OurRuntimeException;

@RestControllerAdvice
public class MyAdvice {

	@ExceptionHandler
	public String handleOurRuntimeException(OurRuntimeException e) {
		return e.getMessage();
	}

}
