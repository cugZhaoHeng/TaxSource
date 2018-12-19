package com.zdsoft.manage.dao;

import java.util.List;

import com.zdsoft.manage.entity.IndustryBean;
/**
 * 
 * @author 赵恒
 *
 * 2017年12月14日
 */
public interface IndustryDao {
	/**
	 * 查询所有的行业
	 * @return
	 */
	public List<IndustryBean> queryAllIndustry();
	
	public IndustryBean queryIndustryById(Integer industryId);
}
