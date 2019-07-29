package com.daniel.userservice.client.hystrix;

import com.daniel.userservice.client.AuthServiceClient;
import com.daniel.userservice.model.JWT;
import org.springframework.stereotype.Component;

/**
 * @Author: Daniel
 * @Date: 2019/7/29 19:36
 */
@Component
public class AuthServiceHystrix implements AuthServiceClient {

    @Override
    public JWT getToken(String authorization, String type, String username, String password) {
        return null;
    }
}
