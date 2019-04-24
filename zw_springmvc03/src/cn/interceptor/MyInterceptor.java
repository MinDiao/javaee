package cn.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
/**
 * 
 * 类描述：自定义拦截器
 * 作者： LiuJinrong  
 * 创建日期：2018年12月26日
 * 修改人：
 * 修改日期：
 * 修改内容：
 * 版本号： 1.0.0
 */
public class MyInterceptor implements HandlerInterceptor {

	/**
	 * 在处理器方法之前执行
	 * 返回true则向下继续执行,如果返回false,则中断执行
	 * 适合登录验证,权限检查等
	 */
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		System.out.println("preHandle");
		/*是否放行： true 放行
				 false 不放行*/
		return true;
	}

	/**
	 * 在处理器方法执行之后,并且在视图解析器 之前执行
	 * 对请求域中的数据和视图做出修改,可加入一些公共的数据信息等
	 */
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		System.out.println("postHandle");
	}

	/**
	 * 整个请求响应完成后再执行
	 * 适合：清理资源
	 */
	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		System.out.println("afterCompletion");
	}

}
