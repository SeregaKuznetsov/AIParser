package ru.kpfu.itis.util;


import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import ru.kpfu.itis.model.Calculator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CalcFormValidator implements Validator {

    static Pattern p = Pattern.compile("[-+]?[0-9]*\\.?[0-9]+([eE][-+]?[0-9]+)?");

    @Override
    public boolean supports(Class<?> aClass) {
        return Calculator.class.equals(aClass);
    }

    @Override
    public void validate(Object o, Errors errors) {
        Calculator calculator = (Calculator) o;

/*        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "firstOperand", "Поле не может быть пустым");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "secondOperand", "Поле не может быть пустым");*/

        Matcher m = p.matcher(calculator.getFirstOperand());

        if (!m.matches()) {
            errors.rejectValue("firstOperand", "", "Тут можно только цифру");
        }

        m = p.matcher(calculator.getSecondOperand());

        if (!m.matches()) {
            errors.rejectValue("secondOperand", "", "Тут можно только цифру");
        }

    }
}
