package com.zdsoft.manage.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.zdsoft.manage.entity.TaskBean;
/**
 * 
 * @author ÕÔºã
 *
 * 2017Äê12ÔÂ26ÈÕ
 */
public interface TaskDao {
	public List<TaskBean> queryTask(@Param("payerCode") String payerCode, @Param("payerName") String payerName, 
			@Param("organId") Integer organId, @Param("industryId") Integer industryId, 
			@Param("startDate") String startDate, @Param("endDate") String endDate, 
			@Param("page") int page, @Param("rows") int rows);
	
	public int getTaskCount();
}
