package com.bakalik.controller;

import com.bakalik.domain.Category;
import com.bakalik.domain.User;
import com.bakalik.service.CategoryService;
import com.bakalik.service.GeneralService;
import com.bakalik.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@AllArgsConstructor
@RestController
@RequestMapping("/user")
public class UserController extends GeneralController<User, Integer> {
    @Autowired
    public UserService userService;

    @Override
    protected GeneralService<User, Integer> getService() {
        return userService;
    }
}
