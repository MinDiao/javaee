package com.zw.controller;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONObject;
import com.zw.pojo.User;

@Controller
@RequestMapping("demo")
public class DemoController {

	@RequestMapping("test")
	@ResponseBody
	public Map test(HttpServletRequest request) {
		Map<String, String[]> map = request.getParameterMap();
		// 遍历
		for (Iterator iter = map.entrySet().iterator(); iter.hasNext();) {
			Map.Entry element = (Map.Entry) iter.next();
			// key值
			Object strKey = element.getKey();
			// value,数组形式
			String[] value = (String[]) element.getValue();

			System.out.print(strKey.toString() + "=");
			for (int i = 0; i < value.length; i++) {
				System.out.print(value[i] + ",");
			}
			System.out.println();
		}
		return map;
	}
	
	@RequestMapping("table")
	@ResponseBody
	public String table(HttpServletRequest request){
		
		Map<String, String[]> map = request.getParameterMap();
		// 遍历
		for (Iterator iter = map.entrySet().iterator(); iter.hasNext();) {
			Map.Entry element = (Map.Entry) iter.next();
			// key值
			Object strKey = element.getKey();
			// value,数组形式
			String[] value = (String[]) element.getValue();

			System.out.print(strKey.toString() + "=");
			for (int i = 0; i < value.length; i++) {
				System.out.print(value[i] + ",");
			}
			System.out.println();
		}
		
		JSONObject json = new JSONObject();
		List<User> users = new ArrayList<>();
		for(int i=1;i<50;i++){
			User user = new User();
			user.setId(i);
			user.setUsername("jack"+i);
			user.setAddress("济宁"+i);
			user.setSex("男");
			users.add(user);
		}
		json.put("rows", users);
		json.put("status", 0);
		json.put("total", 50);
		return json.toJSONString();
	}
}
