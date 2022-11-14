package com.shop.e_shop.controller;

import com.shop.e_shop.model.EmailWrapper;
import com.shop.e_shop.model.User;
import com.shop.e_shop.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@CrossOrigin
@RestController
public class UserController {

    @Autowired
    UserService userService;

    @PostMapping("/user/register")
    public ResponseEntity<String> userRegistration(@RequestBody User user){
        Optional<User> foundUser = Optional.ofNullable(userService.findUserByEmail(user.getEmail()));
        if (foundUser.isPresent()){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        user.setIsAdmin("0");
        userService.saveUser(user);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PostMapping("/user/get/email")
    public int getUserIdByEmail(@RequestBody EmailWrapper emailWrapper){
        User user = userService.findUserByEmail(emailWrapper.getEmail());
        return user.getId();
    }

}
