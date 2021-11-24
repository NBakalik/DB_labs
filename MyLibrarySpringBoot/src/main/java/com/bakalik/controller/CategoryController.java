package com.bakalik.controller;

import com.bakalik.domain.Category;
import com.bakalik.service.CategoryService;
import com.bakalik.service.GeneralService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@AllArgsConstructor
@RestController
@RequestMapping("/category")
public class CategoryController extends GeneralController<Category, Integer> {
    @Autowired
    public CategoryService categoryService;

    @Override
    protected GeneralService<Category, Integer> getService() {
        return categoryService;
    }
}
