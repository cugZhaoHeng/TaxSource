package com.zdsoft.system.dao;



import java.util.List;

import com.zdsoft.system.entity.UserBean;

/**
 * �÷�װ�˶��û������ɾ�Ĳ����
 * @author �Ժ�
 *
 * 2017��12��13��
 */
public interface UserDao {
	public UserBean queryUserByUserName(String userName);
	
	public List<UserBean> queryAllUser();
	
}
