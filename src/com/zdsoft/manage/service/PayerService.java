package com.zdsoft.manage.service;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.zdsoft.manage.dao.PayerDao;
import com.zdsoft.manage.entity.PayerBean;

@Service
public class PayerService {
	@Resource
	PayerDao payerDao;
	
	public List<Map<String, String>> queryPayer(String payerCode, String payerName, Integer page, Integer rows) {
		List<Map<String, String>> queryPayer = payerDao.queryPayer(payerCode, payerName, (page-1)*rows, rows);
		System.out.println();
		return queryPayer;
	}
	
	public int getTotal(String payerCode, String payerName) {
		return payerDao.getTotal(payerCode, payerName);
	}
	
	public List<Map<String, Object>> queryAllPayer() {
		return payerDao.queryAllPayer();
	}
	
	public int removePayerById(Integer id) {
		return payerDao.removePayerById(id);
	}
	
	public int editPayer(PayerBean payerBean) {
		return payerDao.editPayer(payerBean);
	}
	
	public int addPayer(PayerBean payerBean) {
		return payerDao.addPayer(payerBean);
	}
}
