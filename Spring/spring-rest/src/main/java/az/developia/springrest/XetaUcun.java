package az.developia.springrest;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class XetaUcun {
	@ExceptionHandler
	public String handleOurRuntimeException(OurRuntimeException e) {
		return e.getMessage();
	}

}


/*
Sadece "RunTimeException e" olsaydi biz tek Springin deyil butun xetalarin mesajlarini gore bilmeyeceyik.Ona gorede OurRunTimeException classi yaratdiq ve ProductController-de RunTimeException-lari Our ile evez etdik. 

Bu halda yalniz bizim istediyimmizde ele xeta mesajini goreciyik hansi ki, Controllerde evez etdik.

Biz yaratdiqimizdan Springde exta bas vere bilmir (Qarismamasi ucun ozumuzden xeta tipi yaratdiq).
*/