package com.zdsoft.system.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.zdsoft.system.entity.UserBean;
import com.zdsoft.system.service.UserService;

@Controller
public class UserController {
	@Resource
	UserService userService;
	
	@RequestMapping("/getUser.do")
	public @ResponseBody List<UserBean> queryAllUser() {
		return userService.queryAllUser();
	}
	
	@RequestMapping("/getUserByUserName.do")
	public @ResponseBody UserBean queryUserByUserName(String userName) {
		UserBean userBean = userService.queryUserByUserName(userName);
		return userBean;
	}
}
