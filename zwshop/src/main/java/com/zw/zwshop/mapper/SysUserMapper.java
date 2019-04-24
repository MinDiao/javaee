package com.zw.zwshop.mapper;

import java.util.List;

import com.github.abel533.mapper.Mapper;
import com.zw.zwshop.dto.SysUserDto;
import com.zw.zwshop.pojo.SysUser;

/**
 * 
 * @ClassName:  SysUserMapper   
 * @Description: 管理员mapper
 * @author: LiuJinrong
 * @date:   2019年1月5日 下午4:42:09
 */
public interface SysUserMapper extends Mapper<SysUser> {
	
	
	/**
	 * 
	 * @Description: 条件查询列表
	 * @author: LiuJinrong
	 * @date:   2019年1月7日 上午10:47:01    
	 * @param sysUserDto
	 * @return
	 */
	List<SysUser> selectPage(SysUserDto sysUserDto);

	
	
	/**
	 * 
	 * @Description: 批量删除
	 * @author: LiuJinrong
	 * @date:   2019年1月7日 下午2:20:20    
	 * @param ids id字符串数组
	 * @return 
	 */
	int deleteBatch(String[] ids);


	
	

}














