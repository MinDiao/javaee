package com.zw.zw_mvnljrssm.service;

import java.util.List;

import com.github.pagehelper.PageInfo;
import com.zw.zw_mvnljrssm.dto.UserDto;
import com.zw.zw_mvnljrssm.pojo.User;

/**
 * 
 * 接口描述：用户业务逻辑层接口
 * 作者： LiuJinrong  
 * 创建日期：2018年12月28日
 * 修改人：
 * 修改日期：
 * 修改内容：
 * 版本号： 1.0.0
 */
public interface UserService {

	/**
	 * 
	 * 方法描述: 用户列表+分页+模糊查询
	 * @param userDto
	 * @return
	 */
	PageInfo<UserDto> userList(UserDto userDto);

	
	/**
	 * 
	 * 方法描述: 根据用户id删除单条用户
	 * @param id
	 * @return
	 */
	int userDeleteById(int id);


	/**
	 * 
	 * 方法描述: 添加单条用户
	 * @param user
	 * @return
	 */
	int userAdd(User user);


	/**
	 * 
	 * 方法描述: 根据id查询用户信息的回显
	 * @param id 用户id
	 * @return 用户实体类对象
	 */
	User selectUserByIdUpdateBackShow(int id);


	/**
	 * 
	 * 方法描述: 修改单条用户
	 * @param user
	 * @return
	 */
	int userUpdate(User user);


	/**
	 * 
	 * 方法描述: 根据用户id数组批量删除用户
	 * @param ids 用户id数组
	 * @return 影响行数
	 */
	int userDeleteByIds(String[] ids);

}
