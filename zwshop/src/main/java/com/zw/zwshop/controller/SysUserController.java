package com.zw.zwshop.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.PageInfo;
import com.zw.zwshop.dto.SysUserDto;
import com.zw.zwshop.pojo.SysUser;
import com.zw.zwshop.service.SysUserService;
import com.zw.zwshop.utils.R;

/**
 * 
 * @ClassName:  SysUserController   
 * @Description: 管理员Controller
 * @author: LiuJinrong
 * @date:   2019年1月5日 下午4:09:44
 */

@Controller
@RequestMapping("sys_user")
public class SysUserController {
	
	
	// 注入Service
	@Autowired
	private SysUserService sysUserService;
	
	
	
	/**
	 * 
	 * @Description: 验证管理员名是否存在
	 * @author: LiuJinrong
	 * @date:   2019年1月7日 上午9:30:14    
	 * @param username
	 * @return
	 */
	@RequestMapping(value="selectName", method=RequestMethod.POST)
	@ResponseBody
	public String selectName(SysUser sysUser){
		
		// 创建json对象
		JSONObject json = new JSONObject();
		
		// 初始化影响行数
		SysUser resultSysUser = null;
		
		try {
			// 调用根据用户名查询的方法
			resultSysUser = sysUserService.selectName(sysUser);
			
			// 响应至页面
			if (resultSysUser != null) {
				// 名称不存在,可用
				json.put("code", 200);
			} else {
				// 名称存在,不可用
				json.put("code", 500);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		// 响应至页面
		return json.toJSONString();
	}
	
	
	
	
	/**
	 * 
	 * @Description: 管理员注册
	 * @author: LiuJinrong
	 * @date:   2019年1月7日 上午9:28:21    
	 * @param user
	 * @return
	 */
	@RequestMapping(value="add", method=RequestMethod.POST)
	@ResponseBody
	public String add(SysUser user){
		
		// 创建json对象
		JSONObject json = new JSONObject();
		
		try {
			// 调用添加
			int res = sysUserService.add(user);
			
			// 将结果填充至json对象
			json.put("code", 200);
			
		} catch (Exception e) {
			e.printStackTrace();
			// 添加失败
			json.put("code", 500);
		}
		
		// 将json响应至页面
		return json.toString();
	}
	
	
	
	
	/**
	 * 
	 * @Description: 用户列表
	 * @author: LiuJinrong
	 * @date:   2019年1月7日 上午10:34:05    
	 * @param sysUserDto
	 * @return
	 */
	@RequestMapping(value="list", method=RequestMethod.POST)
	@ResponseBody
	public R select(SysUserDto sysUserDto){ // page,limit
		System.out.println();
		// 创建PageInfo对象
		PageInfo pageInfo = null;
		
		try {
			// 调用Service层查询功能
			pageInfo = sysUserService.select(sysUserDto);
			
		} catch (Exception e) {
			e.printStackTrace();
			// 响应默认异常信息
			return R.error();
		}
		
		// 响应至页面
		return R.ok().put("page", pageInfo);
	}
	
	
	
	
	
	/**
	 * 
	 * @Description: 批量删除
	 * @author: LiuJinrong
	 * @date:   2019年1月7日 下午2:12:06    
	 * @param ids
	 * @return
	 */
	@RequestMapping(value="delete")
	@ResponseBody
	public R delete(String ids){
		
		try {
			// 切割字符串填充至字符串数组
			String[] id = ids.split(",");
			
			// 调用删除
			sysUserService.delete(id);
			
		} catch (Exception e) {
			e.printStackTrace();
			return R.error();
		}
		
		return R.ok();
		
	}

}
















