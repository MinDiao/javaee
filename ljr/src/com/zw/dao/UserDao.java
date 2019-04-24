package com.zw.dao;

import java.util.List;

import com.zw.pojo.User;
import com.zw.util.Page;

public interface UserDao {

	/**
	 * 
	 * 方法描述: 分页查询
	 * @param user
	 * @param page
	 * @return
	 */
	List<User> selectUsers(User user, Page page);

	/**
	 * 
	 * 方法描述: 分页页数的统计
	 * @param user
	 * @return
	 */
	long selectCount(User user);

}
