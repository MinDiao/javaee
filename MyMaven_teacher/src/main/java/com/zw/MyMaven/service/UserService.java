package com.zw.MyMaven.service;

import com.github.pagehelper.PageInfo;
import com.zw.MyMaven.dto.UserDto;
import com.zw.MyMaven.pojo.User;

/**
 * @author HP
 * 用户服务接口
 */
public interface UserService {

	/**
	 * 根据id查询用户信息
	 * @param id
	 * @return
	 */
	User selectById(int id);

	/**
	 * 条件+分页查询
	 * @param userDto
	 */
	PageInfo select(UserDto userDto);
	
	int add(User user);

}
