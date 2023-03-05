package com.example.seti.controller;

import com.example.seti.entity.Order;
import com.example.seti.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/test/jwt")
public class Controller {

    @Autowired
    private OrderService orderService;

    @GetMapping("/")
    public List<Order> getAll(HttpServletRequest request) {
        return orderService.getOrders(request.getAttribute("role").toString());
    }

}
