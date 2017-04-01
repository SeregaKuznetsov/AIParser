package ru.kpfu.itis.model;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by Sergey on 18.03.2017.
 */

@Entity
@Table(name = "itis-test")
public class Calculator {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String firstOperand;
    private String secondOperand;
    private String mathAction;
    private Date date;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

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