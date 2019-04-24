package com.zw.MyMaven.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.PageInfo;
import com.zw.MyMaven.dto.UserDto;
import com.zw.MyMaven.pojo.User;
import com.zw.MyMaven.service.UserService;


/**
 * 
 * 类描述：用户的controller
 * 作者： LiuJinrong  
 * 创建日期：2018年12月27日
 * 修改人：
 * 修改日期：
 * 修改内容：
 * 版本号： 1.0.0
 */
// 将controller声明到springbean中
@Controller
@RequestMapping("user")
public class UserController {
	
	// 注入UserService属性
	// @Autowired如果名字重复,可以加@Q..来进行指定名字
	@Autowired
	private UserService userService;
	
	/**
	 * 
	 * 方法描述: 根据用户id查询用户信息
	 * @param id 用户id
	 * @param model springmvcmodel作用域
	 * @return 返回逻辑视图
	 */
	@RequestMapping(value="selectById", method=RequestMethod.GET)
	public String selectById(int id, Model model){
		
		// 创建user对象
		User user = null;
		
		// 调用Service层,try...catch为了使方便调试报错
		try {
			user = userService.selectById(id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		// 响应到页面
		model.addAttribute("user", user);
		
		// return的其实就是逻辑视图名
		return "user";
	}
	
	
	
	/**
	 * 
	 * 方法描述: 条件+分页的查询
	 * @return
	 */
	@RequestMapping(value="select",produces="application/json;charset=utf-8")
	@ResponseBody
	public String select(UserDto userDto){
		// 数据绑定的,包括分页信息条件
		// 创建json对象
		JSONObject json = new JSONObject();
		// 对Page结果进行包装
		PageInfo<User> pageInfo = null;
		
		try {
			// 执行service层查询
			pageInfo = userService.select(userDto);
			
			// 将结果填充至json对象
			json.put("pageInfo", pageInfo);
			json.put("code", "200");
			
		} catch (Exception e) {
			e.printStackTrace();
			// 错误
			json.put("code", "500");
		}
		
		// 响应json字符串
		return json.toString();
	}

}
