package com.itzixi.service;


import com.itzixi.pojo.SysUser;

/**
 * 
 * @Title: UserService.java
 * @Package com.itzixi.service
 * @Description: 处理用户的service
 * Copyright: Copyright (c) 2016
 * Company:FURUIBOKE.SCIENCE.AND.TECHNOLOGY
 * 
 * @author leechenxiang
 * @date 2017年9月5日 上午11:07:39
 * @version V1.0
 */
public interface UserService {

	/**
	 * 
	 * @Description: 保存用户
	 * @param user
	 * 
	 * @author leechenxiang
	 * @date 2017年9月5日 上午11:13:38
	 */
	public void saveUser(SysUser user);
	
}
