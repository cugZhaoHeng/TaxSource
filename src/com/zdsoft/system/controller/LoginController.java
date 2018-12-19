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
	 * ��¼��֤�ķ�������ǰ�˽��մ��ݹ������û��������룬�Զ���ķ�ʽ���棬Ȼ����dao��������ݿ��ж�
	 * ����ɹ������û������浽session��
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
			map.put("msg", "��¼ʧ��");
		} else {
			map.put("success", true);
			map.put("msg", "��¼�ɹ�");
			session.setAttribute("userName", userBean.getUserName());
		}
		return map;
	}
	
	@RequestMapping("/checkcaptcha.do")
	public @ResponseBody Map<String, Object> checkCaptcha(String captcha, HttpSession session) {
		Map<String, Object> map = new HashMap<String, Object>();
		//��session�л�ȡϵͳ�Զ����ɵ���֤��
		String sysCaptcha = session.getAttribute("KAPTCHA_SESSION_KEY").toString();
		if(captcha.equalsIgnoreCase(sysCaptcha)) {
			map.put("success", true);
			map.put("msg", "��֤����ȷ");
		} else {
			map.put("success", false);
			map.put("msg", "��֤�����");
		}
		return map;
	}
}
