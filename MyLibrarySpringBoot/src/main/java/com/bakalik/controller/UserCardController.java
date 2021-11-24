package com.bakalik.controller;

import com.bakalik.domain.Category;
import com.bakalik.domain.UserCard;
import com.bakalik.service.CategoryService;
import com.bakalik.service.GeneralService;
import com.bakalik.service.UserCardService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@AllArgsConstructor
@RestController
@RequestMapping("/userCard")
public class UserCardController extends GeneralController<UserCard, Integer> {
    @Autowired
    public UserCardService userCardService;

    @Override
    protected GeneralService<UserCard, Integer> getService() {
        return userCardService;
    }
}
