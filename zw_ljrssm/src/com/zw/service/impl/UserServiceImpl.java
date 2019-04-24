package com.zw.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zw.mapper.UserMapper;
import com.zw.pojo.User;
import com.zw.service.UserService;

/**
 * 
 * 类描述：用户业务逻辑层实现类
 * 作者： LiuJinrong  
 * 创建日期：2018年12月27日
 * 修改人：
 * 修改日期：
 * 修改内容：
 * 版本号： 1.0.0
 */
@Service
public class UserServiceImpl implements UserService {
	
	// 注入usermapper属性
	// spring默认根据类型进行注入
	@Autowired
	private UserMapper userMapper;

	/**
	 * 用户列表
	 */
	@Override
	public List<User> userList() {
		
		return userMapper.userList();
	}

}
