package com.zw.MyMaven.service;

import com.github.pagehelper.PageInfo;
import com.zw.MyMaven.dto.UserDto;
import com.zw.MyMaven.pojo.User;

/**
 * 
 * 类描述：用户业务逻辑接口
 * 作者： LiuJinrong  
 * 创建日期：2018年12月27日
 * 修改人：
 * 修改日期：
 * 修改内容：
 * 版本号： 1.0.0
 */
public interface UserService {

	/**
	 * 
	 * 方法描述: 根据用户id查询用户信息
	 * @param id 用户id
	 * @return 用户实体类对象
	 */
	User selectById(int id);

	
	/**
	 * 
	 * 方法描述: 条件+分页的查询
	 * @param user
	 * @return 
	 */
	PageInfo select(UserDto userDto);
	
	
	/**
	 * 
	 * 方法描述: 新增用户
	 * @param user
	 * @return
	 */
	int add(User user);

}
