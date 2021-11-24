package com.bakalik.controller;

import com.bakalik.domain.Category;
import com.bakalik.domain.City;
import com.bakalik.service.CategoryService;
import com.bakalik.service.CityService;
import com.bakalik.service.GeneralService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@AllArgsConstructor
@RestController
@RequestMapping("/city")
public class CityController extends GeneralController<City, Integer> {
    @Autowired
    public CityService cityService;

    @Override
    protected GeneralService<City, Integer> getService() {
        return cityService;
    }
}
