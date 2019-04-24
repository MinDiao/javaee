package cn.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import cn.pojo.User;

/**
 * 
 * 类描述：支持的Model类型
 * 作者： LiuJinrong  
 * 创建日期：2018年12月25日
 * 修改人：
 * 修改日期：
 * 修改内容：
 * 版本号： 1.0.0
 */
@Controller
@RequestMapping(value="three")
public class ThirdController {
	
	/**
	 * 
	 * 方法描述: Model, HttpSession
	 */
	@RequestMapping(value="first")
	public String first(Model model, HttpSession session){
		// set到了request域对象中
		model.addAttribute("msg", "model里的数据");
		// 向session域填充值
		session.setAttribute("msg", "session域对象");
		return "user";
	}
	
	/**
	 * 
	 * 方法描述: 普通方式获取
	 */
	@RequestMapping("second")
	public String second(HttpServletRequest request){
		String id = request.getParameter("id");
		System.out.println(id);
		return "user";
	}
	
	/**
	 * 
	 * 方法描述: 简单类型的数据绑定,此处必须传id值
	 */
	@RequestMapping("third")
	public String third(int id){
		System.out.println(id);
		return "user";
	}
	
	/**
	 * 
	 * 方法描述: 简单类型的数据绑定,此处可传可不传
	 * 		@RequestParam:	value: 绑定的传参的参数名
	 * 						required: 是否必须传递,默认值为true
	 * 						defaultValue: 默认值
	 */
	@RequestMapping("fourth")
	public String fourth(@RequestParam(value="ids", required=false, defaultValue="1") int id, String name){
		System.out.println(id);
		System.out.println(name);
		return "user";
	}
	
	
	/**
	 * 
	 * 方法描述: 简单pojo类型的数据绑定
	 */
	@RequestMapping(value="fifth", method=RequestMethod.POST)
	public String fifth(User user){
		System.out.println(user.toString());
		return "user";
	}
	
	
	/**
	 * 
	 * 方法描述: 数组类型的数据绑定
	 */
	@RequestMapping("delete")
	public String delete(Integer[] ids){
		System.out.println(ids);
		return "user";
	}

}
