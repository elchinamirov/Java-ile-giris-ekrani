package annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

@Constraint(validatedBy = ElchininValidator.class)
@Target( {  ElementType.FIELD } )
@Retention(RetentionPolicy.RUNTIME)

public @interface Elchinin {
	public int value() default 18;
	public String message() default "yas min 18 olmalidir";
	
	Class<?>[] groups() default {};
	
	Class<? extends Payload>[] payload() default {};
}