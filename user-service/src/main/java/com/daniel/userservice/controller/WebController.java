package com.daniel.userservice.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

/**
 * @Author: Daniel
 * @Date: 2019/7/29 19:55
 */
@RestController
@RequestMapping("foo")
public class WebController {

    @GetMapping
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    public String getFoo(){
        return "i'm foo, " + UUID.randomUUID().toString();
    }

}
