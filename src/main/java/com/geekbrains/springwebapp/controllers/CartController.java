package com.geekbrains.springwebapp.controllers;

import com.geekbrains.springwebapp.entities.Order;
import com.geekbrains.springwebapp.entities.User;
import com.geekbrains.springwebapp.services.OrderService;
import com.geekbrains.springwebapp.services.UserService;
import com.geekbrains.springwebapp.utils.ShoppingCart;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.security.Principal;
import java.util.ArrayList;

@Controller
@RequestMapping("/cart")
public class CartController {
    private ShoppingCart cart;
    private OrderService orderService;
    private UserService userService;

    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    @Autowired
    public void setOrderService(OrderService orderService) {
        this.orderService = orderService;
    }

    @Autowired
    public void setCart(ShoppingCart cart) {
        this.cart = cart;
    }

    @GetMapping("")
    public String showCart(Model model){
        model.addAttribute("items", cart.getItems());
        return "cart";
    }

    @GetMapping("/add/{id}")
    public String addProductToCart(Model model, @PathVariable("id") Long id){
        cart.addProductById(id);
        return "redirect:/shop";
    }

    @GetMapping("/create_order")
    public String createOrder(Principal principal){

        User user = userService.findByUsername(principal.getName());
        orderService.createOrderFromItems(user, cart.getItems());
        return "redirect:/shop";
    }


}
