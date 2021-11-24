package com.bakalik.controller;

import com.bakalik.domain.Category;
import com.bakalik.domain.Region;
import com.bakalik.service.CategoryService;
import com.bakalik.service.GeneralService;
import com.bakalik.service.RegionService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@AllArgsConstructor
@RestController
@RequestMapping("/region")
public class RegionController extends GeneralController<Region, Integer> {
    @Autowired
    public RegionService regionService;

    @Override
    protected GeneralService<Region, Integer> getService() {
        return regionService;
    }
}
