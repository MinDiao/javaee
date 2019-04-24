package com.zw.test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.junit.Before;
import org.junit.Test;

import com.zw.mapper.UserMapper;
import com.zw.pojo.Car;
import com.zw.pojo.User;
import com.zw.pojo.UserVo;
import com.zw.util.SqlSessionFactoryUtil;

/**
 * 
 * 类描述：测试用例
 * 作者： LiuJinrong  
 * 创建日期：2018年12月18日
 * 修改人：
 * 修改日期：
 * 修改内容：
 * 版本号： 1.0.0
 */
public class UserTest {
	
	private UserMapper userMapper = null;
	
	private SqlSession sqlSession = null;

	@Before
	public void init(){
		// 1.获取会话
		sqlSession = SqlSessionFactoryUtil.getFactory().openSession();

		// 2.获取mapper接口的代理对象
		userMapper = sqlSession.getMapper(UserMapper.class);
	}

	/**
	 * 
	 * 方法描述:根据用户id查询用户信息
	 */
	@Test
	public void selectById(){
		// 3.调用方法
		User user = userMapper.selectById(44);
		// 输出
		System.err.println(user);
	}
	
	
	
	/**
	 * 
	 * 方法描述:map传参根据条件查询用户信息
	 */
	@Test
	public void selectByName(){
		// 创建查询条件
		Map<String, Object> map = new HashMap<>();
		map.put("sex", "男");
		map.put("address", "济宁");
		// map传参
		List<User> list = userMapper.selctByMap(map);
		// 输出
		System.err.println(list);
	}
	
	
	
	/**
	 * 
	 * 方法描述:多参数查询:方法一
	 */
	@Test
	public void selectByParams1(){
		// 传递多参数
		List<User> list = userMapper.selectByParams1("男","济宁");
		// 输出
		System.err.println(list);
	}
	
	
	/**
	 * 
	 * 方法描述:多参数查询:方法二
	 */
	@Test
	public void selectByParams2(){
		// 传递多参数
		List<User> list = userMapper.selectByParams2("男","济宁");
		// 输出
		System.err.println(list);
	}
	
	
	
	
	
	
	
	
	/**
	 * 
	 * 方法描述: 查询所有汽车,pojo属性名与数据库字段名不同
	 * @return
	 */
	@Test
	public void selectCar1(){
		// 执行查询
		List<Car> list = userMapper.selectCar1();
		// 输出
		System.err.println(list);
	}
	
	
	/**
	 * 
	 * 方法描述: 查询所有汽车,pojo属性名与数据库字段名不同
	 * @return
	 */
	@Test
	public void selectCar2(){
		// 执行查询
		List<Car> list = userMapper.selectCar2();
		// 输出
		System.err.println(list);
	}
	
	
	
	
	
	
	/**
	 * 
	 * 方法描述:一对多查询,根据id查询用户信息
	 */
	@Test
	public void selectCar(){
		// 执行查询
		List<UserVo> list = userMapper.selectCars(1);
		// 输出
		System.err.println(list);
	}
	
	
	
	
	/**
	 * 
	 * 方法描述:动态sql -if判断
	 */
	@Test
	public void selectIf(){
		User user = new User();
		user.setSex("男");
		user.setAddress("济宁");
		// 调用
		List<User> list = userMapper.selectIf(user);
		// 输出
		System.err.println(list);
	}
	
	
	/**
	 * 
	 * 方法描述:动态sql -修改
	 */
	@Test
	public void updateUser(){
		// 声明
		User user = new User();
		user.setId(46);
		user.setUsername("jack");
		// 调用
		int result = userMapper.updateUser(user);
		// 提交
		sqlSession.commit();
		// 输出影响行数
		System.err.println(result);
	}
	
	
	
	/**
	 * 
	 * 方法描述:根据ids的集合进行批量删除 
	 */
	@Test
	public void deleteByIds(){
		// 声明
		List<Integer> ids = new ArrayList<>();
		ids.add(41);
		ids.add(42);
		int result = userMapper.deleteByIds(ids);
		// 提交
		sqlSession.commit();
		// 输出
		System.err.println(result);
	}
	
}















