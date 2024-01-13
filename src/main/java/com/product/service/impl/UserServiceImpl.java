package com.product.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ResponseStatusException;

import com.product.dao.UserDao;
import com.product.dto.UserRegisterRequest;
import com.product.model.User;
import com.product.service.UserService;

@Component
public class UserServiceImpl implements UserService {

	private final static Logger log = LoggerFactory.getLogger(UserServiceImpl.class);

	@Autowired
	private UserDao userDao;

	@Override
	public User getUserById(Integer userId) {
		return userDao.getUserById(userId);
	}

	@Override
	public Integer register(UserRegisterRequest userRegisterRequest) {
//		確認email是否已經被註冊
		User user = userDao.getUserByEmail(userRegisterRequest.getEmail());

		if (user != null) {
			log.warn("此 email {} 註冊過了!", userRegisterRequest.getEmail());
			System.out.println("有註冊過了!");
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
		}

		return userDao.createrUser(userRegisterRequest);
	}

}
