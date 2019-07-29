package com.daniel.userservice.service;

import com.daniel.userservice.client.AuthServiceClient;
import com.daniel.userservice.dao.UserDao;
import com.daniel.userservice.dto.UserLoginDTO;
import com.daniel.userservice.exception.UserLoginException;
import com.daniel.userservice.model.JWT;
import com.daniel.userservice.model.User;
import com.daniel.userservice.utils.BPwdEncoderUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 * @Author: Daniel
 * @Date: 2019/7/29 10:06
 */
@Service
public class UserServiceDetail implements UserDetailsService {

    @Autowired
    private UserDao userRepository;

    @Autowired
    AuthServiceClient client;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return userRepository.findByUsername(username);
    }

    public User insertUser(String username, String password){
        User user = new User();
        user.setUsername(username);
        user.setPassword(BPwdEncoderUtil.BCryptPassword(password));
        return userRepository.save(user);
    }

    public UserLoginDTO login(String username, String password){
        //check
        User user = userRepository.findByUsername(username);
        if (user == null){
            throw new RuntimeException("error username");
        }
        if (!BPwdEncoderUtil.matches(password, user.getPassword())){
            throw new RuntimeException("error password");
        }

        //get token
        JWT jwt=client.getToken("Basic dXNlci1zZXJ2aWNlOjEyMzQ1Ng==","password",username,password);
        if (jwt ==null){
            throw new UserLoginException("error internal");
        }

        UserLoginDTO userLoginDTO = new UserLoginDTO();
        userLoginDTO.setJwt(jwt);
        userLoginDTO.setUser(user);

        return userLoginDTO;
    }

}
