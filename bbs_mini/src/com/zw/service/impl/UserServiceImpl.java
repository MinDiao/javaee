package com.zw.service.impl;

import org.apache.ibatis.session.SqlSession;

import com.zw.dao.UserDao;
import com.zw.dao.impl.UserDaoImpl;
import com.zw.mapper.UserMapper;
import com.zw.pojo.User;
import com.zw.service.UserService;
import com.zw.util.SqlSessionFactoryUtil;

public class UserServiceImpl implements UserService {
	
	// 初始化会话工厂
	private SqlSession sqlSession = null;
	
	// 初始化mapper接口代理对象
	private UserMapper userMapper = null;
	
	
	// 注入Dao
	UserDao userDao = new UserDaoImpl();

	/**
	 * 注册用户
	 */
	@Override
	public int addUser(User user) throws RuntimeException {
		int res = 0;
		// 注册前再次确认用户名是否重复
		int flag = checkUser(user.getUsername());
		// 判断
		if (flag == 0) {
			res = userDao.addUser(user);
		}
		return res;
	}

	/**
	 * 检查用户名是否重复
	 */
	@Override
	public int checkUser(String username) throws RuntimeException {
		
		return userDao.checkUser(username);
	}

	
	/**
	 * 用户登录
	 */
	@Override
	public User login(User user) throws RuntimeException {
		//return userDao.login(user);
		// 1.获取会话
		sqlSession = SqlSessionFactoryUtil.getFactory().openSession();
		
		// 2.获取mapper接口的代理对象
		userMapper = sqlSession.getMapper(UserMapper.class);
		
		// 3.调用根据用户名密码查询用户表
		return userMapper.login(user);
	}

}
