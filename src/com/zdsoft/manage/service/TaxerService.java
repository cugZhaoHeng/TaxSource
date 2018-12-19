package com.zdsoft.manage.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.zdsoft.manage.dao.TaxerDao;
import com.zdsoft.manage.entity.TaxerBean;

@Service
public class TaxerService {
	@Resource
	TaxerDao taxerDao;
	
	public List<TaxerBean> queryAllTaxer() {
		return taxerDao.queryAllTaxer();
	}
}
