package cn.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 
 * 类描述：验证返回类型为void
 * 作者： LiuJinrong  
 * 创建日期：2018年12月25日
 * 修改人：
 * 修改日期：
 * 修改内容：
 * 版本号： 1.0.0
 */
@Controller
@RequestMapping("two")
public class SecondController {
	
	/**
	 * 
	 * 方法描述: void，类似于原生的Servlet开发
	 */
	@RequestMapping(value="first")
	public void first(HttpServletRequest request, HttpServletResponse response) throws IOException{
		/**
		 * 转发前后的请求方式不变,而重定向后的请求方式一定是get方式
		 */
		// 重定向
		response.sendRedirect(request.getContextPath()+"/one/first.do");
		
		// 原生的Servlet也是支持的
		// request.setAttribute(arg0, arg1);
		// request.getRequestDispatcher("").forward(arg0, arg1);
	}
	
	/**
	 * 
	 * 方法描述: 返回类型为字符串,会作为逻辑视图名进行处理
	 */
	@RequestMapping("second")
	public String second(){
		return "user";
	}
	
	/**
	 * 
	 * 方法描述: 返回字符串进行重定向 redirect:
	 */
	@RequestMapping("third")
	public String thrid(){
		return "redirect:/one/first.do";
	}
	
	/**
	 * 
	 * 方法描述: 返回字符串进行转发 forward:
	 */
	@RequestMapping("fourth")
	public String fourth(HttpServletRequest request){
		// 设置信息
		request.setAttribute("msg", "转发来的信息");
		return "forward:/two/second.do";
	}

}
