package com.example.seti.service;

import com.example.seti.entity.Order;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class OrderService {


    public List<Order> getOrders(String role) {

        List<Order> allOrders = new ArrayList<>();
        Order order1 = new Order();
        order1.setLabel("Label 1");
        order1.setDate(new Date());
        order1.setAmount(100L);
        order1.setDescription("Descirption 1");
        order1.setId(1L);

        Order order2 = new Order();
        order2.setLabel("Label 2");
        order2.setDate(new Date());
        order2.setAmount(200L);
        order2.setDescription("Descirption 2");
        order2.setId(2L);

        Order order3 = new Order();
        order3.setLabel("Label 3");
        order3.setDate(new Date());
        order3.setAmount(300L);
        order3.setDescription("Descirption 3");
        order3.setId(3L);

        allOrders.add(order1);
        allOrders.add(order2);
        allOrders.add(order3);

        if (role.equals("admin")) {
            return allOrders;
        } else {
            return allOrders.subList(0, 1);
        }
    }


}
