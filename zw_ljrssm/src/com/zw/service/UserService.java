package com.zw.service;

import java.util.List;

import com.zw.pojo.User;

/**
 * 
 * 接口描述：用户业务逻辑层接口
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
	 * 方法描述: 用户列表
	 * @return 填充User对象的List集合
	 */
	List<User> userList();

}
