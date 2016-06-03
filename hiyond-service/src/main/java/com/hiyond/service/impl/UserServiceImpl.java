package com.hiyond.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hiyond.dao.mapper.UserMapper;
import com.hiyond.service.UserService;

import entity.User;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserMapper userDao;

	@Override
	public User loginUser(User user) throws Exception {
		return userDao.loginUser(user);
	}

	@Override
	public void insertUser(User user) throws Exception {
		userDao.insertUser(user);
	}

	@Override
	public void updateUser(User user) throws Exception {
		userDao.updateUser(user);
	}

	@Override
	public int findUserByName(String userName) throws Exception {
		return userDao.findUserByName(userName);
	}


}
