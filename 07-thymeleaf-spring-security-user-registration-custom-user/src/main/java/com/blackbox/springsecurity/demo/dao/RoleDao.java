package com.blackbox.springsecurity.demo.dao;

import com.blackbox.springsecurity.demo.entity.Role;

public interface RoleDao {

	public Role findRoleByName(String theRoleName);
	
}
