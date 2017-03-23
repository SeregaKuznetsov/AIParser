package ru.kpfu.itis.model;

/**
 * Created by Sergey on 18.03.2017.
 */
public class Calculator {

    private String firstOperand;
    private String secondOperand;
    private String mathAction;

    public String getSumma() {
        return summa;
    }

    public void setSumma(String summa) {
        this.summa = summa;
    }

    private String summa;

    public Calculator() {
    }

    public Calculator(String firstOperand, String secondOperand, String mathAction) {
        this.firstOperand = firstOperand;
        this.secondOperand = secondOperand;
        this.mathAction = mathAction;
        this.summa = summa;
    }

    public String getMathAction() {
        return mathAction;
    }

    public void setMathAction(String mathAction) {
        this.mathAction = mathAction;
    }

    public String getFirstOperand() {
        return firstOperand;

    }

    public void setFirstOperand(String firstOperand) {
        this.firstOperand = firstOperand;
    }

    public String getSecondOperand() {
        return secondOperand;
    }

    public void setSecondOperand(String secondOperand) {
        this.secondOperand = secondOperand;
    }
}
