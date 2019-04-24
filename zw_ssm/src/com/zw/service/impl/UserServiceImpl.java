package com.zw.service.impl;

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
@Service("userService")
//默认名称是首字母小写
public class UserServiceImpl implements UserService {
	
	// 注入usermapper属性
	// @Autowired默认是spring根据类型来进行注入
	@Autowired
	private UserMapper userMapper;

	/**
	 * 根据用户id查询用户信息
	 */
	@Override
	public User selectById(int id) {
		
		return userMapper.selectById(id);
	}

}
