package cn.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 * 
 * 类描述：注解开发方式第一个处理器
 * 作者： LiuJinrong  
 * 创建日期：2018年12月25日
 * 修改人：
 * 修改日期：
 * 修改内容：
 * 版本号： 1.0.0
 */
@Controller
@RequestMapping("one")
public class FirstController {
	
	/**
	 * @RequestMapping 里需要配置映射路径,"/first.do",前面的"/"可加可不加,后面的".do"可加可不加;
	 * 		可以注解到方法上,也可以注解到类上;当注解到类上时,表示该类的所有方法都将映射到配置的属性值的路径下
	 * 
	 * 注解的属性：
	 * 		value: 指的是请求的地址,是缺省的默认值; String[] 支持多路径、传值。
	 * 		method: 指的是请求的method类型,get、post。不匹配的话,是代表支持所有请求类型。
	 * 		consumes: 提交类型
	 * 		produces: 返回类型
	 */
	
	@RequestMapping("first")
	// 指定请求类型
		// @RequestMapping(value="first",method=RequestMethod.GET)
	// 多路径请求
		// @RequestMapping(value={"first","second"},method=RequestMethod.GET)
	public ModelAndView first(){
		// 创建ModelAndView,填充数据和视图信息进行返回
		ModelAndView mv = new ModelAndView();
		// 填充model,放到了request域对象里
		mv.addObject("msg", "注解开发方式第一个程序");
		// 设置视图信息
		mv.setViewName("user");
		// 返回对象
		return mv;
	}

}
