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
	 * 前端通过easyUI传递4个参数过来，这边就要用4个参数接收，
	 * 其中两个参数page和rows是隐式的传递，通过datagrid来确定的，
	 * jsonObject对应于Map集合，而jsonArray则对应于List集合
	 * 这里返回值必须返回json对象，所以需要将List<Map<String, String>>再用一层Map包起来
	 * 从而达到最后返回值是JSONObject的效果
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
			map.put("msg", "删除成功");
		} else {
			map.put("success", false);
			map.put("msg", "删除失败");
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
		
		map1.put("invoiceType", "增值税专用发票");
		map2.put("invoiceType", "增值税普通发票");
		map3.put("invoiceType", "定额发票");
		map4.put("invoiceType", "机动车销售同统一发票");
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
			map.put("msg", "修改成功");
		} else {
			map.put("success", false);
			map.put("msg", "修改失败");
		}
		return map;
	}
	
	@RequestMapping("/addPayer.do")
	public @ResponseBody Map<String, Object> addPayer(PayerBean payerBean) {
		Map<String, Object> map = new HashMap<String, Object>();
		int i = payerService.addPayer(payerBean);
		if(i>0) {
			map.put("success", true);
			map.put("msg", "添加成功");
		} else {
			map.put("success", false);
			map.put("msg", "添加失败");
		}
		return map;
	}
	
}
