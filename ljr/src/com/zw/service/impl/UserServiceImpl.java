package com.zw.service.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.zw.dao.UserDao;
import com.zw.dao.impl.UserDaoImpl;
import com.zw.mapper.UserMapper;
import com.zw.pojo.User;
import com.zw.service.UserService;
import com.zw.util.Page;
import com.zw.util.SqlSessionFactoryUtil;

public class UserServiceImpl implements UserService{

	private UserDao userDao = new UserDaoImpl();
	
	// 初始化会话
	private SqlSession sqlSession = null;
	// 初始化mapper接口对象
	private UserMapper userMapper = null;

	@Override
	public Page selectUsers(User user, Page page) {
		// 分页查询出的用户
		List<User> users = userDao.selectUsers(user, page);
		// 查询一共多少页
		// 一共多少条记录
		long rows = userDao.selectCount(user);
		// 多少页的计算
		long totalPage = rows % page.getPageSize()==0?rows/page.getPageSize():rows/page.getPageSize()+1;
		// 返回数据的Page封装
		page.setData(users);
		page.setRows(rows);
		page.setTotalPage(totalPage);
		return page;
	}


	/**
	 * 根据用户id删除用户
	 */
	@Override
	public int userDeleteById(int userId) {
		// 初始化影响行数
		int result = 0;
		try {
			// 1.获取会话
			sqlSession = SqlSessionFactoryUtil.getFactory().openSession();
			// 2.获取mapper接口代理对象
			userMapper = sqlSession.getMapper(UserMapper.class);
			// 3.执行根据用户id删除用户并返回影响行数
			result = userMapper.userDeleteById(userId);
			// 4.提交事务
			sqlSession.commit();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			sqlSession.close();
		}
		// 5.返回影响行数
		return result;
	}
	
	
	
	
	/**
	 * 根据用户id批量删除用户信息
	 */
	@Override
	public int userDeleteByIds(String[] userIds) {
		// 初始化影响行数
		int result = 0;
		try {
			// 1.获取会话
			sqlSession = SqlSessionFactoryUtil.getFactory().openSession();
			// 2.获取mapper接口代理对象
			userMapper = sqlSession.getMapper(UserMapper.class);
			
			/*// 方法2:声明List集合
			List<String> list = new ArrayList<>();
			// 将获取到的Stirng[]填充至List集合中
			System.err.println(userIds.length);
			for (int i = 0; i < userIds.length; i++) {
				// 按照下标
				list.add(userIds[i]);
			}*/
			
			// 3.执行根据用户id删除用户并返回影响行数
			result = userMapper.userDeleteByIds(userIds);
			// 4.提交事务
			sqlSession.commit();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			sqlSession.close();
		}
		// 5.返回影响行数
		return result;
	}
	
	
	
	/**
	 * 模糊查询
	 */
	@Override
	public List<User> userSelectByFuzzy(User user) {
		// 初始化模糊查询list
		List<User> list = null;
		try {
			// 获取会话
			sqlSession = SqlSessionFactoryUtil.getFactory().openSession();
			// 获取mapper接口代理对象
			userMapper = sqlSession.getMapper(UserMapper.class);
			// 执行模糊查询并返回list
			list = userMapper.userSelectByFuzzy(user);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			sqlSession.close();
		}
		return list;
	}

	
	
	
	/**
	 * 添加用户
	 */
	@Override
	public int userAdd(User user) {
		// 初始化执行结果
		int result = 0;
		try {
			// 获取会话
			sqlSession = SqlSessionFactoryUtil.getFactory().openSession();
			// 获取mapper接口代理对象
			userMapper = sqlSession.getMapper(UserMapper.class);
			// 执行用户添加并返回影响行数
			result = userMapper.userAdd(user);
			// 提交事务
			sqlSession.commit();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			sqlSession.close();
		}
		return result;
	}


	/**
	 * 修改用户
	 */
	@Override
	public int userUpdate(User user) {
		// 初始化执行结果
		int result = 0;
		try {
			// 获取会话
			sqlSession = SqlSessionFactoryUtil.getFactory().openSession();
			// 获取mapper接口代理对象
			userMapper = sqlSession.getMapper(UserMapper.class);
			// 执行修改用户sql并返回影响行数
			result = userMapper.userUpdate(user);
			// 提交事务
			sqlSession.commit();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			sqlSession.close();
		}
		return result;
	}


	

	
}
