package com.bakalik.controller;

import com.bakalik.domain.Category;
import com.bakalik.domain.SubCategory;
import com.bakalik.service.CategoryService;
import com.bakalik.service.GeneralService;
import com.bakalik.service.SubCategoryService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@AllArgsConstructor
@RestController
@RequestMapping("/subCategory")
public class SubCategoryController extends GeneralController<SubCategory, Integer> {
    @Autowired
    public SubCategoryService subCategoryService;

    @Override
    protected GeneralService<SubCategory, Integer> getService() {
        return subCategoryService;
    }
}
