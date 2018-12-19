package com.zdsoft.manage.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.zdsoft.manage.dao.IndustryDao;
import com.zdsoft.manage.entity.IndustryBean;

@Service
public class IndustryService {
	@Resource
	IndustryDao industryDao;
	
	public List<IndustryBean> queryAllIndustry() {
		return industryDao.queryAllIndustry();
	}
}
