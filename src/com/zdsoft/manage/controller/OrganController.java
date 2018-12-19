package com.zdsoft.manage.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.zdsoft.manage.entity.OrganBean;
import com.zdsoft.manage.service.OrganService;

@Controller
public class OrganController {
	@Resource
	OrganService organService;
	
	@RequestMapping("/getOrgan.do")
	public @ResponseBody List<OrganBean> queryAllOrgan() {
		List<OrganBean> allOrgan = organService.queryAllOrgan();
		return allOrgan;
	}
}
