package com.zw.service;

import java.util.List;

import com.zw.pojo.User;
import com.zw.util.Page;

public interface UserService {

	/**
	 * 
	 * 方法描述: 分页查询
	 * @param user
	 * @param page
	 * @return
	 */
	Page selectUsers(User user, Page page);

	/**
	 * 
	 * 方法描述:根据用户id删除用户
	 * @param userId 用户id
	 * @return
	 */
	int userDeleteById(int userId);
	
	/**
	 * 
	 * 方法描述: 根据用户id批量删除用户信息
	 * @param userIds
	 * @return
	 */
	int userDeleteByIds(String[] userIds);
	
	
	/**
	 * 
	 * 方法描述: 模糊查询
	 * @return
	 */
	List<User> userSelectByFuzzy(User user);

	/**
	 * 
	 * 方法描述: 修改用户
	 * @param user
	 * @return
	 */
	int userUpdate(User user);
	
	
	/**
	 * 
	 * 方法描述:添加用户
	 * @param user 用户实体类
	 * @return 影响行数
	 */
	int userAdd(User user);

}
