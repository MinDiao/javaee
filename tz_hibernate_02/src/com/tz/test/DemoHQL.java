package com.tz.test;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.Test;

import com.tz.entity.Customer;
import com.tz.utils.HibernateUtils;

/**
 * 
 * 类描述：HQL
 * 作者： LiuJinrong  
 * 创建日期：2018年12月5日
 * 修改人：
 * 修改日期：
 * 修改内容：
 * 版本号： 1.0.0
 */
public class DemoHQL {
	
	/**
	 * 
	 * 方法描述:HQL查询所有
	 */
	@Test
	public void demo01(){
		
		// 1.获得Session对象
		Session session = HibernateUtils.openSession();
		
		// 2.开启事务
		Transaction tx = session.beginTransaction();
		
		// 3.创建HQL语句
		// 查询所有字段
		String hql1 = "from Customer";
		// 根据某个字段查询其所有数据
		String hql2 = "select cust_name from Customer";
		
		// 4.创建HQL查询对象
		Query query = session.createQuery(hql1);
		
		/**
		 * list() 查询所有对象数据
		 * 
		 * uniqueResult() 查询一个对象数据
		 */
		// 5.执行HQL语句并将执行结果填充到List集合中
		List<Customer> list = query.list();
		// 遍历集合控制台输出
		for (Customer c : list) {
			System.out.println(c);
		}
		
		// 6.提交事务
		tx.commit();
		
		// 7.释放资源
		session.close();
	}
	
	/**
	 * 
	 * 方法描述:HQL根据条件查询
	 */
	@Test
	public void demo02(){
		
		// 1.获得Session对象
		Session session = HibernateUtils.openSession();
		
		// 2.开启事务
		Transaction tx = session.beginTransaction();
		
		// 3.创建HQL语句
		String hql1 = "from Customer where cust_name = ?";
		
		String hql2 = "from Customer where cust_name = :cust_name";
		
		// 4.创建查询对象
		Query query = session.createQuery(hql2);
		
		// 5.设置参数用来填充占位符
		query.setParameter("cust_name", "阿里");
		
		// 5.执行HQL语句并返回单条实体类
		Customer customer = (Customer) query.uniqueResult();
		// 打印在控制台
		System.out.println(customer);
		
		// 6.提交事务
		tx.commit();
		
		// 7.释放资源
		session.close();
	}
	
	
	/**
	 * 
	 * 方法描述:HQL分页查询
	 */
	@Test
	public void demo3(){
		
		// 1.获得Session对象
		Session session = HibernateUtils.openSession();
		
		// 2.开启事务
		Transaction tx = session.beginTransaction();
		
		// 3.创建HQL语句,也就是select * from customer linmit ? , ?
		String hql = "from Customer";
		
		// 4.创建查询对象
		Query query = session.createQuery(hql);
		
		// 5.设置分页查询参数,也就是linmit ? , ?
		query.setFirstResult(0); // 下标从0开始
		query.setMaxResults(5);
		
		// 6.执行HQL语句并将执行结果填充到List集合
		List<Customer> list = query.list();
		
		// 7.遍历List集合打印到控制台
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
	 * 方法描述:HQL删除数据
	 */
	@Test
	public void dem04(){
		
		// 1.加载核心配置文件
		Session session = HibernateUtils.openSession();
		
		// 2.开启事务
		Transaction tx = session.beginTransaction();
		
		// 3.创建HQL语句进行删除数据
		String hql1 = "delete Customer where cust_name = ?";
		
		String hql2 = "delete Customer where cust_name = :cust_name";
		
		// 4.创建查询对象
		Query query = session.createQuery(hql2);
		
		// 5.设置参数来填充占位符
		query.setParameter("cust_name", "阿里");
		
		// 6.执行HQ语句的更新和删除操作
		int executeUpdate = query.executeUpdate();
		System.out.println(executeUpdate);
		
		// 7.提交事务
		tx.commit();
		
		// 8.释放资源
		session.close();
	}
}
