package com.blackbox.springsecurity.demo.dao;

import com.blackbox.springsecurity.demo.entity.User;

public interface UserDao {

    public User findByUserName(String userName);
    
    public void save(User user);
    
}
