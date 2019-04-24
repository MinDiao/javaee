package cn.dao.impl;

import org.springframework.stereotype.Repository;

import cn.dao.UserDao;

/**
 * 
 * 类描述：用户持久层实现类-第2个
 * 作者： LiuJinrong  
 * 创建日期：2018年12月21日
 * 修改人：
 * 修改日期：
 * 修改内容：
 * 版本号： 1.0.0
 */
@Repository("userDao") // 并自定义名字
public class UserDaoImpl2 implements UserDao {

	@Override
	public void addUser() {
		
		System.out.println("UserDaoImpl2...");
		
	}

}
