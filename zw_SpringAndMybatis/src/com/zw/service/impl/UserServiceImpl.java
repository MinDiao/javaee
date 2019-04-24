package com.zw.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.zw.mapper.UserMapper;
import com.zw.pojo.User;
import com.zw.service.UserService;

/** 
 * 类描述：业务逻辑层实现类
 * 作者： LiuJinrong  
 * 创建日期：2018年12月24日
 * 修改人：
 * 修改日期：
 * 修改内容：
 * 版本号： 1.0.0   
 */
@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserMapper userMapper;

	/**
	 * 根据用户id查询用户id
	 */
	@Override
	public User selectById(int id) {
		// 调用方法
		return userMapper.selectById(id);
	}

	/**
	 * 转账-方法抛出异常
	 */
	@Transactional
	@Override
	public void tranfer(String in, String out, double money) throws RuntimeException {
		// 1.给out账户减钱
		userMapper.updateAccount(out, -money);
		// 2.给in账户加钱
		userMapper.updateAccount(in, money);
		// 3.模拟抛出异常,无论异常放在方法块内何处都会被spring捕获
		log();
	}

	/**
	 * 转账-自定义抛出异常
	 */
	/*@Transactional
	@Override
	public void tranfer(String in, String out, double money) throws RuntimeException {
		// 1.给out账户减钱
		int res = userMapper.updateAccount(out, -money);
		// 判断异常
		if (res == 0) {
			throw new RuntimeException();
		}
		// 2.给in账户加钱
		userMapper.updateAccount(in, money);
	}*/

	/**
	 * 
	 * 方法描述:记录日志-模拟抛出异常
	 */
	public void log() throws RuntimeException {
		System.err.println("记录日志");
		int a = 1 / 0;
	}

}
