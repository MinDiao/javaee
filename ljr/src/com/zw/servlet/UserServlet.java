package com.zw.servlet;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;

import com.alibaba.fastjson.JSONObject;
import com.zw.base.BaseServlet;
import com.zw.pojo.User;
import com.zw.service.UserService;
import com.zw.service.impl.UserServiceImpl;
import com.zw.util.Page;
/**
 * 
 * 类描述：用户servlet
 * 作者： LiuJinrong  
 * 创建日期：2018年12月19日
 * 修改人：
 * 修改日期：
 * 修改内容：
 * 版本号： 1.0.0
 */
@WebServlet("/UserServlet")
public class UserServlet extends BaseServlet {

	private static final long serialVersionUID = 1L;
	
	// 注入service
	private UserService userService = new UserServiceImpl();

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 申明json对象
		JSONObject json = new JSONObject();
		// 实例化分页对象,分页信息
		Page page = new Page();
		try {
			// 用户名
			String username = request.getParameter("username");
			// 用户性别
			String sex = request.getParameter("sex");
			// 用户生日
			String birthday = request.getParameter("birthday");
			// 页码
			String pageNum = request.getParameter("pageNum");
			// 页容量
			String pageSize = request.getParameter("pageSize");

			User user = new User(username, sex, birthday);

			page.setPageNum(Integer.valueOf(pageNum));
			page.setPageSize(Integer.valueOf(pageSize));

			// 调用service 进行分页 并 进行分页,条件筛选查询
			page = userService.selectUsers(user, page);
		} catch (Exception e) {
			e.printStackTrace();
		}
		json.put("page", page);//往json里放值
		//返回json字符串  应该返回的是从数据库中查询出来的用户列表信息   你们的作业
		response.getWriter().write(json.toString());
	}
	
	
	
	/**
	 * 根据用户id删除用户
	 */
	public void userDeleteById(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 创建json对象
		JSONObject json = new JSONObject();
		// 初始化影响行数
		int result = 0;
		try {
			// 获取请求删除用户id
			String id = request.getParameter("id");
			// 调用service层删除方法
			result = userService.userDeleteById(Integer.parseInt(id));
		} catch (Exception e) {
			e.printStackTrace();
		}
		// 判断执行结果并向json对象中填充结果
		if (result > 0) {
			json.put("code", 1);
		} else {
			json.put("code", 0);
		}
		// 响应至ajax
		response.getWriter().write(json.toString());
	}
	
	
	
	/**
	 * 根据用户id批量删除用户信息
	 */
	public void userDeleteByIds(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 创建json对象
		JSONObject json = new JSONObject();
		// 初始化影响行数
		int result = 0;
		try {
			// 获取请求批量删除的用户id
			String ids = request.getParameter("ids");
			// 方法1:将字符串按,逗号切割并填充至数组中
			String[] split = ids.split(",");
			// 执行批量删除并返回影响行数
			result = userService.userDeleteByIds(split);
		} catch (Exception e) {
			e.printStackTrace();
		}
		// 判断执行结果并向json对象中填充结果
		if (result > 0) {
			json.put("code", 1);
		} else {
			json.put("code", 0);
		}
		// 将结果响应到ajax
		response.getWriter().write(json.toString());
	}
	
	
	/**
	 * 
	 * 方法描述: 模糊查询
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	public void userSelectByFuzzy(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 创建json对象
		JSONObject json = new JSONObject();
		// 初始化填充User对象的List集合
		List<User> list = null;
		try {
			// 获取模糊查询用户名
			String username = request.getParameter("username");
			// 获取性别
			String sex = request.getParameter("sex");
			// 获取生日
			String birthday = request.getParameter("birthday");
			// 封装至User对象
			User user = new User(username, sex, birthday);
			// 执行service层模糊查询
			list = userService.userSelectByFuzzy(user);
		} catch (Exception e) {
			e.printStackTrace();
		}
		// 将填充User对象 List集合填充至json对象
		json.put("code", list);
		// 将结果响应到ajax
		response.getWriter().write(json.toString());
	}
	
	
	
	/**
	 * 
	 * 方法描述: 添加/修改用户
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	public void userAddUpdate(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 创建json对象
		JSONObject json = new JSONObject();
		// 初始化影响行数
		int result = 0;
		try {
			// 获取请求信息
			Map<String, String[]> products = request.getParameterMap();
			
			// 封装对象数据
			User user = new User();
			// 使用BeanUtils填充数据
			BeanUtils.populate(user, products);
			
			// 格式化创建时间
			SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			String date = format.format(new Date());
			// 封装至对象中
			user.setCreateDate(date);
			user.setUpdateDate(date);
			
			// 判断执行的操作
			if (user.getId() != 0) {
				// 请求存在id执行修改
				result = userService.userUpdate(user);
			} else {
				// 请求存在id执行添加
				result = userService.userAdd(user);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		// 判断执行结果
		if (result > 0) {
			// 将标识填充json对象中
			json.put("code", 1);
		} else {
			json.put("code", 0);
		}
		// 将json对象响应至ajax上
		response.getWriter().write(json.toString());
	}

}
