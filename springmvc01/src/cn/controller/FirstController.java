package cn.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

/**
 * 
 * 类描述：xml开发方式第一个处理器
 * 作者： LiuJinrong  
 * 创建日期：2018年12月25日
 * 修改人：
 * 修改日期：
 * 修改内容：
 * 版本号： 1.0.0
 */
public class FirstController implements Controller {

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// 创建ModelAndView,填充数据和视图信息进行返回
		ModelAndView mv = new ModelAndView();
		// 填充model,放到了request域对象里
		mv.addObject("msg", "第一个springmvc程序");
		// 设置视图信息
		mv.setViewName("/WEB-INF/jsps/user.jsp");
		// 返回对象
		return mv;
	}

}
