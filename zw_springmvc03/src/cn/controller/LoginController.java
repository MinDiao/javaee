package cn.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

import cn.pojo.User;

/**
 * 
 * 类描述：用户登录controller
 * 作者： LiuJinrong  
 * 创建日期：2018年12月26日
 * 修改人：
 * 修改日期：
 * 修改内容：
 * 版本号： 1.0.0
 */
// 注册到spring
@Controller
public class LoginController {

	/**
	 * 
	 * 方法描述: 响应json格式,异步开发
	 */
	@RequestMapping(value="login")
	// 做异步开发必须要加此注解:作用于返回的对象,将数据转化为指定的格式,json格式
	@ResponseBody
	public String lgoin(User user){
		// 创建json对象
		JSONObject json = new JSONObject();
		// JSONArray 创建json数组
		// 模拟判断用户名不为空并且长度大于3
		if (user.getUsername()!= null & user.getUsername().length() > 3) {
			// 登录成功
			json.put("code", 1);
		} else {
			// 登录失败
			json.put("code", 0);
		}
		// 返回json字符串
		return json.toJSONString();
	}

	
	/**
	 * 
	 * 方法描述: map返回类型(必须要引入jackson)
	 */
	@RequestMapping(value="login2")
	// 做异步开发必须要加此注解:作用于返回的对象,将数据转化为指定的格式,json格式
	@ResponseBody
	public Map login2(User user){
		// 创建Map集合
		Map<String, Object> map = new HashMap<>();
		// 模拟判断用户名不为空并且长度大于3
		if (user.getUsername()!= null & user.getUsername().length() > 3) {
			// 登录成功
			map.put("code", 1);
		} else {
			// 登录失败
			map.put("code", 0);
		}
		// 返回json字符串
		return map;
	}
	
	
	/**
	 * 
	 * 方法描述: 接收json字符串并返回map类型(相当于第一种普通方式)
	 */
	@RequestMapping(value="login3")
	// @ResponseBody 做异步开发必须要加此注解:作用于返回的对象,将数据转化为指定的格式,json格式
	@ResponseBody
	// @RequestBody 读取请求中的内容,把它转成json格式,然后再进行数据绑定到形参上
	public Map login3(@RequestBody User user){
		// 创建Map集合
		Map<String, Object> map = new HashMap<>();
		// 模拟判断用户名不为空并且长度大于3
		if (user.getUsername()!= null & user.getUsername().length() > 3) {
			// 登录成功
			map.put("code", 1);
		} else {
			// 登录失败
			map.put("code", 0);
		}
		// 返回json字符串
		return map;
	}

}
