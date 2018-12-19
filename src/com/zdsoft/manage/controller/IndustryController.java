package com.zdsoft.manage.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.zdsoft.manage.entity.IndustryBean;
import com.zdsoft.manage.service.IndustryService;

@Controller
public class IndustryController {
	@Resource
	IndustryService industryService;
	
	@RequestMapping("/getIndustry.do")
	public @ResponseBody List<IndustryBean> queryAllIndustry() {
		return industryService.queryAllIndustry();
	}
}
