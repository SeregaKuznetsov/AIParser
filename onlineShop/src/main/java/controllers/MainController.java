package controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import service.ItemService;
import service.UserService;

@Controller
public class MainController {
    @Autowired
    UserService userService;
    @Autowired
    ItemService itemService;

    @RequestMapping(value = "/")
    public String mainPage(Model model) {
        model.addAttribute("items", itemService.getAllItems());
        return "welcome";
    }
    @RequestMapping(value = "/forbidden")
    public String forbiddenPage(){
        return "forbidden";
    }
}
