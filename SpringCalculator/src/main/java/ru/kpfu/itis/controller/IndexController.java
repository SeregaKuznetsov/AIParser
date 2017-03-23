package ru.kpfu.itis.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.kpfu.itis.model.Calculator;

@Controller
public class IndexController {

    @RequestMapping(value = "/")
    public String getIndexPage() {
        return "index";
    }

}
