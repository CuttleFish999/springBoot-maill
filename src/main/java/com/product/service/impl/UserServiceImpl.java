package com.product.service.impl;

import com.product.dao.UserDao;
import com.product.dto.UserRegisterRequest;
import com.product.model.User;
import com.product.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
public class UserServiceImpl implements UserService {


    @Autowired
    private UserDao userDao;

    @Override
    public User getUserById(Integer userId) {
        return userDao.getUserById(userId);
    }

    @Override
    public Integer register(UserRegisterRequest userRegisterRequest) {
        return userDao.createrUser(userRegisterRequest);
    }
}
