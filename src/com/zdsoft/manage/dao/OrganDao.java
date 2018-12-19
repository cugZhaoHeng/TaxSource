package com.zdsoft.manage.dao;

import java.util.List;
import java.util.Map;

import com.zdsoft.manage.entity.OrganBean;

/**
 * 
 * @author 赵恒
 *
 * 2017年12月14日
 */
public interface OrganDao {
	
	public OrganBean queryOrganById(Integer taxOrganId);
	/**
	 * 返回所有的organ记录
	 * @return
	 */
	public List<OrganBean> queryAllOrgan();
	
	/**
	 * 通过地址返回相应的Organ记录
	 * @param address
	 * @return
	 */
	public List<Map<String, String>> queryOrganByAddress(String address);
}
