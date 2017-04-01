package ru.kpfu.itis.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import ru.kpfu.itis.model.Calculator;
import ru.kpfu.itis.service.CalcService;
import ru.kpfu.itis.util.CalcFormValidator;

/**
 * Created by Sergey on 18.03.2017.
 */

@Controller
@RequestMapping(value = "/calculator")
public class CalcController {

    @Autowired
    CalcService calcService;

    CalcFormValidator validator = new CalcFormValidator();

    @RequestMapping(value = "/")
    public String addUser(Model model) {
        Calculator calculator = new Calculator();
        model.addAttribute("calculator", calculator);
        model.addAttribute("summa", calcService.getResult());
        return "calculator";
    }

    @RequestMapping(value = "/operate", method = RequestMethod.POST)
    public String calculate(@ModelAttribute Calculator calculator, BindingResult result) {

        /*System.out.println(calculator.getFirstOperand());
        System.out.println(calculator.getSecondOperand());
        System.out.println(calculator.getMathAction());*/

        validator.validate(calculator, result);
        if (result.hasErrors()) {
            return "calculator";
        } else {
            calcService.calculate(calculator);
            calcService.saveOperation(calculator);
            System.out.println("result after calc" + calcService.getResult());
            return "redirect:/calculator/";
        }
    }


}