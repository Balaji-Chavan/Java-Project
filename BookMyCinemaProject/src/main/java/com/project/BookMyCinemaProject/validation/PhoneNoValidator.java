package com.project.BookMyCinemaProject.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PhoneNoValidator implements ConstraintValidator<PhoneNoValidate ,String> {

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        if(value == null || value.isEmpty())
            return false;


        Pattern p = Pattern.compile("[7-9][0-9]{9}");
        Matcher m = p.matcher(value);

        return  m.find();
    }
}
