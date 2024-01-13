package com.product.service;

import com.product.dto.UserRegisterRequest;
import com.product.model.User;

public interface UserService {


    User getUserById(Integer userId);
    Integer register(UserRegisterRequest userRegisterRequest);

    User getUserByEmail(String email);
}
