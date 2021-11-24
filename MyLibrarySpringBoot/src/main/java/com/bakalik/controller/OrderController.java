package com.bakalik.controller;

import com.bakalik.domain.Category;
import com.bakalik.domain.Order;
import com.bakalik.service.CategoryService;
import com.bakalik.service.GeneralService;
import com.bakalik.service.OrderService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@AllArgsConstructor
@RestController
@RequestMapping("/order")
public class OrderController extends GeneralController<Order, Integer> {
    @Autowired
    public OrderService orderService;

    @Override
    protected GeneralService<Order, Integer> getService() {
        return orderService;
    }
}
