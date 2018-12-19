package com.zdsoft.system.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.zdsoft.system.dao.UserDao;
import com.zdsoft.system.entity.UserBean;

@Service
public class UserService {
	@Resource
	UserDao userDao;
	
	public UserBean queryUserByUserName(String userName) {
		return userDao.queryUserByUserName(userName);
	}
	
	public List<UserBean> queryAllUser() {
		return userDao.queryAllUser();
	}
}
