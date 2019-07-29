package com.daniel.userservice.controller;

import com.daniel.userservice.dto.UserLoginDTO;
import com.daniel.userservice.model.User;
import com.daniel.userservice.service.UserServiceDetail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: Daniel
 * @Date: 2019/7/29 19:21
 */
@RestController
@RequestMapping("user")
public class UserController {

    @Autowired
    UserServiceDetail userServiceDetail;

    @PostMapping("register")
    public User postUser(@RequestParam("username") String username,
                         @RequestParam("password") String password){
        return userServiceDetail.insertUser(username, password);
    }

    @PostMapping("login")
    public UserLoginDTO login(@RequestParam("username") String username,
                              @RequestParam("password") String password){
        return userServiceDetail.login(username,password);
    }

}
