package com.zdsoft.manage.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.zdsoft.manage.entity.PayerBean;
/**
 * 
 * @author �Ժ�
 *
 * 2017��12��26��
 */
public interface PayerDao {
	/**
	 * ��ѯ���е�payer��¼
	 * 
	 * @return
	 */
	public List<Map<String, Object>> queryAllPayer();

	/**
	 * ����id��������ѯָ������˰�ˣ���ҳ��ѯ
	 * @param payerCode
	 * @param payerName
	 * @return
	 */
	public List<Map<String, String>> queryPayer(@Param("payerCode")String payerCode, @Param("payerName")String payerName, @Param("page")Integer page, @Param("rows")Integer rows);
	/**
	 * ��ѯδ��ͳ�Ƶ���ҵ����Ϣ
	 * @param payerCode
	 * @param payerName
	 * @param page
	 * @param rows
	 * @return
	 */
	
	public PayerBean queryPayerById(Integer id);
	
	public List<Map<String, String>> queryStatisticalPayer(String payerCode, String payerName, Integer page, Integer rows);
	
	/**
	 * ��ȡ��˰�˵��ܼ�¼��
	 * @param payerCode
	 * @param payerName
	 * @return
	 */
	public int getTotal(@Param(value = "payerCode") String payerCode, @Param(value = "payerName") String payerName);

	/**
	 * ͨ����˰��ʶ���ɾ����˰��
	 * 
	 * @param payerCode
	 * @return
	 */
	public int removePayerById(Integer id);
	
	/**
	 * �޸���˰��Ա��Ϣ
	 * @param obj
	 * @return
	 */
	public int editPayer(PayerBean payerBean);
	
	/**
	 * ͨ��id��ѯ��˰�˵ļ�¼��������PayerBeanʵ����
	 * @param id
	 * @return
	 */
	public PayerBean getPayerById(Integer id);
	
	/**
	 * ��ѯpayerCode�Ƿ��Ѿ�����
	 * @param payerCode
	 * @return
	 */
	public boolean hasPayer(String payerCode);
	
	/**
	 * �����ݿ��в�������
	 * @param obj
	 * @return
	 */
	public int addPayer(PayerBean payerBean);
	
	/**
	 * ��ȡ��˰�˱������е�invoiceType�ֶΣ�ȥ���ظ�
	 * @return
	 */
	public List<Map<String, String>> queryAllInvoiceType();
	
	public String getIdByCode(String code);
	
}
