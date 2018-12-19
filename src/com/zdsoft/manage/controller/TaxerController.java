package com.zdsoft.manage.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.zdsoft.manage.entity.TaxerBean;
import com.zdsoft.manage.service.TaxerService;

@Controller
public class TaxerController {
	@Resource
	TaxerService taxerService;
	
	@RequestMapping("/getTaxer.do")
	public @ResponseBody List<TaxerBean> queryAllTaxer() {
		return taxerService.queryAllTaxer();
	}
}
