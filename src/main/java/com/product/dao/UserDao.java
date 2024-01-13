package com.product.dao;

import com.product.dto.UserRegisterRequest;
import com.product.model.User;

public interface UserDao {

    User getUserById(Integer userId);
    
    User getUserByEmail(String email);
    
    Integer createrUser(UserRegisterRequest userRegisterRequest);
    
    
}
