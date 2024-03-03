package az.developia.studentcrud.exception;

import org.springframework.validation.BindingResult;

public class MyRuntimeException extends RuntimeException{
	
	private static final long serialVersionUID = 1L;
	private BindingResult result;

	public BindingResult getResult() {
		return result;
	}

	public void setResult(BindingResult result) {
		this.result = result;
	}

	public MyRuntimeException(BindingResult result) {
		super();
		this.result = result;
	}

	

}
