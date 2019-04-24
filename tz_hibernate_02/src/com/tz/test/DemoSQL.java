package com.tz.test;

import java.util.List;

import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.Test;

import com.tz.entity.Customer;
import com.tz.utils.HibernateUtils;

/**
 * 
 * 类描述：原生SQL
 * 作者： LiuJinrong  
 * 创建日期：2018年12月6日
 * 修改人：
 * 修改日期：
 * 修改内容：
 * 版本号： 1.0.0
 */
public class DemoSQL {

	/**
	 * 
	 * 方法描述:原生SQL查询所有
	 */
	@Test
	public void demo01(){
		
		// 1.获得一个全新的Session
		Session session = HibernateUtils.openSession();
		
		// 2.开启事务
		Transaction tx = session.beginTransaction();
		
		// 3.创建原生SQL语句
		String sql = "select * from cst_customer";
		
		// 4.创建SQLQuery查询对象
		SQLQuery sqlQuery = session.createSQLQuery(sql);
		
		// 5.无封装：如果用原生SQL写Hibernate将不会自动填充到实体类对象中
//		List<Object[]> list = sqlQuery.list();
//		for (Object[] objects : list) {
//			System.out.println(Arrays.toString(objects));
//		}
		
		// 5.封装到对象中
		sqlQuery.addEntity(Customer.class);
		
		// 6.将执行查询结果填充到List集合中
		List<Customer> list = sqlQuery.list();
		// 遍历List集合并将结果打印至控制台
		for (Customer customer : list) {
			System.out.println(customer);
		}
		
		// 7.提交事务
		tx.commit();
		
		// 8.释放资源
		session.close();
	}
	
	/**
	 * 
	 * 方法描述:原生SQL分页查询
	 */
	@Test
	public void demo02(){
		
		// 1.获取Session
		Session session = HibernateUtils.openSession();
		
		// 2.开启事务
		Transaction tx = session.beginTransaction();
		
		// 3.创建SQL语句
		String sql = "select * from cst_customer limit ? , ?";
		
		// 4.创建SQLQuery查询对象
		SQLQuery query = session.createSQLQuery(sql);
		
		// 5.设置分页信息
		query.setParameter(0, 0); // 下标从0开始
		query.setParameter(1, 10);
		
		// 6.封装到对象中
		query.addEntity(Customer.class);
		
		// 7.调用法法查询对象并返回List集合
		List<Customer> list = query.list();
		// 遍历并打印至控制台
		for (Customer customer : list) {
			System.out.println(customer);
		}
		
		// 8.提交事务
		tx.commit();
		
		// 9.释放资源
		session.close();
	}
	
	/**
	 * 
	 * 方法描述:原生SQL条件查询
	 */
	@Test
	public void demo03(){
		
		// 1.获取Session
		Session session = HibernateUtils.openSession();
		
		// 2.开启事务
		Transaction tx = session.beginTransaction();
		
		// 3.创建原生SQL语句
		String sql = "select * from cst_customer where cust_id = ?";
		
		// 4.创建SQLQuery查询对象
		SQLQuery query = session.createSQLQuery(sql);
		
		// 5.封装到对象中
		query.addEntity(Customer.class);
		
		// 6.设置参数填充占位符
		query.setInteger(0, 1);
		
		// 7.调用查询方法并返回对象
		Customer customer = (Customer) query.uniqueResult();
		// 打印至控制台
		System.out.println(customer);
		
		// 8.提交事务
		tx.commit();
		
		// 9.释放资源
		session.close();
	}
}
