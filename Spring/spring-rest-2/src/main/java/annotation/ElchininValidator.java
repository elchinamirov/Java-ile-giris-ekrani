package annotation;
import java.time.LocalDate;

	import jakarta.validation.ConstraintValidator;
	import jakarta.validation.ConstraintValidatorContext;


	
	public class ElchininValidator implements ConstraintValidator<Elchinin, LocalDate> {
		private Integer i;
		@Override
		public void initialize(Elchinin annotation) {
		  i=annotation.value();
			
			 
		}
		@Override
		public boolean isValid(LocalDate day, ConstraintValidatorContext context) {
			// 2020-02-02
			 if(day.isBefore(LocalDate.now().minusYears(i))) {
				 return true;
			 }else {
				 
				 return false;
			 }
			 
		}

	}

