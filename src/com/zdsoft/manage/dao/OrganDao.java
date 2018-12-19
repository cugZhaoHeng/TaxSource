package com.zdsoft.manage.dao;

import java.util.List;
import java.util.Map;

import com.zdsoft.manage.entity.OrganBean;

/**
 * 
 * @author �Ժ�
 *
 * 2017��12��14��
 */
public interface OrganDao {
	
	public OrganBean queryOrganById(Integer taxOrganId);
	/**
	 * �������е�organ��¼
	 * @return
	 */
	public List<OrganBean> queryAllOrgan();
	
	/**
	 * ͨ����ַ������Ӧ��Organ��¼
	 * @param address
	 * @return
	 */
	public List<Map<String, String>> queryOrganByAddress(String address);
}
