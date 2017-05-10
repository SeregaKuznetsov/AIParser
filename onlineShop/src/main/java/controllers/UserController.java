package controllers;

import annotation.Logging;
import form.UserRegistrationForm;
import model.Item;
import model.ItemsInOrder;
import model.Order;
import model.User;
import model.enums.ItemStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import repository.ItemInOrderRepository;
import service.ItemService;
import service.OrderService;
import service.StockService;
import service.UserService;

import javax.validation.Valid;
import java.util.List;

/**
 * Created by admin on 27.04.2017.
 */
@Controller
public class UserController {

    @Autowired
    private UserService userService;
    @Autowired
    private ItemService itemService;
    @Autowired
    private OrderService orderService;
    @Autowired
    private ItemInOrderRepository itemInOrderRepository;

    @RequestMapping(value = "/sign_in")
    public String getLoginPage(@RequestParam(value = "error", required = false) Boolean error, Model model) {
        if (Boolean.TRUE.equals(error)) {
            model.addAttribute("error", error);
        }
        return "sign_in";
    }
    @Logging
    @RequestMapping(value = "/sign_up", method = RequestMethod.GET)
    public String getRegistrationPage(Model model) {
        model.addAttribute("userform", new UserRegistrationForm());
        return "sign_up";
    }
    @Logging
    @RequestMapping(value = "/sign_up", method = RequestMethod.POST)
    public String registerUser(@ModelAttribute("userform") @Valid UserRegistrationForm form, BindingResult bindingResult, ModelMap modelMap) {
        if (bindingResult.hasErrors()){
            modelMap.addAttribute("error", bindingResult.getAllErrors());
            return "sign_up";
        }
        userService.saveNewUser(form);
        return "redirect:/";
    }

    @RequestMapping(value = "/add_inOrder")
    private String addItemInOrder(Model model, @RequestParam("id") String param){
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        Item item = itemService.findOneById(Integer.valueOf(param));
        Order order = new Order(user, ItemStatus.STATUS_START);
        ItemsInOrder itemsInOrder = new ItemsInOrder();
        itemsInOrder.setItem(item);
        itemsInOrder.setOrder(order);
        orderService.save(order);
        orderService.saveItemInOrder(itemsInOrder);
        model.addAttribute("item", item);
        return "add_inOrder";
    }

    @RequestMapping(value = "/order")
    private String getOrder(ModelMap model){
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        int userId = user.getId();
        List<ItemsInOrder> itemsInOrders = itemInOrderRepository.getItemsInOrdersByOrderUserId(userId);
        //List<Order> orders = orderService.findAllByUserId(userId);
        //itemInOrderRepository.getItemsInOrderByOrderId()
        model.addAttribute("itemsInOrders", itemsInOrders);
        return "order";
    }

    @RequestMapping(value = "/buy")
    private String buy(Model model){
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        int userId = user.getId();
        List<Order> orders = orderService.findAllByUserId(userId);
        for (Order order : orders) {
            order.setStatus(ItemStatus.STATUS_FORM);
            orderService.save(order);
        }
        List<ItemsInOrder> itemsInOrders = itemInOrderRepository.getItemsInOrdersByOrderUserId(userId);
        model.addAttribute("itemsInOrders", itemsInOrders);
        return "order";
    }
}
