package com.example.service.service;

import com.example.dao.dao.userDao;
import com.example.entity.entity.User;

import com.example.entity.entity.UserDetailed;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * author:@song;
 * version:1.0;
 */
@Service
public class UserviceImpl implements UserService{
    @Autowired
    private userDao userDao;
    @Override
    public String setUser(User user) {
        String s = userDao.setUser(user);
        return s;
    }
    @Override
    public User getUser(User user) {
        User s = userDao.getUser(user);
        return s;
    }
    @Override
    public UserDetailed selectUserDetailed(User user){
        UserDetailed userDetailed = userDao.selectUserDetailed(user);
        return userDetailed;
    }
}
