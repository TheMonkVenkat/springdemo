package com.blackbox.springsecurity.demo.service;

import org.springframework.security.core.userdetails.UserDetailsService;

import com.blackbox.springsecurity.demo.entity.User;
import com.blackbox.springsecurity.demo.user.CrmUser;

public interface UserService extends UserDetailsService {

	public User findByUserName(String userName);

	public void save(CrmUser crmUser);
}
