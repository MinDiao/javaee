package com.zw.bean;

import java.util.List;
import java.util.Map;

/**
 * 
 * 类描述：用户实体类
 * 作者： LiuJinrong  
 * 创建日期：2018年12月21日
 * 修改人：
 * 修改日期：
 * 修改内容：
 * 版本号： 1.0.0
 */
public class User {
	
	private int age;
	
	private String name;
	
	private List<String> list;//爱好
	
	private Map<String, Object> map;//备注
	
	// 这个人的熊汽车
	private Car car;
	

	public Car getCar() {
		return car;
	}

	public void setCar(Car car) {
		this.car = car;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<String> getList() {
		return list;
	}

	public void setList(List<String> list) {
		this.list = list;
	}

	public Map<String, Object> getMap() {
		return map;
	}

	public void setMap(Map<String, Object> map) {
		this.map = map;
	}

	@Override
	public String toString() {
		return "User [age=" + age + ", name=" + name + ", list=" + list + ", map=" + map + ", car=" + car + "]";
	}
}
