package com.itzixi.controller;


import com.itzixi.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

/**
 * 
 * @Title: UserController.java
 * @Package com.itzixi.web.controller
 * @Description: 用户 controller
 * Copyright: Copyright (c) 2016
 * Company:FURUIBOKE.SCIENCE.AND.TECHNOLOGY
 * 
 * @author leechenxiang
 * @date 2017年9月5日 下午2:10:15
 * @version V1.0
 */
@Controller
@RequestMapping("/user")
public class UserController extends com.itzixi.controller.BaseController {
	
	final static Logger log = LoggerFactory.getLogger(UserController.class);
	
	@Autowired
	private UserService userService;
	
	/**
	 * 
	 * @Description: 打开新增用户页面
	 * @param userId
	 * @param request
	 * @return
	 * 
	 * @author leechenxiang
	 * @date 2017年9月5日 下午3:31:42
	 */
	@RequestMapping("/hello")
	public ModelAndView hello(String userId, HttpServletRequest request){
		
		ModelAndView mv = new ModelAndView("index");
		return mv;
	}

}
