package com.zdsoft.manage.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.zdsoft.manage.dao.TaskDao;
import com.zdsoft.manage.entity.TaskBean;

@Service
public class TaskService {
	@Resource
	TaskDao taskDao;
	
	public List<TaskBean> queryTask(String payerCode, String payerName, Integer organId, Integer industryId, String startDate, String endDate, int page, int rows) {
		return taskDao.queryTask(payerCode, payerName, organId, industryId, startDate, endDate, (page-1)*rows, rows);
	}
	
	public int getTaskCount() {
		return taskDao.getTaskCount();
	}
}
