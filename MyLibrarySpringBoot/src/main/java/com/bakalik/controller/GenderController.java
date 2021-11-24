package com.bakalik.controller;

import com.bakalik.domain.Category;
import com.bakalik.domain.Gender;
import com.bakalik.service.CategoryService;
import com.bakalik.service.GenderService;
import com.bakalik.service.GeneralService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@AllArgsConstructor
@RestController
@RequestMapping("/gender")
public class GenderController extends GeneralController<Gender, Integer> {
    @Autowired
    public GenderService genderService;

    @Override
    protected GeneralService<Gender, Integer> getService() {
        return genderService;
    }
}
