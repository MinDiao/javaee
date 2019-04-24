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
 * @ClassName:  SysUserController   
 * @Description:TODO 管理员controller
 * @author: lilong
 * @date:   2019年1月5日 下午4:09:43       
 */  
@Controller
@RequestMapping("sys_user")
public class SysUserController {

	@Autowired
	private SysUserService sysUserService;
	
	/**     
	 * @Description: 添加用户
	 * @author: lilong
	 * @date:   2019年1月5日 下午4:10:44    
	 * @return      
	 */  
	@RequestMapping(value="add",method=RequestMethod.POST)
	@ResponseBody
	public String add(SysUser user){
		JSONObject json = new JSONObject();
		try {
			sysUserService.add(user);
			json.put("code", 200);
		} catch (Exception e) {
			e.printStackTrace();
			json.put("code", 500);
		}
		return json.toJSONString();
	}
	
	
	/**     
	 * @Description:TODO 条件+分页查询
	 * @author: lilong
	 * @date:   2019年1月7日 上午10:10:54    
	 * @return      
	 */  
	@RequestMapping(value="list",method=RequestMethod.POST)
	@ResponseBody
	public R select(SysUserDto sysUserDto){//page,limit
		PageInfo pageInfo = null;
		try {
			pageInfo = sysUserService.select(sysUserDto);
		} catch (Exception e) {
			e.printStackTrace();
			return R.error();
		}
		return R.ok().put("page", pageInfo);
	}
	
	/**     
	 * @Description:TODO 批量删除
	 * @author: lilong
	 * @date:   2019年1月7日 下午2:11:51    
	 * @param ids
	 * @return      
	 */  
	@RequestMapping(value="delete")
	@ResponseBody
	public R delete(String ids){
		try {
			String[] id = ids.split(",");
			sysUserService.delete(id);
		} catch (Exception e) {
			e.printStackTrace();
			return R.error();
		}
		return R.ok();
	}
	
}
