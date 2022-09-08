package com.example.service.service;

import com.example.entity.entity.User;
import com.example.entity.entity.UserDetailed;



/**
 * author:@song;
 * version:1.0;
 */
public interface UserService {
    public String setUser(User user);
    public User getUser(User user);
    public UserDetailed selectUserDetailed(User user);
}
