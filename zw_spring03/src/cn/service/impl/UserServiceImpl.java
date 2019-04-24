package cn.service.impl;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import cn.dao.UserDao;
import cn.service.UserService;
/**
 * 
 * 类描述：用户业务逻辑层实现类
 * 作者： LiuJinrong  
 * 创建日期：2018年12月21日
 * 修改人：
 * 修改日期：
 * 修改内容：
 * 版本号： 1.0.0
 */
@Service
public class UserServiceImpl implements UserService {

	// 获取spring容器中的bean,无需setter方法
	@Autowired // 通过类型去查询匹配,会到spring的beans去根据当前配置的对象的类型去查找,局限性:只能有1个的实现类，建议使用此个注解
	// @Qualifier("userDaoImpl2") // 匹配springbean的名字,用于和@Autowired配置使用,不能单独使用
	// @Resource // 会根据名字进行匹配
	private UserDao userDao;

	/**
	 * 添加用户
	 */
	@Override
	public void addUser() {

		System.out.println("service层,添加用户方法...");
		userDao.addUser();
	}

}
