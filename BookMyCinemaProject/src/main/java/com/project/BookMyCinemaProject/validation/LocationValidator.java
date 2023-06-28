package com.project.BookMyCinemaProject.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.List;

public class LocationValidator implements ConstraintValidator<LocationValidate,String> {

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        if(value == null || value.isEmpty()){
            return false;
        }
        List<String> locationList = List.of("GACHIBOWLI", "HI-TECH");
        value = value.toUpperCase();
        return locationList.contains(value);
    }
}

