package com.zdsoft.manage.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.zdsoft.manage.entity.PayerBean;
import com.zdsoft.manage.service.PayerService;

@Controller
public class PayerContrller {
	@Resource
	PayerService payerService;
	
	/**
	 * ǰ��ͨ��easyUI����4��������������߾�Ҫ��4���������գ�
	 * ������������page��rows����ʽ�Ĵ��ݣ�ͨ��datagrid��ȷ���ģ�
	 * jsonObject��Ӧ��Map���ϣ���jsonArray���Ӧ��List����
	 * ���ﷵ��ֵ���뷵��json����������Ҫ��List<Map<String, String>>����һ��Map������
	 * �Ӷ��ﵽ��󷵻�ֵ��JSONObject��Ч��
	 * @param payerCode
	 * @param payerName
	 * @param page
	 * @param rows
	 * @return
	 */
	@RequestMapping("/listPayer.do")
	public @ResponseBody Map<String, Object> listPayer(String payerCode, String payerName, Integer page, Integer rows) {
		List<Map<String, String>> queryPayer = payerService.queryPayer(payerCode, payerName, page, rows);
		int total = payerService.getTotal(payerCode, payerName);
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("rows", queryPayer);
		map.put("total", total);
		return map;
	}
	
	@RequestMapping("/getPayer.do")
	public @ResponseBody List<Map<String, Object>> getPayer() {		
		return payerService.queryAllPayer();
	}
	
	@RequestMapping("/removePayer.do")
	public @ResponseBody Map<String, Object> removePayerById(Integer id) {
		Map<String, Object> map = new HashMap<String, Object>();
		int i = payerService.removePayerById(id);
		if(i>0) {
			map.put("success", true);
			map.put("msg", "ɾ���ɹ�");
		} else {
			map.put("success", false);
			map.put("msg", "ɾ��ʧ��");
		}
		return map;
	}
	
	@RequestMapping("/getInvoice.do")
	public @ResponseBody List<Map<String, Object>> getInvoice() {
		List<Map<String, Object>> listMap = new ArrayList<Map<String, Object>>();
		Map<String, Object> map1 = new HashMap<String, Object>();
		Map<String, Object> map2 = new HashMap<String, Object>();
		Map<String, Object> map3 = new HashMap<String, Object>();
		Map<String, Object> map4 = new HashMap<String, Object>();
		
		map1.put("invoiceType", "��ֵ˰ר�÷�Ʊ");
		map2.put("invoiceType", "��ֵ˰��ͨ��Ʊ");
		map3.put("invoiceType", "���Ʊ");
		map4.put("invoiceType", "����������ͬͳһ��Ʊ");
		listMap.add(map1);
		listMap.add(map2);
		listMap.add(map3);
		listMap.add(map4);
		return listMap;
	}
	
	@RequestMapping("/editPayer.do")
	public @ResponseBody Map<String, Object> editPayer(PayerBean payerBean) {
		Map<String, Object> map = new HashMap<String, Object>();
		int i = payerService.editPayer(payerBean);
		if(i>0) {
			map.put("success", true);
			map.put("msg", "�޸ĳɹ�");
		} else {
			map.put("success", false);
			map.put("msg", "�޸�ʧ��");
		}
		return map;
	}
	
	@RequestMapping("/addPayer.do")
	public @ResponseBody Map<String, Object> addPayer(PayerBean payerBean) {
		Map<String, Object> map = new HashMap<String, Object>();
		int i = payerService.addPayer(payerBean);
		if(i>0) {
			map.put("success", true);
			map.put("msg", "��ӳɹ�");
		} else {
			map.put("success", false);
			map.put("msg", "���ʧ��");
		}
		return map;
	}
	
}
