package com.zw.utiltest;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import com.zw.pojo.User;
import com.zw.util.SqlSessionFactoryUtil;

/**
 * 
 * 类描述：测试类
 * 作者： LiuJinrong  
 * 创建日期：2018年12月17日
 * 修改人：
 * 修改日期：
 * 修改内容：
 * 版本号： 1.0.0
 */
public class UserUtilTest {
	
	@Test
	public void test1(){
		// 1.获取会话
		SqlSession sqlSession = SqlSessionFactoryUtil.getFactory().openSession();
		// 2.根据id查询
		User user = sqlSession.selectOne("UserMapper.selectById", 22);
		// 3.输出
		System.out.println(user);
	}

}
