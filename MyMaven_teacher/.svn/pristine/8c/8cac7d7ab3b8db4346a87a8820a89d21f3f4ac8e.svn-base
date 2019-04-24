package com.zw.MyMaven.mapper;

import java.util.List;

import com.github.abel533.mapper.Mapper;
import com.zw.MyMaven.dto.UserDto;
import com.zw.MyMaven.pojo.User;

/**
 * @author HP
 * 用户mapper
 */
public interface UserMapper extends Mapper<User>{

	/**
	 * 根据id查询用户信息
	 * @param id
	 * @return
	 */
	User selectById(int id);

	/**
	 * 条件查询
	 * @param userDto
	 * @return
	 */
	List<User> selectPage(UserDto userDto);

}
