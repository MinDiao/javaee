package com.zw.util;

import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

/**
 * 
 * 类描述：会话工厂工具类
 * 作者： LiuJinrong  
 * 创建日期：2018年12月18日
 * 修改人：
 * 修改日期：
 * 修改内容：
 * 版本号： 1.0.0
 */
public class SqlSessionFactoryUtil {
	
	private static SqlSessionFactory sqlSessionFactory = null;
	
	static{
		
		try {
			// 1.加载全局配置文件
			InputStream in = Resources.getResourceAsStream("mybatis.xml");
			
			// 2.获取会话工厂
			sqlSessionFactory = new SqlSessionFactoryBuilder().build(in);
					
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	/**
	 * 
	 * 方法描述: 获取会话工厂
	 * @return
	 */
	public static SqlSessionFactory getFactory(){
		return sqlSessionFactory;
	}

}
