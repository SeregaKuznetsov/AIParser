package ru.kpfu.itis.service;

import ru.kpfu.itis.model.Calculator;

/**
 * Created by Sergey on 19.03.2017.
 */
public interface CalcService {

    double addition(double a, double b);
    double division(double a, double b);
    double subtraction(double a, double b);
    double multiplication(double a, double b);

    String getResult();

    void calculate(Calculator calculator);

}
