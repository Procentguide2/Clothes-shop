package com.shop.e_shop.controller;

import com.shop.e_shop.model.EmailWrapper;
import com.shop.e_shop.model.User;
import com.shop.e_shop.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin
@RestController
public class UserController {

    @Autowired
    UserService userService;

    @PostMapping("/user/register")
    public void userRegistration(@RequestBody User user){
        userService.saveUser(user);
    }

    @PostMapping("/user/get/email")
    public int getUserIdByEmail(@RequestBody EmailWrapper emailWrapper){
        User user = userService.findUserByEmail(emailWrapper.getEmail());
        return user.getId();
    }

}
