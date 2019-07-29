package com.daniel.userservice.dto;

import com.daniel.userservice.model.JWT;
import com.daniel.userservice.model.User;

/**
 * @Author: Daniel
 * @Date: 2019/7/29 19:40
 */
public class UserLoginDTO {

    private JWT jwt;

    private User user;

    public JWT getJwt() {
        return jwt;
    }

    public void setJwt(JWT jwt) {
        this.jwt = jwt;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
