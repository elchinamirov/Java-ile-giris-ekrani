package Student;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class XetaUcun {

	@ExceptionHandler
	@ResponseStatus(code = HttpStatus.BAD_REQUEST)
	public ErrorResponse handleOurRuntimeException(OurRuntimeException e) {
		
		ErrorResponse resp=new ErrorResponse();
		resp.setMessage(e.getMessage());
		resp.setInternalMessage("developer gorecek");
		
		return resp;
	}
	
	
	
	
	
	
	
	
	
	
// best practices korlanib
	//validation
}


/*
Sadece "RunTimeException e" olsaydi biz tek Springin deyil butun xetalarin mesajlarini gore bilmeyeceyik.Ona gorede OurRunTimeException classi yaratdiq ve ProductController-de RunTimeException-lari Our ile evez etdik. 

Bu halda yalniz bizim istediyimmizde ele xeta mesajini goreciyik hansi ki, Controllerde evez etdik.

Biz yaratdiqimizdan Springde exta bas vere bilmir (Qarismamasi ucun ozumuzden xeta tipi yaratdiq).
*/