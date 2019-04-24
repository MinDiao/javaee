package com.zw.test;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import com.zw.pojo.Message;
import com.zw.util.SqlSessionFactoryUtil;

/**
 * 
 * 类描述：测试类
 * 作者： LiuJinrong  
 * 创建日期：2018年12月18日
 * 修改人：
 * 修改日期：
 * 修改内容：
 * 版本号： 1.0.0
 */
public class MessageTest {

	/**
	 * 
	 * 方法描述:根据主题名模糊查询
	 */
	@Test
	public void selectByName(){
		// 1.获取会话
		SqlSession sqlSession = SqlSessionFactoryUtil.getFactory().openSession();
		// 2.根据主题名模糊查询
		List<Message> list = sqlSession.selectList("MessageMapper.selectByName", "%y%");
		// 3.输出查询结果
		System.out.println(list);
	}
}
