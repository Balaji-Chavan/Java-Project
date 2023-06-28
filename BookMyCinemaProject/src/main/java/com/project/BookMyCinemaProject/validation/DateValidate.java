package com.project.BookMyCinemaProject.validation;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Target({ElementType.FIELD,ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Constraint(validatedBy = DateValidator.class)
public @interface DateValidate {
    public String message() default "Sorry !! You are not eligible for register";
    Class<?>[] groups() default { };

    Class<? extends Payload>[] payload() default { };
}
