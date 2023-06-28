package com.project.BookMyCinemaProject.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.time.LocalDate;

public class DateValidator implements ConstraintValidator<DateValidate, LocalDate> {

    @Override
    public boolean isValid(LocalDate value, ConstraintValidatorContext context) {
        LocalDate d = LocalDate.now();

        int a1=   d.getDayOfYear();
        int a2 = 365-value.getDayOfYear();


        int year =d.getYear()- value.getYear()-1;

        year = year+((a1+a2)/365);
        int rem =(a1+a2)%365;
        if(year==18 && rem >0)
            return true;

        if(year>18)
            return  true;

        return false;
    }
}
