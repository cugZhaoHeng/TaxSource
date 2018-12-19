package com.zdsoft.manage.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.zdsoft.manage.entity.PayerBean;
/**
 * 
 * @author 赵恒
 *
 * 2017年12月26日
 */
public interface PayerDao {
	/**
	 * 查询所有的payer记录
	 * 
	 * @return
	 */
	public List<Map<String, Object>> queryAllPayer();

	/**
	 * 根据id和姓名查询指定的纳税人，分页查询
	 * @param payerCode
	 * @param payerName
	 * @return
	 */
	public List<Map<String, String>> queryPayer(@Param("payerCode")String payerCode, @Param("payerName")String payerName, @Param("page")Integer page, @Param("rows")Integer rows);
	/**
	 * 查询未被统计的企业的信息
	 * @param payerCode
	 * @param payerName
	 * @param page
	 * @param rows
	 * @return
	 */
	
	public PayerBean queryPayerById(Integer id);
	
	public List<Map<String, String>> queryStatisticalPayer(String payerCode, String payerName, Integer page, Integer rows);
	
	/**
	 * 获取纳税人的总记录数
	 * @param payerCode
	 * @param payerName
	 * @return
	 */
	public int getTotal(@Param(value = "payerCode") String payerCode, @Param(value = "payerName") String payerName);

	/**
	 * 通过纳税人识别号删除纳税人
	 * 
	 * @param payerCode
	 * @return
	 */
	public int removePayerById(Integer id);
	
	/**
	 * 修改纳税人员信息
	 * @param obj
	 * @return
	 */
	public int editPayer(PayerBean payerBean);
	
	/**
	 * 通过id查询纳税人的记录，并返回PayerBean实体类
	 * @param id
	 * @return
	 */
	public PayerBean getPayerById(Integer id);
	
	/**
	 * 查询payerCode是否已经存在
	 * @param payerCode
	 * @return
	 */
	public boolean hasPayer(String payerCode);
	
	/**
	 * 向数据库中插入数据
	 * @param obj
	 * @return
	 */
	public int addPayer(PayerBean payerBean);
	
	/**
	 * 获取纳税人表中所有的invoiceType字段，去除重复
	 * @return
	 */
	public List<Map<String, String>> queryAllInvoiceType();
	
	public String getIdByCode(String code);
	
}
