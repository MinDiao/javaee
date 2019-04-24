package com.zw.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.zw.pojo.Car;
import com.zw.pojo.User;
import com.zw.pojo.UserVo;

/**
 * 
 * 类描述：用户表接口
 * 作者： LiuJinrong  
 * 创建日期：2018年12月18日
 * 修改人：
 * 修改日期：
 * 修改内容：
 * 版本号： 1.0.0
 */
public interface UserMapper {
	
	/**
	 * 
	 * 方法描述: 根据用户id查询用户信息
	 * @param id
	 * @return
	 */
	public User selectById(int id);

	
	/**
	 * 
	 * 方法描述: map传参查询
	 * @param map
	 * @return
	 */
	public List<User> selctByMap(Map<String, Object> map);


	
	
	/**
	 * 
	 * 方法描述: 多参数查询,方法一
	 * @param sex
	 * @param address
	 * @return
	 */
	public List<User> selectByParams1(String sex, String address);
	
	/**
	 * 
	 * 方法描述: 多参数查询,方法二
	 * @param sex
	 * @param address
	 * @return
	 */
	public List<User> selectByParams2(@Param("sex")String sex, @Param("addr")String address);




	
	
	
	
	/**
	 * 
	 * 方法描述: 查询所有汽车,pojo属性名与数据库字段名不匹配方法一
	 * @return
	 */
	public List<Car> selectCar1();
	
	
	/**
	 * 
	 * 方法描述: 查询所有汽车,pojo属性名与数据库字段名不匹配方法二
	 * @return
	 */
	public List<Car> selectCar2();


	
	
	
	
	/**
	 * 
	 * 方法描述: 一对多查询
	 * @param i
	 * @return
	 */
	public List<UserVo> selectCars(int id);
	
	
	
	/**
	 * 
	 * 方法描述: 动态sql -if判断
	 * @param user
	 * @return
	 */
	public List<User> selectIf(User user);
	
	
	/**
	 * 
	 * 方法描述: 动态sql -修改
	 * @param user
	 * @return
	 */
	public int updateUser(User user);
	
	
	/**
	 * 
	 * 方法描述: 根据ids的集合进行批量删除
	 * @return
	 */
	public int deleteByIds(List<Integer> ids);
}















