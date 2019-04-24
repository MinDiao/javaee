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
 * @author HP
 * 用户controller
 */
@Controller
@RequestMapping("user")
public class UserController {

	@Autowired
	private UserService userService;
	
	/**
	 * 根据id查询用户信息
	 */
	@RequestMapping(value="selectById",method=RequestMethod.GET)
	public String selectById(int id,Model model){
		User user = null;
		try {
			user = userService.selectById(id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		model.addAttribute("user", user);
		return "user";//逻辑视图名
	}
	
	
	/**
	 * 条件+分页的 查询
	 * @return
	 */
	@RequestMapping(value="select",produces="application/json;charset=utf-8")
	@ResponseBody
	public String select(UserDto userDto){
		//数据绑定的 包括分页信息 条件  实体类 单独声明
		JSONObject json = new JSONObject();
		PageInfo<User> pageInfo = null;
		try {
			pageInfo = userService.select(userDto);
			json.put("pageInfo", pageInfo);
			json.put("code", "200");
		} catch (Exception e) {
			e.printStackTrace();
			json.put("code", "500");
		}
		return json.toString();
	}
	
}
