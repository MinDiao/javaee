package com.zw.MyMaven.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.zw.MyMaven.dto.UserDto;
import com.zw.MyMaven.mapper.UserMapper;
import com.zw.MyMaven.pojo.User;
import com.zw.MyMaven.service.UserService;

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

	
	/**
	 * 条件+分页的查询
	 */
	@Override
	public PageInfo select(UserDto userDto) {
		// 计算了limit ?, ? 第一个占位符是几
		// 通用分页拦截器
		PageHelper.startPage(userDto.getPageNum(), userDto.getPageSize());
		
		// 使用pagehelper后limit语句可以省略
		List<User> users = userMapper.selectPage(userDto);
		
		// 对Page结果进行包装
		PageInfo<User> pageInfo = new PageInfo<>(users);
		// 返回PageInfo
		return pageInfo;
	}


	/**
	 * 新增用户
	 */
	@Override
	public int add(User user) {
		
		return userMapper.insertSelective(user);
	}

}
