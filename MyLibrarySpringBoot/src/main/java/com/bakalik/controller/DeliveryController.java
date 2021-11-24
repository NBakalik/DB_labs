package com.bakalik.controller;

import com.bakalik.domain.Category;
import com.bakalik.domain.Delivery;
import com.bakalik.service.CategoryService;
import com.bakalik.service.DeliveryService;
import com.bakalik.service.GeneralService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@AllArgsConstructor
@RestController
@RequestMapping("/delivery")
public class DeliveryController extends GeneralController<Delivery, Integer> {
    @Autowired
    public DeliveryService deliveryService;

    @Override
    protected GeneralService<Delivery, Integer> getService() {
        return deliveryService;
    }
}
