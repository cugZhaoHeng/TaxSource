package com.zdsoft.manage.dao;

import java.util.List;

import com.zdsoft.manage.entity.IndustryBean;
/**
 * 
 * @author �Ժ�
 *
 * 2017��12��14��
 */
public interface IndustryDao {
	/**
	 * ��ѯ���е���ҵ
	 * @return
	 */
	public List<IndustryBean> queryAllIndustry();
	
	public IndustryBean queryIndustryById(Integer industryId);
}
