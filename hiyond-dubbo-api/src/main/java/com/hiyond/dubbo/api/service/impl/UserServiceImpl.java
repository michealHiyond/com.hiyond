package com.hiyond.dubbo.api.service.impl;

import com.hiyond.dubbo.api.service.UserService;
import com.hiyond.entity.User;

import java.util.Date;

/**
 * Created by hiyond on 2016/9/2.
 */
public class UserServiceImpl implements UserService {
    @Override
    public User test(String e) {
        User user = new User();
        user.setName(e);
        user.setLastLoginTime(new Date());
        return user;
    }
}
