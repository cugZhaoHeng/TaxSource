package com.zdsoft.system.dao;



import java.util.List;

import com.zdsoft.system.entity.UserBean;

/**
 * 用封装了对用户表的增删改查操作
 * @author 赵恒
 *
 * 2017年12月13日
 */
public interface UserDao {
	public UserBean queryUserByUserName(String userName);
	
	public List<UserBean> queryAllUser();
	
}
