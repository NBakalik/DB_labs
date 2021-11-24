package com.bakalik.controller;

import com.bakalik.domain.Category;
import com.bakalik.domain.Item;
import com.bakalik.service.CategoryService;
import com.bakalik.service.GeneralService;
import com.bakalik.service.ItemService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@AllArgsConstructor
@RestController
@RequestMapping("/item")
public class ItemController extends GeneralController<Item, Integer> {
    @Autowired
    public ItemService itemService;

    @Override
    protected GeneralService<Item, Integer> getService() {
        return itemService;
    }
}
