package com.zdsoft.manage.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.zdsoft.manage.dao.OrganDao;
import com.zdsoft.manage.entity.OrganBean;
@Service
public class OrganService {
	@Resource
	OrganDao organDao; 
	
	public List<OrganBean> queryAllOrgan() {
		return organDao.queryAllOrgan();
	}
}
