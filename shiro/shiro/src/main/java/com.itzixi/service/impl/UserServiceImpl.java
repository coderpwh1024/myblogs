package com.itzixi.service.impl;

import com.itzixi.mapper.SysUserMapper;
import com.itzixi.pojo.SysUser;
import com.itzixi.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	private SysUserMapper userMapper;

	@Override
	public void saveUser(SysUser user) {
		
	}

}
