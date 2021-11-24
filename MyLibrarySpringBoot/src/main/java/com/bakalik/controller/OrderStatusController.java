package com.bakalik.controller;

import com.bakalik.domain.Category;
import com.bakalik.domain.OrderStatus;
import com.bakalik.service.CategoryService;
import com.bakalik.service.GeneralService;
import com.bakalik.service.OrderStatusService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@AllArgsConstructor
@RestController
@RequestMapping("/orderStatus")
public class OrderStatusController extends GeneralController<OrderStatus, Integer> {
    @Autowired
    public OrderStatusService orderStatusService;

    @Override
    protected GeneralService<OrderStatus, Integer> getService() {
        return orderStatusService;
    }
}
