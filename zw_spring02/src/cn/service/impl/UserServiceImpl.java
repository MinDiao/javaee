package cn.service.impl;

import cn.dao.UserDao;
import cn.service.UserService;
/**
 * 
 * 类描述：用户业务逻辑层实现类
 * 作者： LiuJinrong  
 * 创建日期：2018年12月21日
 * 修改人：
 * 修改日期：
 * 修改内容：
 * 版本号： 1.0.0
 */
public class UserServiceImpl implements UserService {
	
	// 不主动进行实例化,而是获取spring容器中的bean
	private UserDao userDao;
	/**
	 * 1. 必须有setter方法
	 * 2. 必须有午餐构造方法
	 */

	/**
	 * 添加用户
	 */
	@Override
	public void addUser() {

		System.out.println("service层,添加用户方法...");
		userDao.addUser();

	}

	public UserServiceImpl() {
		
	}

	public UserDao getUserDao() {
		return userDao;
	}

	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}

}
