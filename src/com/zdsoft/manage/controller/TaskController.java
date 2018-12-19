package com.zdsoft.manage.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.zdsoft.manage.entity.TaskBean;
import com.zdsoft.manage.service.TaskService;

@Controller
public class TaskController {
	@Resource
	TaskService taskService;
	
	@RequestMapping("/listTask.do")
	public @ResponseBody Map<String, Object> queryTask(String payerCode, String payerName, Integer organId, Integer industryId, String startDate, String endDate, int page, int rows) {
		List<TaskBean> list = taskService.queryTask(payerCode, payerName, organId, industryId, startDate, endDate, page, rows);
		int total = taskService.getTaskCount();
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("rows", list);
		map.put("total", total);
		return map;
	}
}
