package com.project.BookMyCinemaProject.validation;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Target({ElementType.FIELD,ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Constraint(validatedBy = LocationValidator.class)
public @interface LocationValidate {

    public String message() default "Location is Wrong !! it is either GACHIBOWLI or HI-TECH ";
    Class<?>[] groups() default { };

    Class<? extends Payload>[] payload() default { };
}
