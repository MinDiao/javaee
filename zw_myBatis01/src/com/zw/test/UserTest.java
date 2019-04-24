package com.zw.test;

import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.zw.pojo.User;

/**
 * 
 * 类描述：测试用例
 * 作者： LiuJinrong  
 * 创建日期：2018年12月17日
 * 修改人：
 * 修改日期：
 * 修改内容：
 * 版本号： 1.0.0
 */
public class UserTest {
	
	SqlSession sqlSession = null;

	@Before
	public void init() throws IOException{
		// 1.加载mybatis的全局配置文件,io的形式读取自动会从根目录去找
		InputStream in = Resources.getResourceAsStream("mybatis.xml");

		// 2.获取会话工厂
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(in);

		// 3.获取会话
		sqlSession = sqlSessionFactory.openSession();
	}

	
	/**
	 * 
	 * 方法描述:根据id查询用户信息
	 * @throws IOException 
	 */
	@Test
	public void testSelectById() {
		// 4.调用会话的方法进行查询
			// statement: 预处理语句,查询需要执行的sql语句; 格式:命名空间.id
			// parameter: 参数
		User user = sqlSession.selectOne("UserMapper.selectById", 22);

		// 5.输出
		System.err.println(user);
	}
	
	
	/**
	 * 
	 * 方法描述:根据姓名模糊查询
	 */
	@Test
	public void testSelectByName(){
		// 调用会话的方法,进行查询
		List<User> list = sqlSession.selectList("UserMapper.selectByName", "b");
		// 输出
		System.err.println(list);
	}
	
	
	/**
	 * 
	 * 方法描述:取代${}字符串拼接,根据姓名模糊查询
	 */
	@Test
	public void testSelectByName2(){
		// 调用会话的方法,进行查询
		List<User> list = sqlSession.selectList("UserMapper.selectByName2", "%b%");
		// 输出
		System.err.println(list);
	}
	
	
	/**
	 * 
	 * 方法描述:新增用户 
	 */
	@Test
	public void addUser(){
		// 声明对象
		User user = new User("卢志", new Date(), "男", "菏泽");
		// 调用会话的方法,进行添加,并返回影响了多少行
		int res = sqlSession.insert("UserMapper.addUser", user);
		// 提交
		sqlSession.commit();
		// 输出影响了多少行
		System.err.println(res);
		// 获取新增后的用户id
		System.err.println(user.getId());
	}
	
	
	/**
	 * 
	 * 方法描述:修改用户
	 */
	@Test
	public void updateUser(){
		// 声明对象
		User user = new User();
		// 赋值
		user.setId(44);
		user.setUsername("卢志志");
		user.setAddress("青岛");
		// 调用会话的方法,进行修改,并返回影响了多少行
		int res = sqlSession.update("UserMapper.updateUser", user);
		// 提交
		sqlSession.commit();
		// 输出
		System.err.println(res);
	}
	
	
	/**
	 * 
	 * 方法描述:删除用户
	 */
	@Test
	public void deleteUser(){
		// 调用会话的方法,进行删除,并返回影响行数
		int res = sqlSession.delete("UserMapper.deleteUser", 46);
		// 提交
		sqlSession.commit();
		// 输出影响行数
		System.err.println(res);
	}
	

	
	
	@After
	public void after(){
		// 释放资源
		sqlSession.close();
	}
}
