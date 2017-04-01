package ru.kpfu.itis.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import org.springframework.web.bind.annotation.RequestMapping;

import ru.kpfu.itis.service.CalcService;


@Controller
@RequestMapping(value = "/history")
public class HistoryController {


    @Autowired
    CalcService calcService;


    @RequestMapping(value = "/")
    public String getHist(Model model) {

        model.addAttribute("history", calcService.getHistory());
        return "history";
    }


}
