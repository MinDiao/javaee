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


@Service("userService")
public class UserServiceImpl implements UserService{
	
	@Autowired
	private UserMapper userMapper;

	@Override
	public User selectById(int id) {
		return userMapper.selectById(id);
	}

	@Override
	public PageInfo select(UserDto userDto) {
		//计算了 limit ？，？  第一个占位符是 几
		PageHelper.startPage(userDto.getPageNum(), userDto.getPageSize());
		List<User> users = userMapper.selectPage(userDto);// limit语句省略掉
		PageInfo<User> pageInfo = new PageInfo<>(users);
		return pageInfo;
	}

	@Override
	public int add(User user) {
		return userMapper.insertSelective(user);
		//return userMapper.insert(user);
	}
	
	

}
