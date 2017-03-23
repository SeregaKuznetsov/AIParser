package ru.kpfu.itis.service.impl;

import org.springframework.stereotype.Service;
import ru.kpfu.itis.model.Calculator;
import ru.kpfu.itis.service.CalcService;

/**
 * Created by Sergey on 19.03.2017.
 */

@Service
public class CalcServiceImpl implements CalcService {

    String result;

    @Override
    public double addition(double a, double b) {
        return a+b;
    }

    @Override
    public double division(double a, double b) {
        return a/b;
    }

    @Override
    public double subtraction(double a, double b) {
        return a-b;
    }

    @Override
    public double multiplication(double a, double b) {
        return a*b;
    }

    @Override
    public String getResult() {
        return result;
    }


    @Override
    public void calculate(Calculator calculator) {

        String firstOperand = calculator.getFirstOperand();
        String secondOperand = calculator.getSecondOperand();
        String mathAction = calculator.getMathAction();

        if (mathAction.equals("addition")) {
             result = Double.toString(addition(Double.parseDouble(firstOperand), Double.parseDouble(secondOperand)));
            System.out.println("additional result" + result);
        } else if (mathAction.equals("subtraction") && !secondOperand.equals("0")) {
            result = Double.toString(subtraction(Double.parseDouble(firstOperand), Double.parseDouble(secondOperand)));
        } else if (mathAction.equals("multiplication")) {
            result = Double.toString(multiplication(Double.parseDouble(firstOperand), Double.parseDouble(secondOperand)));
        } else if (mathAction.equals("division")) {
            result = Double.toString(division(Double.parseDouble(firstOperand), Double.parseDouble(secondOperand)));
        }
    }


}
