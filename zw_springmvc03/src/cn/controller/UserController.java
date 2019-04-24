package cn.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * 
 * 类描述：RESTful风格
 * 作者： LiuJinrong  
 * 创建日期：2018年12月26日
 * 修改人：
 * 修改日期：
 * 修改内容：
 * 版本号： 1.0.0
 */
@Controller
@RequestMapping("user")
public class UserController {
	
	/**
	 * 
	 * 方法描述: 传统方式根据用户id查询用户
	 */
	@RequestMapping(value="selectById")
	public String selectById(int id, Model model){
		model.addAttribute("msg", "接收到的id:"+ id);
		return "/user.jsp";
	}
	
	/**
	 * 
	 * 方法描述: RESTful风格
	 */
	// {id} 表示是动态参数,用于匹配以 /select/{id} 结尾的请求
	@RequestMapping(value="select/{id}")
	// @PathVariable 用于接收并且绑定请求中的参数
	public ModelAndView select(@PathVariable int id){
		System.out.println("接收到的id:"+ id);
		ModelAndView mv = new ModelAndView();
		mv.addObject("msg", "接收到的id:"+ id);
		mv.setViewName("/user.jsp");
		return mv;
	}

}
