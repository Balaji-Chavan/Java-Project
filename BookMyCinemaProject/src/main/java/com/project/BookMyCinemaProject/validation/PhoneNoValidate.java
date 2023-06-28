package com.project.BookMyCinemaProject.validation;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Target({ElementType.FIELD,ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Constraint(validatedBy = PhoneNoValidator.class)
public @interface PhoneNoValidate  {
    public String message() default "Phone No is not valid!!";
    Class<?>[] groups() default { };
    Class<? extends Payload>[] payload() default { };
}
