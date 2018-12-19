package com.zdsoft.system.controller;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.zdsoft.system.entity.UserBean;
import com.zdsoft.system.service.UserService;

@Controller
public class LoginController {
	@Resource
	UserService userService;
	
	/**
	 * 登录验证的方法，从前端接收传递过来的用户名和密码，以对象的方式保存，然后在dao层进行数据库判断
	 * 如果成功，则将用户名保存到session中
	 * @param userBean
	 * @param session
	 * @return
	 */
	@RequestMapping("/login.do")
	public @ResponseBody Map<String, Object> login(UserBean userBean, HttpSession session) {
		Map<String, Object> map = new HashMap<String, Object>();
		UserBean userBean2 = userService.queryUserByUserName(userBean.getUserName());
		if(userBean2==null) {
			map.put("success", false);
			map.put("msg", "登录失败");
		} else {
			map.put("success", true);
			map.put("msg", "登录成功");
			session.setAttribute("userName", userBean.getUserName());
		}
		return map;
	}
	
	@RequestMapping("/checkcaptcha.do")
	public @ResponseBody Map<String, Object> checkCaptcha(String captcha, HttpSession session) {
		Map<String, Object> map = new HashMap<String, Object>();
		//从session中获取系统自动生成的验证码
		String sysCaptcha = session.getAttribute("KAPTCHA_SESSION_KEY").toString();
		if(captcha.equalsIgnoreCase(sysCaptcha)) {
			map.put("success", true);
			map.put("msg", "验证码正确");
		} else {
			map.put("success", false);
			map.put("msg", "验证码错误");
		}
		return map;
	}
}
